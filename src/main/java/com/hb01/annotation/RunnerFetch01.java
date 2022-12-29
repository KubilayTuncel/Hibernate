package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // DB den bilgi almak icin 3 yol vardir.

        // 1) get()
        // 2) SQL kodlari ile
        // 3) HQL kodlari ile

        // 1.yol : get() methodu ile

          Student01 student1 = session.get(Student01.class,1001);
          Student01 student2 = session.get(Student01.class,1002);
          Student01 student3 = session.get(Student01.class,1003);
          System.out.println(student1);
          System.out.println(student2);
          System.out.println(student3);

        // 2. yol : SQL ile

        String sqlQuery = "select * from t_student01";
        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();

        for (Object[] object:resultList ){
            System.out.println(Arrays.toString(object));
        }

        // 3. yol : HQL ile
         // Trick : SQL sorgusunda fromdan sonra sinif ismi kullanilmali

        String hqlQuery = "from Student01";
        List<Student01> resultList2 = session.createQuery(hqlQuery,Student01.class).getResultList();
        for (Student01 student:resultList2
             ) {
            System.out.println(student.toString());
        }

        //uniqueResult with SQL
        // Dönecek kaydin unique oldugundan emin iseniz uniqueResult() methodu kullanilabilir.

        String sqlQuery2 = "select * from t_student01 where student_name='Tarik Sever'";
        Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println("SQL kodu ile : "+Arrays.toString(uniqueResult1));

        //Yukarida 1 obje gelecek ama icinde kolonlar oldugu icin array türünde obje geldi.

        //uniqueResult with HQL

        String hqlQuery2 = "from Student01 where name='Tarik Sever'";
        Student01 uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
        System.out.println("HQL kodu ile : "+uniqueResult2);

        //yukaridaki sorguyu Alias kullanarak yapalim.
        String hqlQuery3 = "from Student01 std where std.name='Mirac'";
        Student01 uniqueResult3 = session.createQuery(hqlQuery3, Student01.class).uniqueResult();
        System.out.println("Alias ile : " + uniqueResult3);

        //grade degeri 90 olan ögrenciyi getirelimm.

        String hqlQuery4 = "select s.id, s.name from Student01 s where s.grade =90";
        List<Object[]> resultList4 = session.createQuery(hqlQuery4).getResultList();

        //// createQuery metoduna tek parametre girdiğimiz için Student01 clası ile mappleme işlemi yapılmadı
        //        // bu yüzden Object olarak aldık
        for (Object[] object:resultList4
             ) {
            System.out.println(Arrays.toString(object));

        }

        tx.commit();

        session.close();
        sf.close();


    }
}
