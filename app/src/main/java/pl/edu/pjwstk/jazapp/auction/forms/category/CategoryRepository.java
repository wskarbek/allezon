package pl.edu.pjwstk.jazapp.auction.forms.category;

import pl.edu.pjwstk.jazapp.auction.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@ApplicationScoped
public class CategoryRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addCategory(Category category) { em.persist(category); }

    @Transactional
    public boolean categoryExist(String name) {
        Category category = em.find(Category.class, name);
        return category != null;
    }

}
