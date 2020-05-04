package com.bookshelfBanshee.controller;

import com.googlebooksapi.entity.VolumeInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(
        name = "SortBooks",
        urlPatterns = {"/sortBooks"}
)
public class SortBooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo I think this will have to recall the api since it matters which books have been loaded from it...
        HttpSession session = req.getSession();
        List<VolumeInfo> googleBooksData = (List<VolumeInfo>)session.getAttribute("userGoogleBooks");

        String sortBy = req.getParameter("sortBy");

        switch(sortBy) {
            case "titleAsc":
                googleBooksData.sort(Comparator.comparing(VolumeInfo::getTitle));
                break;
            case "titleDesc":
                googleBooksData.sort(Comparator.comparing(VolumeInfo::getTitle).reversed());
                break;
            case "author":
                googleBooksData.sort(Comparator.comparing(VolumeInfo::getLeadAuthor));
                break;
            case "pubDate":
                googleBooksData.sort(Comparator.comparing(VolumeInfo::getPublishedDate));
                break;
            case "pageCount":
                googleBooksData.sort(Comparator.comparing(VolumeInfo::getPageCount));
                break;
            default:
                googleBooksData.sort(Comparator.comparing(VolumeInfo::getTitle));
                break;
        }

        session.setAttribute("userGoogleBooks", googleBooksData);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);

    }
}
