package activity.activity.model.binding;

import activity.activity.model.entity.enums.CategoryNameEnum;
import activity.activity.model.entity.enums.LevelEnumName;

import javax.validation.constraints.Size;

public class SportUpdateBindingModel {

    private Long id;
    private String description;
    private LevelEnumName level;
    private CategoryNameEnum category;
    private String name;
    private String videoUrl;

    public SportUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public SportUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SportUpdateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LevelEnumName getLevel() {
        return level;
    }

    public SportUpdateBindingModel setLevel(LevelEnumName level) {
        this.level = level;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public SportUpdateBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
    @Size(min = 5)
    public String getName() {
        return name;
    }

    public SportUpdateBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public SportUpdateBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
