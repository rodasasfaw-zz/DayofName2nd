package com.nameofday.demo.Models;

import org.springframework.format.annotation.DateTimeFormat;
import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class DateofBirth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
  @DateTimeFormat(pattern = "MMM,d,YYYY")
    private Date date;
    private String name;
    private String sex;

    public DateofBirth() {
    }

    public DateofBirth(Date date, String name, String sex) {
        this.date = date;
        this.name = name;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
