package homeproject.webshop.webshop.repository;

import homeproject.webshop.webshop.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
