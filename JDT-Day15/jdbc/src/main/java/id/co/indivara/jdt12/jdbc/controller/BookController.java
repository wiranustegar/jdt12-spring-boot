package id.co.indivara.jdt12.jdbc.controller;

import id.co.indivara.jdt12.jdbc.entity.Book;
import id.co.indivara.jdt12.jdbc.entity.ResponseMessage;
import id.co.indivara.jdt12.jdbc.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    @Qualifier("jdbcBookRepository")
    private BookRepository bookRepository;

    @PostMapping("/create")
    public ResponseMessage createBook(@RequestBody Book book){
        int hasil = bookRepository.save(book);
        if (hasil > 0 ) {
            return new ResponseMessage(200, "Book Succesfully Inserted");
        }

        return new ResponseMessage(201,"Failed to insert book");

    }

    @PatchMapping("/update")
    public ResponseMessage updateBook (@RequestBody Book book){
        if (bookRepository.update(book) > 0){
            return new ResponseMessage(200, "Book Succesfully Updated");
        }
        return new ResponseMessage(201,"Failed to Update Book");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseMessage deleteBook(@PathVariable int id){
        if (bookRepository.deleteById(id) > 0){
            return new ResponseMessage(200, "Book Succesfully Deleted");
        }
        return new ResponseMessage(201, "Failed to Delete Book");
    }

    @GetMapping("/find/{id}")
    public Book findById(@PathVariable int id){
       return bookRepository.findById(id);
    }

    @GetMapping("/all")
    public ArrayList<Book> findAll(){
        return (ArrayList<Book>) bookRepository.findAll();
    }

    @GetMapping("/find/{name}/{price}")
    public List<Book> findByNameAndPrice(@PathVariable String name, double price){
       return (List<Book>) bookRepository.findByNameAndPrice(name, price);
    }

}
