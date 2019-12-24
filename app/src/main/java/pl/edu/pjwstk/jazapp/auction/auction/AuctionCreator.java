package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.category.CategoryRepository;
import pl.edu.pjwstk.jazapp.auction.entities.Auction;
import pl.edu.pjwstk.jazapp.auction.entities.Photo;
import pl.edu.pjwstk.jazapp.auth.login.LoginSession;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RequestScoped
public class AuctionCreator {
    @Inject
    private AuctionRepository auctionRepository;

    @Inject
    private AuctionPhotoRepository auctionPhotoRepository;

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private LoginSession loginSession;

    private Long auctionID;

    //Location must exist!
    public static final String LOCATION = "/home/jesieniarz/tmp/"; //Linux
    //public static final String LOCATION = "D:/tmp/" //Windows

    public void createAuction(String name, String categoryName, float price, String description, List<Part> photosList) {
        auctionID = auctionRepository.add(new Auction(
                name,
                loginSession.getCurrentUser(),
                categoryRepository.getCategory(categoryName),
                price,
                description));

        String fileName;
        String location = LOCATION;
        new File(location + Long.toString(auctionID)).mkdirs();
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

    public void updateAuction(Long id, String name, String categoryName, float price, String description, List<Part> photosList){
        Auction auction = auctionRepository.getAuctionById(id);
        System.out.println(loginSession.getCurrentUser().getUsername());
        System.out.println(auction.getOwnerName());
        if(!loginSession.getCurrentUser().getUsername().equals(auction.getOwnerName())) return;
        if(!name.equals("")) auction.setName(name);
        if(!categoryName.equals("")) auction.setCategory(categoryRepository.getCategory(categoryName));
        if(price != 0.0) auction.setPrice(price);
        if(!description.equals("")) auction.setDescription(description);
        auctionRepository.update(auction);
        this.unlock(id);

        String location = LOCATION + id + "/";
        for (int i = 0; i < photosList.size(); i++ ) {
            try (InputStream input = photosList.get(i).getInputStream()) {
                Files.copy(input, new File(location, Integer.toString(i)).toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Photo updated");
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public void lock(Long id) {
        Auction auction = auctionRepository.getAuctionById(id);
        auction.setEdited(true);
        auctionRepository.update(auction);
    }

    public void unlock(Long id) {
        Auction auction = auctionRepository.getAuctionById(id);
        auction.setEdited(false);
        auctionRepository.update(auction);
    }
}
