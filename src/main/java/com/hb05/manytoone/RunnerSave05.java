package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {


        University university = new University();
        university.setId(101);
        university.setName("TPE Unversity");

        Student05 student1 = new Student05();
        student1.setId(1001);
        student1.setName("Atilgan Sahin");
        student1.setGrade(90);
        student1.setUniversity(university);

        Student05 student2 = new Student05();
        student2.setId(1002);
        student2.setName("Eray");
        student2.setGrade(80);
        student2.setUniversity(university);

        Student05 student3 = new Student05();
        student3.setId(1003);
        student3.setName("Ahmet Zeki");
        student3.setGrade(70);
        student3.setUniversity(university);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(university);

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sf.close();
    }
}
