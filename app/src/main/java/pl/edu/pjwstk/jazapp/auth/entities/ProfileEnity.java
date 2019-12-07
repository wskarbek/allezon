package pl.edu.pjwstk.jazapp.auth.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class ProfileEnity {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    @Id
    private String username;

    private String password, name, surname, email, birthday;
    private boolean admin;

    public ProfileEnity() {
    }

    public ProfileEnity(String username) {
        this.username = username;
    }

    public ProfileEnity(String username, String password, String name, String surname, String email, String birthday, boolean admin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public boolean getAdmin() { return admin; }
}
