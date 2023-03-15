package com.dfive.studentapp.repository;

import com.dfive.studentapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

public User findByUsername(String username);

    public  User findByStudentId(Long studentId);



   public  User getById(Long id);

}
