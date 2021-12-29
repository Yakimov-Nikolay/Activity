package activity.activity.service.impl;

import activity.activity.model.binding.AddPictureBindingModel;
import activity.activity.model.entity.PictureEntity;
import activity.activity.model.entity.UserEntity;
import activity.activity.repository.PictureRepository;
import activity.activity.repository.SportRepository;
import activity.activity.repository.UserRepository;
import activity.activity.service.CloudinaryService;
import activity.activity.service.PictureService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;
    private final PictureRepository pictureRepository;
    private final SportRepository sportRepository;
    private final UserRepository userRepository;

    public PictureServiceImpl(ModelMapper modelMapper, CloudinaryService cloudinaryService, PictureRepository pictureRepository, SportRepository sportRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
        this.sportRepository = sportRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addPicture(AddPictureBindingModel addPictureBindingModel, String principalName) throws IOException {
        UserEntity userEntity = userRepository.findByUsername(principalName).orElseThrow();

        var picture = createPictureEntity(addPictureBindingModel.getPicture(), addPictureBindingModel.getTitle()
                , addPictureBindingModel.getDescription());
        picture.setAuthor(userEntity);

        pictureRepository.save(picture);

    }

    @Override
    public List<PictureEntity> findAllPictureViewModel() {
        return pictureRepository
                .findAll()
                .stream()
                .map(p ->modelMapper.map(p, PictureEntity.class))
                .collect(Collectors.toList());
    }

    private PictureEntity createPictureEntity(MultipartFile picture, String title,
                                              String description) throws IOException {
        final CloudinaryImg upload = this.cloudinaryService.upload(picture);

        return new PictureEntity()
                .setPublicId(upload.getPublicId())
                .setTitle(title)
                .setUrl(upload.getUrl())
                .setDescription(description);
    }

}
