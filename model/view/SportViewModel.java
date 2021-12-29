package activity.activity.model.view;

public class SportViewModel {

    private Long  id;
    private String description;
    private String name;
    private String videoUrl;

    public SportViewModel() {
    }

    public Long getId() {
        return id;
    }

    public SportViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SportViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public SportViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public SportViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
