package com.dfive.studentapp.repository;

import com.dfive.studentapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {


    List<Student> findByStudentClassId(Long classId);

    List<Student> findByStudentId(Long studentId);
}