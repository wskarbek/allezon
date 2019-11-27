package pl.edu.pjwstk.jazapp.auction.auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionRequest {
    private String categoryName;
    private String name;
    private float price;
    private String description;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCategoryName() { return categoryName; }

    public float getPrice() { return price; }

    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + "\n'" +
                "category='" + categoryName + "\n'" +
                "price='" + price + "\n'" +
                "desc='" + description + "\n'" +
                 '}';
    }
}

