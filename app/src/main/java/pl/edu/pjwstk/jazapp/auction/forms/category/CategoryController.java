package pl.edu.pjwstk.jazapp.auction.forms.category;

import pl.edu.pjwstk.jazapp.auction.Category;

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

    private String error = "";

    public void add() {
        System.out.println("Tried to add " + categoryRequest.toString() );
        if(cr.categoryExist(categoryRequest.getName())) {
            error = "Category already exists.";
            return;
        }
        cr.addCategory(new Category(categoryRequest.getName(), categoryRequest.getBranch()));
    }
}
