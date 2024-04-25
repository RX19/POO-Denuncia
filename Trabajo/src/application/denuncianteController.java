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

public class denuncianteController {
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
		
		// Abre la ventana siguiente: MENU PRINCIPAL.
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("menuPrincipal.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stageMenuPrincipal = new Stage();
			stageMenuPrincipal.initModality(Modality.APPLICATION_MODAL);
			stageMenuPrincipal.setTitle("MENU PRINCIPAL");
			stageMenuPrincipal.setScene(scene);
			stageMenuPrincipal.show();
			
			// Cierra la ventana actual: DENUNCIANTE.
			Stage stageDenunciante = (Stage) this.btnAtras.getScene().getWindow();
			stageDenunciante.close();
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
				
				// Modificar instancia de denunciante.
				this.expediente.getDenunciante().setfNm(fNm);
				this.expediente.getDenunciante().setsNm(sNm);
				this.expediente.getDenunciante().setId(id);
				this.expediente.getDenunciante().setEdad(edad);
				this.expediente.getDenunciante().setSexo(sexo);
				this.expediente.getDenunciante().getDireccion().setDepartamento(departamento);
				this.expediente.getDenunciante().getDireccion().setMunicipio(municipio);
				this.expediente.getDenunciante().getDireccion().setAldea(aldea);
				this.expediente.getDenunciante().getDireccion().setBarrio(barrio);
				this.expediente.getDenunciante().getDireccion().setColonia(colonia);
				this.expediente.getDenunciante().getDireccion().setCalle(calle);
				this.expediente.getDenunciante().getDireccion().setBloque(bloque);
				this.expediente.getDenunciante().getDireccion().setCodPostal(codPostal);
				this.expediente.getDenunciante().getDireccion().setReferencia(referencia);
				System.out.printf("Nombre: %s %s.%n", this.expediente.getDenunciante().getfNm(), this.expediente.getDenunciante().getsNm());
				System.out.printf("Identidad: %s.%n", this.expediente.getDenunciante().getId());
				System.out.printf("Edad: %s Sexo: %s.%n", this.expediente.getDenunciante().getEdad(), this.expediente.getDenunciante().getSexo());
				System.out.printf("Direccion: %s.%n%n", this.expediente.getDenunciante().getDireccion().getDireccionCompleta());
				
				
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
					
					System.out.printf("--Nuevo Denunciado:%n");
					denunciadoController.init(this.expediente); // Enviar expediente a la ventana DENUNCIADO.
					stageDenunciado.show(); // Mostrar ventana DENUNCIADO.
					
					// Cierra la ventana actual: DENUNCIANTE.
					Stage stageDenunciante = (Stage) this.btnSiguiente.getScene().getWindow();
					stageDenunciante.close();			
					
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
		
		// Cuando carga DENUNCIANTE desde el MENUPRINCIPAL deja las casillas en blanco.
		// Pero cuando carga DENUNCIANTE desde DENUNCIADO deja los valores escritos con anterioridad.
		txtNombres.setText(this.expediente.getDenunciante().getfNm());
		txtApellidos.setText(this.expediente.getDenunciante().getsNm());
		
		if (this.expediente.getDenunciante().getId() == 0) {
			txtIdentidad.setText("");
		} else {
			txtIdentidad.setText(String.valueOf(this.expediente.getDenunciante().getId()));
		}
		
		if (this.expediente.getDenunciante().getEdad() == 0) {
			txtEdad.setText("");
		} else {
			txtEdad.setText(String.valueOf(this.expediente.getDenunciante().getEdad()));
		}
		
		if (this.expediente.getDenunciante().getSexo().equals("Masculino")) {
		    radMasculino.setSelected(true);
		} else if (this.expediente.getDenunciante().getSexo().equals("Femenino")) {
		    radFemenino.setSelected(true);
		} else if (this.expediente.getDenunciante().getSexo().equals("Otro")) {
			radOtro.setSelected(true);
		} 
		
		txtDepartamento.setText(this.expediente.getDenunciante().getDireccion().getDepartamento());
		txtMunicipio.setText(this.expediente.getDenunciante().getDireccion().getMunicipio());
		txtAldea.setText(this.expediente.getDenunciante().getDireccion().getAldea());
		txtBarrio.setText(this.expediente.getDenunciante().getDireccion().getBarrio());
		txtColonia.setText(this.expediente.getDenunciante().getDireccion().getColonia());
		txtCalle.setText(this.expediente.getDenunciante().getDireccion().getCalle());
		txtBloque.setText(this.expediente.getDenunciante().getDireccion().getBloque());
		txtCodigoPostal.setText(this.expediente.getDenunciante().getDireccion().getCodPostal());
		txtReferencia.setText(this.expediente.getDenunciante().getDireccion().getReferencia());
	}
}