package pl.edu.pjwstk.jazapp.auction;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "auction_parameter")
public class AuctionParameter {

    @EmbeddedId
    AuctionParameterId id;

    private String value;

    public AuctionParameter() {
    }
}

@Embeddable
class AuctionParameterId implements Serializable {
    int auction, param;
}