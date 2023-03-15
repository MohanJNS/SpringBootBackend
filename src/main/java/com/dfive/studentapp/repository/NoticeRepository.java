package com.dfive.studentapp.repository;

import com.dfive.studentapp.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long> {
    List<Notice> findByStudentId(Long studentId);

    List<Notice> findByStudentClassId(Long studentClassId);



//    List<Notice> getNoticesForUser(Long classId);
    @Query(value = "select * from notices where student_class_id is Null or student_class_id = ?1",nativeQuery = true)
    public List<Notice> getNoticesForUser(Long classId);

//    List<Notice> findByNoticeId(Long studentClassId);
}
