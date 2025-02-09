package edu.eci.cvds.tdd.library.book;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    public void shouldCreateBook() {
        String title = "One Hundred Years of Solitude";
        String author = "Gabriel Garcia Marquez";
        String isbn = "9780060114183";
        Book book = new Book(title, author, isbn);
        assertEquals(title, book.getTittle());
        assertEquals(author, book.getAuthor());
        assertEquals(isbn, book.getIsbn());
    }

    @Test
    public void shouldNotBeEqual() {
        Book book1 = new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "9780060114183");
        Book book2 = new Book("Love in the Time of Cholera", "Gabriel Garcia Marquez", "9780307389732");
        assertNotEquals(book1, book2, "Books with different ISBN should not be equal");
    }

    @Test
    public void nullIsbnInEquals() {
        Book book1 = new Book("Title", "Author", null);
        Book book2 = new Book("Title", "Author", null);
        assertThrows(NullPointerException.class, () -> book1.equals(book2), "Should throw NullPointerException when ISBN is null");
    }

    @Test
    public void wrongObjectTypeInEquals() {
        Book book = new Book("Title", "Author", "9780307389732");
        String notABook = "Not a book";
        assertThrows(ClassCastException.class, () -> book.equals(notABook), "Should throw ClassCastException when comparing with wrong object type");
    }
}