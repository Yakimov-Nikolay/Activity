package activity.activity.service.impl;

import activity.activity.model.entity.RoleEntity;
import activity.activity.model.entity.UserEntity;
import activity.activity.model.entity.enums.LevelEnumName;
import activity.activity.model.entity.enums.RoleEnumName;
import activity.activity.model.service.UserServiceModel;
import activity.activity.repository.RoleRepository;
import activity.activity.repository.UserRepository;
import activity.activity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final HomeSportServiceImpl homeSportService;


    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           HomeSportServiceImpl homeSportService) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.homeSportService = homeSportService;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        RoleEntity adminRole = roleRepository.findByRole(RoleEnumName.ADMIN);
        RoleEntity userRole = roleRepository.findByRole(RoleEnumName.USER);

        UserEntity user = null;
        if (userRepository.count() == 0) {

            user = modelMapper.map(userServiceModel, UserEntity.class);
            user.setLevel(LevelEnumName.BEGINNER)
                    .setRole(Set.of(adminRole, userRole))
                    .setPassword(passwordEncoder.encode(userServiceModel.getPassword()));

        } else {

            user = modelMapper.map(userServiceModel, UserEntity.class);
            user.setLevel(LevelEnumName.BEGINNER)
                    .setRole(Set.of(userRole))
                    .setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        }

        userRepository.save(user);

        UserDetails principal = homeSportService.loadUserByUsername(user.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                user.getPassword(),
                principal.getAuthorities()
        );


        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserEntity findByUsername(String name) {
        return userRepository.findByUsername(name).orElse(null);
    }

    @Override
    public boolean isUserNameFree(String userName) {
        return userRepository.findByUsernameIgnoreCase(userName).isEmpty();
    }
//        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
    }

