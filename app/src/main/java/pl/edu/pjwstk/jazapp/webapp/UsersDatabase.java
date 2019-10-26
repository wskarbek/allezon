package pl.edu.pjwstk.jazapp.webapp;

import java.util.ArrayList;
import java.util.List;

public class UsersDatabase {
    List<Account> database = new ArrayList<Account>();

    public Account getUser(int id) {
        return database.get(id);
    }

    public void registerUser(Account account) {
        database.add(account);
    }
}
