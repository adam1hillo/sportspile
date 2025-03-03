package adamh.sportspile.domain.news;

import adamh.sportspile.config.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {

    private final DataSource dataSource;

    public NewsDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<News> findAll() {
        final String sql = """
                SELECT
                    id, title, url, description, date_added, discipline_id
                FROM
                    news
                """;
        try (Connection connection = dataSource.getConnection();
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
