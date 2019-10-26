package pl.edu.pjwstk.jazapp.webapp;

import pl.edu.pjwstk.jazapp.register.RegisterRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterController {
    @Inject
    private RegisterRequest registerRequest;

    public void register() {
        System.out.println("Tried to register with" + registerRequest.toString());
    }
}
