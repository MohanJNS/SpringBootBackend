package com.dfive.studentapp;

import com.dfive.studentapp.entity.Role;
import com.dfive.studentapp.entity.User;
import com.dfive.studentapp.entity.UserRole;
import com.dfive.studentapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class StudentAppApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;


	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception{
		System.out.println("starting code");
//
//		User user = new User();
//		user.setFirstName("Mohan");
//		user.setLastName("Kumar");
//		user.setUsername("mohan");
//		user.setPassword(this.bCryptPasswordEncoder.encode("1234"));
//
//
//		user.setEmail("mohan123@gmail.com");
//		user.setProfile("default.png");
//
//
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//		User user1 = this.userService.createUser(user,userRoleSet);
//		System.out.println(user1.getUsername());
	}
}


