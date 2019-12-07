package pl.edu.pjwstk.jazapp.auth.register;

import org.springframework.security.crypto.bcrypt.BCrypt;
import pl.edu.pjwstk.jazapp.auth.login.LoginSession;
import pl.edu.pjwstk.jazapp.auth.entities.ProfileEnity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@ApplicationScoped
public class RegisterProfileRepository {

    final private String BAD_LOGIN = "Incorrect username or password";

    @Inject
    private LoginSession session;

    @PersistenceContext
    private EntityManager em;

    private String loginError;

    public String getLoginError() {
        return loginError;
    }

    @Transactional
    public void registerUser(ProfileEnity pe) {
        em.persist(pe);
    }

    @Transactional
    public boolean userExists(String username) {
        ProfileEnity profile = em.find(ProfileEnity.class, username);
        if (profile != null) return true;
        return false;
    }
}
