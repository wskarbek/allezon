package pl.edu.pjwstk.jazapp.auction.entities;

import javax.persistence.*;

@Entity
@Table(name = "parameter")
public class Parameter {

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @JoinColumn(name = "name")
    private String name;

    public Parameter(String name) {
        this.name = name;
    }

    public Parameter() {}

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }
}
