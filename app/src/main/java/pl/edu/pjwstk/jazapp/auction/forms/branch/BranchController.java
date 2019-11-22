package pl.edu.pjwstk.jazapp.auction.forms.branch;

import pl.edu.pjwstk.jazapp.auction.Branch;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BranchController {
    @Inject
    private BranchRequest branchRequest;

    @Inject
    private BranchRepository br;

    private String error = "";
    private String success = "";

    public void add() {
        System.out.println("Tried to add " + branchRequest.toString() );
        if(br.branchExist(branchRequest.getName())) {
            error = "Branch already exists.";
            return;
        }
        br.addBranch(new Branch(branchRequest.getName()));
        success = "Branch " + branchRequest.getName() + " added.";
    }

    public String getError() {
        return error;
    }

    public String getSuccess() {
        return success;
    }
}
