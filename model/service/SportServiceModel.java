package activity.activity.model.service;


import activity.activity.model.entity.PictureEntity;
import activity.activity.model.entity.UserEntity;
import activity.activity.model.entity.enums.CategoryNameEnum;
import activity.activity.model.entity.enums.LevelEnumName;

import java.util.Set;

public class SportServiceModel extends BaseServiceModel{

    private String name;
    private String description;
    private UserEntity author;
    private Set<PictureEntity> picture;
    private LevelEnumName level;
    private String videoUrl;
    private Set<CategoryNameEnum> category;

    public SportServiceModel() {
    }

    public String getName() {
        return name;
    }

    public SportServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SportServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public SportServiceModel setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public Set<PictureEntity> getPicture() {
        return picture;
    }

    public SportServiceModel setPicture(Set<PictureEntity> picture) {
        this.picture = picture;
        return this;
    }

    public LevelEnumName getLevel() {
        return level;
    }

    public SportServiceModel setLevel(LevelEnumName level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public SportServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryNameEnum> getCategory() {
        return category;
    }

    public SportServiceModel setCategory(Set<CategoryNameEnum> category) {
        this.category = category;
        return this;
    }
}
