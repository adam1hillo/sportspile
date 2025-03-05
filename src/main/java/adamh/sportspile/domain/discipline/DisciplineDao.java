package adamh.sportspile.domain.discipline;

import adamh.sportspile.config.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DisciplineDao {

    private final DataSource dataSource;

    public DisciplineDao() {
        try {
            dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Discipline> findAll() {
        final String sql = """
                SELECT
                    id, name, description
                FROM
                    discipline
                """;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            List<Discipline> allDisciplines = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Discipline discipline = mapRow(resultSet);
                allDisciplines.add(discipline);
            }
            return allDisciplines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Discipline> findById(int disciplineId) {
        final String sql = """
                SELECT
                    id, name, description
                FROM
                    discipline
                WHERE
                    id = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, disciplineId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Discipline discipline = mapRow(resultSet);
                return Optional.of(discipline);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Discipline mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new Discipline(id, name, description);
    }
}
