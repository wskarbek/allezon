package pl.edu.pjwstk.jazapp.auction.auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AuctionController {
    @Inject
    private AuctionRequest auctionRequest;

    @Inject
    private AuctionCreator auctionCreator;

    private String error = "";
    private String success = "";

    public String getError() {
        return error;
    }

    public String getSuccess() {
        return success;
    }

    public void add() throws IOException {
        System.out.println("Tried to add " + auctionRequest.toString());
        String name = auctionRequest.getName();
        String categoryName = auctionRequest.getCategoryName();
        float price = auctionRequest.getPrice();
        String description = auctionRequest.getDescription();
        List<Part> photosList = new ArrayList<>();
        if(auctionRequest.getThumbnail()!=null) photosList.add(auctionRequest.getThumbnail());
        if(auctionRequest.getPhotoOne()!=null) photosList.add(auctionRequest.getPhotoOne());
        if(auctionRequest.getPhotoTwo()!=null) photosList.add(auctionRequest.getPhotoTwo());
        if(auctionRequest.getPhotoThree()!=null) photosList.add(auctionRequest.getPhotoThree());

        auctionCreator.createAuction(name, categoryName, price, description, photosList);
    }

}
