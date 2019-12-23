package pl.edu.pjwstk.jazapp.auction.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AuctionParameterId implements Serializable {
    public Long auction;
    public Long param;

    public AuctionParameterId(Long auction, Long param) {
        this.auction = auction;
        this.param = param;
    }

    public AuctionParameterId() {}

    public boolean equals(AuctionParameterId auctionParameterId) {
        if (this == auctionParameterId) return true;
        if (auctionParameterId == null || getClass() != auctionParameterId.getClass()) return false;
        return auction == auctionParameterId.auction &&
                param == auctionParameterId.param;
    }

    @Override
    public int hashCode() {
        return Objects.hash(auction, param);
    }

    public Long getAuction() {
        return auction;
    }

    public void setAuction(Long auction) {
        this.auction = auction;
    }

    public Long getParam() {
        return param;
    }

    public void setParam(Long param) {
        this.param = param;
    }
}
