package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.entities.Auction;
import pl.edu.pjwstk.jazapp.auction.entities.Category;
import pl.edu.pjwstk.jazapp.auction.category.CategoryRepository;
import pl.edu.pjwstk.jazapp.auth.entities.ProfileEnity;
import pl.edu.pjwstk.jazapp.auth.login.LoginProfileRepository;
import pl.edu.pjwstk.jazapp.auth.login.LoginSession;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionController {
    @Inject
    private AuctionRequest auctionRequest;

    @Inject
    private AuctionRepository auctionRepository;

    @Inject
    private LoginSession profileSession;

    private String error = "";
    private String success = "";

    public String getError() {
        return error;
    }

    public String getSuccess() {
        return success;
    }

    public void add() {
        System.out.println("Tried to add " + auctionRequest.toString());
        String name = auctionRequest.getName();
        ProfileEnity owner = profileSession.getCurrentUser();
        Category category = auctionRepository.getCategory(auctionRequest.getCategoryName());
        float price = auctionRequest.getPrice();
        String description = auctionRequest.getDescription();
        auctionRepository.add(new Auction(name, owner, category, price, description));
    }

}
