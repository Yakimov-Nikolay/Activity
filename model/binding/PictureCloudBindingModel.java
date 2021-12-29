package activity.activity.model.binding;

import org.springframework.web.multipart.MultipartFile;

public class PictureCloudBindingModel {

    private String title;
    private MultipartFile picture;

    public PictureCloudBindingModel() {
    }

    public String getTitle() {
        return title;
    }

    public PictureCloudBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public PictureCloudBindingModel setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }
}
