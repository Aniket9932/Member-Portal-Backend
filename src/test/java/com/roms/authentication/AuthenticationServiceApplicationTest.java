package com.roms.authentication;

import static org.mockito.Mockito.mock;

import com.roms.authentication.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class AuthenticationServiceApplicationTest {
    /**
     * Method under test: {@link AuthenticationServiceApplication#AuthenticationServiceApplication(UserRepository, PasswordEncoder)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     AuthenticationServiceApplication.passwordEncoder
        //     AuthenticationServiceApplication.userRepository

        UserRepository userRepository = mock(UserRepository.class);
        new AuthenticationServiceApplication(userRepository, new Argon2PasswordEncoder());

    }

    /**
     * Method under test: {@link AuthenticationServiceApplication#run(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRun() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        AuthenticationServiceApplication authenticationServiceApplication = null;
        String[] args = null;

        // Act
        authenticationServiceApplication.run(args);

        // Assert
        // TODO: Add assertions on result
    }
}

