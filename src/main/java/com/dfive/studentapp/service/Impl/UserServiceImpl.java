package com.dfive.studentapp.service.Impl;

import com.dfive.studentapp.entity.User;
import com.dfive.studentapp.entity.UserRole;
import com.dfive.studentapp.repository.RoleRepository;
import com.dfive.studentapp.repository.UserRepository;
import com.dfive.studentapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Set;




@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;





    @Override
    public User createUser(User user, Set<UserRole> userRoles) {

        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !");
            throw new RuntimeException("User already present !!");
        } else {
            // validate student id
            User userWithSameId = this.userRepository.findByStudentId(user.getStudentId());
            if (userWithSameId != null) {
                System.out.println("Student ID is already registered!");
                throw new RuntimeException("Student ID already registered!");
            }

            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }

        return null;
    }




    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }


    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.getById(id);
    }




}
