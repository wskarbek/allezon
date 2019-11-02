package pl.edu.pjwstk.jazapp.auth;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class ProfileEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String name;

    public ProfileEnity() {
    }

    public ProfileEnity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
