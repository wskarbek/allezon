package pl.edu.pjwstk.jazapp.auction.entities;

import pl.edu.pjwstk.jazapp.auth.entities.ProfileEnity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "auction_cart")
    private ShoppingCartAuction shoppingCartAuction;

    @OneToOne
    @JoinColumn(name = "owner")
    private ProfileEnity owner;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public ShoppingCart() {
    }
}
