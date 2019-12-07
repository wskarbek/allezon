package pl.edu.pjwstk.jazapp.auction.branch;

import pl.edu.pjwstk.jazapp.auction.entities.Branch;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BranchController {
    @Inject
    private BranchRequest branchRequest;

    @Inject
    private BranchRequestEdit branchRequestEdit;

    @Inject
    private BranchRepository br;

    private String error = "";
    private String success = "";
    private String errorEdit = "";
    private String successEdit = "";

    public void add() {
        System.out.println("Tried to add " + branchRequest.toString() );
        if(br.branchExist(branchRequest.getName())) {
            error = "Branch already exists.";
            return;
        }
        br.addBranch(new Branch(branchRequest.getName()));
        success = "Branch " + branchRequest.getName() + " added.";
    }

    public void update() {
        System.out.println("Tried to update to " + branchRequestEdit.toString());
        Branch branch = br.getBranch(branchRequestEdit.getBranchName());
        branch.setName(branchRequestEdit.getNewName());
        br.updateBranch(branch);
        successEdit = "Branch updated.";
    }

    public String getError() {
        return error;
    }

    public String getSuccess() {
        return success;
    }

    public String getSuccessEdit() { return successEdit; }
}
