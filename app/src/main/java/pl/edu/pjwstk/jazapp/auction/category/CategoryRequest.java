package pl.edu.pjwstk.jazapp.auction.category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryRequest {
    private String name;
    private String branchName;
    private String branch;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getBranchName() { return branchName; }

    public void setBranchName(String branch) { this.branchName = branch; }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + "\n'" +
                "branch'" + branchName + "\n'" +
                 '}';
    }
}

