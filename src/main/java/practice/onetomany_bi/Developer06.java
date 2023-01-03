package practice.onetomany_bi;

import javax.persistence.*;

@Entity
public class Developer06 {

    @Id
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String branch;

    @ManyToOne
    @JoinColumn
    private Company03 company;

    public Developer06 () {}

    public Developer06(int id, String name, String email, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
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

    public Company03 getCompany() {
        return company;
    }

    public void setCompany(Company03 company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Developer06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
