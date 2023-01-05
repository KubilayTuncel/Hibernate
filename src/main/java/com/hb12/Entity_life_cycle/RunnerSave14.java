package com.hb12.Entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {

    public static void main(String[] args) {

        Student14 student1 = new Student14("Recep Kara",99); //Transient State
        Student14 student2 = new Student14("Emir Celik",99); //Transient State
        Student14 student3 = new Student14("Tarik Kücük",99); //Transient State


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student14.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1); //Life cycle da Persisted State
        student1.setName("Güncellenmis Recep Kara");
        session.evict(student1); //!!! Detached state e gecti. Yani takip etme dedik. evict önemli method. tikpi SQL de rollback gibi.
                                    //Burada detached yaptigimiz icin yukaridaki kisimdaki save ve set calismaz cünkü transaction
                                    // alt kisimda commitlendigi icin

       // session.update(student1);  //detached olmus student1 objesini persisted state e alir
       // session.merge(student1);  //detached olmus student1 objesini persisted state e alir

        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sf.close();
    }
}
