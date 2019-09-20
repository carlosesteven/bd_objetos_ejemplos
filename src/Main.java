import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Main {

    private static final String ODB_NAME = "base_datos_personas.neodatis";

    public static void main(String[] args)
    {
        borrarBaseDatosActual();
        insertaDatos();
        cantidadDatos();
        filtraPorCiudaBogota();
        filtraPorCiudaCali();
    }

    private static void filtraPorCiudaCali()
    {
        ODB odb = null;
        try {
            odb = ODBFactory.open(ODB_NAME);

            IQuery query = new CriteriaQuery(Persona.class, Where.equal("ciudad", "Cali"));

            Objects<Persona> objects = odb.getObjects(query);

            System.out.print("\n");
            System.out.println("Existen " + objects.size() + " personas de CALI registradas en la base datos de objetos.");
            System.out.print("\n");

            int i = 1;

            while(objects.hasNext())
            {
                Persona actual = objects.next();
                System.out.println(
                        "[ " + i + " ] "
                                + actual.getPrimer_nombre()
                                + " "
                                + actual.getSegundo_nombre()
                                + " -> "
                                + actual.getCiudad()
                );
                i++;
            }

        } finally {
            if (odb != null) {
                // Close the database
                odb.close();
            }
        }
    }

    private static void filtraPorCiudaBogota()
    {
        ODB odb = null;
        try {
            odb = ODBFactory.open(ODB_NAME);

            IQuery query = new CriteriaQuery(Persona.class, Where.equal("ciudad", "Bogota"));

            Objects<Persona> objects = odb.getObjects(query);

            System.out.print("\n");
            System.out.println("Existen " + objects.size() + " personas de BOGOTA registradas en la base datos de objetos.");
            System.out.print("\n");

            int i = 1;

            while(objects.hasNext())
            {
                Persona actual = objects.next();
                System.out.println(
                        "[ " + i + " ] "
                                + actual.getPrimer_nombre()
                                + " "
                                + actual.getSegundo_nombre()
                                + " -> "
                                + actual.getCiudad()
                );
                i++;
            }

        } finally {
            if (odb != null) {
                // Close the database
                odb.close();
            }
        }
    }

    private static void cantidadDatos()
    {
        ODB odb = null;
        try {
            odb = ODBFactory.open(ODB_NAME);
            Objects<Persona> objects = odb.getObjects(Persona.class);

            System.out.print("\n");
            System.out.println("Existen " + objects.size() + " personas registradas en la base datos de objetos.");
            System.out.print("\n");

            int i = 1;

            while(objects.hasNext())
            {
                Persona actual = objects.next();
                System.out.println(
                        "[ " + i + " ] "
                        +  actual.getCedula() + " "
                        + actual.getPrimer_nombre()
                        + " "
                        + actual.getSegundo_nombre()
                );
                i++;
            }

        } finally {
            if (odb != null) {
                // Close the database
                odb.close();
            }
        }
    }

    private static void borrarBaseDatosActual()
    {
        Objects objects;

        // Open the database
        ODB odb = null;

        try {
            odb = ODBFactory.open(ODB_NAME);
            objects = odb.getObjects(Persona.class);
            while (objects.hasNext()) {
                odb.delete(objects.next());
            }
        } finally {
            if (odb != null) {
                // Close the database
                odb.close();
            }
        }
    }

    private static void insertaDatos()
    {
        ODB odb = null;
        try {
            odb = ODBFactory.open(ODB_NAME);

            Persona p1 = new Persona(
                    111111111,
                    "Carlos",
                    "Steven",
                    "Cali",
                    "Colombia"
            );

            Persona p2 = new Persona(
                    111111111,
                    "Carolina",
                    "Molina",
                    "Cali",
                    "Colombia"
            );

            Persona p3 = new Persona(
                    222222222,
                    "Paula",
                    "Andrea",
                    "Bogota",
                    "Colombia"
            );

            Persona p4 = new Persona(
                    222222222,
                    "Aura",
                    "Maria",
                    "Bogota",
                    "Colombia"
            );

            odb.store(p1);
            odb.store(p2);
            odb.store(p3);
            odb.store(p4);

        } finally {
            if (odb != null) {
                // Close the database
                odb.close();
            }
        }
    }

}
