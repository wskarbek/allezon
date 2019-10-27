package pl.edu.pjwstk.jazapp.webapp;

import pl.edu.pjwstk.jazapp.register.RegisterRequest;
import pl.edu.pjwstk.jazapp.webapp.UsersDatabase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterController {
    @Inject
    private RegisterRequest registerRequest;

    @Inject
    private UsersDatabase usersDatabase;

    public void register() {
        System.out.println("Tried to register with" + registerRequest.toString());

        usersDatabase.registerUser(registerRequest.toAccount());
    }
}
