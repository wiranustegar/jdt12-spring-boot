package id.co.indivara.jdt12.jdbc.repo;

import id.co.indivara.jdt12.jdbc.entity.Book;

import java.util.List;

public interface BookRepository {
    int count();
    int save(Book book);
    int update(Book book);
    int deleteById(int id);
    List<Book> findAll();
    List<Book> findByNameAndPrice(String name, double price);
    Book findById (int id);

}
