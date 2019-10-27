package pl.edu.pjwstk.jazapp.login;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("*")
public class LoginFilter {

    //http://www.itcuties.com/j2ee/jsf-2-login-filter-example/
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        /*if (req.getRequestURI().contains("/test")) {
            res.sendRedirect("https://google.com");
        } else {
            chain.doFilter(req, res);
        }*/

    }
}
