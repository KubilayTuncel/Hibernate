package practice.onetomany_bi;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company03 {

    @Id
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @OneToMany (mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Developer06> developers = new HashSet<>();

    public Company03 () {}

    public Company03(int id, String name) {
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

    public Set<Developer06> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer06> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Company03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers=" + developers +
                '}';
    }
}
