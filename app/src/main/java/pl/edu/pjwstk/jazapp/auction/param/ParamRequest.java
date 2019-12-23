package pl.edu.pjwstk.jazapp.auction.param;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ParamRequest {
    private String name;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Param{" +
                "name='" + name + '\''+
                '}';
    }
}

