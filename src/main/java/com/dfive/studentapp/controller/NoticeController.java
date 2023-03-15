package com.dfive.studentapp.controller;


import com.dfive.studentapp.entity.Notice;

import com.dfive.studentapp.entity.PublicNotice;
import com.dfive.studentapp.entity.Student;
import com.dfive.studentapp.entity.User;
import com.dfive.studentapp.repository.UserRepository;
import com.dfive.studentapp.service.Impl.NoticeService;

import com.dfive.studentapp.service.Impl.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/notice")
public class NoticeController {


    @Autowired
    private NoticeService noticeService;


    @Autowired
    private UserRepository userRepository;



    @Autowired
private StudentService studentService;

    @GetMapping("/{noticeId}")
    public ResponseEntity<Notice> getNotice(@PathVariable("noticeId") Long noticeId) {
        Optional<Notice> noticeOptional = this.noticeService.getNotice(noticeId);
        if (noticeOptional.isPresent()) {
            return ResponseEntity.ok(noticeOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/")
    public ResponseEntity<Notice> addNotice(@RequestBody Notice notice) {
        Long studentId = notice.getStudentId();

        Notice notice1 = this.noticeService.addNotice(notice);
        return ResponseEntity.ok(notice1);
    }

    @GetMapping("/")
    public ResponseEntity<?> getNotices() {
        return ResponseEntity.ok(this.noticeService.getNotices());
    }

    @DeleteMapping("/{noticeId}")
    public void deleteNotice(@PathVariable("noticeId") Long noticeId) {
        this.noticeService.deleteNotice(noticeId);

    }

    @GetMapping("/{studentId}/notices")
    public ResponseEntity<List<Notice>> getNoticesByStudentId(@PathVariable Long studentId) {
        List<Notice> notices = this.noticeService.getNoticesByStudentId(studentId);
        if (notices.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(notices);
        }
    }

    @GetMapping("/{studentClassId}/classes")
    public ResponseEntity<List<Notice>> getNoticesByStudentClassId(@PathVariable Long studentClassId) {
        List<Notice> notices = this.noticeService.getNoticesByStudentClassId(studentClassId);
        if (notices.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(notices);
        }
    }
    @GetMapping("/user/{userId}")
    public List<Notice> getNoticesByUserId(@PathVariable Long userId) {
        List<Notice> notices = this.noticeService.getNoticesByUserId(userId);
        notices.sort((n1, n2) -> n2.getCreationDate().compareTo(n1.getCreationDate()));
        return notices;
    }
    @PutMapping("/{noticeId}")
    public Notice updateNotice(@PathVariable Long noticeId, @RequestBody Notice notice) {
        notice.setId(noticeId);
        return this.noticeService.updateNotice(notice);
    }






}