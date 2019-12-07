package pl.edu.pjwstk.jazapp.auction.entities;

import pl.edu.pjwstk.jazapp.auth.entities.ProfileEnity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany
    private List<Photos> photosList = new ArrayList<>();

    @OneToMany
    private List<AuctionParameter> auctionParameterList = new ArrayList<>();

    public Auction(String name, ProfileEnity owner, Category category, float price, String description) {
        this.name = name;
        this.owner = owner;
        this.category = category;
        this.price = price;
        this.description = description;
    }
    public Auction() {}
}
