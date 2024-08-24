package com.roms.authentication.controller;

import com.roms.authentication.entity.Caregiver;
import com.roms.authentication.entity.User;
import com.roms.authentication.exception.TokenInvalidException;
import com.roms.authentication.payload.AuthResponse;
import com.roms.authentication.payload.LoginRequest;
import com.roms.authentication.security.JwtHandler;
import com.roms.authentication.service.service_Impl.CaregiverServiceImpl;
import com.roms.authentication.service.service_Impl.RegisterServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth") // Context Root
@CrossOrigin(origins = "*")
@Slf4j

public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtHandler jwtHandler;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private RegisterServiceImpl userService;

    @Autowired
    private CaregiverServiceImpl careService;

    public AuthController(AuthenticationManager authManager, JwtHandler jwtHandler, PasswordEncoder passwordEncoder) {
        this.authManager = authManager;
        this.jwtHandler = jwtHandler;
        this.passwordEncoder = passwordEncoder;
    }

    //Mapping for Authentication

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthResponse authResponse = jwtHandler.generateJwtToken(authentication);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @GetMapping("/validate")
    public boolean validateAndReturnUser(@RequestHeader("Authorization") String token) throws TokenInvalidException {
        return jwtHandler.validateJwtToken(token);
    }

    //Mappings for Registrations

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }

    //Mapping for Users

    @GetMapping("/users")
    public List<User> fetchUserList(){
        return userService.fetchUserList();
    }

    @GetMapping("/users/name/{name}")
    public User fetchUserByName(@PathVariable("name") String username){
        return userService.fetchUserByName(username);
    }


    @PutMapping("/user/{name}")
    public User updateUserByName(@PathVariable("name") String username,@RequestBody User user){
        return userService.updateUserByName(username,user);
    }

    @PostMapping("/user/{uname}/caregiver/{cname}")
    public Caregiver assignCaregiver(@PathVariable("uname") String uname,@PathVariable("cname") String cname){
        return userService.assignCaregiver(uname,cname);
    }




}
