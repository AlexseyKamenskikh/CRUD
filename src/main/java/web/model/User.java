package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String countryOfResidence;

    public User() {
    }

    public User(String name, String email, String countryOfResidence) {
        this.name = name;
        this.email = email;
        this.countryOfResidence = countryOfResidence;
        this.setId(id);
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

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", countryOfResidence='" + countryOfResidence + '\'' +
                '}';
    }
}