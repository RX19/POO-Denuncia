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

public class denunciadoController {
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
	int id, edad, sexo;
	
	// Event Listener on Button[#btnAtras].onAction
	@FXML
	public void paginaAnterior(ActionEvent event) {
		
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
			
			System.out.printf("--Editar Denunciante:%n");
			denuncianteController.init(this.expediente); // Enviar denunciante a la ventana DENUNCIANTE.
			stageDenunciante.show(); // Mostrar ventana DENUNCIANTE.
			
			// Cierra la ventana actual: DENUNCIADO.
			Stage stageDenunciado = (Stage) this.btnSiguiente.getScene().getWindow();
			stageDenunciado.close();			
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
		if (fNm.isEmpty() || sNm.isEmpty() || idtext.isEmpty() || edadtext.isEmpty() || sexo == 0 || departamento.isEmpty() || municipio.isEmpty() || referencia.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Debe llenar los campos obligatorios (*).");
			alert.showAndWait();
		} else {
			//Verificar si los campos id y edad solo contienen numeros.
			if (idtext.matches("\\d+") && edadtext.matches("\\d+")) {
				id = Integer.parseInt(idtext);
				edad = Integer.parseInt(edadtext);
				
				// Modificar instancia de Denunciado.
				this.expediente.getDenunciado().setfNm(fNm);
				this.expediente.getDenunciado().setsNm(sNm);
				this.expediente.getDenunciado().setId(id);
				this.expediente.getDenunciado().setEdad(edad);
				this.expediente.getDenunciado().setSexo(sexo);
				this.expediente.getDenunciado().getDireccion().setDepartamento(departamento);
				this.expediente.getDenunciado().getDireccion().setMunicipio(municipio);
				this.expediente.getDenunciado().getDireccion().setAldea(aldea);
				this.expediente.getDenunciado().getDireccion().setBarrio(barrio);
				this.expediente.getDenunciado().getDireccion().setColonia(colonia);
				this.expediente.getDenunciado().getDireccion().setCalle(calle);
				this.expediente.getDenunciado().getDireccion().setBloque(bloque);
				this.expediente.getDenunciado().getDireccion().setCodPostal(codPostal);
				this.expediente.getDenunciado().getDireccion().setReferencia(referencia);
				System.out.printf("Nombre: %s %s.%n", this.expediente.getDenunciado().getfNm(), this.expediente.getDenunciado().getsNm());
				System.out.printf("Identidad: %s.%n", this.expediente.getDenunciado().getId());
				System.out.printf("Edad: %s Sexo: %s.%n", this.expediente.getDenunciado().getEdad(), this.expediente.getDenunciado().getSexo());
				System.out.printf("Direccion: %s.%n%n", this.expediente.getDenunciado().getDireccion().getDireccionCompleta());
				
				
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
					
					System.out.printf("--Nuevos Asuntos:%n");
					asuntoController.init(this.expediente); // Enviar expediente a la ventana ASUNTO.
					stageAsunto.show(); // Mostrar ventana ASUNTO.
					
					// Cierra la ventana actual: DENUNCIADO.
					Stage stageDenunciado = (Stage) this.btnSiguiente.getScene().getWindow();
					stageDenunciado.close();			
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Tipo de datos incorrecto. Identidad y Edad deben ser números.");
				alert.showAndWait();
			}
		}
	}

	public void init(Expediente expediente) {
		this.expediente = expediente;
		
		// Cuando carga DENUNCIADO desde el DENUNCIANTE deja las casillas en blanco.
		// Pero cuando carga DENUNCIADO desde ASUNTO deja los valores escritos con anterioridad.
		txtNombres.setText(this.expediente.getDenunciado().getfNm());
		txtApellidos.setText(this.expediente.getDenunciado().getsNm());
		
		if (this.expediente.getDenunciado().getId() == 0) {
			txtIdentidad.setText("");
		} else {
			txtIdentidad.setText(String.valueOf(this.expediente.getDenunciado().getId()));
		}
		
		if (this.expediente.getDenunciado().getEdad() == 0) {
			txtEdad.setText("");
		} else {
			txtEdad.setText(String.valueOf(this.expediente.getDenunciado().getEdad()));
		}
		
		if (this.expediente.getDenunciado().getSexo().equals("Masculino")) {
		    radMasculino.setSelected(true);
		} else if (this.expediente.getDenunciado().getSexo().equals("Femenino")) {
		    radFemenino.setSelected(true);
		} else if (this.expediente.getDenunciado().getSexo().equals("Otro")) {
			radOtro.setSelected(true);
		} 
		
		txtDepartamento.setText(this.expediente.getDenunciado().getDireccion().getDepartamento());
		txtMunicipio.setText(this.expediente.getDenunciado().getDireccion().getMunicipio());
		txtAldea.setText(this.expediente.getDenunciado().getDireccion().getAldea());
		txtBarrio.setText(this.expediente.getDenunciado().getDireccion().getBarrio());
		txtColonia.setText(this.expediente.getDenunciado().getDireccion().getColonia());
		txtCalle.setText(this.expediente.getDenunciado().getDireccion().getCalle());
		txtBloque.setText(this.expediente.getDenunciado().getDireccion().getBloque());
		txtCodigoPostal.setText(this.expediente.getDenunciado().getDireccion().getCodPostal());
		txtReferencia.setText(this.expediente.getDenunciado().getDireccion().getReferencia());
	}
}