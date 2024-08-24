package com.roms.authentication.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ExceptionResponseTest {
    /**
     * Method under test: {@link ExceptionResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new ExceptionResponse()).canEqual("Other"));
        assertFalse(
                (new ExceptionResponse(mock(java.sql.Date.class), "An error occurred", "Details", 3)).canEqual("Other"));
    }

    /**
     * Method under test: {@link ExceptionResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        assertTrue(exceptionResponse.canEqual(new ExceptionResponse()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionResponse#ExceptionResponse()}
     *   <li>{@link ExceptionResponse#setDetails(String)}
     *   <li>{@link ExceptionResponse#setMessage(String)}
     *   <li>{@link ExceptionResponse#setStatus(int)}
     *   <li>{@link ExceptionResponse#setTimestamp(Date)}
     *   <li>{@link ExceptionResponse#toString()}
     *   <li>{@link ExceptionResponse#getDetails()}
     *   <li>{@link ExceptionResponse#getMessage()}
     *   <li>{@link ExceptionResponse#getStatus()}
     *   <li>{@link ExceptionResponse#getTimestamp()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ExceptionResponse actualExceptionResponse = new ExceptionResponse();
        actualExceptionResponse.setDetails("Details");
        actualExceptionResponse.setMessage("An error occurred");
        actualExceptionResponse.setStatus(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualExceptionResponse.setTimestamp(fromResult);
        actualExceptionResponse.toString();
        assertEquals("Details", actualExceptionResponse.getDetails());
        assertEquals("An error occurred", actualExceptionResponse.getMessage());
        assertEquals(1, actualExceptionResponse.getStatus());
        assertSame(fromResult, actualExceptionResponse.getTimestamp());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionResponse#ExceptionResponse(Date, String, String, int)}
     *   <li>{@link ExceptionResponse#setDetails(String)}
     *   <li>{@link ExceptionResponse#setMessage(String)}
     *   <li>{@link ExceptionResponse#setStatus(int)}
     *   <li>{@link ExceptionResponse#setTimestamp(Date)}
     *   <li>{@link ExceptionResponse#toString()}
     *   <li>{@link ExceptionResponse#getDetails()}
     *   <li>{@link ExceptionResponse#getMessage()}
     *   <li>{@link ExceptionResponse#getStatus()}
     *   <li>{@link ExceptionResponse#getTimestamp()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        ExceptionResponse actualExceptionResponse = new ExceptionResponse(
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "An error occurred", "Details", 1);
        actualExceptionResponse.setDetails("Details");
        actualExceptionResponse.setMessage("An error occurred");
        actualExceptionResponse.setStatus(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualExceptionResponse.setTimestamp(fromResult);
        actualExceptionResponse.toString();
        assertEquals("Details", actualExceptionResponse.getDetails());
        assertEquals("An error occurred", actualExceptionResponse.getMessage());
        assertEquals(1, actualExceptionResponse.getStatus());
        assertSame(fromResult, actualExceptionResponse.getTimestamp());
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new ExceptionResponse(), null);
        assertNotEquals(new ExceptionResponse(), "Different type to ExceptionResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionResponse#equals(Object)}
     *   <li>{@link ExceptionResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        assertEquals(exceptionResponse, exceptionResponse);
        int expectedHashCodeResult = exceptionResponse.hashCode();
        assertEquals(expectedHashCodeResult, exceptionResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionResponse#equals(Object)}
     *   <li>{@link ExceptionResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        ExceptionResponse exceptionResponse1 = new ExceptionResponse();
        assertEquals(exceptionResponse, exceptionResponse1);
        int expectedHashCodeResult = exceptionResponse.hashCode();
        assertEquals(expectedHashCodeResult, exceptionResponse1.hashCode());
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "An error occurred", "Details", 1);
        assertNotEquals(exceptionResponse, new ExceptionResponse());
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        exceptionResponse.setTimestamp(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        assertNotEquals(exceptionResponse, new ExceptionResponse());
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage("An error occurred");
        assertNotEquals(exceptionResponse, new ExceptionResponse());
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDetails("Details");
        assertNotEquals(exceptionResponse, new ExceptionResponse());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionResponse#equals(Object)}
     *   <li>{@link ExceptionResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "An error occurred", "Details", 1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        ExceptionResponse exceptionResponse1 = new ExceptionResponse(
                Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()), "An error occurred", "Details", 1);

        assertEquals(exceptionResponse, exceptionResponse1);
        int expectedHashCodeResult = exceptionResponse.hashCode();
        assertEquals(expectedHashCodeResult, exceptionResponse1.hashCode());
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        ExceptionResponse exceptionResponse1 = new ExceptionResponse();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        exceptionResponse1.setTimestamp(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        assertNotEquals(exceptionResponse, exceptionResponse1);
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals10() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        ExceptionResponse exceptionResponse1 = new ExceptionResponse();
        exceptionResponse1.setMessage("An error occurred");
        assertNotEquals(exceptionResponse, exceptionResponse1);
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals11() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        ExceptionResponse exceptionResponse1 = new ExceptionResponse();
        exceptionResponse1.setDetails("Details");
        assertNotEquals(exceptionResponse, exceptionResponse1);
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals12() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        assertNotEquals(exceptionResponse,
                new ExceptionResponse(mock(java.sql.Date.class), "An error occurred", "Details", 1));
    }
}

