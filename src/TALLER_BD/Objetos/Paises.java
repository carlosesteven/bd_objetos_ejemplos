package TALLER_BD.Objetos;

public class Paises {

    // Propiedades
    private int id;
    private String nombrePais;

    //Contructores
    public Paises() {
    }

    public Paises(int id, String nombrePais) {
        this.id = id;
        this.nombrePais = nombrePais;
    }

    //Metodos Getter y Setter
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @Override
    public String toString() {
        return nombrePais;
    }
}

