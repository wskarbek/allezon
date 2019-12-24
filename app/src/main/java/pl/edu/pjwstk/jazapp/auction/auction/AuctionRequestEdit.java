package pl.edu.pjwstk.jazapp.auction.auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@RequestScoped
public class AuctionRequestEdit {
    private Long id;
    private String categoryName;
    private String name;
    private float price;
    private String description;
    private Part thumbnail, photoOne, photoTwo, photoThree;

    public AuctionRequestEdit() {
        id = null;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Part getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Part thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Part getPhotoOne() {
        return photoOne;
    }

    public void setPhotoOne(Part photoOne) {
        this.photoOne = photoOne;
    }

    public Part getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(Part photoTwo) {
        this.photoTwo = photoTwo;
    }

    public Part getPhotoThree() {
        return photoThree;
    }

    public void setPhotoThree(Part photoThree) {
        this.photoThree = photoThree;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @Override
    public String toString() {
        return "Auction{" +
                "name='" + name + "\n'" +
                "category='" + categoryName + "\n'" +
                "price='" + price + "\n'" +
                "desc='" + description + "\n'" +
                 '}';
    }
}

