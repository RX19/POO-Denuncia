import java.time.LocalDate;
import java.util.ArrayList;

class Expediente {
    private static int nextId = 1;
    private int idExp;
    private String denunciante;
    private String denunciado;
    private String ofendido;
    private String desHechos;
    private LocalDate fechaDenuncia;
    private LocalDate fechaSucesos;

    public Expediente(String denunciante, String denunciado, String ofendido, String desHechos) {
        this.idExp = nextId++;
        this.denunciante = denunciante;
        this.denunciado = denunciado;
        this.ofendido = ofendido;
        this.desHechos = desHechos;
        this.fechaDenuncia = LocalDate.now();
    }

    public void setFechaSucesos(int dia, int mes, int anio) {
        this.fechaSucesos = LocalDate.of(anio, mes, dia);
    }

    public int getIdExp() {
        return idExp;
    }

    public String getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(String denunciante) {
        this.denunciante = denunciante;
    }

    public String getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(String denunciado) {
        this.denunciado = denunciado;
    }

    public String getOfendido() {
        return ofendido;
    }

    public void setOfendido(String ofendido) {
        this.ofendido = ofendido;
    }

    public String getDesHechos() {
        return desHechos;
    }

    public void setDesHechos(String desHechos) {
        this.desHechos = desHechos;
    }

    public LocalDate getFechaDenuncia() {
        return fechaDenuncia;
    }

    public LocalDate getFechaSucesos() {
        return fechaSucesos;
    }
}

class Persona {
    private String fNm, sNm;
    private boolean sexo;
    private Direccion direccion;
    private ArrayList<String> delitosCometidos;
    private ArrayList<String> delitosAsociados;
    

    public Persona(String fNm, String sNm, boolean sexo, Direccion direccion) {
        this.fNm = fNm;
        this.sNm = sNm;
        this.sexo = sexo;
        this.direccion = direccion;
        this.delitosCometidos = new ArrayList<>();
        this.delitosAsociados = new ArrayList<>();
    }

    public String getfNm() {
        return fNm;
    }

    public String getsNm() {
        return sNm;
    }

    public boolean getSex() {
        return sexo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public ArrayList<String> getDelitosCometidos() {
        return delitosCometidos;
    }

    public ArrayList<String> getDelitosAsociados() {
        return delitosAsociados;
    }

    public void setfNm(String fNm) {
        this.fNm = fNm;
    }

    public void setsNm(String sNm) {
        this.sNm = sNm;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void addDelitoCometido(String delito) {
        this.delitosCometidos.add(delito);
    }

    public void addDelitoAsociado(String delito) {
        this.delitosAsociados.add(delito);
    }
}

class Direccion {
    private String departamento, municipio, aldea, barrio, colonia, calle, bloque, referencia;
    private int codPost;

    public Direccion(String departamento, String municipio, String aldea, String barrio, String colonia, String calle, String bloque, int codPost, String referencia) {
        this.departamento = departamento;
        this.municipio = municipio;
        this.aldea = aldea;
        this.barrio = barrio;
        this.colonia = colonia;
        this.calle = calle;
        this.bloque = bloque;
        this.codPost = codPost;
        this.referencia = referencia;        
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getAldea() {
        return aldea;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCalle() {
        return calle;
    }

    public String getBloque() {
        return bloque;
    }

    public int getCodPost() {
        return codPost;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public void setCodPost(int codPost) {
        this.codPost = codPost;
    }

    public void setReferencia(String referencia) {  
        this.referencia = referencia;
    }
}

public class Main {
    public static void main(String[] args) {
        //Instance Direccion for each Persona
        //Direccion dir = new Direccion(Depto, Municipio, Aldea, Barrio, Colonia, Calle, Bloque, CPost, Referencia);
        Direccion dir = new Direccion("Comayagua", "Comayagua", "Lamani", "San Juan", "Olvidada", "Tierrosa", "Quinto", 33166, "Enfrente de carniceria el ToroLoco");
        Direccion dir1 = new Direccion("Francisco Morazan", "Tegucigalpa", "Inventada", "San Pedro", "Olvidada", "Con baches", "Dos", 23100, "Enfrente de la taberna el bolo ciego");
        Direccion dir2 = new Direccion("Francisco Morazan", "Tegucigalpa", "Creada", "San Lucas", "Nueva", "Con baches", "Dos", 11550, "Enfrente de donde Juanito el zapatero");
    
        //Instance Persona
        //Persona example = new Persona("firstName", "secondName", 0/Woman - 1/Man, dir)
        Persona denunciante = new Persona("Juan", "Perez", true, dir);
        Persona denunciado = new Persona("Luis", "Lopez", true, dir1);
        Persona ofendido = new Persona("Maria", "Gomez", false, dir2);
        
        //addDelitoCometido and addDelitoAsociado
        denunciado.addDelitoCometido("Robo");
        denunciado.addDelitoAsociado("Asalto");

        //addDelitoCometido and addDelitoAsociado
        //ofendido.addDelitoCometido("Acoso");
        ofendido.addDelitoAsociado("Robo");
    
        //Instance of Expediente
        //Expediente expediente = new Expediente(denunciante.getfNm(), denunciado.getfNm(), ofendido.getfNm(), descHechos) and fechaSucesos
        Expediente expediente = new Expediente(denunciante.getfNm(), denunciado.getfNm(), ofendido.getfNm(), "Hechos impactante, un tiroteo y un asalto, un herido por un carnicero");
        expediente.setFechaSucesos(15, 4, 2024);

        System.out.println("Expediente ID: " + expediente.getIdExp());
        System.out.println("Denunciante: " + expediente.getDenunciante());
        System.out.println("Denunciado: " + expediente.getDenunciado());
        System.out.println("Ofendido: " + expediente.getOfendido());
        System.out.println("Hechos: " + expediente.getDesHechos());
        System.out.println("Fecha de denuncia: " + expediente.getFechaDenuncia());
        System.out.println("Fecha de sucesos: " + expediente.getFechaSucesos());

        System.out.println("\nDelitos cometidos por denunciado:");
        for (String delito : denunciado.getDelitosCometidos()) {
            System.out.println("- " + delito);
        }

        System.out.println("\nDelitos asociados a denunciado:");
        for (String delito : denunciado.getDelitosAsociados()) {
            System.out.println("- " + delito);
        }

        System.out.println("\nDelitos cometidos por ofendido:");
        for (String delito : ofendido.getDelitosCometidos()) {
            System.out.println("- " + delito);
        }

        System.out.println("\nDelitos asociados a ofendido:");
        for (String delito : ofendido.getDelitosAsociados()) {
            System.out.println("- " + delito);
        }
    }
}

