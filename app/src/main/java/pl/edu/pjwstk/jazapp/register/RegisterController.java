package pl.edu.pjwstk.jazapp.register;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.edu.pjwstk.jazapp.auth.ProfileEnity;
import pl.edu.pjwstk.jazapp.auth.ProfileRepository;

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
    private ProfileRepository pr;

    private String registerError = "";

    public String getRegisterError() {
        return registerError;
    }

    public void register() throws IOException {
        System.out.println("Tried to register with" + registerRequest.toString());
        //usersDatabase.registerUser(registerRequest.toAccount());

        if(!pr.userExists(registerRequest.getUsername())) {

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
                    registerRequest.getBirthday()
            ));

            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("login.xhtml");
        } else {
            registerError = "User already exists.";
        }
    }
}
