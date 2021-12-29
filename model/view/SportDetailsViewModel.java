package activity.activity.model.view;

import activity.activity.model.entity.PictureEntity;

import java.util.Set;

public class SportDetailsViewModel {

    private Long id;
    private String description;
    //    private LevelEnumName level;
    private String name;
        private Set<PictureEntity> pictures;
    private String videoUrl;
    private boolean canDelete;

    public SportDetailsViewModel() {
    }

    public Long getId() {
        return id;
    }

    public SportDetailsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SportDetailsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public SportDetailsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Set<PictureEntity> getPictures() {
        return pictures;
    }

    public SportDetailsViewModel setPictures(Set<PictureEntity> pictures) {
        this.pictures = pictures;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public SportDetailsViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public SportDetailsViewModel setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
        return this;
    }
}
