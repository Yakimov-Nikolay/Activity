package activity.activity.model.service;

public class CommentServiceModel {

    private Long sportId;
    private String message;
    private String author;

    public CommentServiceModel() {
    }

    public Long getSportId() {
        return sportId;
    }

    public CommentServiceModel setSportId(Long sportId) {
        this.sportId = sportId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommentServiceModel setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public CommentServiceModel setAuthor(String author) {
        this.author = author;
        return this;
    }
}
