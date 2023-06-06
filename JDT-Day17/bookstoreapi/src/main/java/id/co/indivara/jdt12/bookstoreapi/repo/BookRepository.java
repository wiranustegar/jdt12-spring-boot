package id.co.indivara.jdt12.bookstoreapi.repo;

import id.co.indivara.jdt12.bookstoreapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long> {
}
