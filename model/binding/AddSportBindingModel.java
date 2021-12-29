package activity.activity.model.binding;


import activity.activity.model.entity.enums.CategoryNameEnum;
import activity.activity.model.entity.enums.LevelEnumName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddSportBindingModel {


    private String name;
    private String description;
    private LevelEnumName level;
    private String videoUrl;
    private CategoryNameEnum category;

    public AddSportBindingModel() {
    }

    @NotBlank(message = "Cannot be empty")
    @Size(min = 3, max = 20, message = "name have to be between 3 and 20")
    public String getName() {
        return name;
    }

    public AddSportBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank(message = "cannot be empty")
    @Size(min = 5, message = "min 5")
    public String getDescription() {
        return description;
    }

    public AddSportBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull(message = "you must select")
    public LevelEnumName getLevel() {
        return level;
    }

    public AddSportBindingModel setLevel(LevelEnumName level) {
        this.level = level;
        return this;
    }

    @NotBlank
    public String getVideoUrl() {
        return videoUrl;
    }

    public AddSportBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }


    @NotNull(message = "you must select")
    public CategoryNameEnum getCategory() {
        return category;
    }

    public AddSportBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

}
