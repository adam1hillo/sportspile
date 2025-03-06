package adamh.sportspile.domain.news;

import adamh.sportspile.config.DataSourceProvider;
import adamh.sportspile.domain.common.BaseDao;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsDao extends BaseDao {



    public List<News> findAll() {
        final String sql = """
                SELECT
                    id, title, url, description, date_added, discipline_id
                FROM
                    news
                """;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<News> allNews = new ArrayList<>();
            while (resultSet.next()) {
                News news = mapRow(resultSet);
                allNews.add(news);
            }
            return allNews;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<News> findByDiscipline(int disciplineId) {
        final String sql = """
                SELECT
                    id, title, url, description, date_added, discipline_id
                FROM
                    news
                WHERE
                    discipline_id = ?
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, disciplineId);
            List<News> newsList = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                News news = mapRow(resultSet);
                newsList.add(news);
            }
            return newsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private News mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String url = resultSet.getString("url");
        String description = resultSet.getString("description");
        LocalDateTime dateAdded = resultSet.getObject("date_added", LocalDateTime.class);
        int disciplineId = resultSet.getInt("discipline_id");
        return new News(id,title, url, description, dateAdded, disciplineId);
    }
}
