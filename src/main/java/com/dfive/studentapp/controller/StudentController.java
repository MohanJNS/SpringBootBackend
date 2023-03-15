package com.dfive.studentapp.controller;


import com.dfive.studentapp.entity.Student;
import com.dfive.studentapp.entity.User;
import com.dfive.studentapp.repository.StudentRepository;
import com.dfive.studentapp.repository.UserRepository;

import com.dfive.studentapp.service.Impl.StudentService;
import com.dfive.studentapp.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private StudentRepository studentRepository;

    //get student
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable("studentId") Long studentId) {
        Optional<Student> studentOptional = this.studentService.getStudent(studentId);
        if (studentOptional.isPresent()) {
            return ResponseEntity.ok(studentOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //add student
    @PostMapping("/")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student student1 = this.studentService.addStudent(student);
        return ResponseEntity.ok(student1);
    }


    //get all students
    @GetMapping("/")
    public ResponseEntity<?> getStudents(){
        return ResponseEntity.ok(this.studentService.getStudents());
    }


    //update
    @PatchMapping("/{studentId}")
    public ResponseEntity<Student> patchStudent(@PathVariable Long studentId, @RequestBody Student partialUpdate) {
        Optional<Student> optionalStudent = this.studentService.getStudent(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            if (partialUpdate.getStudentName() != null) {
                student.setStudentName(partialUpdate.getStudentName());
            }
            if (partialUpdate.getClassName() != null) {
                student.setClassName(partialUpdate.getClassName());
            }
            if (partialUpdate.getPhoneNumber() != null) {
                student.setPhoneNumber(partialUpdate.getPhoneNumber());
            }

            if (partialUpdate.getStudentClassId() != null) {
                student.setStudentClassId(partialUpdate.getStudentClassId());
            }

            Student updated = this.studentService.updateStudent(student);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student student) throws NotFoundException {
        // Fetch User record based on studentId
        User user = userRepository.findByStudentId(student.getStudentId());
        if (user == null) {
            throw new NotFoundException("User not found for studentId: " + student.getStudentId());
        }


        // Update Student record based on User record
//        student.setUsername(user.getUsername());
        student.setStudentId(user.getStudentId());
//        student.setStudentClassId(user.getStudentClassId());
//        student.setClassName(user.getClassName());
//        student.setSection(user.getSection());
        // ... set other fields as needed

        // Save updated Student record to database
        student.setId(studentId);
        return studentRepository.save(student);
    }

    //delete

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable ("studentId") Long studentId){
        this.studentService.deleteStudent(studentId);

    }

    @GetMapping("/class/{classId}")
    public List<Student> getStudents(@PathVariable("classId") Long classId) {
        List<Student> studentList = this.studentService.getstudentsByclass(classId);
     return studentList;
    }

    @GetMapping("/count")
    public Long getStudentCount() {
        return studentRepository.count();
    }

}