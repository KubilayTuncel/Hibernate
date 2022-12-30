package com.hb06.bi_onetomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

       Student07 student1 = session.get(Student07.class,1001);
        System.out.println(student1);
        student1.getBookList().forEach(b-> System.out.println(b));

        //SQL ile ögrenci bilgilerini alalim

        String sqlQuery = "select s.student_name,b.book_name from t_student07 s inner join t_book07 b on s.id=b.student_id";
        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery).getResultList();

        resultList1.forEach(t-> System.out.println(Arrays.toString(t)));

        String hqlQuery = "select s.name,b.name from Student07 s inner join Book07 b on s.id = b.student.id";
        List<Object[]> resulList2 = session.createQuery(hqlQuery).getResultList();

        resulList2.forEach(t-> System.out.println(Arrays.toString(t)));


        tx.commit();
        session.close();
        sf.close();
    }
}
