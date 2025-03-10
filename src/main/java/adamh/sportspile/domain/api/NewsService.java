package adamh.sportspile.domain.api;

import adamh.sportspile.domain.dto.NewsBasicInfo;
import adamh.sportspile.domain.dto.NewsSaveRequest;
import adamh.sportspile.domain.news.News;
import adamh.sportspile.domain.news.NewsDao;
import adamh.sportspile.domain.user.UserDao;
import adamh.sportspile.domain.vote.VoteDao;

import java.time.LocalDateTime;
import java.util.List;


public class NewsService {

    private final NewsDao newsDao = new NewsDao();
    private final NewsMapper newsMapper = new NewsMapper();

    public void add(NewsSaveRequest saveRequest) {
        News news = newsMapper.map(saveRequest);
        newsDao.save(news);
    }

    public List<NewsBasicInfo> findAll() {
        return newsDao.findAll()
                .stream()
                .map(newsMapper::map)
                .toList();
    }

    public List<NewsBasicInfo> findByDiscipline(int disciplineId) {
        return newsDao.findByDiscipline(disciplineId)
                .stream()
                .map(newsMapper::map)
                .toList();
    }

    private static class NewsMapper {
        private final VoteDao voteDao = new VoteDao();
        private final UserDao userDao = new UserDao();
        NewsBasicInfo map(News news) {
            return new NewsBasicInfo(
                    news.getId(),
                    news.getTitle(),
                    news.getUrl(),
                    news.getDescription(),
                    news.getDateAdded(),
                    voteDao.voteCountByNewsId(news.getId()),
                    userDao.findById(news.getUserId())
                            .orElseThrow()
                            .getUsername()
            );
        }
        News map(NewsSaveRequest saveRequest) {
            return new News(
                    saveRequest.getTitle(),
                    saveRequest.getUrl(),
                    saveRequest.getDescription(),
                    LocalDateTime.now(),
                    saveRequest.getDisciplineId(),
                    userDao.findByUsername(saveRequest.getUsername())
                            .orElseThrow()
                            .getId()
            );
        }
    }
}
