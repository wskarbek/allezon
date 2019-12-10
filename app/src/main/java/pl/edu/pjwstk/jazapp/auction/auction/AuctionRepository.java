package pl.edu.pjwstk.jazapp.auction.auction;

import pl.edu.pjwstk.jazapp.auction.entities.Auction;
import pl.edu.pjwstk.jazapp.auction.entities.Category;

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

    @Transactional
    public Category getCategory(String categoryName) {
        return em.createQuery("from Category where name = :categoryName", Category.class).setParameter("categoryName", categoryName).getSingleResult();
    }

    @Transactional
    public List<Category> getCategories() {
        return em.createQuery("from Category order by name", Category.class).getResultList();
    }

    @Transactional
    public List<Auction> getAuctions() {
        return em.createQuery("from Auction order by name", Auction.class).getResultList();
    }
}