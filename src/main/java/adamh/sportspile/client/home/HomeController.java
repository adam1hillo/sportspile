package adamh.sportspile.client.home;

import adamh.sportspile.domain.api.NewsBasicInfo;
import adamh.sportspile.domain.api.NewsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {

    private final NewsService newsService = new NewsService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NewsBasicInfo> allNews = newsService.findAll();
        request.setAttribute("news", allNews);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
