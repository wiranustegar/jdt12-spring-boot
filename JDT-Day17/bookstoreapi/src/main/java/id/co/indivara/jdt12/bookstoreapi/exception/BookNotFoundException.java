package id.co.indivara.jdt12.bookstoreapi.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id){
        super("Book " + id + " not found");
    }
}
