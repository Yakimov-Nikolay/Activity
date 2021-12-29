package activity.activity.repository;

import activity.activity.model.entity.PictureCloudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureCloudRepository extends JpaRepository<PictureCloudEntity, Long> {

    void deleteAllByPublicId(String publicId);
}
