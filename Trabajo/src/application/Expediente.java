package application;

public class Expediente {

	// Atributos que representan los componentes de un Expedinete.
	int idExpediente;
	Fecha fechaExpediente;
	Denunciante denunciante;
	Denunciado denunciado;
	Ofendido ofendido;
	String asuntos;
	Fecha fechaAsuntos;
	
	// Constructor para inicializar un Expedinete.
	public Expediente(int idExpediente, Fecha fechaExpediente, Denunciante denunciante, Denunciado denunciado, Ofendido ofendido, String asuntos, Fecha fechaAsuntos) {
		this.idExpediente = idExpediente;
		this.fechaExpediente = fechaExpediente;
        this.denunciante = denunciante;
        this.denunciado = denunciado;
        this.ofendido = ofendido;
        this.asuntos = asuntos;
        this.fechaAsuntos = fechaAsuntos;
	}
	
	// Método getter para obtener el id del expediente.
	public int getIdExpediente() {
        return idExpediente;
    }
	// Método setter para asignar el id del expediente.
    public void setIdExpediente() {
    	//Sirve para simular el autonumerado.
    	this.idExpediente += 1;
    }
    
    // Método getter para obtener la fecha de la creacion del expediente.
    public Fecha getFechaExpediente() {
        return fechaExpediente;
    }
    // Método setter para asignar la fecha de la creacion del expediente.
    public void setFechaExpediente(Fecha fechaExpediente) {
        this.fechaExpediente = fechaExpediente;
    }

    // Método getter para obtener el Denunciante del expediente.
    public Denunciante getDenunciante() {
        return denunciante;
    }
    // Método setter para asignar el Denunciante del expediente.
    public void setDenunciante(Denunciante denunciante) {
        this.denunciante = denunciante;
    }

    // Método getter para obtener el Denunciado del expediente.
    public Denunciado getDenunciado() {
        return denunciado;
    }
    // Método setter para asignar el Denunciado del expediente.
    public void setDenunciado(Denunciado denunciado) {
        this.denunciado = denunciado;
    }

    // Método getter para obtener el Ofendido del expediente.
    public Ofendido getOfendido() {
        return ofendido;
    }
    // Método setter para asignar el Ofendido del expediente.
    public void setOfendido(Ofendido ofendido) {
        this.ofendido = ofendido;
    }

    // Método getter para obtener los asuntos en el expediente.
    public String getAsuntos() {
        return asuntos;
    }
    // Método setter para asignar los asuntos en el expediente.
    public void setAsuntos(String asuntos) {
        this.asuntos = asuntos;
    }

    // Método getter para obtener la fecha de los asuntos en el expediente.
    public Fecha getFechaAsuntos() {
        return fechaAsuntos;
    }
    // Método setter para asignar la fecha de los asuntos en el expediente.
    public void setFechaAsuntos(Fecha fechaAsuntos) {
        this.fechaAsuntos = fechaAsuntos;
    }
}