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

    @ManyToOne
    @JoinColumn(name = "owner")
    private ProfileEnity owner;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;
}
