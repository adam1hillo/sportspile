package adamh.sportspile.domain.api;

import adamh.sportspile.domain.dto.NewsBasicInfo;
import adamh.sportspile.domain.dto.NewsSaveRequest;
import adamh.sportspile.domain.news.News;
import adamh.sportspile.domain.news.NewsDao;
import adamh.sportspile.domain.user.User;
import adamh.sportspile.domain.user.UserDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class NewsService {

    private final NewsDao newsDao = new NewsDao();
    private final UserDao userDao = new UserDao();

    public void add(NewsSaveRequest saveRequest) {
        int userId = userDao.findByUsername(saveRequest.getUsername())
                .orElseThrow()
                .getId();
        News news = NewsMapper.map(saveRequest, userId);
        newsDao.save(news);
    }

    public List<NewsBasicInfo> findAll() {
        return newsDao.findAll()
                .stream()
                .map(NewsMapper::map)
                .toList();
    }

    public List<NewsBasicInfo> findByDiscipline(int disciplineId) {
        return newsDao.findByDiscipline(disciplineId)
                .stream()
                .map(NewsMapper::map)
                .toList();
    }

    private static class NewsMapper {
        static NewsBasicInfo map(News news) {
            return new NewsBasicInfo(
                    news.getId(),
                    news.getTitle(),
                    news.getUrl(),
                    news.getDescription(),
                    news.getDateAdded()
            );
        }
        static News map(NewsSaveRequest saveRequest, int userId) {
            return new News(
                    saveRequest.getTitle(),
                    saveRequest.getUrl(),
                    saveRequest.getDescription(),
                    LocalDateTime.now(),
                    saveRequest.getDisciplineId(),
                    userId
            );
        }
    }
}
