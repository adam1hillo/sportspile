package adamh.sportspile.client.discipline;

import adamh.sportspile.domain.api.DisciplineService;
import adamh.sportspile.domain.api.NewsService;
import adamh.sportspile.domain.dto.DisciplineFullInfo;
import adamh.sportspile.domain.dto.NewsBasicInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/discipline")
public class DisciplineController extends HttpServlet {

    private final DisciplineService disciplineService = new DisciplineService();
    private final NewsService newsService = new NewsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int disciplineId = Integer.parseInt(request.getParameter("id"));
        DisciplineFullInfo discipline = disciplineService.findById(disciplineId).orElseThrow();
        request.setAttribute("discipline", discipline);
        List<NewsBasicInfo> allNewsByDiscipline = newsService.findByDiscipline(disciplineId);
        request.setAttribute("news", allNewsByDiscipline);
        request.getRequestDispatcher("WEB-INF/views/discipline.jsp").forward(request, response);
    }
}
