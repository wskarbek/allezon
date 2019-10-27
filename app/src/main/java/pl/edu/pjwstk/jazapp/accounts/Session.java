package pl.edu.pjwstk.jazapp.accounts;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class Session implements Serializable {
    private boolean session = false;
    private Account loggedUser;

    public Account getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Account loggedUser) {
        this.loggedUser = loggedUser;
    }
}
