package pl.edu.pjwstk.jazapp.auction.category;

import pl.edu.pjwstk.jazapp.auction.entities.Branch;
import pl.edu.pjwstk.jazapp.auction.entities.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class CategoryRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addCategory(Category category) { em.persist(category); }

    @Transactional
    public void updateCategory(Category category) { em.merge(category); }

    @Transactional
    public Category getCategory(String categoryName) {
        return em.createQuery("from Category where name = :categoryName", Category.class).setParameter("categoryName", categoryName).getSingleResult();
    }

    @Transactional
    public List<Category> getCategories() {
        return em.createQuery("from Category order by name", Category.class).getResultList();
    }

    @Transactional
    public Branch getBranch(String branchName) {
        return em.createQuery("from Branch where name = :branchName", Branch.class).setParameter("branchName", branchName).getSingleResult();
    }

    @Transactional
    public boolean categoryExist(String name) {
        var category = em.createQuery("from Category where name = :categoryName", Category.class).setParameter("categoryName", name);
        return category == null;
    }

}
