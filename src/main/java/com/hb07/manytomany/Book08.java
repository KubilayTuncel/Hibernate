package com.hb07.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book08 {

    @Id
    private int id;

    @Column(length = 100)
    private String name;

    @ManyToMany (mappedBy = "bookList")
    private List<Student08> students = new ArrayList<>();

    public Book08(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book08 () {}

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

    public List<Student08> getStudents() {
        return students;
    }

    public void setStudents(List<Student08> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Book08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
