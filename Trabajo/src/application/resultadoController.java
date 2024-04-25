package application;

import javafx.fxml.FXML;

import javafx.scene.control.Label;

public class resultadoController {
	@FXML
	private Label lblResultado;
	
	Expediente expediente;

	public void init(Expediente expediente) {
		this.expediente = expediente;
		
		String numExp = String.format("Número de Expediente: %s.%n", this.expediente.getIdExpediente());
		String fechaCreacion = String.format("Fecha de Creación: %s.%n%n", this.expediente.getFechaDenuncia().getFechaCompleta());
		
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
		String fechaHechos = String.format("Fecha de los Hechos: %s.%n%n", this.expediente.fechaAsunto.getFechaCompleta());
		
		String resultado = numExp + fechaCreacion;
		resultado += denuncianteNombre + denuncianteId + denuncianteEdadSexo + denuncianteDireccion;
		resultado += denunciadoNombre + denunciadoId + denunciadoEdadSexo + denunciadoDireccion;
		resultado += ofendidoNombre + ofendidoId + ofendidoEdadSexo + ofendidoDireccion;
		resultado += hechos + fechaHechos;		
		
		lblResultado.setText(resultado);
		
		System.out.println("--Fin del Programa--");
		
	}

}
