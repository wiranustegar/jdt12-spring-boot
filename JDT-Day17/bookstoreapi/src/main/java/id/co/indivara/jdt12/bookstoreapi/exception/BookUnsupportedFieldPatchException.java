package id.co.indivara.jdt12.bookstoreapi.exception;

import java.util.Set;

public class BookUnsupportedFieldPatchException extends RuntimeException {
    public BookUnsupportedFieldPatchException(Set<String> keys) {
        super("Sorry, field " + keys.toString() + " cannot be updated");
    }
}
