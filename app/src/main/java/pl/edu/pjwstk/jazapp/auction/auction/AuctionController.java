package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.entities.Photo;

import javax.annotation.PreDestroy;
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
    private AuctionRequestEdit auctionRequestEdit;

    @Inject
    private AuctionCreator auctionCreator;

    private String error = "";
    private String success = "";

    private Long id;

    public String getError() {
        return error;
    }

    public String getSuccess() {
        return success;
    }

    /*@PreDestroy
    public void destroy() {
        auctionCreator.unlock(id);
    }*/

    public void submit() throws IOException {
        if(id==null) {
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
        String description = auctionRequestEdit.getDescription();
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

    public void update() throws IOException{
        auctionCreator.updateAuction(
                id,
                auctionRequestEdit.getName(),
                auctionRequestEdit.getCategoryName(),
                auctionRequestEdit.getPrice(),
                auctionRequestEdit.getDescription(),
                createPhotoList(auctionRequestEdit.getThumbnail(), auctionRequestEdit.getPhotoOne(), auctionRequestEdit.getPhotoTwo(), auctionRequestEdit.getPhotoThree())
        );
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("auction.xhtml?auctionId="+id);
    }

    public List<Part> createPhotoList(Part thumbnail, Part one, Part two, Part three) {
        List<Part> photosList = new ArrayList<>();
        if(thumbnail != null) photosList.add(thumbnail);
        if(one != null) photosList.add(one);
        if(two != null) photosList.add(two);
        if(three != null) photosList.add(three);
        return photosList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        auctionCreator.lock(id);
    }
}
