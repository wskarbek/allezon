package pl.edu.pjwstk.jazapp.auction.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "auction_parameter")
public class AuctionParameter implements Serializable{

    @EmbeddedId
    AuctionParameterId id;

    @Column(name = "value")
    private String value;

    @JoinColumn(name = "auction")
    @MapsId("auction")
    @ManyToOne
    private Auction auction;

    @JoinColumn(name = "param")
    @MapsId("param")
    @ManyToOne
    private Parameter parameter;

    public AuctionParameter() {
    }
}