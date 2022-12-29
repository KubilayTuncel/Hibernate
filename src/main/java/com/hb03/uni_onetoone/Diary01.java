package com.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary01 {

    @Id
    private int id;

    private String name;

    @OneToOne  //Bu anatation primary-foreign key olarak calisiyor.
    @JoinColumn(name="std_id") //name parametresini setlemezsek default deger olarak student_id olusturur.
    private Student03 student03;

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

    public Student03 getStudent03() {
        return student03;
    }

    public void setStudent03(Student03 student03) {
        this.student03 = student03;
    }

    @Override
    public String toString() {
        return "Diary01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student03=" + student03 +
                '}';
    }
}
