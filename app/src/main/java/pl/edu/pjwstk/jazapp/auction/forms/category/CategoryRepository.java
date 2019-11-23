package pl.edu.pjwstk.jazapp.auction.forms.category;

import pl.edu.pjwstk.jazapp.auction.Category;

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
    public boolean categoryExist(String name) {
        var category = em.createQuery("from Category where name = :categoryName", Category.class).setParameter("categoryName", name);
        return category != null;
    }

}
