package adamh.sportspile.domain.common;

import adamh.sportspile.config.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseDao {

    private final DataSource dataSource;

    public BaseDao() {
        try {
            dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
