package practice.onetomany_uni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="t_company02")
public class Company02 {

    @Id
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @OneToMany
    @JoinColumn //Eger joinColumn anatation kullanmazsak join table üretilir.
    //// Extra table gerek kalmadan Developer tablosunda foreign key olusturarak bir kolon ekliyor.
    private Set<Developer05> developers = new HashSet<>();

    public Company02 () {}

    public Company02(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Developer05> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer05> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Company02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers=" + developers +
                '}';
    }
}
