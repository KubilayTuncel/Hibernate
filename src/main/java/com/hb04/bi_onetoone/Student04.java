package com.hb04.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name="t_student04")
public class Student04 {

    @Id
    private int id;

    @Column(name="std_name",length = 100, nullable = false)
    private String name;

    private int grade;

    @OneToOne(mappedBy = "student04") //sadece Diary tablosunda iliski icin yeni kolon olusmasini sagliyor.
    private Diary02 diary02;         // Diger türlü her iki tarafta da id icin kolon acar.



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

    public Diary02 getDiary02() {
        return diary02;
    }

    public void setDiary02(Diary02 diary02) {
        this.diary02 = diary02;
    }

    //Method ciktisinda sonsuz döngüye girilmesin diye diary objesi eklenmedi.
    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
