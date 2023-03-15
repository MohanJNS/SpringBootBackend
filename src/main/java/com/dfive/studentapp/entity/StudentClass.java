package com.dfive.studentapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="class")
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String className;
    @Column
    private String section;

    @Temporal(TemporalType.DATE)
    private Date createdAt = new Date();


    public StudentClass(Long id, String className, String section, Date createdAt) {
        this.id = id;
        this.className = className;
        this.section = section;
        this.createdAt = createdAt;
    }

    public StudentClass() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
