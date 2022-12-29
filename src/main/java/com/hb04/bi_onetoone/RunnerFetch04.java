package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary02.class);
        SessionFactory sf =con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student04 student1 = session.get(Student04.class,1001);
        Diary02 diary1 = session.get(Diary02.class,101);

        System.out.println(student1);
        System.out.println("**************************");
        System.out.println(diary1);

        System.out.println("**************************");
        System.out.println(diary1.getStudent04());
        System.out.println(student1.getDiary02());

        //Kesisim kümesini getirelim.(innerjoin yapacagiz)

        String hqlQuery = "select s.name,d.name from Student04 s inner join fetch Diary02 d on s.id=d.student04";
        List<Object[]> resultList = session.createQuery(hqlQuery).getResultList();

        for (Object[] object:resultList
             ) {
            System.out.println(Arrays.toString(object));
        }

        //lamda ile yukaridaki foreach islemi
        //resultList.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        //left join
        //bütün ögrenciler ve kitabi olan ögrenciler nelerdir.
        String hqlQuery2 = "select s.name,d.name from Student04 s left join fetch Diary02 d on s.id=d.student04.id"; //id yazsakta son kisma yazmasakta hibernate anliyor.
        List<Object[]> resultList2  =session.createQuery(hqlQuery2).getResultList();

        resultList2.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        //right join
        String hqlQuery3 = "select s.name,d.name from Student04 s right join fetch Diary02 d on s.id=d.student04.id"; //id yazsakta son kisma yazmasakta hibernate anliyor.
        List<Object[]> resultList3  =session.createQuery(hqlQuery3).getResultList();

        resultList3.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        //full join
        String hqlQuery4 = "select s.name,d.name from Student04 s full join fetch Diary02 d on s.id=d.student04.id"; //id yazsakta son kisma yazmasakta hibernate anliyor.
        List<Object[]> resultList4  =session.createQuery(hqlQuery4).getResultList();

        resultList4.stream().forEach(t-> System.out.println(Arrays.toString(t)));


        tx.commit();
        session.close();
        sf.close();
    }
}
