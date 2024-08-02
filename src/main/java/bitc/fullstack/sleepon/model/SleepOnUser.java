package bitc.fullstack.sleepon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "sleep_on_user")
public class SleepOnUser {
    @Id
    @Column(length = 45, nullable = false)
    private String id;

    @Column(length = 45, nullable = false)
    private String pass;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 45, nullable = false)
    private String age;

    @Column(length = 45)
    private String tel;

    @Column(length = 1, nullable = false)
    private String manager = "N";

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public boolean isUnderage() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(this.age, formatter);
        return Period.between(birthDate, LocalDate.now()).getYears() < 18;
    }

    public boolean isManager() {
//        return this.id.startsWith("admin");
        // 매니저인 경우 true 반환
        return this.manager.equals("Y");
    }
}