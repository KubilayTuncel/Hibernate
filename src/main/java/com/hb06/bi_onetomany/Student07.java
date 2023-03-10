package com.hb06.bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_student07")
public class Student07 {

    @Id
    private int id;

    @Column(name="student_name", nullable = false,length = 100)
    private String name;

    private int grade;

    @OneToMany (mappedBy = "student",orphanRemoval = true,cascade = CascadeType.REMOVE) //cascadetype.remove ana objeyi silersen child ini da sil
    private List<Book07> bookList = new ArrayList<>();                                  //orphanREmoval ile cascade de ayni isi yapar.

    public Student07(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Student07 (){}

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
