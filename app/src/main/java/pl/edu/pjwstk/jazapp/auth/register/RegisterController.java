package pl.edu.pjwstk.jazapp.auth.register;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.edu.pjwstk.jazapp.auth.entities.ProfileEnity;
import pl.edu.pjwstk.jazapp.auth.login.LoginProfileRepository;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class RegisterController {
    @Inject
    private RegisterRequest registerRequest;

    @Inject
    private RegisterProfileRepository pr;

    private String registerError = "";

    public String getRegisterError() {
        return registerError;
    }

    public void register() throws IOException {
        System.out.println("Tried to register with" + registerRequest.toString());
        if(pr.userExists(registerRequest.getUsername())) {
            registerError = "User already exists.";
            return;
        }
        if(!registerRequest.getPassword().equals(registerRequest.getPasswordCheck())) {
            registerError = "Passwords are not matching.";
            return;
        }
        /*if(pr.emailExists(registerRequest.getEmail())) {
            registerError = "This email address belongs to another account.";
            return;
        }*/

        var passwordEncoder = new BCryptPasswordEncoder();
        final String rawPass = registerRequest.getPassword();
        final String hashPass = passwordEncoder.encode(rawPass);
        System.out.println("Hashed password: " + hashPass);

        pr.registerUser(new ProfileEnity(
                registerRequest.getUsername(),
                hashPass,
                registerRequest.getName(),
                registerRequest.getSurname(),
                registerRequest.getEmail(),
                registerRequest.getBirthday(),
                false
        ));
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("login.xhtml");
    }
}
