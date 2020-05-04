package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Role;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


@WebServlet(
        name = "Signup",
        urlPatterns = {"/Signup"}
)
public class SignupServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");

        String password = req.getParameter("password");
        String retypedPassword = req.getParameter("password2");
        logger.debug("the username: {}", username);
        logger.debug("the password: {}", password);
        logger.debug("the retyped Password: {}", retypedPassword);

        //TODO check the username here, move password authentication to front end
        if (password.equals(retypedPassword)){
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            logger.debug(newUser.toString());
            Role userRole = new Role();
            userRole.setRole("user");
            userRole.setUser(newUser);
            userRole.setUsername(newUser.getUsername());
            GenericDao<User> userDao = new GenericDao<>(User.class);
            userDao.insert(newUser);
            GenericDao<Role> roleDao = new GenericDao<>(Role.class);
            roleDao.insert(userRole);
            String successMessage = "Success account created! Please log in to get started.";
            session.setAttribute("successMessage", successMessage);
            //goes to new url
            String location = "UserHome";
            resp.sendRedirect(location);
        } else {
            String errorMessage = "Passwords do not match. Please retry.";
            session.setAttribute("errorMessage", errorMessage);
            //stays at same url
            RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
            dispatcher.forward(req, resp);
        }


    }
}
