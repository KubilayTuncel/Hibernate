package practice.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import practice.anacation.Developer01;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch02 {

    public static void main(String[] args) {



        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer02.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Developer02 dev1 =session.get(Developer02.class,1);
        System.out.println(dev1);

        String hqlQuery1 = "select education from Developer02 where id=1";
        List<Object> resultSet1 = session.createQuery(hqlQuery1).getResultList();

        System.out.println(resultSet1);


        tx.commit();
        session.close();
        sf.close();
    }
}
