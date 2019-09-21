package EJEMPLO_2.Objetos;

public class Paises {

    // Propiedades
    private int id;
    private String nombrePais;

    public Paises(int id, String nombrePais) {
        this.id = id;
        this.nombrePais = nombrePais;
    }

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



