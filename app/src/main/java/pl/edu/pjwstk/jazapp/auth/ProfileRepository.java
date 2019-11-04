package pl.edu.pjwstk.jazapp.auth;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@ApplicationScoped
public class ProfileRepository {

    final private String BAD_LOGIN = "Incorrect username or password";

    @Inject
    private ProfileSession session;

    @PersistenceContext
    private EntityManager em;

    private String loginError;

    public String getLoginError() { return loginError; }

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

    /*@Transactional
    public boolean emailExists(String email) {
        ProfileEnity profile = em.find
    }*/

    @Transactional
    public ProfileEnity getAndCheckUser(String username, String password) {
        ProfileEnity profile = em.find(ProfileEnity.class, username);
        if(profile != null) {
            if(BCrypt.checkpw(password, profile.getPassword())) {
                return profile;
            } else {
                loginError = BAD_LOGIN;
                return null;
            }
        } else {
            loginError = BAD_LOGIN;
            return null;
        }
    }
}
