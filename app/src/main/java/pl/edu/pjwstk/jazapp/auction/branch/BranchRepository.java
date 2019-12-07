package pl.edu.pjwstk.jazapp.auction.branch;

import pl.edu.pjwstk.jazapp.auction.entities.Branch;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class BranchRepository {

    private List<Branch> branchList = new ArrayList<>();

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addBranch(Branch branch) { em.persist(branch); }

    @Transactional
    public void updateBranch(Branch branch) {
        em.merge(branch);
    }

    @Transactional
    public Branch getBranch(String branchName) {
        return em.createQuery("from Branch where name = :branchName", Branch.class).setParameter("branchName", branchName).getSingleResult();
    }

    @Transactional
    public List<Branch> getBranches() {
        return em.createQuery("from Branch order by name", Branch.class).getResultList();
    }

    @Transactional
    public boolean branchExist(String name) {
        var branch = em.createQuery("from Branch where name = :branchName", Branch.class).setParameter("branchName", name);
        return branch == null;
    }

}
