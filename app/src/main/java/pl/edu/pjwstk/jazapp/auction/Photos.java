package pl.edu.pjwstk.jazapp.auction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="photos")
public class Photos {
    @Id
    private int id;

    private int auctionId;
    private String file;
}
