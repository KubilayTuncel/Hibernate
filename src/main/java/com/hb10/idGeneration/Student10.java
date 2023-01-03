package com.hb10.idGeneration;

import javax.persistence.*;

@Entity
public class Student10 {

   /*
   Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken başlangıç değeri veya kaç tane id cachelenecek
   bu gibi bilgileri developer setliyebilir)
   MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur, içlerindeki en basitidir)

   GenerationType.AUTO ---> Hibernate otomatik olarak stratejiyi belirler
   GenerationType.TABLE ---> En yavaşı , oyüzden çok kullanılmıyor, çünkü id
    üretmek için ekstra tablo oluşturuyor
 */


    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE) //generator kisminda degeri asagidaki name ile ayni olmali
    @SequenceGenerator(name = "sequence",
                        sequenceName = "student_seq", //DB de olusacak sequence ismi
                        initialValue = 1000,  //Baslangic numarasi verebiliyoruz
                        allocationSize = 10 //Hazirda olusturdugu id sayisi (cacheleme islemi)
                        )
    @Id
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private int grade;

    public Student10 () {}

    public Student10(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    // Getter -Setter

    public int getId() {
        return id;
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

        // toSting()

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
