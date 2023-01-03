package practice.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

    @Id
    private int id;

    @Column(length = 50, nullable = false)
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name="project_dev",
                joinColumns =@JoinColumn(name="project_id"),
                inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private Set<Developer07> developers = new HashSet<>();

    public Project () {}

    public Project(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Developer07> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer07> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", developers=" + developers +
                '}';
    }
}
