package com.hb06.bi_onetomany;

import javax.persistence.*;

@Entity
@Table(name="t_book07")
public class Book07 {

    @Id
    private int id;

    @Column(name="book_name",nullable = false,length = 100)
    private String name;

    @ManyToOne
    @JoinColumn
    private Student07 student;

    public Book07(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book07 () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
