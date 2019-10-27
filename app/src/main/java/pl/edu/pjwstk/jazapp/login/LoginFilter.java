package pl.edu.pjwstk.jazapp.login;

import javax.servlet.annotation.WebFilter;
import javax.servlet.ServletException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class LoginFilter {

    //@Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        /*if (req.getRequestURI().contains("/test")) {
            res.sendRedirect("https://google.com");
        } else {
            chain.doFilter(req, res);
        }*/
    }
}
