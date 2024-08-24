package com.roms.authentication.service.service_Impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.roms.authentication.entity.Caregiver;
import com.roms.authentication.entity.User;
import com.roms.authentication.repository.CaregiverRepository;
import com.roms.authentication.repository.UserRepository;

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

@ContextConfiguration(classes = {RegisterServiceImpl.class})
@ExtendWith(SpringExtension.class)
class RegisterServiceImplTest {
    @MockBean
    private CaregiverRepository caregiverRepository;

    @Autowired
    private RegisterServiceImpl registerServiceImpl;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link RegisterServiceImpl#saveUser(User)}
     */
    @Test
    void testSaveUser() {
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
        when(userRepository.save((User) any())).thenReturn(user);

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
        assertSame(user, registerServiceImpl.saveUser(user1));
        verify(userRepository).save((User) any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#saveUser(User)}
     */
    @Test
    void testSaveUser2() {
        when(userRepository.save((User) any())).thenThrow(new RuntimeException());

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
        assertThrows(RuntimeException.class, () -> registerServiceImpl.saveUser(user));
        verify(userRepository).save((User) any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#fetchUserList()}
     */
    @Test
    void testFetchUserList() {
        ArrayList<User> userList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList);
        List<User> actualFetchUserListResult = registerServiceImpl.fetchUserList();
        assertSame(userList, actualFetchUserListResult);
        assertTrue(actualFetchUserListResult.isEmpty());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link RegisterServiceImpl#fetchUserList()}
     */
    @Test
    void testFetchUserList2() {
        when(userRepository.findAll()).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> registerServiceImpl.fetchUserList());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link RegisterServiceImpl#updateUser(Long, User)}
     */
    @Test
    void testUpdateUser() {
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setCaregivers(new ArrayList<>());
        user2.setCid(1L);
        user2.setCname("Cname");
        user2.setFirstName("Jane");
        user2.setId(123L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setRoles("Roles");
        user2.setUsername("janedoe");
        assertSame(user1, registerServiceImpl.updateUser(123L, user2));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#updateUser(Long, User)}
     */
    @Test
    void testUpdateUser2() {
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
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.save((User) any())).thenThrow(new RuntimeException());
        when(userRepository.findById((Long) any())).thenReturn(ofResult);

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
        assertThrows(RuntimeException.class, () -> registerServiceImpl.updateUser(123L, user1));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#updateUser(Long, User)}
     */
    @Test
    void testUpdateUser3() {
        User user = mock(User.class);
        doNothing().when(user).setAddress((String) any());
        doNothing().when(user).setCaregivers((List<Caregiver>) any());
        doNothing().when(user).setCid(anyLong());
        doNothing().when(user).setCname((String) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRoles((String) any());
        doNothing().when(user).setUsername((String) any());
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setCaregivers(new ArrayList<>());
        user2.setCid(1L);
        user2.setCname("Cname");
        user2.setFirstName("Jane");
        user2.setId(123L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setRoles("Roles");
        user2.setUsername("janedoe");
        assertSame(user1, registerServiceImpl.updateUser(123L, user2));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(user).setAddress((String) any());
        verify(user).setCaregivers((List<Caregiver>) any());
        verify(user, atLeast(1)).setCid(anyLong());
        verify(user, atLeast(1)).setCname((String) any());
        verify(user, atLeast(1)).setFirstName((String) any());
        verify(user).setId(anyLong());
        verify(user, atLeast(1)).setLastName((String) any());
        verify(user, atLeast(1)).setPassword((String) any());
        verify(user, atLeast(1)).setRoles((String) any());
        verify(user, atLeast(1)).setUsername((String) any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#updateUser(Long, User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.roms.authentication.service.service_Impl.RegisterServiceImpl.updateUser(RegisterServiceImpl.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

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
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        User user1 = mock(User.class);
        doNothing().when(user1).setAddress((String) any());
        doNothing().when(user1).setCaregivers((List<Caregiver>) any());
        doNothing().when(user1).setCid(anyLong());
        doNothing().when(user1).setCname((String) any());
        doNothing().when(user1).setFirstName((String) any());
        doNothing().when(user1).setId(anyLong());
        doNothing().when(user1).setLastName((String) any());
        doNothing().when(user1).setPassword((String) any());
        doNothing().when(user1).setRoles((String) any());
        doNothing().when(user1).setUsername((String) any());
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

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setCaregivers(new ArrayList<>());
        user2.setCid(1L);
        user2.setCname("Cname");
        user2.setFirstName("Jane");
        user2.setId(123L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setRoles("Roles");
        user2.setUsername("janedoe");
        registerServiceImpl.updateUser(123L, user2);
    }

    /**
     * Method under test: {@link RegisterServiceImpl#fetchUserByName(String)}
     */
    @Test
    void testFetchUserByName() {
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
        when(userRepository.findByUsernameIgnoreCase((String) any())).thenReturn(user);
        assertSame(user, registerServiceImpl.fetchUserByName("janedoe"));
        verify(userRepository).findByUsernameIgnoreCase((String) any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#fetchUserByName(String)}
     */
    @Test
    void testFetchUserByName2() {
        when(userRepository.findByUsernameIgnoreCase((String) any())).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> registerServiceImpl.fetchUserByName("janedoe"));
        verify(userRepository).findByUsernameIgnoreCase((String) any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#assignCaregiver(String, String)}
     */
    @Test
    void testAssignCaregiver() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        when(caregiverRepository.findByCaregiverName((String) any())).thenReturn(caregiver);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsernameIgnoreCase((String) any())).thenReturn(user);
        assertSame(caregiver, registerServiceImpl.assignCaregiver("Uname", "Cname"));
        verify(caregiverRepository).findByCaregiverName((String) any());
        verify(userRepository).findByUsernameIgnoreCase((String) any());
        verify(userRepository).save((User) any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#assignCaregiver(String, String)}
     */
    @Test
    void testAssignCaregiver2() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        when(caregiverRepository.findByCaregiverName((String) any())).thenReturn(caregiver);

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
        when(userRepository.save((User) any())).thenThrow(new RuntimeException());
        when(userRepository.findByUsernameIgnoreCase((String) any())).thenReturn(user);
        assertThrows(RuntimeException.class, () -> registerServiceImpl.assignCaregiver("Uname", "Cname"));
        verify(caregiverRepository).findByCaregiverName((String) any());
        verify(userRepository).findByUsernameIgnoreCase((String) any());
        verify(userRepository).save((User) any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#assignCaregiver(String, String)}
     */
    @Test
    void testAssignCaregiver3() {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(123);
        caregiver.setCaregiverName("Caregiver Name");
        caregiver.setPhone("4105551212");
        when(caregiverRepository.findByCaregiverName((String) any())).thenReturn(caregiver);
        User user = mock(User.class);
        when(user.getCaregivers()).thenReturn(new ArrayList<>());
        doNothing().when(user).setAddress((String) any());
        doNothing().when(user).setCaregivers((List<Caregiver>) any());
        doNothing().when(user).setCid(anyLong());
        doNothing().when(user).setCname((String) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRoles((String) any());
        doNothing().when(user).setUsername((String) any());
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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsernameIgnoreCase((String) any())).thenReturn(user);
        assertSame(caregiver, registerServiceImpl.assignCaregiver("Uname", "Cname"));
        verify(caregiverRepository).findByCaregiverName((String) any());
        verify(userRepository).findByUsernameIgnoreCase((String) any());
        verify(userRepository).save((User) any());
        verify(user, atLeast(1)).getCaregivers();
        verify(user).setAddress((String) any());
        verify(user).setCaregivers((List<Caregiver>) any());
        verify(user).setCid(anyLong());
        verify(user).setCname((String) any());
        verify(user).setFirstName((String) any());
        verify(user).setId(anyLong());
        verify(user).setLastName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRoles((String) any());
        verify(user).setUsername((String) any());
    }
}

