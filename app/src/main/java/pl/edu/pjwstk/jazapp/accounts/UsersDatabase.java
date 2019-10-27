package pl.edu.pjwstk.jazapp.accounts;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsersDatabase {
    private final List<Account> database = new ArrayList<Account>();

    /*public Account getUser(String username) {
        for (Account a : database) {

        }
    }*/

    public void registerUser(Account account) {
        database.add(account);
    }

    public Account getAndCheckUser(String username, String password) {
        if (database.size() == 0) System.out.println("Database is empty!");
        for (Account a : database) {
            if(a.getUsername().equals(username)) {
                if(a.getPassword().equals(password)) {
                    System.out.println("User logged in as " + a.getUsername());
                    return a;
                } else {
                    System.out.println("Wrong password");
                    return null;
                }
            } else {
                System.out.println("User doesn't exist");
                return null;
            }
        }
        return null;
    }
}
