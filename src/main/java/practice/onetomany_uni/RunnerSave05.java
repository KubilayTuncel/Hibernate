package practice.onetomany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import practice.manytoone.Company;
import practice.manytoone.Developer04;

import java.util.HashSet;
import java.util.Set;

public class RunnerSave05 {
    public static void main(String[] args) {

        Developer05 dev1=new Developer05(1,"HarryPotter","hp@gmail.com","backend");
        Developer05 dev2=new Developer05(2,"Shrek","shrek@gmail.com","frontend");
        Developer05 dev3=new Developer05(3,"JackSparrow","jack@gmail.com","mobile");
        Developer05 dev4=new Developer05(4,"Richie Rich","rich@gmail.com","fullstack");
        Developer05 dev5=new Developer05(5,"Gandalf","gandalf@gmail.com","backend");

        Company02 com1 = new Company02(11,"Google");
        Company02 com2 = new Company02(22,"Amazon");

        Set<Developer05> devset1 = new HashSet<>();
        devset1.add(dev3);
        devset1.add(dev4);
        devset1.add(dev5);

        com1.getDevelopers().add(dev1);
        com1.getDevelopers().add(dev2);
        com2.setDevelopers(devset1);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer05.class).addAnnotatedClass(Company02.class);
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
