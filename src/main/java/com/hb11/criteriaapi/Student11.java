package com.hb11.criteriaapi;

import javax.persistence.*;

@Entity
public class Student11 {

    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sequence",
                        sequenceName = "student_seq",
                        initialValue = 1000,
                        allocationSize = 10)
    @Id
    private Long id;

    @Column(length = 50,nullable = false)
    private String name;

    private int grade;

    public Student11 () {}

    public Student11(Long id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }
/*Yukarida generator anatation kullandigimiz icin set methoduna gerek kalmadi.
    public void setId(Long id) {
        this.id = id;
    }

 */

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

    @Override
    public String toString() {
        return "Student11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
