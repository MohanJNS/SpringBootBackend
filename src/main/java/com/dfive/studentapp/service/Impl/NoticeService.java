package com.dfive.studentapp.service.Impl;


import com.dfive.studentapp.entity.Notice;
import com.dfive.studentapp.entity.PublicNotice;
import com.dfive.studentapp.entity.Student;
import com.dfive.studentapp.entity.User;
import com.dfive.studentapp.repository.NoticeRepository;
import com.dfive.studentapp.repository.StudentRepository;
import com.dfive.studentapp.repository.UserRepository;
import com.dfive.studentapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoticeService {

    @Autowired
    private NoticeService noticeService;


    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    public Notice addNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    public Optional<Notice> getNotice(Long id) {return noticeRepository.findById(id);
    }

    public List<Notice> getNotices() {return noticeRepository.findAll();
    }

    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }

    public Notice updateNotice(Notice notice) {
        return noticeRepository.save(notice);
    }


    public List<Notice> getNoticesByStudentId(Long studentId) {
        return this.noticeRepository.findByStudentId(studentId);
    }

    public List<Notice> getNoticesByStudentClassId(Long studentClassId) {
        return this.noticeRepository.findByStudentClassId(studentClassId);
    }


//    public List<Notice> getNoticesById(Long studentClassId) {
//        return this.noticeRepository.findByNoticeId(studentClassId);
//    }

    public List<Notice> getNoticesByUserId(Long userId) {
        User user = userService.getById(userId);
        List<Student> students = studentService.getStudentByStudentId(user.getStudentId());
        Long classId=null;
        if (students.size()>0){
            classId= students.get(0).getStudentClassId();
        }

        return noticeRepository.getNoticesForUser(classId);
    }
}
