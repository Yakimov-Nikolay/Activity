package activity.activity.repository;

import activity.activity.model.entity.SportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository  extends JpaRepository<SportEntity, Long> {


}
