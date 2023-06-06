package id.co.indivara.jdt12.bookstoreapi.controller;

import id.co.indivara.jdt12.bookstoreapi.entity.Book;
import id.co.indivara.jdt12.bookstoreapi.repo.BookRepository;
import id.co.indivara.jdt12.bookstoreapi.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

//    @PostMapping("/create")
//    Book createBook(@RequestBody Book book){
//        bookRepository.save(book);
//
//        return book;
//    }

    @GetMapping("/books")
    List<Book> findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    Book findBook(@PathVariable @Min(1) Long id){
        return bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
    }


    @PostMapping("/books")
    Book newBook(@Valid @RequestBody Book book){
        return bookRepository.save(book);
    }
}
