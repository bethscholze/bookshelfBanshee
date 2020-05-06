package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.utilities.PropertiesLoader;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;


/**
 * The type Application startup.
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = {"/project4-startup"},
        loadOnStartup = 1
)
/**
 * A servlet to load properties.
 *  @author Beth Scholze
 *  @version 4
 */
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {
    private Properties properties;

    public void init() {
        //todo move urls for api to properties folder
        properties = loadProperties("/bookshelfBanshee.properties");
        BookManager bookManager = new BookManager();
        ListManager listManager = new ListManager();
        getServletContext().setAttribute("bookshelfBanshee", properties);
        getServletContext().setAttribute("bookManager", bookManager);
        getServletContext().setAttribute("listManager", listManager);
    }

}