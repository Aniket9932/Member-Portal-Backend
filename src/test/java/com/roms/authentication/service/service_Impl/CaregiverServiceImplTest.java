package com.roms.authentication.service.service_Impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.roms.authentication.entity.Caregiver;
import com.roms.authentication.repository.CaregiverRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CaregiverServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CaregiverServiceImplTest {
    @MockBean
    private CaregiverRepository caregiverRepository;

    @Autowired
    private CaregiverServiceImpl caregiverServiceImpl;

    /**
     * Method under test: {@link CaregiverServiceImpl#fetchCaregiverList()}
     */
    @Test
    void testFetchCaregiverList() {
        ArrayList<Caregiver> caregiverList = new ArrayList<>();
        when(caregiverRepository.findAll()).thenReturn(caregiverList);
        List<Caregiver> actualFetchCaregiverListResult = caregiverServiceImpl.fetchCaregiverList();
        assertSame(caregiverList, actualFetchCaregiverListResult);
        assertTrue(actualFetchCaregiverListResult.isEmpty());
        verify(caregiverRepository).findAll();
    }

    /**
     * Method under test: {@link CaregiverServiceImpl#fetchCaregiverById(Integer)}
     */
    @Test
    void testFetchCaregiverById() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        Optional<Caregiver> ofResult = Optional.of(caregiver);
        when(caregiverRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(caregiver, caregiverServiceImpl.fetchCaregiverById(123));
        verify(caregiverRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link CaregiverServiceImpl#fetchCaregiverById(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFetchCaregiverById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.roms.authentication.service.service_Impl.CaregiverServiceImpl.fetchCaregiverById(CaregiverServiceImpl.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        when(caregiverRepository.findById((Integer) any())).thenReturn(Optional.empty());
        caregiverServiceImpl.fetchCaregiverById(123);
    }

    /**
     * Method under test: {@link CaregiverServiceImpl#fetchCaregiverByName(String)}
     */
    @Test
    void testFetchCaregiverByName() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        when(caregiverRepository.findByCaregiverNameIgnoreCase((String) any())).thenReturn(caregiver);
        assertSame(caregiver, caregiverServiceImpl.fetchCaregiverByName("Caregiver Name"));
        verify(caregiverRepository).findByCaregiverNameIgnoreCase((String) any());
    }
}

