package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {


       Student04 student1 = new Student04();
       student1.setId(1001);
       student1.setName("Emir");
       student1.setGrade(90);

        Student04 student2 = new Student04();
        student2.setId(1002);
        student2.setName("Fatih Arzu");
        student2.setGrade(90);

        Student04 student3 = new Student04();
        student3.setId(1003);
        student3.setName("Ridvan A");
        student3.setGrade(90);

        Diary02 diary1 = new Diary02();
        diary1.setId(101);
        diary1.setName("Emir Diary");
        diary1.setStudent04(student1);

        Diary02 diary2 = new Diary02();
        diary2.setId(102);
        diary2.setName("Ridvar Diary");
        diary2.setStudent04(student2);

        Diary02 diary3 = new Diary02();
        diary3.setId(103);
        diary3.setName("Ögrencisi olmayan günlük");



        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student04.class).addAnnotatedClass(Diary02.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
/*
        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);

 */
        session.save(diary3);

        tx.commit();
        session.close();
        sf.close();
    }
}
