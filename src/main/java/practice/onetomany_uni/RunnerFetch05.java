package practice.onetomany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer05.class).addAnnotatedClass(Company02.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1--Amazonda çalışan developer bilgilerini getiriniz.

         Company02 com1 = session.get(Company02.class,22);
        com1.getDevelopers().stream().forEach(t-> System.out.println(t));

        String hqlQuery ="";

        tx.commit();
        session.close();
        sf.close();
    }
}
