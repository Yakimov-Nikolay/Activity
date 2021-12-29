package activity.activity.model.service;


import activity.activity.model.entity.UserEntity;

public class PictureServiceModel extends BaseServiceModel{

    private String title;
    private String url;
    private String description;
    private UserEntity author;
    private String publicId;

    public PictureServiceModel() {
    }

    public String getTitle() {
        return title;
    }

    public PictureServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureServiceModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public PictureServiceModel setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PictureServiceModel setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PictureServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
