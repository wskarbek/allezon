package pl.edu.pjwstk.jazapp.register;

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

    public void register() throws IOException {
        System.out.println("Tried to register with" + registerRequest.toString());
        //usersDatabase.registerUser(registerRequest.toAccount());

        pr.registerUser(new ProfileEnity(
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                registerRequest.getName(),
                registerRequest.getSurname(),
                registerRequest.getEmail(),
                registerRequest.getBirthday()
        ));

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("login.xhtml");
    }
}
