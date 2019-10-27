package pl.edu.pjwstk.jazapp.login;

import pl.edu.pjwstk.jazapp.accounts.Account;
import pl.edu.pjwstk.jazapp.accounts.UsersDatabase;
import pl.edu.pjwstk.jazapp.accounts.WebSession;

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
    private UsersDatabase usersDatabase;

    @Inject
    private WebSession session;

    //@Inject
    //private ProfileRepository profileRepository;

    public void login() throws IOException {
        System.out.println("Tried to log in using " + loginRequest.toString());
        Account acc = usersDatabase.getAndCheckUser(loginRequest.getUsername(), loginRequest.getPassword());
        if(acc != null){
            session.setLoggedUser(acc);
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("/app");
        } else {
            //TODO: Couldn't login error
        }
        //profileRepository.sampleCodeWithPC();
    }
}
