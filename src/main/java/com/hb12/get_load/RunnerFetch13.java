package com.hb12.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
    get()  --> gercek nesneyi döndürür
                nesne yoksa null döner
                nesnenin oldugundan emin degilseiz get() kullanin
                dönen nesneyi hemen kullanacaksam get() kullanilmali

    load()  --> proxy nesne döndürür, gercek nesnenin gölgesi,
                nesne yoksa exception firlatir
                dönen nesne üyerinde delete yapilacaksa kullanilabilir
 */

public class RunnerFetch13 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student13.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("get methodunun baslangiy yeri ....");
        Student13 student1 = session.get(Student13.class,1L);
        System.out.println("get methodunun bittigi yer ....");
        System.out.println("Student ID : "+student1.getId());
        System.out.println("Student Name : "+student1.getName());

        System.out.println("*********************************");
        //yukaridaki senaryonun aynisini load() methodu ile yapalim.
        System.out.println("load methodunun basladigi yeri : ");
        Student13 student2 = session.load(Student13.class,2L);
        System.out.println("getName() cagirildigi yer"); // Artik obje üyerinde get  yada set islemi yaptigimiz icin  DB ye gider
                                                        // ve sorgulama islemini yapar
        System.out.println("Student2 nin Name : "+student2.getName());
        System.out.println("load methodunun bittigi yer ....");

        //DB de olmayan id yi cagirirsak
        System.out.println("get methodu calismaya basladi.......");
        Student13 student3 = session.get(Student13.class,4L);
        System.out.println("get methodu bitti");

        if (student3!=null){
            System.out.println("Student Id : "+student3.getId());
            System.out.println("Student Name : "+student3.getName());
        }

        System.out.println("*******************************");
/*
        System.out.println("load methodu calismaya basladi......");
        Student13 student4 = session.load(Student13.class,5L);
        System.out.println("load methodu bitti......");


        if (student4!=null){
            System.out.println("Student id : "+student4.getId());
            System.out.println("Student Name : "+student4.getName());
        }


 */
        //Peki load() methodu neden kullanilliyor!!!
        //load methodu ile obje referansi alinir ve daha sonra delete cagirilir
        //Silme isleminde _DB ye gitmemize gerek olmadigi icin load kullanmak daha mantikli
        // get methodu cagirilmayarak DB ye hit (database e sorgu göndermek) engellenmis olur.

        Student13 student5 = session.load(Student13.class,1L);
        session.delete(student5);


        tx.commit();
        session.close();
        sf.close();
    }
}
