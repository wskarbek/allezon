package pl.edu.pjwstk.jazapp.auth.login;

import pl.edu.pjwstk.jazapp.auth.entities.ProfileEnity;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
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

    public void logout() throws IOException {
        this.loggedUser = null;
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("/app/login.xhtml");
    }

    public boolean userIsLogged() {
        if (loggedUser != null) return true;
        return false;
    }

    public ProfileEnity getCurrentUser() {
        return loggedUser;
    }

    public boolean isAdmin() {
        return loggedUser.getAdmin();
    }

    public void adminPanel() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("/app/admin.xhtml");
    }
}
