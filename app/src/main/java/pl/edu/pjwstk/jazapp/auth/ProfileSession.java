package pl.edu.pjwstk.jazapp.auth;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ProfileSession implements Serializable {
    private ProfileEnity loggedUser;
    private String name = "";

    public String getName() {
        return name;
    }

    public String getUsername() { return loggedUser.getUsername(); }

    public void setLoggedUser(ProfileEnity loggedUser) {
        this.loggedUser = loggedUser;
        name = loggedUser.getUsername();
    }

    public void setWrongPassword() {
        //TODO: Wrong password message
    }

    public boolean userIsLogged() {
        if (loggedUser != null) return true;
        return false;
    }
}
