package activity.activity.repository;

import activity.activity.model.entity.Commentaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Commentaries, Long> {
}
