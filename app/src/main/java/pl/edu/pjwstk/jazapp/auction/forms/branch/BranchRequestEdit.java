package pl.edu.pjwstk.jazapp.auction.forms.branch;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class BranchRequestEdit {
    private String name;
    private String branchName;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\''+
                '}';
    }
}

