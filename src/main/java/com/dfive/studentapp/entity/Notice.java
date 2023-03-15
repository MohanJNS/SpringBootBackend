package com.dfive.studentapp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "notices")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String noticeTitle;

    @Column
    private Long studentClassId;


    @Column
    private Long studentId;

    @Column
    private String noticeMsg;

    @Temporal(TemporalType.DATE)
    @Column
    private Date creationDate;


    public Notice() {
    }

    public Notice(Long id, String noticeTitle, Long studentClassId, Long studentId, String noticeMsg, Date creationDate) {
        this.id = id;
        this.noticeTitle = noticeTitle;
        this.studentClassId = studentClassId;
        this.studentId = studentId;
        this.noticeMsg = noticeMsg;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }


    public Long getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(Long studentClassId) {
        this.studentClassId = studentClassId;
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getNoticeMsg() {
        return noticeMsg;
    }

    public void setNoticeMsg(String noticeMsg) {
        this.noticeMsg = noticeMsg;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


}