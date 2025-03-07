package adamh.sportspile.client.news;

import adamh.sportspile.domain.api.DisciplineService;
import adamh.sportspile.domain.api.NewsService;
import adamh.sportspile.domain.dto.DisciplineName;
import adamh.sportspile.domain.dto.NewsSaveRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/news/add")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER"),
                @HttpMethodConstraint(value = "POST", rolesAllowed = "USER")
        }
)
public class AddNewsController extends HttpServlet {

    private final DisciplineService disciplineService = new DisciplineService();
    private final NewsService newsService = new NewsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DisciplineName> disciplines = disciplineService.findAllDisciplines();
        request.setAttribute("disciplines", disciplines);
        request.getRequestDispatcher("/WEB-INF/views/add-news.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsSaveRequest saveRequest = createSaveRequest(request);
        newsService.add(saveRequest);
        response.sendRedirect(request.getContextPath());
    }

    private NewsSaveRequest createSaveRequest(HttpServletRequest request) {
        return new NewsSaveRequest(
                request.getParameter("title"),
                request.getParameter("url"),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("disciplineId")),
                request.getUserPrincipal().getName()
        );
    }
}
