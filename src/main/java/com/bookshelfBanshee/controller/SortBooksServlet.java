package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.MappedBook;
import com.googlebooksapi.entity.VolumeInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(
        name = "SortBooks",
        urlPatterns = {"/sortBooks"}
)
public class SortBooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo I think this will have to recall the api since it matters which books have been loaded from it...
        HttpSession session = req.getSession(false);
        Map<Integer, MappedBook> mappedBooks = (Map<Integer, MappedBook>)session.getAttribute("userMappedBooks");
//        List<MappedBook> listMappedBooks = (ArrayList)mappedBooks.values();
//        List<VolumeInfo> sortedListBooks = new ArrayList<>();
//        for (MappedBook book : listMappedBooks) {
//            sortedListBooks.add(book.getGoogleData());
//        }

        Map<Integer, VolumeInfo> mapToSort = new TreeMap<>();
        for (Map.Entry<Integer, MappedBook> entry : mappedBooks.entrySet()) {
            mapToSort.put(entry.getKey(), entry.getValue().getGoogleData());
        }

        Map<Integer, VolumeInfo> sortedMap;

        String sortBy = req.getParameter("sortBy");

        switch(sortBy) {
            case "titleAsc":
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getTitle))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, TreeMap::new));
//                sortedListBooks.sort(Comparator.comparing(VolumeInfo::getTitle));
                break;
            case "titleDesc":
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getTitle).reversed())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, TreeMap::new));
//                sortedListBooks.sort(Comparator.comparing(VolumeInfo::getTitle).reversed());
                break;
//            case "authorAsc":
//                sortedListBooks.sort(Comparator.comparing(VolumeInfo::getLeadAuthor));
//                break;
//            case "authorDesc":
//                sortedListBooks.sort(Comparator.comparing(VolumeInfo::getLeadAuthor).reversed());
//                break;
//            case "pubDateAsc":
//                sortedListBooks.sort(Comparator.comparing(VolumeInfo::getPublishedDate));
//                break;
//            case "pubDateDesc":
//                sortedListBooks.sort(Comparator.comparing(VolumeInfo::getPublishedDate).reversed());
//                break;
//            case "pageCountAsc":
//                sortedListBooks.sort(Comparator.comparing(VolumeInfo::getPageCount));
//                break;
//            case "pageCountDesc":
//                sortedListBooks.sort(Comparator.comparing(VolumeInfo::getPageCount).reversed());
//                break;
            default:
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getTitle))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, TreeMap::new));
                break;
        }

        session.setAttribute("sortedBooks", sortedMap);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);

    }
}
