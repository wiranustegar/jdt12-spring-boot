package id.co.indivara.jdt12.manytoone.repo;

import id.co.indivara.jdt12.manytoone.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository <Comment, Long> {
    List<Comment> findByTutorialId(Long postId);

    @Transactional
    void deleteByTutorialId(Long tutorialId);
}
