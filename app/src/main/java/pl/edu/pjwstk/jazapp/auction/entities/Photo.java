package pl.edu.pjwstk.jazapp.auction.entities;

import javax.persistence.*;

@Entity
@Table(name="photos")
public class Photo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @Column(name = "file")
    private String file;

    public Photo(Auction auction, String file) {
        this.auction = auction;
        this.file = file;
    }

    public Photo() {}

    public String getFile() { return file; }
}
