package com.bookshelfBanshee.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The type User logout.
 */
@WebServlet(
        urlPatterns = {"/logout"}
)

public class UserLogout extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("This is the logout page");
        HttpSession session = req.getSession();
        req.logout();
        session.setMaxInactiveInterval(0);
        session.invalidate();
        logger.debug(req.getUserPrincipal());
        req.logout();
        String location = "index.jsp";
        resp.sendRedirect(location);
    }

}
