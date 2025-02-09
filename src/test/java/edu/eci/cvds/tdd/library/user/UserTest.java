package edu.eci.cvds.tdd.library.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void shouldCreateUser() {
        User user = new User();
        user.setName("David");
        user.setId("12345");
        assertEquals("David", user.getName());
        assertEquals("12345", user.getId());
    }

    @Test
    public void shouldUpdateUserName() {
        User user = new User();
        user.setName("David");
        assertEquals("David", user.getName());
        user.setName("Emily");
        assertEquals("Emily", user.getName());
    }

    @Test
    public void shouldUpdateUserId() {
        User user = new User();
        user.setId("12345");
        assertEquals("12345", user.getId());
        user.setId("67890");
        assertEquals("67890", user.getId());
    }

    @Test
    public void shouldCreateUserWithoutInitialization() {
        User user = new User();
        assertNull(user.getName());
        assertNull(user.getId());
    }
}