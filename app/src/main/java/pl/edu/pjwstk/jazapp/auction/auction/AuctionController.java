package pl.edu.pjwstk.jazapp.auction.auction;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
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
    private AuctionRequestEdit auctionRequestEdit;

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


        auctionCreator.createAuction(
                name,
                categoryName,
                price,
                description,
                createPhotoList(auctionRequest.getThumbnail(), auctionRequest.getPhotoOne(), auctionRequest.getPhotoTwo(), auctionRequest.getPhotoThree()));

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("index.xhtml");
    }

    public void update() throws IOException {
        auctionCreator.updateAuction(
                auctionRequestEdit.getId(),
                auctionRequestEdit.getName(),
                auctionRequestEdit.getCategoryName(),
                auctionRequestEdit.getPrice(),
                auctionRequestEdit.getDescription(),
                createPhotoList(auctionRequestEdit.getThumbnail(), auctionRequestEdit.getPhotoOne(), auctionRequestEdit.getPhotoTwo(), auctionRequestEdit.getPhotoThree())
        );
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("auction.xhtml?autionId="+auctionRequestEdit.getId());
    }

    public List<Part> createPhotoList(Part thumbnail, Part one, Part two, Part three) {
        List<Part> photosList = new ArrayList<>();
        photosList.add(thumbnail);
        photosList.add(one);
        photosList.add(two);
        photosList.add(three);
        return photosList;
    }
}
