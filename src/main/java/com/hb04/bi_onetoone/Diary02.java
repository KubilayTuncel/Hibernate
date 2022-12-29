package com.hb04.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name="t_diary02")
public class Diary02 {

    @Id
    private int id;

    @Column (name="diary_name", length = 100)
    private String name;

    @OneToOne
    @JoinColumn
    private Student04 student04;


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

    public Student04 getStudent04() {
        return student04;
    }

    public void setStudent04(Student04 student04) {
        this.student04 = student04;
    }

    @Override
    public String toString() {
        return "Diary02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student04=" + student04 +
                '}';
    }

}
