package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetcht05 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student05 student1 = session.get(Student05.class,1001);

        //HQL ile 101 id li universiteye giden bütün ögrencileri bulalim

        String hqlQuery ="from Student05 s where s.university.id=101";
        List<Student05> resultList = session.createQuery(hqlQuery, Student05.class).getResultList();

        resultList.forEach(t-> System.out.println(t));



        tx.commit();
        session.close();
        sf.close();
    }
}
