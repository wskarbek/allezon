package pl.edu.pjwstk.jazapp.auction.entities;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
