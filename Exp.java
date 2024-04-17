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
    private String fNm;
    private String sNm;
    private boolean sexo;
    private Direccion direccion;

    public Persona(String fNm, String sNm, boolean sexo, Direccion direccion) {
        this.fNm = fNm;
        this.sNm = sNm;
        this.sexo = sexo;
        this.direccion = direccion;
    }

    // Getters and setters for Persona class
    public String getfNm() {
        return fNm;
    }

    public void setfNm(String fNm) {
        this.fNm = fNm;
    }

    public String getsNm() {
        return sNm;
    }

    public void setsNm(String sNm) {
        this.sNm = sNm;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}

class Denunciado extends Persona {
    private ArrayList<String> delitosCometidos;
    private ArrayList<String> delitosAsociados;

    public Denunciado(String fNm, String sNm, boolean sexo, Direccion direccion) {
        super(fNm, sNm, sexo, direccion);
        this.delitosCometidos = new ArrayList<>();
        this.delitosAsociados = new ArrayList<>();
    }

    // Getters and setters for Denunciado class
    public ArrayList<String> getDelitosCometidos() {
        return delitosCometidos;
    }

    public void addDelitoCometido(String delito) {
        this.delitosCometidos.add(delito);
    }

    public ArrayList<String> getDelitosAsociados() {
        return delitosAsociados;
    }

    public void addDelitoAsociado(String delito) {
        this.delitosAsociados.add(delito);
    }
}

class Ofendido extends Persona {
    private ArrayList<String> delitosCometidos;
    private ArrayList<String> delitosAsociados;

    public Ofendido(String fNm, String sNm, boolean sexo, Direccion direccion) {
        super(fNm, sNm, sexo, direccion);
        this.delitosCometidos = new ArrayList<>();
        this.delitosAsociados = new ArrayList<>();
    }

    // Get n Set for Ofendido
    public ArrayList<String> getDelitosCometidos() {
        return delitosCometidos;
    }

    public void addDelitoCometido(String delito) {
        this.delitosCometidos.add(delito);
    }

    public ArrayList<String> getDelitosAsociados() {
        return delitosAsociados;
    }

    public void addDelitoAsociado(String delito) {
        this.delitosAsociados.add(delito);
    }
}

class Direccion {
    private String departamento;
    private String municipio;
    private String referencia;

    public Direccion(String departamento, String municipio, String referencia) {
        this.departamento = departamento;
        this.municipio = municipio;
        this.referencia = referencia;
    }

    // Getters and setters for Direccion class
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}

public class Main {
    public static void main(String[] args) {
        Direccion dir = new Direccion("Tegucigalpa", "Colonia Kennedy", "Calle 123");

        Persona denunciante = new Persona("Juan", "Perez", true, dir);
        Persona denunciado = new Persona("Luis", "Lopez", false, dir);
        Persona ofendido = new Persona("Maria", "Gomez", false, dir);

        Denunciado denunciadoObj = new Denunciado("Carlos", "Lopez", false, dir);
        denunciadoObj.addDelitoCometido("Robo");
        denunciadoObj.addDelitoAsociado("Asalto");

        Ofendido ofendidoObj = new Ofendido("Maria", "Gomez", false, dir);
        ofendidoObj.addDelitoCometido("Acoso");
        ofendidoObj.addDelitoAsociado("Amenazas");

        Expediente expediente = new Expediente(denunciante.getfNm(), denunciadoObj.getfNm(), ofendidoObj.getfNm(), "Hechos violentos");
        expediente.setFechaSucesos(15, 4, 2024);

        System.out.println("Expediente ID: " + expediente.getIdExp());
        System.out.println("Denunciante: " + expediente.getDenunciante());
        System.out.println("Denunciado: " + expediente.getDenunciado());
        System.out.println("Ofendido: " + expediente.getOfendido());
        System.out.println("Hechos: " + expediente.getDesHechos());
        System.out.println("Fecha de denuncia: " + expediente.getFechaDenuncia());
        System.out.println("Fecha de sucesos: " + expediente.getFechaSucesos());

        System.out.println("\nDelitos cometidos por denunciado:");
        for (String delito : denunciadoObj.getDelitosCometidos()) {
            System.out.println("- " + delito);
        }

        System.out.println("\nDelitos asociados a denunciado:");
        for (String delito : denunciadoObj.getDelitosAsociados()) {
            System.out.println("- " + delito);
        }

        System.out.println("\nDelitos cometidos por ofendido:");
        for (String delito : ofendidoObj.getDelitosCometidos()) {
            System.out.println("- " + delito);
        }

        System.out.println("\nDelitos asociados a ofendido:");
        for (String delito : ofendidoObj.getDelitosAsociados()) {
            System.out.println("- " + delito);
        }
    }
}

