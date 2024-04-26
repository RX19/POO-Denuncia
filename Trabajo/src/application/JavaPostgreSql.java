package application;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgreSql {

	public static void writeToDatabase(int dbnumExp, String dbFechaExp, String dbDenunciante, String dbDenunciado, String dbOfendido, String dbAsuntos, String dbFechaAsuntos) {
		
		String url = "jdbc:postgresql://localhost:5432/JavaFX";
		String user = "postgres";
		String password = "A123456789";
		
		int numExp = dbnumExp;
		String FechaExp = dbFechaExp;
		String Denunciante = dbDenunciante;
		String Denunciado = dbDenunciado;
		String Ofendido = dbOfendido;
		String Asuntos = dbAsuntos;
		String FechaAsuntos = dbFechaAsuntos;
		
		String query = "INSERT INTO expedientes(IdExpediente, FechaExpediente, Denunciante, Denunciado, Ofendido, Asuntos, FechaAsuntos) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement pst = con.prepareStatement(query)) {
			
			pst.setString(1, String.valueOf(numExp));
			pst.setString(2, FechaExp);
			pst.setString(3, Denunciante);
			pst.setString(4, Denunciado);
			pst.setString(5, Ofendido);
			pst.setString(6, Asuntos);
			pst.setString(7, FechaAsuntos);
			pst.executeUpdate();
			System.out.println("Dato Creado Exitosamente.");
			
		} catch (SQLException ex) {
			
			Logger lgr = Logger.getLogger(JavaPostgreSql.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			
		}
	}

}
