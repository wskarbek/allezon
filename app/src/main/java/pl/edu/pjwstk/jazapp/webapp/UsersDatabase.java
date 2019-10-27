package pl.edu.pjwstk.jazapp.webapp;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

import pl.edu.pjwstk.jazapp.register.RegisterRequest;

@ApplicationScoped
public class UsersDatabase {
    List<Account> database = new ArrayList<Account>();

    public Account getUser(int id) {
        return database.get(id);
    }

    public void registerUser(Account account) {
        database.add(account);
    }

    public boolean checkUser(String username, String password) {
        for (Account a : database) {
            if(a.getUsername().equals(username)) {
                if(a.getPassword().equals(password)) {
                    System.out.println("User logged in as " + a.getUsername());
                    return true;
                } else {
                    System.out.println("Wrong password");
                    return false;
                }
            } else {
                System.out.println("User doesn't exist");
                return false;
            }
        }
        return false;
    }
}
