package activity.activity.init;

import activity.activity.service.CategoryService;
import activity.activity.service.LevelService;
import activity.activity.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

   private final CategoryService categoryService;
   private final RoleService roleService;
   private final LevelService levelService;

    public DataInit(CategoryService categoryService, RoleService roleService, LevelService levelService) {
        this.categoryService = categoryService;
        this.roleService = roleService;
        this.levelService = levelService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
        roleService.initRole();
        levelService.initLevel();

    }
}
