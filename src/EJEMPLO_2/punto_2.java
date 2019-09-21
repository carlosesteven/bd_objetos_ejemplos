package EJEMPLO_2;

import EJEMPLO_2.Objetos.Jugadores;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class punto_2 {

    private static final String ODB_NAME = "BD_taller.neodatis";

    public static void main(String[] args) {

        /*La conexión la realizo con un objeto de clase ODB,
        en la que indico la ruta donde tengo la base de datos.
        Esto sirve para abrirla como para crear una nueva*/
        ODB odb = ODBFactory.open(ODB_NAME);

        /* Genero la consulta: Llamo a la clase Jugadores,la condición será
        que la propiedad deporte sea igual a tenis*/
        IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("deporte", "tenis"));

        //Ordeno ascendentemente por nombre y edad
        query.orderByAsc("nombre,edad");

        // Cargo los objetos pasando como parámetro del odb.getObjects la consulta
        Objects<Jugadores> objects = odb.getObjects(query);
        System.out.println("Hay "+ objects.size()+" Jugadores de tenis:");
        int i = 1; //contador para mostrar listados los objetos

        //visualizar los objetos
        while(objects.hasNext()) {

            // Creo un objeto Jugadores y almaceno ahí el objeto que recupero de la BD
            Jugadores jug = objects.next();

            // Imprimo las propiedades que me interesan de ese objeto
            System.out.println((i++)+" - "+"Nombre: "+jug.getNombre()+", Deporte: "+ jug.getDeporte()+", Pais: "+ jug.getPais().getNombrePais());
        }
    }
}
