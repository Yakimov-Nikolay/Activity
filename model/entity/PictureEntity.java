package activity.activity.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pictures")
public class PictureEntity extends BaseEntity {

    private String title;
    private String url;
    private UserEntity author;
    private String description;
    private String publicId;
    private List<Commentaries> comments;
//    private SportEntity sport;

    public PictureEntity() {
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public PictureEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(nullable = false)
    public String getUrl() {
        return url;
    }

    public PictureEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public PictureEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    @Column(nullable = false)
    public String getPublicId() {
        return publicId;
    }

    public PictureEntity setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    @Lob
    public String getDescription() {
        return description;
    }

    public PictureEntity setDescription(String description) {
        this.description = description;
        return this;
    }
    @OneToMany(mappedBy = "sport", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Commentaries> getComments() {
        return comments;
    }

    public PictureEntity setComments(List<Commentaries> comments) {
        this.comments = comments;
        return this;
    }
}
