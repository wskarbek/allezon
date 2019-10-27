package pl.edu.pjwstk.jazapp.webapp;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.edu.pjwstk.jazapp.login.LoginRequest;
import pl.edu.pjwstk.jazapp.webapp.UsersDatabase;

@Named
@RequestScoped
public class LoginController {
    @Inject
    private LoginRequest loginRequest;

    @Inject
    private UsersDatabase usersDatabase;

    //@Inject
    //private ProfileRepository profileRepository;

    public void login() {
        System.out.println("Tried to log in using " + loginRequest.toString());

        usersDatabase.checkUser(loginRequest.getUsername(), loginRequest.getPassword());
        //profileRepository.sampleCodeWithPC();
    }
}
