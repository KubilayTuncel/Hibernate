package com.hb12.Entity_life_cycle;

import com.hb12.get_load.Student13;

import javax.persistence.*;

/*
Hinernate in Objeler ile nasıl çalıştığı ile ilgili ek bilgi :
   Entity State :
      *) Transient : Objenin newlenmiş hali, DB ile ilişkisi yok.

      *) Persisted or Managed : DB de row a karşılık geldiği durum,
                        save(),get() vs. yapıldığı zamana denk geliyor.

      *) Detached : Session kapandıktan sonra elimizdeki objenin state durumu.

      *) Removed : obje remove yapıldığı zmanki durum.
*/

@Entity
public class Student14 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    private int mathGrade;

    public Student14(String name, int mathGrade) {
        this.name = name;
        this.mathGrade = mathGrade;
    }

    public Student14 ( ) {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    @Override
    public String toString() {
        return "Student14{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}
