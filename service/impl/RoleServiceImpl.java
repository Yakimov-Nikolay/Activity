package activity.activity.service.impl;
import activity.activity.model.entity.RoleEntity;
import activity.activity.model.entity.enums.RoleEnumName;
import activity.activity.repository.RoleRepository;
import activity.activity.service.RoleService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRole() {

        if (roleRepository.count() != 0) {
            return;
        }
        RoleEntity admin  = new RoleEntity();
        admin.setRole(RoleEnumName.ADMIN);

        RoleEntity user = new RoleEntity();
        user.setRole(RoleEnumName.USER);

        roleRepository.saveAll(List.of(admin, user));
    }
}
