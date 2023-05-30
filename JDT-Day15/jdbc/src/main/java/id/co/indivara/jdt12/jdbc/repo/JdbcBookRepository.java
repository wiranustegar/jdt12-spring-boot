package id.co.indivara.jdt12.jdbc.repo;

import id.co.indivara.jdt12.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcBookRepository implements BookRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM books", Integer.class);
    }

    @Override
    public int save(Book book) {
        return jdbcTemplate.update("INSERT INTO books(name, price) VALUES(?,?)", book.getName(), book.getPrice());
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update("UPDATE books SET name=?, price=? WHERE id=?", book.getName(), book.getPrice(), book.getId());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
    }

    @Override
    public Book findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM books WHERE id=?",
                new Object[]{id},
                (rs, rowNum)-> new Book(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"))
        );
    }

    @Override
    public List<Book> findByNameAndPrice(String name, double price) {
        return jdbcTemplate.query("SELECT * FROM books WHERE name LIKE ? AND price <= ?",
                new Object[]{"%" + name + "%", price},
                (rs, rowNum)-> new Book(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
        );
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM books",
                (rs, rowNum)-> new Book(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
        );
    }
}
