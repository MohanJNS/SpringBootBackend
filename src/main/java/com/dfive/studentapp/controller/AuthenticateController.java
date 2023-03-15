package com.dfive.studentapp.controller;


import com.dfive.studentapp.config.JwtUtil;
import com.dfive.studentapp.entity.JwtRequest;
import com.dfive.studentapp.entity.JwtResponse;
import com.dfive.studentapp.entity.User;
import com.dfive.studentapp.service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserDetailsServiceImpl userDetailsService;



    @Autowired
    private JwtUtil jwtUtil;


    //generate token

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("User not found");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }



//    @PostMapping("/generate-token")
//    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
//        try {
//            // Authenticate student using their student ID and password
//            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("Student not found");
//        }
//
//        // Load student details from student database table
//        StudentDetails studentDetails = this.studentDetailsService.loadStudentByStudentId(jwtRequest.getUsername());
//
//        // Generate JWT token with student details
//        String token = this.jwtUtil.generateToken(studentDetails);
//        return ResponseEntity.ok(new JwtResponse(token));
//    }













    private void authenticate(String username, String password) throws Exception {

        try {
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        } catch (DisabledException e) {
            throw new Exception("USER DISABLED" +e.getMessage());

        }catch (BadCredentialsException e)
        {
        throw new Exception("Invalid Credentials"+e.getMessage());
        }
    }


    //return details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {
        return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
    }

}






