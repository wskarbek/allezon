package pl.edu.pjwstk.jazapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("hello")
public class HelloWorldServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setStatus(200);
        double average = 0.0;
        double sum = 0.0;
        if (req.getParameter("average") != null) {
            String[] numbers = req.getParameter("average").split(",");
            for (String d : numbers) {
                sum += Integer.parseInt(d);
            }
            average = sum / numbers.length;
        }
        var writer = resp.getWriter();
        writer.println("Enjoy JAZ course.");
        if (average != 0.0) writer.println("Average: " + average);
    }
}
