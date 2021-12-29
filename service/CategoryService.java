package activity.activity.service;

import activity.activity.model.entity.CategoryEntity;
import activity.activity.model.entity.enums.CategoryNameEnum;

import java.util.Set;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByName(Set<CategoryEntity> category);

    CategoryEntity findByCategoryName(CategoryNameEnum categoryNameEnum);
}
