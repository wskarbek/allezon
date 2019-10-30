package pl.edu.pjwstk.jazapp.accounts;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class WebSession implements Serializable {
    private Account loggedUser;
    private String name = "";

    public String getName() {
        return name;
    }

    public Account getLoggedUser() {
        return loggedUser;
    }

    public String getUsername() { return loggedUser.getUsername(); }

    public void setLoggedUser(Account loggedUser) {
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
