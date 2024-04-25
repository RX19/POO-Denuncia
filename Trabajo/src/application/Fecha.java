package application;

public class Fecha {

	// Atributos que representan los componentes de una dirección.
	int año;
	int mes;
	int dia;
	
	// Constructor para inicializar una fecha.
	public Fecha(int dia, int mes, int año) {
		this.año = año;
		this.mes = mes;
		this.dia = dia;
	}
	
	// Método getter para obtener el año de la fecha.
    public int getAño() {
        return año;
    }
    // Método setter para asignar el año de la fecha.
    public void setAño(int año) {
        this.año = año;
    }
	
    // Método getter para obtener el mes de la fecha.
    public int getMes() {
        return mes;
    }
    // Método setter para asignar el mes de la fecha.
    public void setMes(int mes) {
        this.mes = mes;
    }
    
    // Método getter para obtener el dia de la fecha.
    public int getDia() {
        return dia;
    }
    // Método setter para asignar el dia de la fecha.
    public void setDia(int dia) {
        this.dia = dia;
    }
    
    //Metodo que devuelve la fecha completa.
    public String getFechaCompleta() {
    	String fecha = String.format("%s/%s/%s", dia, mes, año);
       	return fecha;
    }
}