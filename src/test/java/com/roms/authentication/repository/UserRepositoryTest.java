package com.roms.authentication.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.roms.authentication.entity.User;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {UserRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.roms.authentication.entity"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    /**
     * Method under test: {@link UserRepository#findByUsername(String)}
     */
    @Test
    void testFindByUsername() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
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
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        userRepository.save(user);
        userRepository.save(user1);
        assertFalse(userRepository.findByUsername("foo").isPresent());
    }

    /**
     * Method under test: {@link UserRepository#findByUsernameIgnoreCase(String)}
     */
    @Test
    void testFindByUsernameIgnoreCase() {
        User user = new User();
        user.setAddress("42 Main St");
        user.setCaregivers(new ArrayList<>());
        user.setCid(1L);
        user.setCname("Cname");
        user.setFirstName("Jane");
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
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles("Roles");
        user1.setUsername("janedoe");
        userRepository.save(user);
        userRepository.save(user1);
        assertNull(userRepository.findByUsernameIgnoreCase("foo"));
    }
}

