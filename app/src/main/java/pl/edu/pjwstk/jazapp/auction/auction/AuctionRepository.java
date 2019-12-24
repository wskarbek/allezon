package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.entities.Auction;
import pl.edu.pjwstk.jazapp.auction.entities.Category;
import pl.edu.pjwstk.jazapp.auth.entities.ProfileEnity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class AuctionRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long add(Auction auction) {
        em.persist(auction);
        em.flush();
        return auction.getId();
    }

    @Transactional
    public void update(Auction auction) {
        em.merge(auction);
    }

    @Transactional
    public Auction getAuctionById(Long id) {
        return em.createQuery("from Auction where id = :id", Auction.class).setParameter("id", id).getSingleResult();
    }

    @Transactional
    public List<Auction> getAuctions() {
        return em.createQuery("from Auction order by name", Auction.class).getResultList();
    }

    @Transactional
    public List<Auction> getAuctionsOfUser(ProfileEnity user) {
        return em.createQuery("from Auction where owner = :owner order by name", Auction.class).setParameter("owner", user).getResultList();
    }

}