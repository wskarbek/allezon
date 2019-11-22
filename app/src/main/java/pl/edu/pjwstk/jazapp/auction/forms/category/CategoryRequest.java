package pl.edu.pjwstk.jazapp.auction.forms.category;

import pl.edu.pjwstk.jazapp.auction.Branch;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryRequest {
    private String name;
    private String branchName;
    private Branch branch;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Branch getBranch() { return branch; }

    public void setBranch(Branch branch) { this.branch = branch; }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + "\n'" +
                "branch'" + branch.toString() + "\n'" +
                 '}';
    }
}

