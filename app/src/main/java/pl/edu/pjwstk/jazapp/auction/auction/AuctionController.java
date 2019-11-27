package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.Auction;
import pl.edu.pjwstk.jazapp.auction.Category;
import pl.edu.pjwstk.jazapp.auction.category.CategoryRepository;
import pl.edu.pjwstk.jazapp.auth.ProfileEnity;
import pl.edu.pjwstk.jazapp.auth.ProfileRepository;
import pl.edu.pjwstk.jazapp.auth.ProfileSession;

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
    private ProfileRepository profileRepository;

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private ProfileSession profileSession;

    private String error = "";
    private String success = "";

    public void add() {
        System.out.println("Tried to add " + auctionRequest.toString());
        String name = auctionRequest.getName();
        ProfileEnity owner = profileSession.getCurrentUser();
        Category category = categoryRepository.getCategory(auctionRequest.getCategoryName());
        float price = auctionRequest.getPrice();
        String description = auctionRequest.getDescription();
        auctionRepository.add(new Auction(name, owner, category, price, description));
    }

}
