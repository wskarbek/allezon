package pl.edu.pjwstk.jazapp.auth;

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
            if(password.equals(profile.getPassword())) {
                return profile;
            }
        } else {
            System.out.println("User not found");
            return null;
        }
        return null;
    }
    /*@Transactional
    public void sampleCodeWithPC() {
        ProfileEnity profile = new ProfileEnity("jesieniarz");

        em.persist(profile);

        final ProfileEnity profileEnity = em.find(ProfileEnity.class, 7L);
        var list = em.createQuery("from ProfileEnity where name = :name", ProfileEnity.class)
                .setParameter("name", "jesieniarz2")
                .getResultList();

        var passwordEncoder = new BCryptPasswordEncoder();
        final String rawPassword = "xGXi7Qb5EK4";

        System.out.println("hashed password try 1: " + passwordEncoder.encode(rawPassword));
    }*/
}
