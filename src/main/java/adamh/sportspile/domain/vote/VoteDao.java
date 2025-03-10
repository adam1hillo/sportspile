package adamh.sportspile.domain.vote;

import adamh.sportspile.domain.common.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
