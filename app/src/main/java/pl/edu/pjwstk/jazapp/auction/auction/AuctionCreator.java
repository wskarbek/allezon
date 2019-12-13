package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.category.CategoryRepository;
import pl.edu.pjwstk.jazapp.auction.entities.Auction;
import pl.edu.pjwstk.jazapp.auction.entities.Category;
import pl.edu.pjwstk.jazapp.auction.entities.Photo;
import pl.edu.pjwstk.jazapp.auth.login.LoginSession;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

@RequestScoped
public class AuctionCreator {
    @Inject
    AuctionRepository auctionRepository;

    @Inject
    AuctionPhotoRepository auctionPhotoRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    LoginSession loginSession;

    private Integer auctionID;

    public static final String LOCATION = "D:/tmp/photos/";

    public void createAuction(String name, String categoryName, float price, String description, List<Part> photosList){
        auctionID = auctionRepository.add(new Auction(
                name,
                loginSession.getCurrentUser(),
                categoryRepository.getCategory(categoryName),
                price,
                description));

        String fileName;
        String location = LOCATION;
        new File(location + Integer.toString(auctionID)).mkdirs();
        location += auctionID + "/";
        for (int i = 0; i < photosList.size(); i++ ) {
            fileName = Integer.toString(i);
            try (InputStream input = photosList.get(i).getInputStream()) {
                Files.copy(input, new File(location, Integer.toString(i)).toPath());
                System.out.println("Photo saved");
            } catch (IOException e) {
                System.out.println(e);
            }
            auctionPhotoRepository.add(new Photo(auctionRepository.getAuctionById(auctionID), "/" + auctionID + "/" + fileName));
        }
    }
}
