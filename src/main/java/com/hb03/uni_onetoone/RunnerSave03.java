package com.hb03.uni_onetoone;

import com.hb01.annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Student03 student1 = new Student03();
        student1.setId(1001);
        student1.setName("Atilgan Ulasan");
        student1.setGrade(90);

        Student03 student2 = new Student03();
        student2.setId(1002);
        student2.setName("Ridvan Adigüzel");
        student2.setGrade(90);

        Student03 student3 = new Student03();
        student3.setId(1003);
        student3.setName("Errayn Calik");
        student3.setGrade(90);

        Diary01 diary1 = new Diary01();
        diary1.setId(101);
        diary1.setName("Atilgan'in Günlügü");
        diary1.setStudent03(student1);

        Diary01 diary2 = new Diary01();
        diary2.setId(102);
        diary2.setName("Ridvan'in Günlügü");
        diary2.setStudent03(student2);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary01.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);

        tx.commit();
        session.close();
        sf.close();

    }
}
