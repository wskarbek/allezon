package pl.edu.pjwstk.jazapp.login;

import pl.edu.pjwstk.jazapp.auth.ProfileEnity;
import pl.edu.pjwstk.jazapp.auth.ProfileRepository;
import pl.edu.pjwstk.jazapp.auth.ProfileSession;

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
    private ProfileSession session;

    @Inject
    private ProfileRepository profileRepository;

    public void login() throws IOException {
        System.out.println("Tried to log in using " + loginRequest.toString());
        ProfileEnity acc = profileRepository.getAndCheckUser(loginRequest.getUsername(), loginRequest.getPassword());
        if(acc != null){
            session.setLoggedUser(acc);
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("/app");
        } else {
            session.setWrongPassword();
        }
        //profileRepository.sampleCodeWithPC();
    }
}
