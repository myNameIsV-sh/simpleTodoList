import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPostgreSQL {
    private String url;
    private String user;
    private String password;
    private String driver;

    public ConnectionPostgreSQL() {
        this.url = "jdbc:postgresql://localhost:5432/postgres";
        this.user = "postgres";
        this.password = "12345";
        this.driver = "org.postgresql.Driver";
    }

    public Connection getConection() throws SQLException {
        //Não é mais necessário
        //Class.forName(this.driver);

        return DriverManager.getConnection(url, user, password);
    }

    public void close(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        close(statement, connection);
    }

    public void close(PreparedStatement stmt, Connection conexao) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
