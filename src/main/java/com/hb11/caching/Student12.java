package com.hb11.caching;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Student12")
public class Student12 {

    /*
1)	First Level Cache --->
			* defaultta açık geliyor , kapatma durumu yok
			* Aynı session içinde kayıt alır
			* session kapanınca içindekiler silinir
​
2) Second Level Cache --->
			* Defaultta kapalıdır
			* Session factory seviyesinde cachleme yapar, yani farklı
					sessionlar arasında data kullanılabiliyor
			* hibernate.cfg.xml den active edilebilir
​
3) Query Cache
			* Query ler için kullanılıyor
			* hibernate.cfg.xml den active edilebilir
​
 */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(length = 50,nullable = false)
    private String name;

    private int mathGrade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    @Override
    public String toString() {
        return "Student12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}
