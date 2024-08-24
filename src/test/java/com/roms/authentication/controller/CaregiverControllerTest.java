package com.roms.authentication.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.roms.authentication.entity.Caregiver;
import com.roms.authentication.service.service_Impl.CaregiverServiceImpl;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CaregiverController.class})
@ExtendWith(SpringExtension.class)
class CaregiverControllerTest {
    @Autowired
    private CaregiverController caregiverController;

    @MockBean
    private CaregiverServiceImpl caregiverServiceImpl;

    /**
     * Method under test: {@link CaregiverController#fetchCaregiverList()}
     */
    @Test
    void testFetchCaregiverList() throws Exception {
        when(caregiverServiceImpl.fetchCaregiverList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/auth/caregivers");
        MockMvcBuilders.standaloneSetup(caregiverController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CaregiverController#fetchCaregiverList()}
     */
    @Test
    void testFetchCaregiverList2() throws Exception {
        when(caregiverServiceImpl.fetchCaregiverList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/auth/caregivers");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(caregiverController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CaregiverController#fetchCaregiverById(Integer)}
     */
    @Test
    void testFetchCaregiverById() throws Exception {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        when(caregiverServiceImpl.fetchCaregiverById((Integer) any())).thenReturn(caregiver);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/auth/caregivers/{id}", 1);
        MockMvcBuilders.standaloneSetup(caregiverController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"caregiverId\":123,\"caregiverName\":\"Caregiver Name\",\"phone\":\"4105551212\"}"));
    }

    /**
     * Method under test: {@link CaregiverController#fetchCaregiverById(Integer)}
     */
    @Test
    void testFetchCaregiverById2() throws Exception {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        when(caregiverServiceImpl.fetchCaregiverById((Integer) any())).thenReturn(caregiver);
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders
                .formLogin();
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(caregiverController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CaregiverController#fetchCaregiverByName(String)}
     */
    @Test
    void testFetchCaregiverByName() throws Exception {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        when(caregiverServiceImpl.fetchCaregiverByName((String) any())).thenReturn(caregiver);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/auth/caregivers/name/{name}", "Name");
        MockMvcBuilders.standaloneSetup(caregiverController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"caregiverId\":123,\"caregiverName\":\"Caregiver Name\",\"phone\":\"4105551212\"}"));
    }
}

