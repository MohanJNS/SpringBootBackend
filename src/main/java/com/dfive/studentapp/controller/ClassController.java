package com.dfive.studentapp.controller;

import com.dfive.studentapp.entity.StudentClass;
import com.dfive.studentapp.repository.ClassRepository;
import com.dfive.studentapp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClassController {

    @Autowired
    private ClassService classService;
    @Autowired
    private ClassRepository classRepository;

    @PostMapping("/")
    public ResponseEntity<StudentClass> addClass(@RequestBody StudentClass studentClass) {
        StudentClass savedClass = this.classService.addClass(studentClass);
        return ResponseEntity.ok(savedClass);
    }

    @GetMapping("/{classId}")
    public ResponseEntity<StudentClass> getClass(@PathVariable("classId") Long classId) {
        Optional<StudentClass> studentClassOptional = this.classService.getClass(classId);
        if (studentClassOptional.isPresent()) {
            return ResponseEntity.ok(studentClassOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/")
    public ResponseEntity<?> getClasses(){
        return ResponseEntity.ok(this.classService.getClasses());
    }

    @DeleteMapping("/{classId}")
    public void deleteClass(@PathVariable ("classId") Long classId){
        this.classService.deleteClass(classId);

    }



    @PatchMapping ("/{classId}")
    public ResponseEntity<StudentClass> patchClass(@PathVariable("classId") Long classId, @RequestBody StudentClass updatedClass) {
        Optional<StudentClass> existingClassOptional = this.classService.getClass(classId);
        if (existingClassOptional.isPresent()) {
            StudentClass studentClass = existingClassOptional.get();
            studentClass.setId(updatedClass.getId());
            studentClass.setClassName(updatedClass.getClassName());
            studentClass.setSection(updatedClass.getSection());

            StudentClass savedClass = this.classService.addClass(studentClass);
            return ResponseEntity.ok(savedClass);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{classId}")
    public Class updateClass(@PathVariable Long classId, @RequestBody StudentClass studentClass) {
        studentClass.setId(classId);
        return this.classService.updateClass(studentClass);
    }


    @GetMapping("/classes")
    public List<StudentClass> getClasses(
            @RequestParam String className,
            @RequestParam String section) {
        return classRepository.findByClassNameAndSection(className, section);
    }


    @GetMapping("/count")
    public Long getClassCount() {
        return classRepository.count();
    }


}

