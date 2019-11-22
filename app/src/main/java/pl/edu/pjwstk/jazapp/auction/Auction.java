package pl.edu.pjwstk.jazapp.auction;

import pl.edu.pjwstk.jazapp.auth.ProfileEnity;

import javax.persistence.*;

@Entity
@Table(name="auction")
public class Auction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    @Column(name = "owner")
    @ManyToOne
    private ProfileEnity owner;

    @Column(name = "category")
    @ManyToOne
    private Category category;
    private String name;
    private float price;
    private String description;
}
