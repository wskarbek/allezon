package pl.edu.pjwstk.jazapp.auction.param;

import pl.edu.pjwstk.jazapp.auction.entities.Parameter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ParamRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addParam(Parameter branch) { em.persist(branch); }

    @Transactional
    public void updateParam(Parameter branch) {
        em.merge(branch);
    }

    @Transactional
    public Parameter getParam(String paramName) {
        return em.createQuery("from Parameter where name = :paramName", Parameter.class).setParameter("paramName", paramName).getSingleResult();
    }

    @Transactional
    public List<Parameter> getParams() {
        return em.createQuery("from Parameter order by name", Parameter.class).getResultList();
    }

    @Transactional
    public boolean paramExist(String name) {
        var branch = em.createQuery("from Parameter where name = :paramName", Parameter.class).setParameter("paramName", name);
        return branch == null;
    }

}
