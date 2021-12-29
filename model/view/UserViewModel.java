package activity.activity.model.view;


import activity.activity.model.entity.RoleEntity;
import activity.activity.model.entity.enums.LevelEnumName;

import java.util.HashSet;
import java.util.Set;

public class UserViewModel {

    private Long id;
    private String username;
    private String lastName;
    private String email;
    private Integer age;
    private Set<RoleEntity> role;
    private LevelEnumName level;

    public UserViewModel() {
    }

    public Long getId() {
        return id;
    }

    public UserViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserViewModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Set<RoleEntity> getRole() {
        return role;
    }

    public UserViewModel setRole(Set<RoleEntity> role) {
        this.role = role;
        return this;
    }

    public LevelEnumName getLevel() {
        return level;
    }

    public UserViewModel setLevel(LevelEnumName level) {
        this.level = level;
        return this;
    }
}
