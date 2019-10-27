package pl.edu.pjwstk.jazapp;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class NavigationController implements Serializable{

    // http://www.itcuties.com/j2ee/jsf-2-login-filter-example/

    public String redirectToLogin() {
        return "/login.xhtml?faces-redirect=true";
    }

    public String toLogin() {
        return "/login.xhtml";
    }

    public String redirectToWelcome() {
        return "/secured/welcome.xhtml?faces-redirect=true";
    }

    public String toWelcome() {
        return "/secured/welcome.xhtml";
    }
}
