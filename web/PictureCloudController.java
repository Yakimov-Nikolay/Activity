package activity.activity.web;

import activity.activity.model.binding.PictureCloudBindingModel;
import activity.activity.model.entity.PictureCloudEntity;
import activity.activity.model.view.PictureCloudViewModel;
import activity.activity.repository.PictureCloudRepository;
import activity.activity.service.CloudinaryService;
import activity.activity.service.impl.CloudinaryImg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pictureCloud")
public class PictureCloudController {


    private final CloudinaryService cloudinaryService;
    private final PictureCloudRepository pictureCloudRepository;

    public PictureCloudController(CloudinaryService cloudinaryService, PictureCloudRepository pictureCloudRepository) {

        this.cloudinaryService = cloudinaryService;
        this.pictureCloudRepository = pictureCloudRepository;
    }

    @GetMapping("/add")
    public String addPicture() {
        return "addPictureCloud";
    }

    @PostMapping("/add")
    public String confirmAddPicture(PictureCloudBindingModel pictureCloudBindingModel) throws IOException {

        var picture = createPictureCloudEntity(pictureCloudBindingModel.getPicture(),
                pictureCloudBindingModel.getTitle());

        pictureCloudRepository.save(picture);

        return "addPictureCloud";
    }

    @Transactional
    @DeleteMapping("/delete")
    public String delete(@RequestParam("public_id") String publicId) {
        if (cloudinaryService.delete(publicId)) {
            pictureCloudRepository.deleteAllByPublicId(publicId);
        }
        return "redirect:/allPictureCloud";
    }

    @GetMapping("/all")
    public String allPicture(Model model) {
        List<PictureCloudViewModel> pictures =
                pictureCloudRepository
                        .findAll()
                        .stream()
                        .map(this::viewModel)
                        .collect(Collectors.toList());

        model.addAttribute("pictures", pictures);

        return "/allPictureCloud";
    }

    private PictureCloudViewModel viewModel(PictureCloudEntity pictureCloudEntity) {
        return new PictureCloudViewModel()
                .setPublicId(pictureCloudEntity.getPublicId())
                .setTitle(pictureCloudEntity.getTitle())
                .setUrl(pictureCloudEntity.getUrl());
    }

    private PictureCloudEntity createPictureCloudEntity(MultipartFile file, String title) throws IOException {
        final CloudinaryImg upload = this.cloudinaryService.upload(file);

        return new PictureCloudEntity()
                .setPublicId(upload.getPublicId())
                .setTitle(title)
                .setUrl(upload.getUrl());
    }

}
