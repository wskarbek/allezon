package pl.edu.pjwstk.jazapp.auction.forms.category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryRequestEdit {
    private String name;
    private String branchName;
    private String categoryName;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getBranchName() { return branchName; }

    public void setBranchName(String branch) { this.branchName = branch; }

    public String getCategoryName() { return categoryName; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + "\n'" +
                "branch='" + branchName + "\n'" +
                 '}';
    }
}

