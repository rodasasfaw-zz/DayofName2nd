package com.nameofday.demo.Models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String day;
    private String name;

    public Name() {
    }

    public Name(String day, String name) {
        this.day = day;
        this.name = name;
    }
}
