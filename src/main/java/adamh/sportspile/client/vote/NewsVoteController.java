package adamh.sportspile.client.vote;

import adamh.sportspile.domain.api.NewsVoteService;
import adamh.sportspile.domain.dto.NewsVote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/news/vote")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER")
        }
)
public class NewsVoteController extends HttpServlet {

    private final NewsVoteService newsVoteService = new NewsVoteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsVote vote = createNewsVote(request);
        newsVoteService.addVote(vote);
        response.sendRedirect(request.getContextPath());
    }

    private NewsVote createNewsVote(HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        Integer newsId = Integer.valueOf(request.getParameter("id"));
        String type = request.getParameter("type");
        return new NewsVote(username, newsId, type);
    }
}
