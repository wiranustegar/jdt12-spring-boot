package id.co.indivara.jdt12.bookstoreapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Nama wajib diisi")
    private String name;

    @NotEmpty(message = "Author wajib diisi")
    private String author;

    @NotNull(message = "Price wajib diisi")
    @DecimalMin(value = "1.00")
    private BigDecimal price;

    public Book() {
    }

    public Book(String name, String author, BigDecimal price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
