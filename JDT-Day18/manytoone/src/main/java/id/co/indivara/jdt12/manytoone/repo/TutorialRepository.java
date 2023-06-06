package id.co.indivara.jdt12.manytoone.repo;

import id.co.indivara.jdt12.manytoone.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(Boolean publised);

    List<Tutorial> findByTitleContaining(String title);

}
