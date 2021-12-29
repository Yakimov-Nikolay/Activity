package activity.activity.web;
import activity.activity.model.binding.AddSportBindingModel;
import activity.activity.model.binding.SportUpdateBindingModel;
import activity.activity.model.entity.enums.CategoryNameEnum;
import activity.activity.model.entity.enums.LevelEnumName;
import activity.activity.model.service.SportUpdateServiceModel;
import activity.activity.model.view.SportDetailsViewModel;
import activity.activity.service.SportService;
import activity.activity.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class SportController {

    private final ModelMapper modelMapper;
    private final SportService sportService;

    public SportController(ModelMapper modelMapper, SportService sportService) {
        this.modelMapper = modelMapper;
        this.sportService = sportService;
    }

    @GetMapping("/add/sport")
    public String addSport() {
        return "addSport";
    }

    @PostMapping("/add/sport")
    public String confirmSport(@Valid AddSportBindingModel addSportBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes
            , Principal user) {
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addSportBindingModel", addSportBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult" +
                    ".addSportBindingModel", bindingResult);

            return "redirect:/addSport";
        }
        sportService.addActivity(addSportBindingModel, user.getName());

        return "redirect:/";
    }


    @GetMapping("/all/sports")
    public String allSports(Model model){

        model.addAttribute("allSports", sportService.findAllSportViewModel());
        return "allSport";
    }

    @GetMapping("/sport/{id}/details")
    public String details(@PathVariable Long id,
                          Model model,
                          Principal principal) {

        model.addAttribute("activ",
                this.sportService.findSportById(id, principal.getName()));

        return "sport_details";
    }

    @PreAuthorize("isOwner(#id)")
   // @PreAuthorize("@sportServiceImpl.isOwner(#principal.name, #id)")
    @DeleteMapping("/sport/{id}")
    public String deleteSport(@PathVariable Long id,
                              Principal principal){

        sportService.deleteSport(id);

        return "redirect:/";
    }
    @GetMapping("/sport/{id}/update")
        public String update(@PathVariable Long id, Model model,
                             Principal currentUser) {


            SportDetailsViewModel sportDetailsViewModel =
                    sportService.findSportById(id, currentUser.getName());


            SportUpdateBindingModel sportUpdateBindingModel = modelMapper.map(sportDetailsViewModel,
                    SportUpdateBindingModel.class);

            model.addAttribute("levelToUpdate", LevelEnumName.values());
            model.addAttribute("categoryToUpdate", CategoryNameEnum.values());
            model.addAttribute("currentSport", sportUpdateBindingModel);

            return "sport_update";
        }

        @PatchMapping("/sport/{id}/update")
        public String update(SportUpdateBindingModel sportUpdateBindingModel,
                             @PathVariable Long id) throws ObjectNotFoundException {

            SportUpdateServiceModel sportUpdateServiceModel = modelMapper.map(sportUpdateBindingModel,
                    SportUpdateServiceModel.class);
    //        sportUpdateBindingModel.setId(id);


            sportService.updateSport(sportUpdateServiceModel);

            return "redirect:/";
        }

    @ModelAttribute
    public AddSportBindingModel addSportBindingModel() {
        return new AddSportBindingModel();
    }
}
