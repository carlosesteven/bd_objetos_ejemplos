public class Persona {

    private int cedula;
    private String primer_nombre;
    private String segundo_nombre;
    private String ciudad;
    private String pais;

    public Persona(int cedula, String primero_nombre, String segundo_nombre, String ciudad, String pais) {
        this.cedula = cedula;
        this.primer_nombre = primero_nombre;
        this.segundo_nombre = segundo_nombre;
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

}

