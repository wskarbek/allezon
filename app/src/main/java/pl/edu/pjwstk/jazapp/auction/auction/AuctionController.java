package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.entities.Photo;

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
    private AuctionRequestAdd auctionRequestAdd;

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

    public void submit() throws IOException {
        if(auctionRequestEdit.getId()==null) {
            add();
        } else {
            update();
        }
    }

    private void add() throws IOException {
        System.out.println("Tried to add " + auctionRequestEdit.toString());
        String name = auctionRequestEdit.getName();
        String categoryName = auctionRequestEdit.getCategoryName();
        float price = auctionRequestEdit.getPrice();
        String description = auctionRequestAdd.getDescription();
        List<Part> photos = createPhotoList(auctionRequestEdit.getThumbnail(), auctionRequestEdit.getPhotoOne(), auctionRequestEdit.getPhotoTwo(), auctionRequestEdit.getPhotoThree());


        auctionCreator.createAuction(
                name,
                categoryName,
                price,
                description,
                photos);

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("index.xhtml");
    }

    public void oldAdd() throws IOException {
        System.out.println("Tried to add " + auctionRequestAdd.toString());
        String name = auctionRequestAdd.getName();
        String categoryName = auctionRequestAdd.getCategoryName();
        float price = auctionRequestAdd.getPrice();
        String description = auctionRequestAdd.getDescription();


        auctionCreator.createAuction(
                name,
                categoryName,
                price,
                description,
                createPhotoList(auctionRequestAdd.getThumbnail(), auctionRequestAdd.getPhotoOne(), auctionRequestAdd.getPhotoTwo(), auctionRequestAdd.getPhotoThree()));

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("index.xhtml");
    }

    public void update() throws IOException{
        System.out.println("Nie działam napomusz");
        auctionCreator.updateAuction(
                auctionRequestEdit.getId(),
                auctionRequestEdit.getName(),
                auctionRequestEdit.getCategoryName(),
                auctionRequestEdit.getPrice(),
                auctionRequestEdit.getDescription(),
                createPhotoList(auctionRequestEdit.getThumbnail(), auctionRequestEdit.getPhotoOne(), auctionRequestEdit.getPhotoTwo(), auctionRequestEdit.getPhotoThree())
        );
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("auction.xhtml?auctionId="+auctionRequestEdit.getId());
    }

    public List<Part> createPhotoList(Part thumbnail, Part one, Part two, Part three) {
        List<Part> photosList = new ArrayList<>();
        if(thumbnail != null) photosList.add(thumbnail);
        if(one != null) photosList.add(one);
        if(two != null) photosList.add(two);
        if(three != null) photosList.add(three);
        return photosList;
    }
}
