package pl.edu.pjwstk.jazapp.auction.branch;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class BranchRequestEdit {
    private String newName;
    private String branchName;

    public String getNewName() { return newName; }

    public void setNewName(String name) { this.newName = name; }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + newName + '\''+
                '}';
    }
}

