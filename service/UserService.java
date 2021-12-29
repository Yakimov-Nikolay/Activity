package activity.activity.service;


import activity.activity.model.entity.UserEntity;
import activity.activity.model.service.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findById(Long id);

    UserEntity findByUsername(String name);

    boolean isUserNameFree(String userName);

}
