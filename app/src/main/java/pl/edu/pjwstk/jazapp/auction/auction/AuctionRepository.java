package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.Auction;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@ApplicationScoped
public class AuctionRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void add(Auction auction) {
        em.persist(auction);
    }

    @Transactional
    public void update(Auction auction) {
        em.merge(auction);
    }

    @Transactional
    public boolean exist(String name) {
        var auction = em.createQuery("from Auction where name = :auctionName", Auction.class).setParameter("auctionName", name);
        return auction == null;
    }
}