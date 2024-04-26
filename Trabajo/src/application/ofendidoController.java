package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.scene.control.RadioButton;

public class ofendidoController {
	@FXML
	private TextField txtIdentidad;
	@FXML
	private TextField txtNombres;
	@FXML
	private TextField txtApellidos;
	@FXML
	private TextField txtEdad;
	@FXML
	private RadioButton radMasculino;
	@FXML
	private RadioButton radFemenino;
	@FXML
	private RadioButton radOtro;
	@FXML
	private TextField txtDepartamento;
	@FXML
	private TextField txtMunicipio;
	@FXML
	private TextField txtAldea;
	@FXML
	private TextField txtBarrio;
	@FXML
	private TextField txtColonia;
	@FXML
	private TextField txtCalle;
	@FXML
	private TextField txtBloque;
	@FXML
	private TextField txtCodigoPostal;
	@FXML
	private TextField txtReferencia;
	@FXML
	private Button btnAtras;
	@FXML
	private Button btnSiguiente;

	// Variables globales.
	Expediente expediente;
	String fNm, sNm, idtext, edadtext, departamento, municipio, aldea, barrio, colonia, calle, bloque, codPostal, referencia;
	int edad, sexo;
	long id;
	boolean seguirId = true;
	boolean seguirEdad = true;
	
