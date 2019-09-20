package TALLER_BD;

import TALLER_BD.Objetos.Jugadores;
import TALLER_BD.Objetos.Paises;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class punto_3 {

    private static final String ODB_NAME = "BD_taller.neodatis";

    public static void main(String[] args) {
        //borrarPaisdeBD("España");
        verJugadoresPorPaisyDeporte("EEUU", "tenis");
    }

    //apartado A)
    /*Metodo que recibe el nombre de pais y un deporte y visualize los jugadores
    que son de ese pais y practican ese deporte, si no hay ninguno da un mensaje*/
    private static void verJugadoresPorPaisyDeporte(String pais, String deporte){
        ODB odb = ODBFactory.open(ODB_NAME);
        ICriterion criterio = new And().add(Where.equal("pais.nombrePais", pais))
                .add(Where.equal("deporte", deporte));

        IQuery query = new CriteriaQuery(Jugadores.class, criterio);

        Objects jugadores = odb.getObjects(query);
        if (jugadores.size() == 0) {
            System.out.println ("No existen jugadores de "+pais+" no se pueden mostrar jugadores de "+deporte);
        } else {
            Jugadores jug;
            System.out.println("JUGADORES DE "+pais+" QUE JUEGAN AL "+deporte);
            while (jugadores.hasNext()) {
                jug = (Jugadores) jugadores.next();
                System.out.println("Nombre: "+jug.getNombre()+" Edad: "+ jug.getEdad());
            }
        }
        odb.close();
    }

    //apartado B
    /*Metodo que reciba un pais y lo borre de la BD Neodatis, comprueba si tiene
    jugadores si tiene jugadores asigna null al pais de esos jugadores*/
    private static void borrarPaisdeBD(String pais){
        ODB odb = ODBFactory.open(ODB_NAME);
        IQuery query = new CriteriaQuery(Paises.class, Where.equal ("nombrePais", pais));
        Objects  objetosPais = odb.getObjects (query);

        //Obtiene solo el primer objeto Pais encontrado
        Paises paisABorrar = (Paises)objetosPais.getFirst();

        //Consulta para ver los jugadores con ese pais asignado
        IQuery query1 = new CriteriaQuery(Jugadores.class, Where.equal ("pais.nombrePais", pais));
        Objects  objetosJug = odb.getObjects (query1);
        if (objetosJug.size() == 0) {
            System.out.println("No existen jugadores de " + pais + " no se pueden mostrar jugadores de " + objetosJug);
        } else {
            Jugadores jug;
            System.out.println("JUGADORES DE " + pais);
            while (objetosJug.hasNext()) {
                jug = (Jugadores) objetosJug.next();
                Paises paisNuevo = null;
                System.out.println("Pais Anterior: " + jug.getPais().getNombrePais());
                jug.setPais(paisNuevo);
                odb.store(jug);
            }
            odb.commit();
        }

        //elimino el objeto Pais
        odb.delete(paisABorrar);
        odb.close();
    }

    //Metodo que devuelve los jugadores de 14 años de españa,italia y francia
    private static void jugadores14AnyosEspañaItaliaFrancia() {
        ODB odb = ODBFactory.open(ODB_NAME);
        ICriterion criterio = new And().add(Where.equal("edad", 14))
                .add(new Or().add(Where.equal("pais.nombrePais", "ESPAÑA"))
                        .add(Where.equal("pais.nombrePais", "ITALIA"))
                        .add(Where.equal("pais.nombrePais", "FRANCIA")));

        IQuery query = new CriteriaQuery(Jugadores.class, criterio);

        Objects jugadores = odb.getObjects(query);

        if (jugadores.size() == 0) {
            System.out.println("No existen jugadores de 14 años de ESPAÑA, ITALIA, FRANCIA.");
        } else {
            Jugadores jug;
            System.out.println("Jugadores de 14 años de ESPAÑA, ITALIA, FRANCIA.");
            while (jugadores.hasNext()) {
                jug = (Jugadores) jugadores.next();
                System.out.println("Nombre: " + jug.getNombre() + ",Edad: " + jug.getEdad() + ",Pais: " + jug.getPais().getNombrePais());
            }
        }
        odb.close();
    }

    //método recibe el nombre de un país y actualiza las edades de los jugadores de ese país.
    //Suma 2 a la edad. Si no hay jugadores del país visualiza un mensaje indicándolo
    private static void actualizarEdadJugadoresPorPais(String pais) {
        ODB odb = ODBFactory.open(ODB_NAME);
        ICriterion criterio = Where.equal("pais.nombrePais", pais);
        IQuery query = new CriteriaQuery(Jugadores.class, criterio);
        Objects jugadores = odb.getObjects(query);
        if (jugadores.size() == 0) {
            System.out.println("No existen jugadores de" + pais + "no se actualiza la edad de " + pais);
        } else {
            Jugadores jug;
            System.out.println("ACTUALIZAMOS LA EDAD DE LOS JUGADORES DE " + pais);
            while (jugadores.hasNext()) {
                jug = (Jugadores) jugadores.next();
                int edad = jug.getEdad() + 2;
                System.out.println("Edad Anterior: " + jug.getNombre() + "Edad Anterior: " + jug.getEdad());
                jug.setEdad(edad);
                System.out.println("Edad Actualizada: " + jug.getNombre() + "Edad Actualizada: " + jug.getEdad());
                odb.store(jug);
            }
            odb.commit();
        }
        odb.close();
    }
    private void cambiarDeporteJugador(){
        ODB odb = ODBFactory.open(ODB_NAME);
        IQuery query = new CriteriaQuery(Jugadores.class, Where.equal ("nombre", "Maria"));
        Objects  objetos = odb.getObjects (query);
        //Obtiene solo el primer objeto encontrado
        Jugadores jug = (Jugadores) objetos.getFirst();
        //Cambia el deporte
        jug.setDeporte ("voley-playa");
        //Actualiza el objeto
        odb.store(jug);
        //Valida los cambios
        odb.commit();
        odb.close();
    }
    private void borrarJugador(){
        ODB odb = ODBFactory.open(ODB_NAME);
        IQuery query = new CriteriaQuery(Jugadores.class, Where.equal ("nombre", "Maria"));
        Objects  objetos = odb.getObjects(query);
        //Obtiene solo el primer objeto encontrado
        Jugadores jug = (Jugadores) objetos.getFirst();
        //elimina el objeto
        odb.delete(jug);
        odb.close();
    }
    private void obtenerJugCuyoNombreComienza(){
        ODB odb = ODBFactory.open(ODB_NAME);
        ICriterion criterio = Where.like ("nombre", "M%");
        CriteriaQuery query = new CriteriaQuery(Jugadores.class, criterio);
        Objects jugadores = odb.getObjects(query);
        Jugadores jug;
        System.out.println("Jugadores que su nombre empieza por M");
        while (jugadores.hasNext()) {
            jug = (Jugadores) jugadores.next();
            System.out.println(jug.getNombre());
        }
        odb.commit();
        odb.close();
    }
    private void jugMayoresDe14(){
        ODB odb = ODBFactory.open(ODB_NAME);
        ICriterion criterio = Where.gt("edad", 14);
        CriteriaQuery query = new CriteriaQuery(Jugadores.class, criterio);
        Objects jugadores = odb.getObjects(query);
        Jugadores jug;
        System.out.println("Jugadores mayores de 14 años");
        while (jugadores.hasNext()) {
            jug = (Jugadores) jugadores.next();
            System.out.println(jug.getNombre());
        }
        odb.commit();
        odb.close();
    }
    private void jugDeMadridyEdadIgualoMayorA15(){
        ODB odb = ODBFactory.open(ODB_NAME);
        ICriterion criterio = new And().add(Where.equal("ciudad", "Madrid"))
                .add(Where.equal("edad", 15));
        CriteriaQuery query = new CriteriaQuery(Jugadores.class, criterio);
        Objects jugadores = odb.getObjects(query);
        Jugadores jug;
        System.out.println("Jugadores mayores de 15 años y que son de Madrid");
        while (jugadores.hasNext()) {
            jug = (Jugadores) jugadores.next();
            System.out.println(jug.getNombre());
        }
        odb.commit();
        odb.close();
    }
}
