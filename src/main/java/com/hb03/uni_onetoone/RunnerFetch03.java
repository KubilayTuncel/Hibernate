package com.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary01.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //Student fetch(get) ediyoruz, id ile
        Student03 student1 = session.get(Student03.class,1001);

        Diary01 diary1 = session.get(Diary01.class,101);

        System.out.println(student1);
        System.out.println("*******************");
        System.out.println(diary1);
        System.out.println("*********************");
        System.out.println(diary1.getStudent03());

        tx.commit();
        session.close();
        sf.close();

    }
}
