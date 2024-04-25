package application;

public class Expediente {

	// Atributos que representan los componentes de una persona denunciante.
	int idExpediente;
	Denunciante denunciante;
	Denunciado denunciado;
	Ofendido ofendido;
	String asuntos;
	Fecha fechaDenuncia;
	Fecha fechaAsunto;
	
	// Constructor para inicializar una persona denunciante.
	public Expediente(int idExpediente, Denunciante denunciante, Denunciado denunciado, Ofendido ofendido, String asuntos, Fecha fechaAsunto, Fecha fechaDenuncia) {
		this.idExpediente = idExpediente;
        this.denunciante = denunciante;
        this.denunciado = denunciado;
        this.ofendido = ofendido;
        this.asuntos = asuntos;
        this.fechaAsunto = fechaAsunto;
        this.fechaDenuncia = fechaDenuncia;
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
    public Fecha getFechaAsunto() {
        return fechaAsunto;
    }
    // Método setter para asignar la fecha de los asuntos en el expediente.
    public void setFechaAsunto(Fecha fechaAsunto) {
        this.fechaAsunto = fechaAsunto;
    }

    // Método getter para obtener la fecha de la creacion del expediente.
    public Fecha getFechaDenuncia() {
        return fechaDenuncia;
    }
    // Método setter para asignar la fecha de la creacion del expediente.
    public void setFechaDenuncia(Fecha fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }
}