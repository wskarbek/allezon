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
    private Long id;

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

    @Column(name = "is_edited")
    private boolean isEdited;

    @OneToMany(mappedBy = "auction", fetch = FetchType.EAGER)
    private List<Photo> photoList = new ArrayList<>();

    @OneToMany
    private List<AuctionParameter> auctionParameterList = new ArrayList<>();

    public Auction(String name, ProfileEnity owner, Category category, float price, String description) {
        this.name = name;
        this.owner = owner;
        this.category = category;
        this.price = price;
        this.description = description;
        this.isEdited = false;
    }
    public Auction() {}

    public String getName() {
        return name;
    }

    public String getPriceString() {
        return String.valueOf(price);
    }

    public String getOwnerName() {
        return owner.getUsername();
    }

    public Long getId() { return id; }

    public String getIdString() {
        return String.valueOf(id);
    }

    public String getDescription() { return description; }

    public List<Photo> getPhotos() { return photoList; }

    public void setOwner(ProfileEnity owner) {
        this.owner = owner;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEdited() { return isEdited; }

    public void setEdited(boolean edited) { isEdited = edited; }

    public Photo getPhoto() {
        if(photoList.size() > 0) return photoList.get(0);
        else return null;
    }

    public String getCategoryName() {
        return category.getName();
    }
}
