package practice.onetomany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {

    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company03.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1--Amazonda çalışan developer bilgilerini getiriniz.

        String hqlQuery1 = "from Company03 c where c.name='Amazon'";

        Company03 company1 =   session.createQuery(hqlQuery1,Company03.class).uniqueResult();
        System.out.println("********************Amazonda Calisanlar***********");
        company1.getDevelopers().forEach(t-> System.out.println(t));

        //2--"Gandalf"ın çalıştığı company bilgilerini getiriniz.
        String hqlQuery2 = "from Developer06 d where d.name='Gandalf'";
        Developer06 dev1 = session.createQuery(hqlQuery2,Developer06.class).uniqueResult();
        System.out.println("Gandalf'in Company si : "+dev1.getCompany());

        //3--id=22 olan companynin dev listesinden id=3 olan developerı siliniz.
        Developer06 dev2 = session.get(Developer06.class,3);
        Company03 com2 = session.get(Company03.class,22);

        com2.getDevelopers().remove(dev2);
        System.out.println(com2.getDevelopers());


        //id si 22 olan company sil



        tx.commit();
        session.close();
        sf.close();
    }
}
