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

       //Student07 student1 = session.get(Student07.class,1001);
        //System.out.println(student1);
        //student1.getBookList().forEach(b-> System.out.println(b));

        //SQL ile ögrenci bilgilerini alalim

        String sqlQuery = "select s.student_name,b.book_name from t_student07 s inner join t_book07 b on s.id=b.student_id";
        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery).getResultList();

        resultList1.forEach(t-> System.out.println(Arrays.toString(t)));

        String hqlQuery = "select s.name,b.name from Student07 s inner join Book07 b on s.id = b.student.id";
        List<Object[]> resulList2 = session.createQuery(hqlQuery).getResultList();

        resulList2.forEach(t-> System.out.println(Arrays.toString(t)));

        //!!! delete islemi SQL

        String sqlQuery2 = "delete from t_book07";
        //int nummerOfDeletedReport = session.createSQLQuery(sqlQuery2).executeUpdate();
        //System.out.println("Silinen kayit sayisi : "+nummerOfDeletedReport);

        //!!! delete islemi hql

        String hqlQuery2 = "delete from Student07";
        //int deletedStudent = session.createQuery(hqlQuery2).executeUpdate();
        //System.out.println("Silinen Student sayisi : "+deletedStudent);

        // Kitap ismi Abook olan Kitabi silme
        String hqlQuery3 = "delete from Book07 b where b.name='A Book'";
        //int deletedABook = session.createQuery(hqlQuery3).executeUpdate();
        //System.out.println("A book silindi :"+deletedABook);


        //Kitap bilgisi olan bir ögrenciyi silmek istersek 2 yolu vardir.
        //1) Önce book tablosundan iliskili oldugu kitaplar silinir
            //daha sonra istenen student objesi silinir.
        //2) Student entity clasinin ilgili yerine orphanRemoval

        //!!!1001 id li student ojemi delete methoduyla silelim.
       // Student07 student2 = session.get(Student07.class,1001);
        //session.delete(student2);
        //orphanRemoval true ya sset edildiginde  child tabloda null 'a setli kismlari da otomatik siler.

        //!!! book ismi icinde Java gecen student kayitlarini alalim(HQL)

        String hqlQuery4 = "select s from Student07 s inner join s.bookList b where b.name like '%Java%'";
        List<Student07> student3 = session.createQuery(hqlQuery4,Student07.class).getResultList();

        student3.forEach(t-> System.out.println(t));




        tx.commit();
        session.close();
        sf.close();
    }
}
