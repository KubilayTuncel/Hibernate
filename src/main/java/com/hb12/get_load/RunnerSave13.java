package com.hb12.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave13 {
    public static void main(String[] args) {

        Student13 student1 = new Student13("Mustafa Keser",35);
        Student13 student2 = new Student13("Yunus Sefa",25);
        Student13 student3 = new Student13("Halide Kayin",45);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student13.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sf.close();
    }
}
