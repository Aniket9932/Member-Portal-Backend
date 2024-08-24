package com.roms.authentication.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roms.authentication.entity.Caregiver;
import com.roms.authentication.entity.User;
import com.roms.authentication.exception.TokenInvalidException;
import com.roms.authentication.payload.AuthResponse;
import com.roms.authentication.payload.LoginRequest;
import com.roms.authentication.security.JwtHandler;
import com.roms.authentication.service.service_Impl.CaregiverServiceImpl;
import com.roms.authentication.service.service_Impl.RegisterServiceImpl;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class})
@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private CaregiverServiceImpl caregiverServiceImpl;

    @MockBean
    private JwtHandler jwtHandler;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private RegisterServiceImpl registerServiceImpl;

    /**
     * Method under test: {@link AuthController#fetchUserList()}
     */
    @Test
    void testFetchUserList() throws Exception {
        when(registerServiceImpl.fetchUserList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/auth/users");
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuthController#fetchUserList()}
     */
    @Test
    void testFetchUserList2() throws Exception {
        when(registerServiceImpl.fetchUserList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/auth/users");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuthController#fetchUserByName(String)}
     */
    @Test
    void testFetchUserByName() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        when(registerServiceImpl.fetchUserByName((String) any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/auth/users/name/{name}", "Name");
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"username\":\"janedoe\",\"password\":\"iloveyou\",\"roles\":\"Roles\",\"firstName\":\"Jane\",\"lastName\":"
                                        + "\"Doe\",\"cid\":1,\"cname\":\"Cname\",\"caregivers\":[],\"address\":\"42 Main St\"}"));
    }

    /**
     * Method under test: {@link AuthController#updateUserByName(String, User)}
     */
    @Test
    void testUpdateUserByName() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        when(registerServiceImpl.updateUserByName((String) any(), (User) any())).thenReturn(user);

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/auth/user/{name}", "Name")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"username\":\"janedoe\",\"password\":\"iloveyou\",\"roles\":\"Roles\",\"firstName\":\"Jane\",\"lastName\":"
                                        + "\"Doe\",\"cid\":1,\"cname\":\"Cname\",\"caregivers\":[],\"address\":\"42 Main St\"}"));
    }

    /**
     * Method under test: {@link AuthController#assignCaregiver(String, String)}
     */
    @Test
    void testAssignCaregiver() throws Exception {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        when(registerServiceImpl.assignCaregiver((String) any(), (String) any())).thenReturn(caregiver);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/user/{uname}/caregiver/{cname}",
                "Uname", "Cname");
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"caregiverId\":123,\"caregiverName\":\"Caregiver Name\",\"phone\":\"4105551212\"}"));
    }

    /**
     * Method under test: {@link AuthController#assignCaregiver(String, String)}
     */
    @Test
    void testAssignCaregiver2() throws Exception {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        when(registerServiceImpl.assignCaregiver((String) any(), (String) any())).thenReturn(caregiver);
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders
                .formLogin();
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link AuthController#authenticateUser(LoginRequest)}
     */
    @Test
    void testAuthenticateUser() throws Exception {
        when(jwtHandler.generateJwtToken((Authentication) any())).thenReturn(new AuthResponse("janedoe", "ABC123"));
        when(authenticationManager.authenticate((Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("iloveyou");
        loginRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"userName\":\"janedoe\",\"token\":\"ABC123\"}"));
    }

    /**
     * Method under test: {@link AuthController#registerUser(User)}
     */
    @Test
    void testRegisterUser() throws Exception {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUsername("janedoe");
        when(registerServiceImpl.saveUser((User) any())).thenReturn(user);
        when(passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        User user1 = new User();
        user1.setAddress("42 Main St");
        user1.setCaregivers(new ArrayList<>());
        user1.setCid(1L);
        user1.setCname("Cname");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"username\":\"janedoe\",\"password\":\"iloveyou\",\"roles\":\"Roles\",\"firstName\":\"Jane\",\"lastName\":"
                                        + "\"Doe\",\"cid\":1,\"cname\":\"Cname\",\"caregivers\":[],\"address\":\"42 Main St\"}"));
    }

    /**
     * Method under test: {@link AuthController#validateAndReturnUser(String)}
     */
    @Test
    void testValidateAndReturnUser() throws Exception {
        when(jwtHandler.validateJwtToken((String) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/auth/validate")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link AuthController#validateAndReturnUser(String)}
     */
    @Test
    void testValidateAndReturnUser2() throws Exception {
        when(jwtHandler.validateJwtToken((String) any())).thenThrow(new TokenInvalidException("?"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/auth/validate")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(401));
    }
}

