package activity.activity.model.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "sports")
public class SportEntity extends BaseEntity {

    private String name;
    private String description;
    private UserEntity author;
    private String videoUrl;
    private LevelEntity level;
    private CategoryEntity category;
    private List<Commentaries> comments;


    public SportEntity() {
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public SportEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Lob
    public String getDescription() {
        return description;
    }

    public SportEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public SportEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    @Column
    public String getVideoUrl() {
        return videoUrl;
    }

    public SportEntity setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    @OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public LevelEntity getLevel() {
        return level;
    }

    public SportEntity setLevel(LevelEntity level) {
        this.level = level;
        return this;
    }

    @OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public CategoryEntity getCategory() {
        return category;
    }

    public SportEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    @OneToMany(mappedBy = "sport", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Commentaries> getComments() {
        return comments;
    }

    public SportEntity setComments(List<Commentaries> comments) {
        this.comments = comments;
        return this;
    }
}
