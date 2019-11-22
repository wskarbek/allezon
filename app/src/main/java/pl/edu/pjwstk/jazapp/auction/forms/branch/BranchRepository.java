package pl.edu.pjwstk.jazapp.auction.forms.branch;

import pl.edu.pjwstk.jazapp.auction.Branch;

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

    /*@Transactional
    public boolean branchExist(String name) {
        //Branch branch = em.find(Branch.class, name);
        Branch branch = em.createQuery(from ")
        return branch != null;
    }*/

}
