package pl.edu.pjwstk.jazapp.register;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String passwordCheck;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPasswordCheck() { return passwordCheck; }
    public void setPasswordCheck(String passwordCheck) { this.passwordCheck = passwordCheck; }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordCheck='" + passwordCheck + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ",}";
    }
}
