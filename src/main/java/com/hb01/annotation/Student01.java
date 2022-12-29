package com.hb01.annotation;


import javax.persistence.*;


//@Entity annotation i koydugumuz sinifi DB de bir tabloya karsilik getirir.
//Yani Student01 class nin üstüne yazarak DB de bu isimle bir tablo olusturmamizi sagliyor.
@Entity
@Table(name="t_student01") //Db de tablo ismim parantez icerisindeki gibi olmasi icin bu annotation ve name metodunu kullandik.
public class Student01 { //DB ye gider "student01" (s kücük olarak alir) isminde tablo olusturur.

    //zorunlu alan cünkü uniqe olmasi lazim en az biri
    @Id  //bu annotation uniqe id atamasi yapiyor. //primary key olusmasini sagliyor.
    //@Column(name="std_id") kolon ismini bu sekilde de degistirebiliyoruz.
    private int id;

    //@Column zorunlu degil ancak custamize(degisiklik) edebilmek icin gerekli. Burada nullable bos birakilamaz demek bu sütün demek icin kullanildi
    @Column(name="student_name", length = 100, nullable = false, unique = false)
    private String name;

    //@Transient  //DB deki tabloda grade adinda bir kolon olusmasini engeller.
    private int grade;

    //@Lob // --> Large object ile büyük boyutlu datalar tutulabilir.
    //private byte[] image;


    //getter-setter


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

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
