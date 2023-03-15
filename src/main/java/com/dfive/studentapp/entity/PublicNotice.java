package com.dfive.studentapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name="public_notice")
public class PublicNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private String message;

    @Temporal(TemporalType.DATE)
    @Column
    private Date date;


    public PublicNotice() {
    }


    public PublicNotice(Long id, String title, String message, Date date) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
