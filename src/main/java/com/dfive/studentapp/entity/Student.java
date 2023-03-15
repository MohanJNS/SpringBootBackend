package com.dfive.studentapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String studentName;
    @Column
    private Long studentClassId;

    @Column
    private String className;
    @Column
    private String section;

    @Column
    private String gender;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column
    private Long studentId;
    @Column
    private String fatherName;
    @Column
    private String MotherName;

    @Column
    private String phoneNumber;
    @Column
    private String alternateNumber;
    @Column
    private String address;

    @Column
    private String image;
    @Temporal(TemporalType.DATE)
    private Date Admissiondate = new Date();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public Long getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(Long studentClassId) {
        this.studentClassId = studentClassId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAlternateNumber() {
        return alternateNumber;
    }

    public void setAlternateNumber(String alternateNumber) {
        this.alternateNumber = alternateNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getAdmissiondate() {
        return Admissiondate;
    }

    public void setAdmissiondate(Date admissiondate) {
        Admissiondate = admissiondate;
    }



}