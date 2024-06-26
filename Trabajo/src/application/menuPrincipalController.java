package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

import javafx.event.ActionEvent;

public class menuPrincipalController {
	@FXML
	private Button btnNuevoExpediente;

	// Variables globales.
	int idExpediente;  
	Fecha fechaExpediente;
	Expediente expediente;
	Denunciante denunciante;
	Denunciado denunciado;
	Ofendido ofendido;
	String asuntos = "";
	Fecha fechaAsuntos;
	
	// Event Listener on Button[#btnNuevoExpediente].onAction
	@FXML
	public void crearExpediente(ActionEvent event) {
		// Abre la ventana siguiente: DENUNCIANTE.
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("denunciante.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stageDenunciante = new Stage();
			stageDenunciante.initModality(Modality.APPLICATION_MODAL);
			stageDenunciante.setTitle("DENUNCIANTE");
			stageDenunciante.setScene(scene);
			denuncianteController denuncianteController = loader.getController();
			
			//Instanciar una fecha de Expediente.
			this.fechaExpediente = new Fecha(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
			
			//Instanciar una fecha de Asunto.
			this.fechaAsuntos = new Fecha(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());			
			
			//Instancia de un Ofendido en blanco.
			this.ofendido = new Ofendido("", "", 0, 0, 0, "", "", "", "", "", "", "", "", "");
			
			//Instancia de un Denunciado en blanco.
			this.denunciado = new Denunciado("", "", 0, 0, 0, "", "", "", "", "", "", "", "", "");
			
			//Instancia de un Denunciante en blanco.
			this.denunciante = new Denunciante("", "", 0, 0, 0, "", "", "", "", "", "", "", "", "");
			
			//Instancia de un Expediente en blanco.
			this.expediente = new Expediente(this.idExpediente, this.fechaExpediente, this.denunciante, this.denunciado, this.ofendido, this.asuntos, this.fechaAsuntos);			
			
			System.out.printf("--Nuevo Denunciante:%n");
			denuncianteController.init(this.expediente); // Enviar expediente a la ventana DENUNCIANTE.
			stageDenunciante.show(); // Mostrar ventana DENUNCIANTE.
			
			// Cierra la ventana actual: MENU PRINCIPAL.
			Stage stageMenuPrincipal = (Stage) this.btnNuevoExpediente.getScene().getWindow();
			stageMenuPrincipal.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void init(Expediente expediente) {
		// Obtener valor del id del anterior expediente.
		this.idExpediente = expediente.getIdExpediente();
		
	}
}