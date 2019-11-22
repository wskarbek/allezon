package pl.edu.pjwstk.jazapp.auction.forms.category;

import pl.edu.pjwstk.jazapp.auction.Category;
import pl.edu.pjwstk.jazapp.auction.forms.branch.BranchRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryController {
    @Inject
    private CategoryRequest categoryRequest;

    @Inject
    private CategoryRepository cr;

    @Inject
    private BranchRepository br;

    private String error = "";
    private String success = "";

    public void add() {
        System.out.println("Tried to add " + categoryRequest.toString() );
        if(cr.categoryExist(categoryRequest.getName())) {
            error = "Category already exists.";
            return;
        }
        cr.addCategory(new Category(categoryRequest.getName(), br.getBranch(categoryRequest.getBranchName())));
        success = "Category " + categoryRequest.getName() + " - " + categoryRequest.getBranchName() + " added.";
    }

    public String getError() {
        return error;
    }

    public String getSuccess() {
        return success;
    }
}
