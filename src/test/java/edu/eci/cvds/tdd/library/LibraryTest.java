package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Library responsible for manage the loans and the users.
 */
public class LibraryTest {

    @Test
    public void testAddNewBook() {
        Library library = new Library();
        Book book = new Book("Cien años de soledad", "Gabriel Garcia Marquez", "9780060114183");
        library.addBook(book);
        boolean result = library.addBook(book);

        assertTrue(result, "The book count should be 1 after adding a new book");
    }
   

}