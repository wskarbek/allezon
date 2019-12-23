package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.entities.Auction;
import pl.edu.pjwstk.jazapp.auction.entities.Photo;
import pl.edu.pjwstk.jazapp.auth.login.LoginSession;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class AuctionRequestViewList implements Serializable {

    @Inject
    private AuctionRepository auctionRepository;

    @Inject
    private LoginSession loginSession;

    public List<Auction> getMyAuctions() { return auctionRepository.getAuctionsOfUser(loginSession.getCurrentUser()); }

    public List<Auction> getAuctions() { return auctionRepository.getAuctions(); }
}
