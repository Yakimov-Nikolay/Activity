package activity.activity.model.service;

import activity.activity.model.entity.RoleEntity;
import activity.activity.model.entity.enums.LevelEnumName;

import java.util.Set;

public class UserServiceModel {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer age;
    private Set<RoleEntity> role;
    private LevelEnumName level;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Set<RoleEntity> getRole() {
        return role;
    }

    public UserServiceModel setRole(Set<RoleEntity> role) {
        this.role = role;
        return this;
    }

    public LevelEnumName getLevel() {
        return level;
    }

    public UserServiceModel setLevel(LevelEnumName level) {
        this.level = level;
        return this;
    }
}
