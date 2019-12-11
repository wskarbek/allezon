package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.entities.Auction;
import pl.edu.pjwstk.jazapp.auction.entities.Category;
import pl.edu.pjwstk.jazapp.auth.entities.ProfileEnity;
import pl.edu.pjwstk.jazapp.auth.login.LoginSession;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionDisplay {

    @Inject
    private AuctionRepository auctionRepository;

    @Inject
    private LoginSession profileSession;

    private Auction auction;

    private Integer id;

    public void setId(Integer id) {
        auction = auctionRepository.getAuctionById(id);
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public String getName() {
        return auction.getName();
    }

    public String getDescription() {
        return auction.getDescription();
    }

    public String getPrice() {
        return auction.getPriceString();
    }

    public String getOwner() {
        return auction.getOwnerName();
    }
}
