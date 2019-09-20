package EJEMPLO.Objetos;

public class Persona {

    private int cedula;
    private String primer_nombre;
    private String segundo_nombre;
    private char sexo;
    private String ciudad;
    private String pais;

    public Persona(int cedula, String primer_nombre, String segundo_nombre, char sexo, String ciudad, String pais) {
        this.cedula = cedula;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}

