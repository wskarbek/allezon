package pl.edu.pjwstk.jazapp.auction.param;

import pl.edu.pjwstk.jazapp.auction.entities.Parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ParamController {
    @Inject
    private ParamRequest paramRequest;

    @Inject
    private ParamRequestEdit paramRequestEdit;

    @Inject
    private ParamRepository pr;

    private String error = "";
    private String success = "";
    private String errorEdit = "";
    private String successEdit = "";

    public void add() {
        System.out.println("Tried to add " + paramRequest.toString() );
        if(pr.paramExist(paramRequest.getName())) {
            error = "Param already exists.";
            return;
        }
        pr.addParam(new Parameter(paramRequest.getName()));
        success = "Param " + paramRequest.getName() + " added.";
    }

    public void update() {
        System.out.println("Tried to update to " + paramRequestEdit.toString());
        Parameter param = pr.getParam(paramRequestEdit.getParamName());
        param.setName(paramRequestEdit.getNewName());
        pr.updateParam(param);
        successEdit = "Param updated.";
    }

    public String getError() {
        return error;
    }

    public String getSuccess() {
        return success;
    }

    public String getSuccessEdit() { return successEdit; }
}
