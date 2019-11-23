package pl.edu.pjwstk.jazapp.login;

import pl.edu.pjwstk.jazapp.auth.ProfileSession;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class LoginFilter extends HttpFilter {

    @Inject
    ProfileSession profileSession;


    //http://www.itcuties.com/j2ee/jsf-2-login-filter-example/
    //https://stackoverflow.com/questions/44702494/servlet-filter-prevents-css-from-working
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        boolean isCSSFile = req.getRequestURI().contains(".css");
        boolean isImageFile = req.getRequestURI().contains(".png");

        //TODO: access to branchedit.xhtml admin / moderator only
        if (profileSession.userIsLogged() || req.getRequestURI().contains("login.xhtml") || req.getRequestURI().contains("register.xhtml") || req.getRequestURI().contains("branchedit.xhtml")|| isCSSFile || isImageFile) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(req.getContextPath()+"/login.xhtml");
        }

    }
}
