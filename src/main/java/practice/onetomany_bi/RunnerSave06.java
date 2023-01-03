package practice.onetomany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {

        Developer06 dev1=new Developer06(1,"HarryPotter","hp@gmail.com","backend");
        Developer06 dev2=new Developer06(2,"Shrek","shrek@gmail.com","frontend");
        Developer06 dev3=new Developer06(3,"JackSparrow","jack@gmail.com","mobile");
        Developer06 dev4=new Developer06(4,"Richie Rich","rich@gmail.com","fullstack");
        Developer06 dev5=new Developer06(5,"Gandalf","gandalf@gmail.com","backend");

        Company03 com1 = new Company03(11,"Google");
        Company03 com2 = new Company03(22,"Amazon");
        Company03 com3 = new Company03(33,"Trendyol");

       dev1.setCompany(com1);
       dev2.setCompany(com1);
       dev3.setCompany(com2);
       dev4.setCompany(com2);
       dev5.setCompany(com3);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company03.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(com1);
        session.save(com2);
        session.save(com3);

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
