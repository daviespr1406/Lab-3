package edu.eci.cvds.tdd.library.loan;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    private Loan loan;
    private Book book;
    private User user;

    @BeforeEach
    void setUp() {
        loan = new Loan();
        book = new Book("1984", "George Orwell", "9780451524935");
        user = new User();
        user.setId("12345");
        user.setName("David");
    }

    @Test
    void testSetAndGetBook() {
        loan.setBook(book);
        assertEquals(book, loan.getBook(), "The book should match the one set");
    }

    @Test
    void testSetAndGetUser() {
        loan.setUser(user);
        assertEquals(user, loan.getUser(), "The user should match the one set");
    }

    @Test
    void testSetAndGetLoanDate() {
        LocalDateTime now = LocalDateTime.now();
        loan.setLoanDate(now);
        assertEquals(now, loan.getLoanDate(), "The loan date should match the one set");
    }

    @Test
    void testSetAndGetReturnDate() {
        LocalDateTime returnDate = LocalDateTime.now().plusDays(14);
        loan.setReturnDate(returnDate);
        assertEquals(returnDate, loan.getReturnDate(), "The return date should match the one set");
    }

    @Test
    void testSetAndGetStatus() {
        loan.setStatus(LoanStatus.ACTIVE);
        assertEquals(LoanStatus.ACTIVE, loan.getStatus(), "The loan status should match the one set");
    }
}
