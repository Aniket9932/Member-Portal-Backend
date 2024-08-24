package com.roms.authentication.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LoginRequestTest {
    /**
     * Method under test: {@link LoginRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new LoginRequest()).canEqual("Other"));
    }

    /**
     * Method under test: {@link LoginRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        LoginRequest loginRequest = new LoginRequest();

        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setPassword("iloveyou");
        loginRequest1.setUsername("janedoe");
        assertTrue(loginRequest.canEqual(loginRequest1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link LoginRequest}
     *   <li>{@link LoginRequest#setPassword(String)}
     *   <li>{@link LoginRequest#setUsername(String)}
     *   <li>{@link LoginRequest#toString()}
     *   <li>{@link LoginRequest#getPassword()}
     *   <li>{@link LoginRequest#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        LoginRequest actualLoginRequest = new LoginRequest();
        actualLoginRequest.setPassword("iloveyou");
        actualLoginRequest.setUsername("janedoe");
        String actualToStringResult = actualLoginRequest.toString();
        assertEquals("iloveyou", actualLoginRequest.getPassword());
        assertEquals("janedoe", actualLoginRequest.getUsername());
        assertEquals("LoginRequest(username=janedoe, password=iloveyou)", actualToStringResult);
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("janedoe");
        assertNotEquals(loginRequest, null);
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals2() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("janedoe");
        assertNotEquals(loginRequest, "Different type to LoginRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#equals(Object)}
     *   <li>{@link LoginRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("janedoe");
        assertEquals(loginRequest, loginRequest);
        int expectedHashCodeResult = loginRequest.hashCode();
        assertEquals(expectedHashCodeResult, loginRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#equals(Object)}
     *   <li>{@link LoginRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("janedoe");

        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setPassword("iloveyou");
        loginRequest1.setUsername("janedoe");
        assertEquals(loginRequest, loginRequest1);
        int expectedHashCodeResult = loginRequest.hashCode();
        assertEquals(expectedHashCodeResult, loginRequest1.hashCode());
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("janedoe");
        loginRequest.setUsername("janedoe");

        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setPassword("iloveyou");
        loginRequest1.setUsername("janedoe");
        assertNotEquals(loginRequest, loginRequest1);
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(null);
        loginRequest.setUsername("janedoe");

        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setPassword("iloveyou");
        loginRequest1.setUsername("janedoe");
        assertNotEquals(loginRequest, loginRequest1);
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("iloveyou");

        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setPassword("iloveyou");
        loginRequest1.setUsername("janedoe");
        assertNotEquals(loginRequest, loginRequest1);
    }

    /**
     * Method under test: {@link LoginRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername(null);

        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setPassword("iloveyou");
        loginRequest1.setUsername("janedoe");
        assertNotEquals(loginRequest, loginRequest1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#equals(Object)}
     *   <li>{@link LoginRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(null);
        loginRequest.setUsername("janedoe");

        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setPassword(null);
        loginRequest1.setUsername("janedoe");
        assertEquals(loginRequest, loginRequest1);
        int expectedHashCodeResult = loginRequest.hashCode();
        assertEquals(expectedHashCodeResult, loginRequest1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginRequest#equals(Object)}
     *   <li>{@link LoginRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername(null);

        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setPassword("iloveyou");
        loginRequest1.setUsername(null);
        assertEquals(loginRequest, loginRequest1);
        int expectedHashCodeResult = loginRequest.hashCode();
        assertEquals(expectedHashCodeResult, loginRequest1.hashCode());
    }
}

