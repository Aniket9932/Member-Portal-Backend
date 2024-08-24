package com.roms.authentication.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Request;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {GlobalExceptionHandler.class})
@ExtendWith(SpringExtension.class)
class GlobalExceptionHandlerTest {
    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    /**
     * Method under test: {@link GlobalExceptionHandler#handleAllExceptions(Exception, WebRequest)}
     */
    @Test
    void testHandleAllExceptions() {
        Exception ex = new Exception();
        ResponseEntity<ExceptionResponse> actualHandleAllExceptionsResult = globalExceptionHandler.handleAllExceptions(ex,
                new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleAllExceptionsResult.hasBody());
        assertTrue(actualHandleAllExceptionsResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualHandleAllExceptionsResult.getStatusCode());
        ExceptionResponse body = actualHandleAllExceptionsResult.getBody();
        assertEquals("uri=", body.getDetails());
        assertNull(body.getMessage());
        assertEquals(500, body.getStatus());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleAllExceptions(Exception, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleAllExceptions2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.roms.authentication.exception.GlobalExceptionHandler.handleAllExceptions(GlobalExceptionHandler.java:19)
        //   See https://diff.blue/R013 to resolve this issue.

        globalExceptionHandler.handleAllExceptions(null, new ServletWebRequest(new MockHttpServletRequest()));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleAllExceptions(Exception, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleAllExceptions3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.apache.catalina.connector.Request.getRequestURI(Request.java:2451)
        //       at com.roms.authentication.exception.GlobalExceptionHandler.handleAllExceptions(GlobalExceptionHandler.java:19)
        //   See https://diff.blue/R013 to resolve this issue.

        Exception ex = new Exception();
        globalExceptionHandler.handleAllExceptions(ex, new ServletWebRequest(new Request(new Connector())));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleAllExceptions(Exception, WebRequest)}
     */
    @Test
    void testHandleAllExceptions4() {
        Exception ex = new Exception();
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getRequestURI()).thenReturn("https://example.org/example");
        ResponseEntity<ExceptionResponse> actualHandleAllExceptionsResult = globalExceptionHandler.handleAllExceptions(ex,
                new ServletWebRequest(defaultMultipartHttpServletRequest));
        assertTrue(actualHandleAllExceptionsResult.hasBody());
        assertTrue(actualHandleAllExceptionsResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualHandleAllExceptionsResult.getStatusCode());
        ExceptionResponse body = actualHandleAllExceptionsResult.getBody();
        assertEquals("uri=https://example.org/example", body.getDetails());
        assertNull(body.getMessage());
        assertEquals(500, body.getStatus());
        verify(defaultMultipartHttpServletRequest).getRequestURI();
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleUserNotFoundException(UserNotFoundException, WebRequest)}
     */
    @Test
    void testHandleUserNotFoundException() {
        UserNotFoundException ex = new UserNotFoundException("janedoe");
        ResponseEntity<ExceptionResponse> actualHandleUserNotFoundExceptionResult = globalExceptionHandler
                .handleUserNotFoundException(ex, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleUserNotFoundExceptionResult.hasBody());
        assertTrue(actualHandleUserNotFoundExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.NOT_FOUND, actualHandleUserNotFoundExceptionResult.getStatusCode());
        ExceptionResponse body = actualHandleUserNotFoundExceptionResult.getBody();
        assertEquals("uri=", body.getDetails());
        assertEquals("There is no user available with this username: janedoe", body.getMessage());
        assertEquals(404, body.getStatus());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleUserNotFoundException(UserNotFoundException, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleUserNotFoundException2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.roms.authentication.exception.GlobalExceptionHandler.handleUserNotFoundException(GlobalExceptionHandler.java:26)
        //   See https://diff.blue/R013 to resolve this issue.

        globalExceptionHandler.handleUserNotFoundException(null, new ServletWebRequest(new MockHttpServletRequest()));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleUserNotFoundException(UserNotFoundException, WebRequest)}
     */
    @Test
    void testHandleUserNotFoundException3() {
        UserNotFoundException userNotFoundException = mock(UserNotFoundException.class);
        when(userNotFoundException.getMessage()).thenReturn("Not all who wander are lost");
        ResponseEntity<ExceptionResponse> actualHandleUserNotFoundExceptionResult = globalExceptionHandler
                .handleUserNotFoundException(userNotFoundException, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleUserNotFoundExceptionResult.hasBody());
        assertTrue(actualHandleUserNotFoundExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.NOT_FOUND, actualHandleUserNotFoundExceptionResult.getStatusCode());
        ExceptionResponse body = actualHandleUserNotFoundExceptionResult.getBody();
        assertEquals("uri=", body.getDetails());
        assertEquals("Not all who wander are lost", body.getMessage());
        assertEquals(404, body.getStatus());
        verify(userNotFoundException).getMessage();
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleUserNotFoundException(UserNotFoundException, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleUserNotFoundException4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.roms.authentication.exception.GlobalExceptionHandler.handleUserNotFoundException(GlobalExceptionHandler.java:26)
        //   See https://diff.blue/R013 to resolve this issue.

        UserNotFoundException userNotFoundException = mock(UserNotFoundException.class);
        when(userNotFoundException.getMessage()).thenReturn("Not all who wander are lost");
        globalExceptionHandler.handleUserNotFoundException(userNotFoundException, null);
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleTokenInvalidException(TokenInvalidException, WebRequest)}
     */
    @Test
    void testHandleTokenInvalidException() {
        TokenInvalidException ex = new TokenInvalidException("Msg");
        ResponseEntity<ExceptionResponse> actualHandleTokenInvalidExceptionResult = globalExceptionHandler
                .handleTokenInvalidException(ex, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleTokenInvalidExceptionResult.hasBody());
        assertTrue(actualHandleTokenInvalidExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.UNAUTHORIZED, actualHandleTokenInvalidExceptionResult.getStatusCode());
        ExceptionResponse body = actualHandleTokenInvalidExceptionResult.getBody();
        assertEquals("uri=", body.getDetails());
        assertEquals("Msg", body.getMessage());
        assertEquals(401, body.getStatus());
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleTokenInvalidException(TokenInvalidException, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleTokenInvalidException2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.roms.authentication.exception.GlobalExceptionHandler.handleTokenInvalidException(GlobalExceptionHandler.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        globalExceptionHandler.handleTokenInvalidException(null, new ServletWebRequest(new MockHttpServletRequest()));
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleTokenInvalidException(TokenInvalidException, WebRequest)}
     */
    @Test
    void testHandleTokenInvalidException3() {
        TokenInvalidException tokenInvalidException = mock(TokenInvalidException.class);
        when(tokenInvalidException.getMessage()).thenReturn("Not all who wander are lost");
        ResponseEntity<ExceptionResponse> actualHandleTokenInvalidExceptionResult = globalExceptionHandler
                .handleTokenInvalidException(tokenInvalidException, new ServletWebRequest(new MockHttpServletRequest()));
        assertTrue(actualHandleTokenInvalidExceptionResult.hasBody());
        assertTrue(actualHandleTokenInvalidExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.UNAUTHORIZED, actualHandleTokenInvalidExceptionResult.getStatusCode());
        ExceptionResponse body = actualHandleTokenInvalidExceptionResult.getBody();
        assertEquals("uri=", body.getDetails());
        assertEquals("Not all who wander are lost", body.getMessage());
        assertEquals(401, body.getStatus());
        verify(tokenInvalidException).getMessage();
    }

    /**
     * Method under test: {@link GlobalExceptionHandler#handleTokenInvalidException(TokenInvalidException, WebRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleTokenInvalidException4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.roms.authentication.exception.GlobalExceptionHandler.handleTokenInvalidException(GlobalExceptionHandler.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        TokenInvalidException tokenInvalidException = mock(TokenInvalidException.class);
        when(tokenInvalidException.getMessage()).thenReturn("Not all who wander are lost");
        globalExceptionHandler.handleTokenInvalidException(tokenInvalidException, null);
    }
}

