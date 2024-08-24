package com.roms.authentication.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TokenInvalidExceptionTest {
    /**
     * Method under test: {@link TokenInvalidException#TokenInvalidException(String)}
     */
    @Test
    void testConstructor() {
        TokenInvalidException actualTokenInvalidException = new TokenInvalidException("Msg");
        assertNull(actualTokenInvalidException.getCause());
        assertEquals(0, actualTokenInvalidException.getSuppressed().length);
        assertEquals("Msg", actualTokenInvalidException.getMessage());
        assertEquals("Msg", actualTokenInvalidException.getLocalizedMessage());
    }
}

