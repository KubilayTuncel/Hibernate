package practice.anacation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_developer01")
public class Developer01 {

    @Id
    private int id;

    @Column (name="developer_name",length = 100, nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String branch;

    public Developer01(int id, String name, String email, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
    }

    public Developer01(){

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Develepor01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
