package com.roms.authentication.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.roms.authentication.entity.User;
import com.roms.authentication.exception.TokenInvalidException;
import com.roms.authentication.model.UserDetailPrincipal;
import com.roms.authentication.service.service_Impl.UserDetailsServiceImpl;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.CoyoteOutputStream;

import org.apache.catalina.connector.Response;
import org.apache.catalina.connector.ResponseFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.DelegatingServletInputStream;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {AuthTokenFilter.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class AuthTokenFilterTest {
    @Autowired
    private AuthTokenFilter authTokenFilter;

    @MockBean
    private JwtHandler jwtHandler;

    @MockBean
    private UserDetailsServiceImpl userDetailsServiceImpl;

    /**
     * Method under test: {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal() throws IOException, ServletException {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        authTokenFilter.doFilterInternal(mockHttpServletRequest, response, filterChain);
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        assertFalse(mockHttpServletRequest.isRequestedSessionIdFromURL());
        assertTrue(mockHttpServletRequest.isRequestedSessionIdFromCookie());
        assertFalse(mockHttpServletRequest.isAsyncSupported());
        assertFalse(mockHttpServletRequest.isAsyncStarted());
        assertTrue(mockHttpServletRequest.isActive());
        assertTrue(mockHttpServletRequest.getSession() instanceof MockHttpSession);
        assertEquals("", mockHttpServletRequest.getServletPath());
        assertEquals(80, mockHttpServletRequest.getServerPort());
        assertEquals("localhost", mockHttpServletRequest.getServerName());
        assertEquals("http", mockHttpServletRequest.getScheme());
        assertEquals("", mockHttpServletRequest.getRequestURI());
        assertEquals(80, mockHttpServletRequest.getRemotePort());
        assertEquals("localhost", mockHttpServletRequest.getRemoteHost());
        assertEquals("HTTP/1.1", mockHttpServletRequest.getProtocol());
        assertEquals("", mockHttpServletRequest.getMethod());
        assertEquals(80, mockHttpServletRequest.getLocalPort());
        assertEquals("localhost", mockHttpServletRequest.getLocalName());
        assertTrue(mockHttpServletRequest.getInputStream() instanceof DelegatingServletInputStream);
        assertEquals(DispatcherType.REQUEST, mockHttpServletRequest.getDispatcherType());
        assertEquals("", mockHttpServletRequest.getContextPath());
        assertEquals(-1L, mockHttpServletRequest.getContentLengthLong());
    }

    /**
     * Method under test: {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal2() throws IOException, ServletException {
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        authTokenFilter.doFilterInternal(null, response, filterChain);
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        HttpServletResponse response1 = response.getResponse();
        assertTrue(response1 instanceof ResponseFacade);
        assertSame(response.getOutputStream(), response1.getOutputStream());
        assertTrue(authTokenFilter.getEnvironment() instanceof StandardServletEnvironment);
    }

    /**
     * Method under test: {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal3() throws IOException, ServletException {
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getHeader((String) any())).thenReturn("https://example.org/example");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        authTokenFilter.doFilterInternal(defaultMultipartHttpServletRequest, response, filterChain);
        verify(defaultMultipartHttpServletRequest).getHeader((String) any());
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
    }

    /**
     * Method under test: {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal4()
            throws TokenInvalidException, IOException, ServletException, UsernameNotFoundException {
        when(jwtHandler.getUserNameFromJwtToken((String) any())).thenReturn("janedoe");
        when(jwtHandler.validateJwtToken((String) any())).thenReturn(true);
        when(userDetailsServiceImpl.loadUserByUsername((String) any())).thenReturn(new UserDetailPrincipal(new User()));
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getRemoteAddr()).thenReturn("42 Main St");
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean())).thenReturn(new MockHttpSession());
        when(defaultMultipartHttpServletRequest.getHeader((String) any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        authTokenFilter.doFilterInternal(defaultMultipartHttpServletRequest, response, filterChain);
        verify(jwtHandler).validateJwtToken((String) any());
        verify(jwtHandler).getUserNameFromJwtToken((String) any());
        verify(userDetailsServiceImpl).loadUserByUsername((String) any());
        verify(defaultMultipartHttpServletRequest).getRemoteAddr();
        verify(defaultMultipartHttpServletRequest).getHeader((String) any());
        verify(defaultMultipartHttpServletRequest).getSession(anyBoolean());
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
    }

    /**
     * Method under test: {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal5()
            throws TokenInvalidException, IOException, ServletException, UsernameNotFoundException {
        when(jwtHandler.getUserNameFromJwtToken((String) any())).thenReturn("janedoe");
        when(jwtHandler.validateJwtToken((String) any())).thenReturn(false);
        when(userDetailsServiceImpl.loadUserByUsername((String) any())).thenReturn(new UserDetailPrincipal(new User()));
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getRemoteAddr()).thenReturn("42 Main St");
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean())).thenReturn(new MockHttpSession());
        when(defaultMultipartHttpServletRequest.getHeader((String) any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        authTokenFilter.doFilterInternal(defaultMultipartHttpServletRequest, response, filterChain);
        verify(jwtHandler).validateJwtToken((String) any());
        verify(defaultMultipartHttpServletRequest).getHeader((String) any());
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
    }

    /**
     * Method under test: {@link AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    void testDoFilterInternal6()
            throws TokenInvalidException, IOException, ServletException, UsernameNotFoundException {
        when(jwtHandler.getUserNameFromJwtToken((String) any())).thenReturn("janedoe");
        when(jwtHandler.validateJwtToken((String) any())).thenReturn(true);
        when(userDetailsServiceImpl.loadUserByUsername((String) any())).thenReturn(null);
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getRemoteAddr()).thenReturn("42 Main St");
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean())).thenReturn(new MockHttpSession());
        when(defaultMultipartHttpServletRequest.getHeader((String) any())).thenReturn("Bearer ");
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
        authTokenFilter.doFilterInternal(defaultMultipartHttpServletRequest, response, filterChain);
        verify(jwtHandler).validateJwtToken((String) any());
        verify(jwtHandler).getUserNameFromJwtToken((String) any());
        verify(userDetailsServiceImpl).loadUserByUsername((String) any());
        verify(defaultMultipartHttpServletRequest).getHeader((String) any());
        verify(filterChain).doFilter((ServletRequest) any(), (ServletResponse) any());
    }
}

