package pl.edu.pjwstk.jazapp.auth;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ProfileRepository {

    @Inject
    private ProfileSession session;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void registerUser(ProfileEnity pe) {
        em.persist(pe);
    }

    @Transactional
    public ProfileEnity getAndCheckUser(String username, String password) {
        ProfileEnity profile = em.find(ProfileEnity.class, username);
        if(profile != null) {
            if(BCrypt.checkpw(password, profile.getPassword())) {
                return profile;
            }
        } else {
            System.out.println("User not found");
            return null;
        }
        return null;
    }
}
