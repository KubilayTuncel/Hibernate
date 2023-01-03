package practice.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import practice.onetomany_bi.Company03;
import practice.onetomany_bi.Developer06;

import java.util.HashSet;
import java.util.Set;

public class RunnerSave07 {

    public static void main(String[] args) {
        Developer07 dev1=new Developer07(1,"HarryPotter","hp@gmail.com","backend");
        Developer07 dev2=new Developer07(2,"Shrek","shrek@gmail.com","frontend");
        Developer07 dev3=new Developer07(3,"JackSparrow","jack@gmail.com","mobile");

        Project project1 = new Project(11,"CarRentalApp");
        Project project2 = new Project(22,"AtmApp");

        Set<Developer07> devSet1 = new HashSet<Developer07>();
        devSet1.add(dev1);
        devSet1.add(dev2);
        project1.setDevelopers(devSet1);

        Set<Developer07> devSet2 = new HashSet<Developer07>();
        devSet2.add(dev1);
        devSet2.add(dev2);
        devSet2.add(dev3);
        project2.setDevelopers(devSet2);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer07.class).addAnnotatedClass(Project.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(project1);
        session.save(project2); //Cascade type all oldugu icin developerlar da kendiliginden kayit altina alinip developer07 adinda table olusuyor.

        tx.commit();
        session.close();
        sf.close();
    }
}
