package practice.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Developer03 dev1 = session.get(Developer03.class,1);
        System.out.println(dev1);

        System.out.println("***********************");

        Computer computer = session.get(Computer.class,1l);
        System.out.println(computer);

        Computer computer1 = session.get(Computer.class,2L);
        System.out.println(computer1.getDeveloper03());


        String hqlQuery ="from Developer03 d where d.computer.id=2L";
        System.out.println(session.createQuery(hqlQuery).getResultList());

        tx.commit();
        session.close();
        sf.close();

    }
}
