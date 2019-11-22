package pl.edu.pjwstk.jazapp.auction;

import javax.inject.Named;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branch")
@Named
public class Branch {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<Category> categories;

    public Branch(String name) {
        this.name = name;
    }

    public Branch() {

    }


    public void setName(String name) {
        this.name = name;
    }
}
