package practice.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import practice.embeddable.Developer02;

public class RunnerSave04 {
    public static void main(String[] args) {


        Company com1 = new Company(11,"Google");
        Company com2 = new Company(22,"Amazon");

        Developer04 dev1=new Developer04(1,"HarryPotter","hp@gmail.com","backend",com1);
        Developer04 dev2=new Developer04(2,"Shrek","shrek@gmail.com","frontend",com1);
        Developer04 dev3=new Developer04(3,"JackSparrow","jack@gmail.com","mobile",com2);
        Developer04 dev4=new Developer04(4,"Richie Rich","rich@gmail.com","fullstack",com2);
        Developer04 dev5=new Developer04(5,"Gandalf","gandalf@gmail.com","backend",com2);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(com1);
        session.save(com2);

        session.save(dev1);
        session.save(dev2);
        session.save(dev3);
        session.save(dev4);
        session.save(dev5);

        tx.commit();
        session.close();
        sf.close();
    }
}
