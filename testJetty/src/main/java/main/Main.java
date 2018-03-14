package main;


import org.eclipse.jetty.security.*;
import org.eclipse.jetty.security.authentication.FormAuthenticator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.security.Constraint;
import servlets.LkServlet;
import servlets.RootServlet;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Dfyz on 16.07.2017.
 */
public class Main {
    public static void main(String[] a) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler contextHandler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS|ServletContextHandler.SECURITY);

        contextHandler.addServlet(new ServletHolder(new DefaultServlet() {
            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("text/html");

            }
        }), "/login");

        contextHandler.addServlet(LkServlet.class,"/lk");
        contextHandler.addServlet(RootServlet.class,"/");

        Constraint constraint = new Constraint();
        constraint.setName(Constraint.__FORM_AUTH);
        constraint.setRoles(new String[]{"user","admin"});
        constraint.setAuthenticate(true);

        ConstraintMapping constraintMapping = new ConstraintMapping();
        constraintMapping.setConstraint(constraint);
        constraintMapping.setPathSpec("/lk/*");

        ConstraintSecurityHandler securityHandler = new ConstraintSecurityHandler();
        securityHandler.addConstraintMapping(constraintMapping);
        //HashLoginService loginService = new HashLoginService();
        //loginService.putUser("username", new Password("password"), new String[] {"user"});
        LoginService loginService = new JDBCLoginService("loginservice","../resources/main/mysql.properties");
        securityHandler.setLoginService(loginService);

        FormAuthenticator authenticator = new FormAuthenticator("/login", "/login", false);
        securityHandler.setAuthenticator(authenticator);

        contextHandler.setSecurityHandler(securityHandler);

        server.start();
        server.join();
    }

}
