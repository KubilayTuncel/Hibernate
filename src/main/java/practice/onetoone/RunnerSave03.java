package practice.onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {

    public static void main(String[] args) {

        Computer computer1 = new Computer(1L,"123465897","lagaluga");
        Computer computer2 = new Computer(2L,"123465899","lagaluga");
        Computer computer3 = new Computer(3L,"123465899","lagaluga");

        Developer03 dev1 = new Developer03(1,"hakan Caliskan","h.caliskan@gmail.com","frontend");
        Developer03 dev2 = new Developer03(2,"adnan Adivar","a.adivar@gmail.com","mobile");
        Developer03 dev3 = new Developer03(3,"Hülya Pirilti","h.pirilti@gmail.com","backend");

        dev1.setComputer(computer1);
        dev2.setComputer(computer2);
        dev3.setComputer(computer3);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(computer1);
        session.save(computer2);
        session.save(computer3);

        session.save(dev1);
        session.save(dev2);
        session.save(dev3);

        tx.commit();
        session.close();
        sf.close();

    }
}
