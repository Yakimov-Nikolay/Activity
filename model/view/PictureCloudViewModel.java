package activity.activity.model.view;

public class PictureCloudViewModel {

    private String title;
    private String url;
    private String publicId;

    public PictureCloudViewModel() {
    }

    public String getTitle() {
        return title;
    }

    public PictureCloudViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureCloudViewModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PictureCloudViewModel setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
