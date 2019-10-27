package pl.edu.pjwstk.jazapp.register;

import pl.edu.pjwstk.jazapp.accounts.UsersDatabase;

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
    private UsersDatabase usersDatabase;

    public void register() throws IOException {
        System.out.println("Tried to register with" + registerRequest.toString());
        usersDatabase.registerUser(registerRequest.toAccount());

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("login.xhtml");
    }
}
