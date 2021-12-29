package activity.activity.model.binding;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class AddPictureBindingModel {

    private String title;
    private MultipartFile picture;
    private String description;

    public AddPictureBindingModel() {
    }

    @Size(min = 3, max = 50)
    public String getTitle() {
        return title;
    }

    public AddPictureBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }


    public MultipartFile getPicture() {
        return picture;
    }

    public AddPictureBindingModel setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }

    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public AddPictureBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}

