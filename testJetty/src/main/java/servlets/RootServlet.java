package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dfyz on 16.07.2017.
 */
public class RootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("<html><h1>Привет!</h1><br><form method='POST' action='/j_security_check'>"
                + "<input type='text' name='j_username'/>"
                + "<input type='password' name='j_password'/>"
                + "<input type='submit' value='Login'/></form></html>");
    }

}
