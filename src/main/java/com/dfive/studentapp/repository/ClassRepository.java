package com.dfive.studentapp.repository;

import com.dfive.studentapp.entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<StudentClass, Long> {


//    @Query("SELECT c FROM StudentClass c WHERE c.className = :className AND c.section = :section")
//    List<StudentClass> findByClassNameAndSectionName(String className, String section);
List<StudentClass> findByClassNameAndSection(String className, String section);


}
