package activity.activity.model.entity;


import activity.activity.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;


@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    private CategoryNameEnum name;


    public CategoryEntity() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryNameEnum name) {
        this.name = name;

        return this;
    }
}
