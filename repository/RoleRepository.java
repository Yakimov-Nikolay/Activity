package activity.activity.repository;

import activity.activity.model.entity.RoleEntity;
import activity.activity.model.entity.enums.RoleEnumName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByRole(RoleEnumName roleEnumName);
}
