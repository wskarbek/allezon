package pl.edu.pjwstk.jazapp.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ProfileRepository {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
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
    }
}
