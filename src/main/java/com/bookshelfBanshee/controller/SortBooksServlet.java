package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.MappedBook;
import com.googlebooksapi.entity.VolumeInfo;
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
import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Sort books servlet.
 */
@WebServlet(
        name = "SortBooks",
        urlPatterns = {"/sortBooks"}
)
public class SortBooksServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        Map<Integer, MappedBook> mappedBooks = (Map<Integer, MappedBook>)session.getAttribute("userMappedBooks");

        Map<Integer, VolumeInfo> mapToSort = new TreeMap<>();
        for (Map.Entry<Integer, MappedBook> entry : mappedBooks.entrySet()) {
            mapToSort.put(entry.getKey(), entry.getValue().getGoogleData());
        }

        Map<Integer, VolumeInfo> sortedMap;

        String sortBy = req.getParameter("sortBy");

        switch(sortBy) {
            case "titleAsc":
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getTitle))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
                break;
            case "titleDesc":
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getTitle).reversed())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap ::new));
                break;
            case "authorAsc":
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getLeadAuthor))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap ::new));
                break;
            case "authorDesc":
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getLeadAuthor).reversed())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap ::new));
                break;
            case "pubDateAsc":
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getPublishedDate))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
                break;
            case "pubDateDesc":
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getPublishedDate).reversed())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
                break;
            case "pageCountAsc":
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getPageCount))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
                break;
            case "pageCountDesc":
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getPageCount).reversed())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
                break;
            default:
                sortedMap = mapToSort.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(VolumeInfo::getTitle))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, TreeMap::new));
                break;
        }

        Map<Integer, MappedBook> mappedBooksOrdered = new LinkedHashMap <>();
        for (Map.Entry<Integer, VolumeInfo> entry : sortedMap.entrySet()) {
            MappedBook book = mappedBooks.get(entry.getKey());
            mappedBooksOrdered.put(entry.getKey(), book);
        }

        logger.debug(mappedBooks);
        logger.debug(mappedBooksOrdered);

        session.setAttribute("userMappedBooks", mappedBooksOrdered);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);

    }
}
