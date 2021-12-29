package activity.activity.service.impl;

public class CloudinaryImg {

    private String url;
    private String publicId;

    public CloudinaryImg() {
    }

    public String getUrl() {
        return url;
    }

    public CloudinaryImg setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public CloudinaryImg setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
