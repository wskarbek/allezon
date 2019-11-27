package pl.edu.pjwstk.jazapp.auction.category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryRequestEdit {
    private String newName;
    private String newBranchName;
    private String categoryName;

    public String getNewName() { return newName; }

    public void setNewName(String name) { this.newName = name; }

    public String getNewBranchName() { return newBranchName; }

    public void setNewBranchName(String branch) { this.newBranchName = branch; }

    public String getCategoryName() { return categoryName; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + newName + "\n'" +
                "branch='" + newBranchName + "\n'" +
                 '}';
    }
}

