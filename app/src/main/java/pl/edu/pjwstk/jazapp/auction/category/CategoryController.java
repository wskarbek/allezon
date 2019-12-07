package pl.edu.pjwstk.jazapp.auction.category;

import pl.edu.pjwstk.jazapp.auction.entities.Category;
import pl.edu.pjwstk.jazapp.auction.branch.BranchRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryController {
    @Inject
    private CategoryRequest categoryRequest;

    @Inject
    private CategoryRequestEdit categoryRequestEdit;

    @Inject
    private CategoryRepository cr;

    @Inject
    private BranchRepository br;

    private String error = "";
    private String success = "";
    private String errorEdit = "";
    private String successEdit = "";

    public void add() {
        System.out.println("Tried to add " + categoryRequest.toString() );
        if(cr.categoryExist(categoryRequest.getName())) {
            error = "Category already exists.";
            return;
        }
        cr.addCategory(new Category(categoryRequest.getName(), cr.getBranch(categoryRequest.getBranchName())));
        success = "Category " + categoryRequest.getName() + " - " + categoryRequest.getBranchName() + " added.";
    }

    public void update() {
        System.out.println("Tried to update to " + categoryRequestEdit.toString());
        Category category = cr.getCategory(categoryRequestEdit.getCategoryName());
        if(!categoryRequestEdit.getNewName().equals("")) category.setName(categoryRequestEdit.getNewName());
        category.setBranch(cr.getBranch(categoryRequestEdit.getNewBranchName()));
        cr.updateCategory(category);
        successEdit = "Category updated";
    }

    public String getError() {
        return error;
    }

    public String getSuccess() {
        return success;
    }

    public String getErrorEdit() {
        return errorEdit;
    }

    public String getSuccessEdit() {
        return successEdit;
    }
}
