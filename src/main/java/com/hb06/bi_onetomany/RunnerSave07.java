package com.hb06.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {


        Student07 student1 = new Student07(1001,"Seyma Özcam",95);
        Student07 student2 = new Student07(1002,"Recep Gün",25);
        Student07 student3 = new Student07(1003,"Emir Salman",55);

        Book07 book1 = new Book07(101,"Math Book");
        Book07 book2 = new Book07(102,"Art Book");
        Book07 book3 = new Book07(103,"Java Book");
        Book07 book4 = new Book07(104,"A Book");
        Book07 book5 = new Book07(105,"B Book");

        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sf.close();
    }
}
