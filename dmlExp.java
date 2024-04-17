import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExpedienteDML {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "!1Qazwsx";

    public void insertExpediente(Expediente expediente) {
        String insertQuery = "INSERT INTO expedientes (id, denunciante, denunciado, ofendido, desHechos, fechaDenuncia, fechaSucesos) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setInt(1, expediente.getIdExp());
            statement.setString(2, expediente.getDenunciante());
            statement.setString(3, expediente.getDenunciado());
            statement.setString(4, expediente.getOfendido());
            statement.setString(5, expediente.getDesHechos());
            statement.setDate(6, new java.sql.Date(expediente.getFechaDenuncia().getTime()));
            statement.setDate(7, new java.sql.Date(expediente.getFechaSucesos().getTime()));
            statement.executeUpdate();
            System.out.println("Expediente insert");
        } catch (SQLException e) {
            System.err.println("Error insert expediente " + e.getMessage());
        }
    }

    public void updateExpediente(Expediente expediente) {
        String updateQuery = "UPDATE expedientes SET denunciante = ?, denunciado = ?, ofendido = ?, desHechos = ?, fechaDenuncia = ?, fechaSucesos = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, expediente.getDenunciante());
            statement.setString(2, expediente.getDenunciado());
            statement.setString(3, expediente.getOfendido());
            statement.setString(4, expediente.getDesHechos());
            statement.setDate(5, new java.sql.Date(expediente.getFechaDenuncia().getTime()));
            statement.setDate(6, new java.sql.Date(expediente.getFechaSucesos().getTime()));
            statement.setInt(7, expediente.getIdExp());
            statement.executeUpdate();
            System.out.println("Expediente update ");
        } catch (SQLException e) {
            System.err.println("Error update expediente" + e.getMessage());
        }
    }

    public void deleteExpediente(int id) {
        String deleteQuery = "DELETE FROM expedientes WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Expediente delete");
        } catch (SQLException e) {
            System.err.println("Error delete expediente " + e.getMessage());
        }
    }

    // You can add more methods for other DML operations like querying data
}
