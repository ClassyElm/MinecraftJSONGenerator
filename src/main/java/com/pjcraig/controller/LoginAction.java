package com.pjcraig.controller;

import com.pjcraig.entity.User;
import com.pjcraig.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet handles requests made for logging a user or admin into the web application through the login button.
 * @author pjcraig
 */
@WebServlet(
        name = "LoginAction",
        urlPatterns = {"/login"}
)
public class LoginAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger();

    /**
     * Redirects the user to the index page.
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException Whether or not the servlet encounters an error.
     * @throws IOException Whether or not an IO exception occurs.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getRemoteUser();
        String role = request.isUserInRole("admin") ? "admin" : "user";
        logger.info("Logged in {} user with a role of {}", user, role);
        // TODO: Pass login feedback as attribute rather than letting index page handle logic
        response.sendRedirect("index.jsp");
    }
}
