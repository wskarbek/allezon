package pl.edu.pjwstk.jazapp.auction.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="auction_cart")
public class ShoppingCartAuction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @ManyToMany
    @JoinColumn(name = "auction")
    private List<Auction> auction;

    @Column(name = "amount")
    private Long amount;

    ShoppingCartAuction() {}
}
