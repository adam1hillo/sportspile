package adamh.sportspile.domain.api;

import adamh.sportspile.domain.news.News;
import adamh.sportspile.domain.news.NewsDao;

import java.util.List;

public class NewsService {

    private final NewsDao newsDao = new NewsDao();

    public List<NewsBasicInfo> findAll() {
        return newsDao.findAll()
                .stream()
                .map(NewsMapper::map)
                .toList();
    }

    private static class NewsMapper {
        static NewsBasicInfo map(News news) {
            return new NewsBasicInfo(
                    news.getTitle(),
                    news.getUrl(),
                    news.getDescription(),
                    news.getDateAdded()
            );
        }
    }
}
