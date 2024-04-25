package application;

public class Persona {

	// Atributos que representan los componentes de una persona.
	String fNm;
	String sNm;
	int id;
	int edad;
	int sexo;
	Direccion direccion;
	
	// Constructor para inicializar una persona.
	public Persona(String fNm, String sNm, int id, int edad, int sexo, String departamento, String municipio, String aldea, String barrio, String colonia, String calle, String bloque, String codPostal, String referencia) {
		this.fNm = fNm;
		this.sNm = sNm;
		this.id = id;
		this.edad = edad;
		this.sexo = sexo;
		this.direccion = new Direccion(departamento, municipio, aldea, barrio, colonia, calle, bloque, codPostal, referencia); //Instancia de una dirección.
	}
	
	// Método getter para obtener los nombres de la persona.
    public String getfNm() {
        return fNm;
    }
    // Método setter para asignar los nombres de la persona.
    public void setfNm(String fNm) {
        this.fNm = fNm;
    }

    // Método getter para obtener los apellidos de la persona.
    public String getsNm() {
        return sNm;
    }
    // Método setter para asignar los apellidos de la persona.
    public void setsNm(String sNm) {
        this.sNm = sNm;
    }

    // Método getter para obtener el número de identidad de la persona.
    public int getId() {
        return id;
    }
    // Método setter para asignar el número de identidad de la persona.
    public void setId(int id) {
        this.id = id;
    }

    // Método getter para obtener la edad de la persona.
    public int getEdad() {
        return edad;
    }
    // Método setter para asignar la edad de la persona.
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método getter para obtener el sexo de la persona.
    public String getSexo() {
        String sexotext = "";
    	if (sexo == 1) {
        	sexotext = "Masculino";
        } 
    	if (sexo == 2) {
        	sexotext = "Femenino";
        } 
    	if (sexo == 3) {
        	sexotext = "Otro";
        }
    	return sexotext;
    }
    // Método setter para asignar el sexo de la persona.
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    // Método getter para obtener la dirección de la persona.
    public Direccion getDireccion() {
        return direccion;
    }
    // Método setter para asignar la dirección de la persona.
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
}