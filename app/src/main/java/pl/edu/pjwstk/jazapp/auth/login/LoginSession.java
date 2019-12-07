package pl.edu.pjwstk.jazapp.auth.login;

import pl.edu.pjwstk.jazapp.auth.entities.ProfileEnity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginSession implements Serializable {
    private ProfileEnity loggedUser;
    private String name = "";

    public String getName() {
        return name;
    }

    public String getUsername() { return loggedUser.getUsername(); }

    public void setLoggedUser(ProfileEnity loggedUser) {
        this.loggedUser = loggedUser;
        name = loggedUser.getName() + " " + loggedUser.getSurname();
    }

    public boolean userIsLogged() {
        if (loggedUser != null) return true;
        return false;
    }

    public ProfileEnity getCurrentUser() {
        return loggedUser;
    }
}
