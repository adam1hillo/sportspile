package adamh.sportspile.domain.vote;

import adamh.sportspile.domain.common.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteDao extends BaseDao {
    public void save(Vote vote) {
        final String sql = """
                INSERT INTO
                    vote (user_id, news_id, type, date_added)
                VALUES
                    (?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE
                    type = ?
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, vote.getUserId());
            statement.setInt(2, vote.getNewsId());
            statement.setString(3, vote.getType().toString());
            statement.setObject(4, vote.getDateAdded());
            statement.setObject(5, vote.getType().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int voteCountByNewsId(int newsId) {
        final String sql = """
                SELECT
                    (SELECT COUNT(news_id) FROM vote WHERE news_id = ? AND type = 'UP')
                    -
                    (SELECT COUNT(news_id) FROM vote WHERE news_id = ? AND type = 'DOWN')
                    AS
                    vote_count
                """;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newsId);
            statement.setInt(2, newsId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("vote_count");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
