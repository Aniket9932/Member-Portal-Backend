package com.roms.authentication.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class UserNotFoundExceptionTest {
    /**
     * Method under test: {@link UserNotFoundException#UserNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        UserNotFoundException actualUserNotFoundException = new UserNotFoundException("janedoe");
        assertNull(actualUserNotFoundException.getCause());
        assertEquals(0, actualUserNotFoundException.getSuppressed().length);
        assertEquals("There is no user available with this username: janedoe", actualUserNotFoundException.getMessage());
        assertEquals("There is no user available with this username: janedoe",
                actualUserNotFoundException.getLocalizedMessage());
    }
}

