package activity.activity.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "picture_cloud")
public class PictureCloudEntity {


    private Long id;
    private String title;
    private String url;
    private String publicId;

    public PictureCloudEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public PictureCloudEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PictureCloudEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureCloudEntity setUrl(String url) {
        this.url = url;
        return this;
    }


    public String getPublicId() {
        return publicId;
    }

    public PictureCloudEntity setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
