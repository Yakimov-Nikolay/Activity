package activity.activity.service.impl;
import activity.activity.model.entity.CategoryEntity;
import activity.activity.model.entity.enums.CategoryNameEnum;
import activity.activity.repository.CategoryRepository;
import activity.activity.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    CategoryEntity categoryEntity = new CategoryEntity();
                    categoryEntity.setName(categoryNameEnum);

                    categoryRepository.save(categoryEntity);
                });

    }

    @Override
    public CategoryEntity findByName(Set<CategoryEntity> category) {
        return categoryRepository.findByName((CategoryEntity) category)
                .orElse(null);
    }

    @Override
    public CategoryEntity findByCategoryName(CategoryNameEnum categoryNameEnum) {
        return null;
    }

//    @Override
//    public CategoryEntity findCategory(CategoryNameEnum categoryNameEnum) {
//        return categoryRepository.findByCategoryName(categoryNameEnum);
//    }

//    @Override
//    public CategoryEntity findCategory(CategoryNameEnum categoryNameEnum) {
//        return categoryRepository.findByCategoryName(categoryNameEnum).orElse(null);
//    }
}
