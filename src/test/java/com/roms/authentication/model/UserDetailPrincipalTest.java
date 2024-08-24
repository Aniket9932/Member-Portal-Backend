package com.roms.authentication.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.roms.authentication.entity.User;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserDetailPrincipalTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserDetailPrincipal#UserDetailPrincipal(User)}
     *   <li>{@link UserDetailPrincipal#getAuthorities()}
     *   <li>{@link UserDetailPrincipal#getPassword()}
     *   <li>{@link UserDetailPrincipal#getUsername()}
     *   <li>{@link UserDetailPrincipal#isAccountNonExpired()}
     *   <li>{@link UserDetailPrincipal#isAccountNonLocked()}
     *   <li>{@link UserDetailPrincipal#isCredentialsNonExpired()}
     *   <li>{@link UserDetailPrincipal#isEnabled()}
     * </ul>
     */
    @Test
    void testConstructor() {
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
        UserDetailPrincipal actualUserDetailPrincipal = new UserDetailPrincipal(user);
        assertNull(actualUserDetailPrincipal.getAuthorities());
        assertEquals("iloveyou", actualUserDetailPrincipal.getPassword());
        assertEquals("janedoe", actualUserDetailPrincipal.getUsername());
        assertTrue(actualUserDetailPrincipal.isAccountNonExpired());
        assertTrue(actualUserDetailPrincipal.isAccountNonLocked());
        assertTrue(actualUserDetailPrincipal.isCredentialsNonExpired());
        assertTrue(actualUserDetailPrincipal.isEnabled());
    }

    /**
     * Method under test: {@link UserDetailPrincipal#UserDetailPrincipal(User)}
     */
    @Test
    void testConstructor2() {
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
        UserDetailPrincipal actualUserDetailPrincipal = new UserDetailPrincipal(user);
        assertEquals("janedoe", actualUserDetailPrincipal.getUsername());
        assertEquals("iloveyou", actualUserDetailPrincipal.getPassword());
        assertEquals(123L, actualUserDetailPrincipal.getId());
    }
}

