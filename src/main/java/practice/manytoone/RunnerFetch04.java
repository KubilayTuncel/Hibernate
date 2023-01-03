package practice.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1--id=2 olan developerın çalıştığı company bilgilerini getiriniz.

        Developer04 dev1 = session.get(Developer04.class,2);
        System.out.println(dev1.getCompany());

        //2--tüm developerların ismini ve çalıştığı company ismini görüntüleyiniz.
        String hqlquery1 = "select d.name, d.company.name from Developer04 d inner join Company c on d.company.id=c.id";
        List<Object[]> resultSet1 = session.createQuery(hqlquery1).getResultList();
        resultSet1.forEach(t-> System.out.println(Arrays.toString(t)));

        //3--Googleda çalışan developerların ismini ve branchini görüntüleyiniz.***ÖDEV***

        tx.commit();
        session.close();
        sf.close();
    }
}
