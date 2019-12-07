package pl.edu.pjwstk.jazapp.auth.login;

import pl.edu.pjwstk.jazapp.auth.entities.ProfileEnity;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class LoginController {
    @Inject
    private LoginRequest loginRequest;

    @Inject
    private LoginSession session;

    @Inject
    private LoginProfileRepository profileRepository;

    private String loginError = "";

    public String getLoginError() {
        return loginError;
    }

    public void login() throws IOException {
        System.out.println("Tried to log in using " + loginRequest.toString());

        ProfileEnity acc = profileRepository.getAndCheckUser(loginRequest.getUsername(), loginRequest.getPassword());
        if(acc != null){
            session.setLoggedUser(acc);
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("/app");
        }
    }
}
