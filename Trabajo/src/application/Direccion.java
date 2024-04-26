package application;

public class Direccion {

	// Atributos que representan los componentes de una dirección.
	String departamento;
	String municipio;
	String aldea;
	String barrio;
	String colonia;
	String calle;
	String bloque;
	String codPostal;
	String referencia;
	
	// Constructor para inicializar una dirección.
	public Direccion(String departamento, String municipio, String aldea, String barrio, String colonia, String calle, String bloque, String codPostal, String referencia) {
		this.departamento = departamento;
		this.municipio = municipio;
		this.aldea = aldea;
		this.barrio = barrio;
		this.colonia = colonia;
		this.calle = calle;
		this.bloque = bloque;
		this.codPostal = codPostal;
		this.referencia = referencia;
	}
	
	// Método getter para obtener el departamento de la dirección.
    public String getDepartamento() {
        return departamento;
    }
    // Método setter para asignar el departamento de la dirección.
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
	
    // Método getter para obtener el municipio de la dirección.
    public String getMunicipio() {
        return municipio;
    }
    // Método setter para asignar el municipio de la dirección.
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
 
    // Método getter para obtener la aldea de la dirección.
    public String getAldea() {
        return aldea;
    }
    // Método setter para asignar la aldea de la dirección.
    public void setAldea(String aldea) {
        this.aldea = aldea;
    }
    
    // Método getter para obtener el barrio de la dirección.
    public String getBarrio() {
        return barrio;
    }
    // Método setter para asignar el barrio de la dirección.
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    
    // Método getter para obtener la colonia de la dirección.
    public String getColonia() {
        return colonia;
    }
    // Método setter para asignar la colonia de la dirección.
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
    // Método getter para obtener la calle de la dirección.
    public String getCalle() {
        return calle;
    }
    // Método setter para asignar la calle de la dirección.
    public void setCalle(String calle) {
        this.calle = calle;
    }
 
    // Método getter para obtener el bloque de la dirección.
    public String getBloque() {
        return bloque;
    }
    // Método setter para asignar el bloque de la dirección.
    public void setBloque(String bloque) {
        this.bloque = bloque;
    }
    
    // Método getter para obtener el código postal de la dirección.
    public String getCodPostal() {
        return codPostal;
    }
    // Método setter para asignar el código postal de la dirección.
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }
    
    // Método getter para obtener la referencia de la dirección.
    public String getReferencia() {
        return referencia;
    }
    // Método setter para asignar la referencia de la dirección.
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    //Metodo que devuelve la direccion completa.
    public String getDireccionCompleta() {
    	String direccion = String.format("%s, %s, ", departamento, municipio);
    	
    	if (!aldea.isEmpty()) {
    	    direccion += aldea + ", ";
    	}
    	if (!barrio.isEmpty()) {
    	    direccion += barrio + ", ";
    	}
    	if (!colonia.isEmpty()) {
    	    direccion += colonia + ", ";
    	}
    	if (!calle.isEmpty()) {
    	    direccion += calle + ", ";
    	}
    	if (!bloque.isEmpty()) {
    	    direccion += bloque + ", ";
    	}
    	if (!codPostal.isEmpty()) {
    	    direccion += codPostal + ", ";
    	}
    	
    	direccion += referencia; 
    	return direccion;
    }

}