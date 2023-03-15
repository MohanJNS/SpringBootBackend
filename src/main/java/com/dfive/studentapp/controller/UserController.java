package com.dfive.studentapp.controller;

import com.dfive.studentapp.entity.Role;
import com.dfive.studentapp.entity.User;
import com.dfive.studentapp.entity.UserRole;
import com.dfive.studentapp.repository.UserRepository;
import com.dfive.studentapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //create user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception{
        user.setProfile("default.png");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
    Set<UserRole> roles=new HashSet<>();

    Role role = new Role();
    role.setRoleId(46l);
    role.setRoleName("STUDENT");
    UserRole userRole=new UserRole();
    userRole.setUser(user);
    userRole.setRole(role);
    roles.add(userRole);
        return  this.userService.createUser(user,roles);
    }





    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return  this.userService.getUser(username);
    }

    @GetMapping("users/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return  this.userService.getById(id);
    }


    @DeleteMapping("/{userId}")
    public  void deleteUser(@PathVariable("userId") Long userId){
    this.userService.deleteUser(userId);

    }

    @GetMapping("/count")
    public Long getUserCount() {
        return userRepository.count();
    }
}
