package com.dfive.studentapp.service;

import com.dfive.studentapp.entity.Student;
import com.dfive.studentapp.entity.StudentClass;
import com.dfive.studentapp.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;


    @Autowired
    private ClassService classService;

    public StudentClass addClass(StudentClass studentClass) {
        return classRepository.save(studentClass);
    }


    public Optional<StudentClass> getClass(Long id) {return classRepository.findById(id);
    }

    public List<StudentClass> getClasses() {return classRepository.findAll();
    }


    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    public Class updateClass(StudentClass studentClass) {
        return classRepository.save(studentClass).getClass();
    }
}
