package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

import javafx.event.ActionEvent;

import javafx.scene.control.DatePicker;

public class expedienteController {
	@FXML
	private TextField txtIdExp;
	@FXML
	private DatePicker dateExpediente;
	@FXML
	private Button btnAtras;
	@FXML
	private Button btnSiguiente;

	// Variables globales.
	Expediente expediente;
	Fecha fechaExpediente;
	int año, mes, dia;
	
	// Event Listener on DatePicker[#dateExpediente].onAction
	@FXML
	public void dateExpediente(ActionEvent event) {
		LocalDate localDate = dateExpediente.getValue();
        this.año = localDate.getYear();
        this.mes = localDate.getMonthValue();
        this.dia = localDate.getDayOfMonth();
        this.fechaExpediente = new Fecha(this.dia, this.mes, this.año);
	}
	
	// Event Listener on Button[#btnAtras].onAction
	@FXML
	public void paginaAnterior(ActionEvent event) {
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
			
			System.out.printf("--Editar Denunciado:%n");
			ofendidoController.init(this.expediente); // Enviar expediente a la ventana OFENDIDO.
			stageOfendido.show(); // Mostrar ventana OFENDIDO.
			
			// Cierra la ventana actual: EXPEDIENTE.
			Stage stageExpediente = (Stage) this.btnSiguiente.getScene().getWindow();
			stageExpediente.close();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Event Listener on Button[#btnSiguiente].onAction
	@FXML
	public void paginaSiguiente(ActionEvent event) {
		
		// Modificar Atributo de Número de expediente y Fecha de Creacion.
		this.expediente.setIdExpediente();
		this.expediente.setFechaExpediente(this.fechaExpediente);
		System.out.printf("No. de expediente: %s.%n", this.expediente.getIdExpediente());
		System.out.printf("Fecha de Creación: %s.%n", this.expediente.getFechaExpediente().getFechaCompleta());			
		
		// Abre la ventana siguiente: OFENDIDO.
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("resultado.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stageResultado = new Stage();
			stageResultado.initModality(Modality.APPLICATION_MODAL);
			stageResultado.setTitle("RESULTADO");
			stageResultado.setScene(scene);
			resultadoController resultadoController = loader.getController();
			
			resultadoController.init(this.expediente); // Enviar expediente a la ventana RESULTADO.
			stageResultado.show(); // Mostrar ventana RESULTADO.
			
			// Cierra la ventana actual: EXPEDIENTE.
			Stage stageExpediente = (Stage) this.btnSiguiente.getScene().getWindow();
			stageExpediente.close();			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void init(Expediente expediente) {
		this.expediente = expediente;
		this.fechaExpediente = expediente.getFechaExpediente();
		
		// Cuando carga EXPEDIENTE desde el OFENDIDO deja las casillas en blanco.
		txtIdExp.setText(String.valueOf(this.expediente.getIdExpediente()+1));
		
		// Establecer una fecha específica (YY/MM/DD)
        this.año = this.expediente.getFechaExpediente().getAño();
        this.mes = this.expediente.getFechaExpediente().getMes();
        this.dia = this.expediente.getFechaExpediente().getDia();
        LocalDate fecha = LocalDate.of(this.año, this.mes, this.dia);
        dateExpediente.setValue(fecha);
	}
}
