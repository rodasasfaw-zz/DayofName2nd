package com.nameofday.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;
import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class DateofBirth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @DateTimeFormat(pattern = "MMM d,yyyy")
    private Date date;

    @Override
    public String toString() {
        return "DateofBirth{" +
                "zodiac='" + zodiac + '\'' +
                '}';
    }

    private String name="";
    private String sex="";
    private String zodiac="";

    public DateofBirth() {


    }

    public DateofBirth(Date date, String name, String sex) {
        this.date= date;
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

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }
}
