package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private User testUser;
    private Book testBook;
    private Loan loan;

    @BeforeEach
    void setUp() {
        library = new Library();
        testUser = new User();
        testUser.setId("123");
        testUser.setName("Test User");
        library.addUser(testUser);
        testBook = new Book("Fahrenheit 451", "Ray Bradbury", "3060311358");
        library.addBook(testBook);
        loan = new Loan();
        loan.setBook(testBook);
        loan.setUser(testUser);
        loan.setLoanDate(LocalDateTime.now());
        loan.setStatus(LoanStatus.ACTIVE);
    }

    @Test
    public void testAddNewBook() {
        Book book = new Book("One Hundred Years Of Solitude", "Gabriel Garcia Marquez", "9780060114183");
        boolean result = library.addBook(book);
        assertTrue(result, "The book should be successfully added");
    }

    @Test
    public void shouldFailBookNotAvailable() {
        assertThrows(RuntimeException.class, () -> {
            library.loanABook(testUser.getId(), testBook.getIsbn());
            library.loanABook(testUser.getId(), testBook.getIsbn());
        });
    }

    @Test
    public void testLoanABook() {
        Loan loan = library.loanABook(testUser.getId(), testBook.getIsbn());
        assertNotNull(loan, "Loan should not be null");
        assertEquals(testUser, loan.getUser(), "Loan user should match test user");
        assertEquals(testBook, loan.getBook(), "Loan book should match test book");
    }

    @Test
    public void testReturnLoan() {
        Loan loan = library.loanABook(testUser.getId(), testBook.getIsbn());
        assertNotNull(loan, "The loan should be successfully created");
        Loan returnedLoan = library.returnLoan(loan);
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus(), "The loan status should be RETURNED");
        assertDoesNotThrow(() -> library.loanABook(testUser.getId(), testBook.getIsbn()), "Book should be available again");
    }

    @Test
    public void testReturnAlreadyReturnedLoan() {
        loan.setStatus(LoanStatus.RETURNED);
        assertThrows(IllegalArgumentException.class, () -> {
            library.returnLoan(loan);
        }, "Should throw exception for already returned loan");
    }

    @Test
    public void testReturnNullLoan() {
        assertThrows(IllegalArgumentException.class, () -> {
            library.returnLoan(null);
        }, "Should throw exception for null loan");
    }
}
