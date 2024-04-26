package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class resultadoController {
	@FXML
	private Label lblResultado;
	@FXML
	private Button btnOk;

	// Variables globales.
	Expediente expediente;
	int dbNumExp;
	String dbFechaExp;
	String dbDenunciante;
	String dbDenunciado;
	String dbOfendido;
	String dbAsuntos;
	String dbFechaAsuntos;
	
	// Event Listener on Button[#btnOk].onAction
	@FXML
	public void regresarInicio(ActionEvent event) {
		// Abre la ventana siguiente: MENU PRINCIPAL.
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("menuPrincipal.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stageMenuPrincipal = new Stage();
			stageMenuPrincipal.initModality(Modality.APPLICATION_MODAL);
			stageMenuPrincipal.setTitle("MENU PRINCIPAL");
			stageMenuPrincipal.setScene(scene);
			menuPrincipalController menuPrincipalController = loader.getController();
			menuPrincipalController.init(this.expediente); // Enviar expediente a la ventana Menu Principal.
			
			//Mandar datos a la Base de datos.
			JavaPostgreSql.writeToDatabase(this.dbNumExp, this.dbFechaExp, this.dbDenunciante, this.dbDenunciado, this.dbOfendido, this.dbAsuntos, this.dbFechaAsuntos);
			
			stageMenuPrincipal.show(); // Mostrar ventana Menu Principal.
			
			// Cierra la ventana actual: RESULTADO.
			Stage stageDenunciante = (Stage) this.btnOk.getScene().getWindow();
			stageDenunciante.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init(Expediente expediente) {
		this.expediente = expediente;
		
		String numExp = String.format("Número de Expediente: %s.%n", this.expediente.getIdExpediente());
		String fechaCreacion = String.format("Fecha de Creación: %s.%n%n", this.expediente.getFechaExpediente().getFechaCompleta());
		
		String denuncianteNombre = String.format("Denunciante:%nNombre: %s %s%n", this.expediente.getDenunciante().getfNm(), this.expediente.getDenunciante().getsNm());
		String denuncianteId = String.format("No. Identidad: %s%n", this.expediente.getDenunciante().getId());
		String denuncianteEdadSexo = String.format("Edad: %s Sexo: %s%n", this.expediente.getDenunciante().getEdad(), this.expediente.getDenunciante().getSexo());
		String denuncianteDireccion = String.format("Dirección: %s%n%n", this.expediente.getDenunciante().getDireccion().getDireccionCompleta());
		
		String denunciadoNombre = String.format("Denunciado:%nNombre: %s %s%n", this.expediente.getDenunciado().getfNm(), this.expediente.getDenunciado().getsNm());
		String denunciadoId = String.format("No. Identidad: %s%n", this.expediente.getDenunciado().getId());
		String denunciadoEdadSexo = String.format("Edad: %s Sexo: %s%n", this.expediente.getDenunciado().getEdad(), this.expediente.getDenunciado().getSexo());
		String denunciadoDireccion = String.format("Dirección: %s%n%n", this.expediente.getDenunciado().getDireccion().getDireccionCompleta());
		
		String ofendidoNombre = String.format("Ofendido:%nNombre: %s %s%n", this.expediente.getOfendido().getfNm(), this.expediente.getOfendido().getsNm());
		String ofendidoId = String.format("No. Identidad: %s%n", this.expediente.getOfendido().getId());
		String ofendidoEdadSexo = String.format("Edad: %s Sexo: %s%n", this.expediente.getOfendido().getEdad(), this.expediente.getOfendido().getSexo());
		String ofendidoDireccion = String.format("Dirección: %s%n%n", this.expediente.getOfendido().getDireccion().getDireccionCompleta());
		
		String hechos = String.format("Hechos: %n%s%n", this.expediente.getAsuntos());
		String fechaHechos = String.format("Fecha de los Hechos: %s.%n%n", this.expediente.fechaAsuntos.getFechaCompleta());
		
		String resultado = numExp + fechaCreacion;
		resultado += denuncianteNombre + denuncianteId + denuncianteEdadSexo + denuncianteDireccion;
		resultado += denunciadoNombre + denunciadoId + denunciadoEdadSexo + denunciadoDireccion;
		resultado += ofendidoNombre + ofendidoId + ofendidoEdadSexo + ofendidoDireccion;
		resultado += hechos + fechaHechos;		
		
		lblResultado.setText(resultado);
		
		System.out.println("--Fin del Programa--");
		
		//Valores para la base de datos.
		this.dbNumExp = this.expediente.getIdExpediente();
		this.dbFechaExp = this.expediente.getFechaExpediente().getFechaCompleta();
		this.dbDenunciante = this.expediente.getDenunciante().getfNm() + " " + this.expediente.getDenunciante().getsNm();
		this.dbDenunciado = this.expediente.getDenunciado().getfNm() + " " + this.expediente.getDenunciado().getsNm();
		this.dbOfendido = this.expediente.getOfendido().getfNm() + " " + this.expediente.getOfendido().getsNm();
		this.dbAsuntos = this.expediente.getAsuntos();
		this.dbFechaAsuntos = this.expediente.getFechaAsuntos().getFechaCompleta();
	}
}
