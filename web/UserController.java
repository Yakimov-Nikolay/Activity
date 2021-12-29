package activity.activity.web;

import activity.activity.model.binding.UserRegisterBindingModel;
import activity.activity.model.service.UserServiceModel;
import activity.activity.repository.UserRepository;
import activity.activity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final UserRepository userRepository;


    public UserController(ModelMapper modelMapper, UserService userService, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String register() {
        return "registerPage";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "registerPage";
        }

        userService.registerUser(modelMapper.map(userRegisterBindingModel,
                UserServiceModel.class));


        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }



    @PostMapping("/login-error")
    public String LoginError(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                    String username, RedirectAttributes attributes) {


        attributes.addFlashAttribute("loginError", true);
        attributes.addFlashAttribute("usernameEr", username);

        return "redirect:/users/login";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));

        return "profilePage";
    }


//
//    @GetMapping("profile/changePass")
//    public String changePassword(@PathVariable Long id, Principal user){
//        return "redirect:/changePassword";
//    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }
}
