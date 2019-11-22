package pl.edu.pjwstk.jazapp.auction;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "branch")
    private Branch branch;

    public Category(String name, Branch branch) {
        this.name = name;
        this.branch = branch;
    }

    public Category() {

    }
}
