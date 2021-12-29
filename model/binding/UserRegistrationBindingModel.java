package activity.activity.model.binding;

import javax.validation.constraints.*;

public class UserRegistrationBindingModel {
    private String username;
    private String email;
    private Integer age;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;

    public UserRegistrationBindingModel() {
    }

    @NotBlank
    @Size(min = 3, max = 20)
    public String getUsername() {
        return username;
    }

    public UserRegistrationBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank
    @Email
    public String getEmail() {
        return email;
    }

    public UserRegistrationBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotNull
    @Positive
    public Integer getAge() {
        return age;
    }

    public UserRegistrationBindingModel setAge(Integer age) {
        this.age = age;
        return this;
    }
@NotBlank
@Size(min = 1, max = 50)
    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    @NotBlank
    @Size(min = 1, max = 50)
    public String getLastName() {
        return lastName;
    }

    public UserRegistrationBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
@NotBlank
@Size(min = 4, max = 20)
    public String getPassword() {
        return password;
    }

    public UserRegistrationBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
    @NotBlank
    @Size(min = 4, max = 20)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
