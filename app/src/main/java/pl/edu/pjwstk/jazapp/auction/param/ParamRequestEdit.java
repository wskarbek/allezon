package pl.edu.pjwstk.jazapp.auction.param;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ParamRequestEdit {
    private String newName;
    private String paramName;

    public String getNewName() { return newName; }

    public void setNewName(String name) { this.newName = name; }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @Override
    public String toString() {
        return "Param{" +
                "name='" + newName + '\''+
                '}';
    }
}

