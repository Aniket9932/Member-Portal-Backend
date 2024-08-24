package com.roms.authentication.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AuthResponseTest {
    /**
     * Method under test: {@link AuthResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new AuthResponse("janedoe", "ABC123")).canEqual("Other"));
    }

    /**
     * Method under test: {@link AuthResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        AuthResponse authResponse = new AuthResponse("janedoe", "ABC123");
        assertTrue(authResponse.canEqual(new AuthResponse("janedoe", "ABC123")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthResponse#AuthResponse(String, String)}
     *   <li>{@link AuthResponse#setToken(String)}
     *   <li>{@link AuthResponse#setUserName(String)}
     *   <li>{@link AuthResponse#toString()}
     *   <li>{@link AuthResponse#getToken()}
     *   <li>{@link AuthResponse#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuthResponse actualAuthResponse = new AuthResponse("janedoe", "ABC123");
        actualAuthResponse.setToken("ABC123");
        actualAuthResponse.setUserName("janedoe");
        String actualToStringResult = actualAuthResponse.toString();
        assertEquals("ABC123", actualAuthResponse.getToken());
        assertEquals("janedoe", actualAuthResponse.getUserName());
        assertEquals("AuthResponse(userName=janedoe, token=ABC123)", actualToStringResult);
    }

    /**
     * Method under test: {@link AuthResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new AuthResponse("janedoe", "ABC123"), null);
        assertNotEquals(new AuthResponse("janedoe", "ABC123"), "Different type to AuthResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthResponse#equals(Object)}
     *   <li>{@link AuthResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        AuthResponse authResponse = new AuthResponse("janedoe", "ABC123");
        assertEquals(authResponse, authResponse);
        int expectedHashCodeResult = authResponse.hashCode();
        assertEquals(expectedHashCodeResult, authResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthResponse#equals(Object)}
     *   <li>{@link AuthResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AuthResponse authResponse = new AuthResponse("janedoe", "ABC123");
        AuthResponse authResponse1 = new AuthResponse("janedoe", "ABC123");

        assertEquals(authResponse, authResponse1);
        int expectedHashCodeResult = authResponse.hashCode();
        assertEquals(expectedHashCodeResult, authResponse1.hashCode());
    }

    /**
     * Method under test: {@link AuthResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        AuthResponse authResponse = new AuthResponse("ABC123", "ABC123");
        assertNotEquals(authResponse, new AuthResponse("janedoe", "ABC123"));
    }

    /**
     * Method under test: {@link AuthResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        AuthResponse authResponse = new AuthResponse(null, "ABC123");
        assertNotEquals(authResponse, new AuthResponse("janedoe", "ABC123"));
    }

    /**
     * Method under test: {@link AuthResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        AuthResponse authResponse = new AuthResponse("janedoe", "janedoe");
        assertNotEquals(authResponse, new AuthResponse("janedoe", "ABC123"));
    }

    /**
     * Method under test: {@link AuthResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        AuthResponse authResponse = new AuthResponse("janedoe", null);
        assertNotEquals(authResponse, new AuthResponse("janedoe", "ABC123"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthResponse#equals(Object)}
     *   <li>{@link AuthResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        AuthResponse authResponse = new AuthResponse(null, "ABC123");
        AuthResponse authResponse1 = new AuthResponse(null, "ABC123");

        assertEquals(authResponse, authResponse1);
        int expectedHashCodeResult = authResponse.hashCode();
        assertEquals(expectedHashCodeResult, authResponse1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthResponse#equals(Object)}
     *   <li>{@link AuthResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        AuthResponse authResponse = new AuthResponse("janedoe", null);
        AuthResponse authResponse1 = new AuthResponse("janedoe", null);

        assertEquals(authResponse, authResponse1);
        int expectedHashCodeResult = authResponse.hashCode();
        assertEquals(expectedHashCodeResult, authResponse1.hashCode());
    }
}

