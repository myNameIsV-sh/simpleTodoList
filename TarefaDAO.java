import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TarefaDAO {
    // Create
    public void adicionarTarefa(ListaTarefas tarefas) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = postgres.getConection();
            statement = connection.prepareStatement("INSERT INTO TAREFA(id, descricao, data, status) VALUES(?,?,?,?)");
            statement.setInt(1, tarefas.getId());
            statement.setString(2, tarefas.getDescricao());
            statement.setString(3, tarefas.getData());
            statement.setString(4, tarefas.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(statement, connection);
        }
    }

    // Read
    public List<ListaTarefas> listarTarefas() {
        List<ListaTarefas> lista_tarefas = new LinkedList<>();
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = postgres.getConection();
            statement = connection.prepareStatement("SELECT * FROM TAREFA ORDER BY ID");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ListaTarefas listaTarefas = new ListaTarefas(resultSet.getInt("id"),
                        resultSet.getString("descricao"), resultSet.getString("data"), resultSet.getString("status"));
                lista_tarefas.add(listaTarefas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(resultSet, statement, connection);
        }
        return lista_tarefas;
    }

    // Filtrando as visualizações
    public ListaTarefas visualizarUtilizandoCodigo(int id) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = postgres.getConection();
            statement = connection.prepareStatement("SELECT * FROM TAREFA WHERE ID=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ListaTarefas tarefas = new ListaTarefas(resultSet.getInt("id"),
                        resultSet.getString("descricao"), resultSet.getString("data"), resultSet.getString("status"));
                return tarefas;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(resultSet, statement, connection);
        }
        return null;
    }

    // Update
    public void atualizarTarefas(ListaTarefas tarefas) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = postgres.getConection();
            statement = connection.prepareStatement("UPDATE TAREFA SET descricao=?, data=?, status=? WHERE ID=?");
            statement.setString(1, tarefas.getDescricao());
            statement.setString(2, tarefas.getData());
            statement.setString(3, tarefas.getStatus());
            statement.setInt(1, tarefas.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(statement, connection);
        }
    }

    // Delete
    public void deletarTarefa(int id) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = postgres.getConection();
            statement = connection.prepareStatement("DELETE FROM TAREFA WHERE ID=?");
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, statement, connection);
        }
    }


}
