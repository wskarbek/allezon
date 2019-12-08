package pl.edu.pjwstk.jazapp.auth.login;

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
    LoginSession loginSession;

    //http://www.itcuties.com/j2ee/jsf-2-login-filter-example/
    //https://stackoverflow.com/questions/44702494/servlet-filter-prevents-css-from-working
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        boolean isCSSFile = req.getRequestURI().contains(".css");
        boolean isImageFile = req.getRequestURI().contains(".png");

        String[] authPages = { "login.xhtml", "register.xhtml" };
        String[] adminPages = { "branchedit.xhtml", "admin.xhtml" };

        if(isOneOfSites(req.getRequestURI(), adminPages)) {
            if(loginSession.getCurrentUser() != null) {
                if(loginSession.getCurrentUser().getAdmin()) {
                    chain.doFilter(req, res);
                } else {
                    res.sendRedirect(req.getContextPath() + "/noaccess.xhtml");
                }
            } else {
                res.sendRedirect(req.getContextPath() + "/login.xhtml");
            }
        } else {
            if (loginSession.userIsLogged() || isOneOfSites(req.getRequestURI(), authPages) || req.getRequestURI().contains("branchedit.xhtml") || isCSSFile || isImageFile) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect(req.getContextPath() + "/login.xhtml");
            }
        }
    }

    private boolean isOneOfSites(String address, String[] uris) {
        for (String uri : uris) {
            if (address.contains(uri)) {
                return true;
            }
        }
        return false;
    }
}
