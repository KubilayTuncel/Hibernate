package com.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="t_student05")
public class Student05 {

    @Id
    private int id;

    @Column(name="student_name", nullable = false)
    private String name;

    private int grade;

    private LocalDateTime createOn;  //create edime tarihi

    @ManyToOne
    @JoinColumn(name="university_id")
    private University university;

    @PrePersist  //Bu anatation method icerisindeki degerin database e persist(yani gönderildigi) an olusmasi zamani baz almasini saglar.
    public void prePersist(){
        createOn = LocalDateTime.now();
    }

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

    public LocalDateTime getCreateOn() {
        return createOn;
    }
/*
    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }
     Burayi yoruma aldik. Cünkü create olusturulduktan sonra bir daha degistirilmemesi icin set methodunu kullanmiyoruz.
 */

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
