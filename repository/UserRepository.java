package activity.activity.repository;

import activity.activity.model.entity.UserEntity;
import activity.activity.model.entity.enums.RoleEnumName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    UserEntity findByRole(RoleEnumName role);

    Optional<UserEntity> findByUsernameIgnoreCase(String userName);
}
