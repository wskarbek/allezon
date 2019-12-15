package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.entities.Auction;
import pl.edu.pjwstk.jazapp.auction.entities.Photo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuctionPhotoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void add(Photo photo) {
        em.persist(photo);
    }

    @Transactional
    public void update(Photo photo) { em.merge(photo); }

    @Transactional
    public Photo getPhotoByAuction(Auction auction) {
        return em.createQuery("from Photo where auction = :auction", Photo.class).setParameter("auction", auction).getSingleResult();
    }
}
