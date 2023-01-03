package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class RunnerFetch11 {
    public static void main(String[] args) {


        /*
        CRUD (Create, Read, Update, Delete)

        C --> session.save
        R --> session.get, HQL, SQL
        U --> session.update, updateQuery
        D --> session.delete, HQL, SQL

         */

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student11.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //Student11 student1 = session.get(Student11.class,1001L);
        //student1.setName("Güncellenmis : "+student1.getName());
        //session.update(student1);

        //degisken Tanimlama
        int sMathGrade = 80;
        int lMathGrade = 75;

        /*
        Bu sorgu, veritabanında "Student11" tablosunun "mathGrade" sütununda bulunan verileri güncellemek için kullanılır.
        "SET s.mathGrade=:sMath" ifadesi, "s.mathGrade" değerini ":sMath" değerine eşitler. "WHERE s.mathGrade<:lMath" ifadesi ise,
         "s.mathGrade" değerinin ":lMath" değerinden küçük olduğu satırları seçer. Bu sorguda, ":sMath" ve ":lMath" gibi
         etiketler girdi olarak kullanılmaktadır ve kullanıcı tarafından belirli değerlerle değiştirilmelidir.
         */
/*
       // String hqlQuery = "update Student11 s set s.grade=:sMath where s.grade<:lMath";
        String hqlQuery = "UPDATE Student11 s SET s.grade=:sMath WHERE s.grade<:lMath";
        Query query = session.createQuery(hqlQuery);

        query.setParameter("sMath",sMathGrade);
        query.setParameter("lMath",lMathGrade);
        int nummerOfRecord = query.executeUpdate();

        System.out.println("Degistirilen kayit saiysi : "+nummerOfRecord);


 */
        //!!!!CriteriaAPI ******************** ilk 3 satir standart yaziliyor.
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);

        //1. örnek

        criteriaQuery.select(root);
        Query<Student11> query1 = session.createQuery(criteriaQuery);
        List<Student11> resultList1 = query1.getResultList();
        resultList1.forEach(t-> System.out.println(t));



        // 2.Örnek , Student ismi "Student Name 6" olan öğrenci bilgilerini getirelim
        criteriaQuery.select(root).where(cb.equal(root.get("name"),"Student Name 6"));
        Query<Student11> query2 = session.createQuery(criteriaQuery);
        List<Student11> resultList2 = query2.getResultList();
        resultList2.forEach(t-> System.out.println(t));

        //3.Örnek grade degeri 80 den büyük olan datalar
        criteriaQuery.select(root).where(cb.greaterThan(root.get("grade"),80));
        Query<Student11> query3 = session.createQuery(criteriaQuery);
        List<Student11> resultList3 = query3.getResultList();
        resultList3.forEach(t-> System.out.println(t));

        //4.Örnek
        criteriaQuery.select(root).where(cb.lessThan(root.get("grade"),80));
        Query<Student11> query4 = session.createQuery(criteriaQuery);
        List<Student11> resultList4 = query4.getResultList();
        resultList4.forEach(t-> System.out.println(t));

        tx.commit();
        session.close();
        sf.close();
    }
}
