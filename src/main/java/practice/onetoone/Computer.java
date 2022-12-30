package practice.onetoone;

import javax.persistence.*;

@Entity
@Table(name="t_computer")
public class Computer {

    @Id
    private Long id;

    @Column(length = 10)
    private String serialNo;

    private String brand;

    @OneToOne (mappedBy = "computer")
    private Developer03 developer03;

    public Computer(Long id, String serialNo, String brand) {
        this.id = id;
        this.serialNo = serialNo;
        this.brand = brand;
    }

    public Computer () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Developer03 getDeveloper03() {
        return developer03;
    }

    public void setDeveloper03(Developer03 developer03) {
        this.developer03 = developer03;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", serialNo='" + serialNo + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
