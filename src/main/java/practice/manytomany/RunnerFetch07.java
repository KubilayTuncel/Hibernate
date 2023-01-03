package practice.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer07.class).addAnnotatedClass(Project.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1--id=11 olan projede çalışan developer bilgilerini getiriniz.

        Project project1 = session.get(Project.class,11);
        project1.getDevelopers().forEach(t-> System.out.println(t));

        //2--id=1 olan developerın çalıştığı proje bilgilerini getiriniz.

        Developer07 dev1 = session.get(Developer07.class,1);
        dev1.getProjects().forEach(t-> System.out.println(t));

        tx.commit();
        session.close();
        sf.close();
    }
}
