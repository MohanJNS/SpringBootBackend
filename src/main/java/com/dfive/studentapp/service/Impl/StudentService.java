package com.dfive.studentapp.service.Impl;

import com.dfive.studentapp.entity.Notice;
import com.dfive.studentapp.entity.Student;
import com.dfive.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getstudentsByclass(Long classId) {
        return studentRepository.findByStudentClassId(classId);
    }

    public List<Student> getStudentByStudentId(Long studentId) {
        return studentRepository.findByStudentId(studentId);
    }



}


