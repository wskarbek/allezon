package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.entities.Auction;
import pl.edu.pjwstk.jazapp.auction.entities.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class AuctionRequestView implements Serializable {

    @Inject
    private AuctionRepository auctionRepository;

    private Auction auction;

    private Long id;

    public void setId(Long id) {
        auction = auctionRepository.getAuctionById(id);
        this.id = id;
    }

    public Long getId(){
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

    public List<Photo> getPhotos() { return auction.getPhotos(); }

    public Photo getThumbnail() { return auction.getPhoto(); }

    public Boolean getIsEdited() {
        if (auction!=null) return auction.isEdited();
        return false;
    }
}
