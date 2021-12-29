package activity.activity.service.impl;

import activity.activity.model.binding.AddSportBindingModel;
import activity.activity.model.entity.RoleEntity;
import activity.activity.model.entity.SportEntity;
import activity.activity.model.entity.UserEntity;
import activity.activity.model.entity.enums.RoleEnumName;
import activity.activity.model.service.SportServiceModel;
import activity.activity.model.service.SportUpdateServiceModel;
import activity.activity.model.view.SportDetailsViewModel;
import activity.activity.model.view.SportViewModel;
import activity.activity.repository.SportRepository;
import activity.activity.repository.UserRepository;
import activity.activity.service.CategoryService;
import activity.activity.service.SportService;
import activity.activity.service.UserService;
import activity.activity.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class SportServiceImpl implements SportService {

    private final SportRepository sportRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;


    public SportServiceImpl(SportRepository sportRepository, UserRepository userRepository, UserService userService,
                            ModelMapper modelMapper, CategoryService categoryService) {
        this.sportRepository = sportRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public SportServiceModel addActivity(AddSportBindingModel addSportBindingModel,
                                         String userIdentifier) {
        UserEntity userEntity = userRepository.findByUsername(userIdentifier).orElseThrow();

        modelMapper.map(addSportBindingModel, SportServiceModel.class);

        SportEntity newSport = modelMapper.map(addSportBindingModel, SportEntity.class);
        newSport.setAuthor(userEntity);

        SportEntity add = sportRepository.save(newSport);

        return modelMapper.map(add, SportServiceModel.class);
    }

    @Override
    public SportDetailsViewModel findSportById(Long id, String currentUser) {
        return this.sportRepository.findById(id)
                .map(s -> mapDetails(currentUser, s)).get();

    }

    private SportDetailsViewModel mapDetails(String currentUser, SportEntity sport) {
        SportDetailsViewModel sportDetailsViewModel = this.modelMapper.map(sport, SportDetailsViewModel.class);
        sportDetailsViewModel.setCanDelete(isOwner(currentUser, sport.getId()));
        sportDetailsViewModel.setName(sport.getName());
        return sportDetailsViewModel;
    }

    public boolean isOwner(String currentUser, Long id) {
        Optional<SportEntity> sportEntityOptional = sportRepository.
                findById(id);

        Optional<UserEntity> userEntityOptional = userRepository.
                findByUsername(currentUser);

        if (sportEntityOptional.isEmpty() || userEntityOptional.isEmpty()) {
            return false;
        } else {
            SportEntity sportEntity = sportEntityOptional.get();

            return isAdmin(userEntityOptional.get()) ||
                    sportEntity.getAuthor()
                            .getUsername().equals(currentUser);
        }
    }

    private boolean isAdmin(UserEntity userEntity) {
        return userEntity.getRole().stream().map(RoleEntity::getRole)
                .anyMatch(r -> r == RoleEnumName.ADMIN);
    }

    @Transactional
    @Override
    public List<SportViewModel> findAllSportSportViewModels() {
        return sportRepository
                .findAll()
                .stream()
                .map(sportEntity -> {
                    return modelMapper.map(sportEntity, SportViewModel.class);
                })
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public List<SportEntity> findAllSportViewModel() {
        return sportRepository
                .findAll()
                .stream()
                .map(sport -> modelMapper.map(sport, SportEntity.class))
                .collect(Collectors.toList());
    }

    @Override
        public void updateSport(SportUpdateServiceModel sportUpdateServiceModel) throws ObjectNotFoundException {
            SportEntity sportEntity = sportRepository.findById(sportUpdateServiceModel.getId()).orElseThrow(
                    () -> new ObjectNotFoundException(
                            "Activity whit id: " + sportUpdateServiceModel.getId() + " not found!!!"
                    ));

            sportEntity.setName(sportUpdateServiceModel.getName());
            sportEntity.setVideoUrl(sportUpdateServiceModel.getVideoUrl());
            sportEntity.setDescription(sportUpdateServiceModel.getDescription());

            sportRepository.save(sportEntity);
        }

    @Override
    public void deleteSport(Long id) {
        sportRepository.deleteById(id);
    }
}
