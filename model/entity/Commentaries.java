package activity.activity.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Commentaries extends BaseEntity {

    private Boolean approved;
    private String content;
    private LocalDateTime created;
    private SportEntity sport;
    private UserEntity author;

    public Commentaries() {
    }

    @Column(nullable = false)
    public Boolean getApproved() {
        return approved;
    }

    public Commentaries setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    @Lob
    public String getContent() {
        return content;
    }

    public Commentaries setContent(String content) {
        this.content = content;
        return this;
    }

    @Column(nullable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    public Commentaries setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public SportEntity getSport() {
        return sport;
    }

    public Commentaries setSport(SportEntity sport) {
        this.sport = sport;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public UserEntity getAuthor() {
        return author;
    }

    public Commentaries setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }
}
