package activity.activity.web;
import activity.activity.model.binding.AddPictureBindingModel;
import activity.activity.service.CloudinaryService;
import activity.activity.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.Principal;;

@Controller
public class PictureController {

    private final CloudinaryService cloudinaryService;
    private final PictureService pictureService;
    private final ModelMapper modelMapper;


    public PictureController(CloudinaryService cloudinaryService, PictureService pictureService,
                             ModelMapper modelMapper) {
        this.cloudinaryService = cloudinaryService;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add/picture")
    private String addPicture() {
        return "addPicture";
    }

    @PostMapping("/add/picture")
    private String confirmPicture(@Valid AddPictureBindingModel addPictureBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,
                                  Principal principal) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addPictureBindingModel", addPictureBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addPictureBindingModel", bindingResult);
            return "redirect:/addPicture";
        }
        pictureService.addPicture(addPictureBindingModel, principal.getName());

        return "redirect:/";
    }

    @GetMapping("/all/picture")
    public String allPicture(Model model) {
        model.addAttribute("picture", pictureService.findAllPictureViewModel());

        return "allPicture";
    }

}

