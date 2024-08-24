package com.roms.authentication.service.service_Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.roms.authentication.entity.Caregiver;
import com.roms.authentication.entity.User;
import com.roms.authentication.exception.UserNotFoundException;
import com.roms.authentication.model.UserDetailPrincipal;
import com.roms.authentication.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserDetailsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
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
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = userDetailsServiceImpl.loadUserByUsername("janedoe");
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertEquals(123L, ((UserDetailPrincipal) actualLoadUserByUsernameResult).getId());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        User user = mock(User.class);
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getId()).thenReturn(123L);
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
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = userDetailsServiceImpl.loadUserByUsername("janedoe");
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertEquals(123L, ((UserDetailPrincipal) actualLoadUserByUsernameResult).getId());
        verify(userRepository).findByUsername((String) any());
        verify(user).getPassword();
        verify(user).getUsername();
        verify(user).getId();
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

    /**
     * Method under test: {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        when(userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        User user = mock(User.class);
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getId()).thenReturn(123L);
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
        assertThrows(UserNotFoundException.class, () -> userDetailsServiceImpl.loadUserByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
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

