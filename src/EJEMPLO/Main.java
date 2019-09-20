package EJEMPLO;

import EJEMPLO.Objetos.Persona;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * USANDO: http://neodatis.wikidot.com/start
 * BASE DEL EJEMPLO: http://www.programandoapasitos.com/2016/03/acceso-datos-neodatis.html
 */

public class Main {

    private static final String ODB_NAME = "BD_ejemplo.neodatis";

    public static void main(String[] args)
    {
        borrarBaseDatosActual();
        insertaDatos();
        cantidadDatos();
        ordenarPorNombre();
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

    private static void ordenarPorNombre()
    {
        ODB odb = null;
        try {
            odb = ODBFactory.open(ODB_NAME);

            IQuery query = new CriteriaQuery( Persona.class )
                    .orderByAsc("primer_nombre");

            Objects<Persona> objects = odb.getObjects(query);

            System.out.print("\n");
            System.out.println("Lista ordenada de manera ASC por nombre.");
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
                );
                i++;
            }

            System.out.print("\n");
            System.out.println("Lista ordenada de manera DES por nombre.");
            System.out.print("\n");

            query = new CriteriaQuery( Persona.class )
                    .orderByDesc("primer_nombre");

            objects = odb.getObjects(query);

            System.out.print("\n");
            System.out.println("Lista ordenada de manera ASC por nombre.");
            System.out.print("\n");

            i = 1;

            while(objects.hasNext())
            {
                Persona actual = objects.next();
                System.out.println(
                        "[ " + i + " ] "
                                + actual.getPrimer_nombre()
                                + " "
                                + actual.getSegundo_nombre()
                );
                i++;
            }

        } finally {
            if (odb != null) {
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
                    'H',
                    "Cali",
                    "Colombia"
            );

            Persona p2 = new Persona(
                    222222222,
                    "Carolina",
                    "Molina",
                    'M',
                    "Cali",
                    "Colombia"
            );

            Persona p3 = new Persona(
                    333333333,
                    "Paula",
                    "Andrea",
                    'M',
                    "Bogota",
                    "Colombia"
            );

            Persona p4 = new Persona(
                    444444444,
                    "Aura",
                    "Maria",
                    'M',
                    "Bogota",
                    "Colombia"
            );

            Persona p5 = new Persona(
                    555555555,
                    "Carlos",
                    "Manuel",
                    'H',
                    "Bogota",
                    "Colombia"
            );

            Persona p6 = new Persona(
                    666666666,
                    "Carlos",
                    "Manuel",
                    'H',
                    "Medellin",
                    "Colombia"
            );

            Persona p7 = new Persona(
                    777777777,
                    "Laura",
                    "Sofia",
                    'M',
                    "Medellin",
                    "Colombia"
            );

            Persona p8 = new Persona(
                    888888888,
                    "Camilo",
                    "Muñoz",
                    'H',
                    "Pasto",
                    "Colombia"
            );

            Persona p9 = new Persona(
                    999999999,
                    "Diana",
                    "Carolina",
                    'H',
                    "Popayan",
                    "Colombia"
            );

            Persona p10 = new Persona(
                    1010101010,
                    "Daniela",
                    "Murillo",
                    'M',
                    "Popayan",
                    "Colombia"
            );

            odb.store(p1);
            odb.store(p2);
            odb.store(p3);
            odb.store(p4);
            odb.store(p5);
            odb.store(p6);
            odb.store(p7);
            odb.store(p8);
            odb.store(p9);
            odb.store(p10);

        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

}