	// Event Listener on Button[#btnAtras].onAction
	@FXML
	public void paginaAnterior(ActionEvent event) {
		// Abre la ventana siguiente: ASUNTO.
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("asunto.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stageAsunto = new Stage();
			stageAsunto.initModality(Modality.APPLICATION_MODAL);
			stageAsunto.setTitle("ASUNTO");
			stageAsunto.setScene(scene);
			asuntoController asuntoController = loader.getController();
			
			System.out.printf("--Editar Asuntos:%n");
			asuntoController.init(this.expediente); // Enviar expediente a la ventana ASUNTO.
			stageAsunto.show(); // Mostrar ventana ASUNTO.
			
			// Cierra la ventana actual: OFENDIDO.
			Stage stageOfendido = (Stage) this.btnSiguiente.getScene().getWindow();
			stageOfendido.close();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Event Listener on Button[#btnSiguiente].onAction
	@FXML
	public void paginaSiguiente(ActionEvent event) {
		
		//Obtener Valores de las cajas de texto.					
		fNm = this.txtNombres.getText();
		sNm = this.txtApellidos.getText();
		idtext = this.txtIdentidad.getText();
		edadtext = this.txtEdad.getText();
		departamento = this.txtDepartamento.getText();
		municipio = this.txtMunicipio.getText();
		aldea = this.txtAldea.getText();
		barrio = this.txtBarrio.getText();
		colonia = this.txtColonia.getText();
		calle = this.txtCalle.getText();
		bloque = this.txtBloque.getText();
		codPostal = this.txtCodigoPostal.getText();
		referencia = this.txtReferencia.getText();

		//Validar valor de sexo.
		if (this.radMasculino.isSelected()) {
			sexo = 1;
		} else if (this.radFemenino.isSelected()) {
			sexo = 2;
		} else if (this.radOtro.isSelected()) {
			sexo = 3;
		} else {
			sexo = 0;
		}
		
		//Verifica si los campos obligatorios no estan vacios.
		if (sexo == 0 || departamento.isEmpty() || municipio.isEmpty() || referencia.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Debe llenar los campos obligatorios (*).");
			alert.showAndWait();
		} else {
			//Verifica si el campo id esta vacio y si solo contiene numeros.
			if (idtext.isEmpty()) {
				id = 0;
			} else if (idtext.matches("\\d+")) {
				id = Long.parseLong(idtext);
			} else {
				this.seguirId = false;
			}
			
			//Verifica si el campo edad esta vacio y si solo contiene numeros.
			if (edadtext.isEmpty()) {
				edad = 0;
			} else if (edadtext.matches("\\d+")) {
				edad = Integer.parseInt(edadtext);
			} else {
				this.seguirEdad = false;
			}
			
			//Verificar si los campos id y edad estan llens y solo contienen numeros.
			if (this.seguirId && this.seguirEdad) {
				// Modificar instancia de Ofendido.
				this.expediente.getOfendido().setfNm(fNm);
				this.expediente.getOfendido().setsNm(sNm);
				this.expediente.getOfendido().setId(id);
				this.expediente.getOfendido().setEdad(edad);
				this.expediente.getOfendido().setSexo(sexo);
				this.expediente.getOfendido().getDireccion().setDepartamento(departamento);
				this.expediente.getOfendido().getDireccion().setMunicipio(municipio);
				this.expediente.getOfendido().getDireccion().setAldea(aldea);
				this.expediente.getOfendido().getDireccion().setBarrio(barrio);
				this.expediente.getOfendido().getDireccion().setColonia(colonia);
				this.expediente.getOfendido().getDireccion().setCalle(calle);
				this.expediente.getOfendido().getDireccion().setBloque(bloque);
				this.expediente.getOfendido().getDireccion().setCodPostal(codPostal);
				this.expediente.getOfendido().getDireccion().setReferencia(referencia);
				System.out.printf("Nombre: %s %s.%n", this.expediente.getOfendido().getfNm(), this.expediente.getOfendido().getsNm());
				System.out.printf("Identidad: %s.%n", this.expediente.getOfendido().getId());
				System.out.printf("Edad: %s Sexo: %s.%n", this.expediente.getOfendido().getEdad(), this.expediente.getOfendido().getSexo());
				System.out.printf("Direccion: %s.%n%n", this.expediente.getOfendido().getDireccion().getDireccionCompleta());
				
				
				// Abre la ventana siguiente: ASUNTO.
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("expediente.fxml"));
					Parent root = loader.load();
					Scene scene = new Scene(root);
					Stage stageExpediente = new Stage();
					stageExpediente.initModality(Modality.APPLICATION_MODAL);
					stageExpediente.setTitle("EXPEDIENTE");
					stageExpediente.setScene(scene);
					expedienteController expedienteController = loader.getController();
					
					System.out.printf("--Nuevo Expediente:%n");
					expedienteController.init(this.expediente); // Enviar expediente a la ventana EXPEDIENTE.
					stageExpediente.show(); // Mostrar ventana EXPEDIENTE.
					
					// Cierra la ventana actual: OFENDIDO.
					Stage stageOfendido = (Stage) this.btnSiguiente.getScene().getWindow();
					stageOfendido.close();			
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Tipo de datos incorrecto. Identidad y Edad deben ser números.");
				alert.showAndWait();
				this.txtIdentidad.setText("");
				this.txtEdad.setText("");
				this.seguirId = true;
				this.seguirEdad = true;
			}
		}
	}
	
	public void init(Expediente expediente) {
		this.expediente = expediente;
		
		// Cuando carga OFENDIDO desde el ASUNTO deja las casillas en blanco.
		// Pero cuando carga OFENDIDO desde EXPEDIENTE deja los valores escritos con anterioridad.
		txtNombres.setText(this.expediente.getOfendido().getfNm());
		txtApellidos.setText(this.expediente.getOfendido().getsNm());
		
		if (this.expediente.getOfendido().getId() == 0) {
			txtIdentidad.setText("");
		} else {
			txtIdentidad.setText(String.valueOf(this.expediente.getOfendido().getId()));
		}
		
		if (this.expediente.getOfendido().getEdad() == 0) {
			txtEdad.setText("");
		} else {
			txtEdad.setText(String.valueOf(this.expediente.getOfendido().getEdad()));
		}
		
		if (this.expediente.getOfendido().getSexo().equals("Masculino")) {
		    radMasculino.setSelected(true);
		} else if (this.expediente.getOfendido().getSexo().equals("Femenino")) {
		    radFemenino.setSelected(true);
		} else if (this.expediente.getOfendido().getSexo().equals("Otro")) {
			radOtro.setSelected(true);
		} 
		
		txtDepartamento.setText(this.expediente.getOfendido().getDireccion().getDepartamento());
		txtMunicipio.setText(this.expediente.getOfendido().getDireccion().getMunicipio());
		txtAldea.setText(this.expediente.getOfendido().getDireccion().getAldea());
		txtBarrio.setText(this.expediente.getOfendido().getDireccion().getBarrio());
		txtColonia.setText(this.expediente.getOfendido().getDireccion().getColonia());
		txtCalle.setText(this.expediente.getOfendido().getDireccion().getCalle());
		txtBloque.setText(this.expediente.getOfendido().getDireccion().getBloque());
		txtCodigoPostal.setText(this.expediente.getOfendido().getDireccion().getCodPostal());
		txtReferencia.setText(this.expediente.getOfendido().getDireccion().getReferencia());
	}
}
