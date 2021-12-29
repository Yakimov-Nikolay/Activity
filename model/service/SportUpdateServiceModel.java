package activity.activity.model.service;

import activity.activity.model.entity.enums.CategoryNameEnum;
import activity.activity.model.entity.enums.LevelEnumName;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

public class SportUpdateServiceModel {

    private Long id;
    private String description;
    private LevelEnumName level;
    private CategoryNameEnum category;
    private String name;
    private String videoUrl;

    public SportUpdateServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public SportUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SportUpdateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public LevelEnumName getLevel() {
        return level;
    }

    public SportUpdateServiceModel setLevel(LevelEnumName level) {
        this.level = level;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getCategory() {
        return category;
    }

    public SportUpdateServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    @Size(min = 5)
    public String getName() {
        return name;
    }

    public SportUpdateServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public SportUpdateServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
