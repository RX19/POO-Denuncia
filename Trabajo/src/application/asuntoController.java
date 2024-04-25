package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.time.LocalDate;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;

public class asuntoController {
	@FXML
	private TextArea txaDescripcion;
	@FXML
	private DatePicker dateAsunto;
	@FXML
	private Button btnAtras;
	@FXML
	private Button btnSiguiente;

	// Variables globales.
	Expediente expediente;
	String asunto;
	Fecha fechaAsunto;
	int año, mes, dia;
	
	// Event Listener on DatePicker[#dateAsunto].onAction
	@FXML
	public void dateAsunto(ActionEvent event) {
		LocalDate localDate = dateAsunto.getValue();
        this.año = localDate.getYear();
        this.mes = localDate.getMonthValue();
        this.dia = localDate.getDayOfMonth();
        this.fechaAsunto = new Fecha(this.dia, this.mes, this.año);
	}
	
	// Event Listener on Button[#btnAtras].onAction
	@FXML
	public void paginaAnterior(ActionEvent event) {
		
		// Abre la ventana siguiente: DENUNCIADO.
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("denunciado.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stageDenunciado = new Stage();
			stageDenunciado.initModality(Modality.APPLICATION_MODAL);
			stageDenunciado.setTitle("DENUNCIADO");
			stageDenunciado.setScene(scene);
			denunciadoController denunciadoController = loader.getController();
			
			System.out.printf("--Editar Denunciado:%n");
			denunciadoController.init(this.expediente); // Enviar expediente a la ventana DENUNCIADO.
			stageDenunciado.show(); // Mostrar ventana DENUNCIADO.
			
			// Cierra la ventana actual: ASUNTO.
			Stage stageAsunto = (Stage) this.btnSiguiente.getScene().getWindow();
			stageAsunto.close();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Event Listener on Button[#btnSiguiente].onAction
	@FXML
	public void paginaSiguiente(ActionEvent event) {
		//Obtener Valores de las cajas de texto.					
		asunto = this.txaDescripcion.getText();
		
		//Verifica si los campos obligatorios no estan vacios.
		if (asunto.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Debe llenar los campos obligatorios (*).");
			alert.showAndWait();
		} else {
			
			// Modificar atributo de Asunto y Fecha de asunto.
			this.expediente.setAsuntos(this.asunto);
			this.expediente.setFechaAsunto(this.fechaAsunto);
			System.out.printf("%s%n", this.expediente.getAsuntos());			
			
			// Abre la ventana siguiente: OFENDIDO.
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ofendido.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				Stage stageOfendido = new Stage();
				stageOfendido.initModality(Modality.APPLICATION_MODAL);
				stageOfendido.setTitle("OFENDIDO");
				stageOfendido.setScene(scene);
				ofendidoController ofendidoController = loader.getController();
				
				System.out.printf("%n--Nuevo Ofendido:%n");
				ofendidoController.init(this.expediente); // Enviar expediente a la ventana OFENDIDO.
				stageOfendido.show(); // Mostrar ventana OFENDIDO.
				
				// Cierra la ventana actual: ASUNTO.
				Stage stageAsunto = (Stage) this.btnSiguiente.getScene().getWindow();
				stageAsunto.close();			
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void init(Expediente expediente) {
		this.expediente = expediente;
		
		// Cuando carga ASUNTO desde el DENUNCIADO deja las casillas en blanco.
		// Pero cuando carga ASUNTO desde OFENDIDO deja los valores escritos con anterioridad.
		txaDescripcion.setText(this.expediente.getAsuntos());
		
		// Establecer una fecha específica (YY/MM/DD)
        this.año = this.expediente.getFechaAsunto().getAño();
        this.mes = this.expediente.getFechaAsunto().getMes();
        this.dia = this.expediente.getFechaAsunto().getDia();
        LocalDate fecha = LocalDate.of(this.año, this.mes, this.dia);
		dateAsunto.setValue(fecha);
	}
}