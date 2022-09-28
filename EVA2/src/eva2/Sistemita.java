package eva2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Sistemita implements Serializable {

    private static final long serialVersionUID = -1000L;
    private Librero librero;

    public Sistemita() {
        librero = new Librero();
    }

    public Sistemita deSerializar(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Sistemita s = (Sistemita) ois.readObject();
        return s;
    }

    public void serializar(String archivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.close();
    }

    public void prender() {

        Articulo a1 = new DTOLibro(new Date(2003, 10, 05), "autor1", 300, 1, "nombre1", "genero1");
        Articulo a2 = new DTOLibro(new Date(2001, 10, 05), "autor2", 400, 2, "nombre2", "genero2");
        Articulo a3 = new DTOLibro(new Date(2002, 10, 05), "autor3", 600, 3, "nombre3", "genero3");
        Articulo a4 = new DTOLibro(new Date(2002, 10, 05), "autor3", 600, 3, "nombre4", "genero3");
        Articulo a5 = new DTOLibro(new Date(2002, 10, 05), "autor3", 600, 3, "nombre5", "genero3");

        librero.agregarArticulo(a1);
        librero.agregarArticulo(a2);
        librero.agregarArticulo(a3);
        librero.agregarArticulo(a4);
        librero.agregarArticulo(a5);
    }

    public boolean mostrarMenu() {
        Lectura lector = new Lectura();
        DAOLibro libreria = new DAOLibro();
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            int op;
            do {

                System.out.println(
                        "\tMENÚ EMPLEADO\n\n"
                        + "\t[1] Agregar un Libro\n"
                        + "\t[2] Borrar Libro\n"
                        + "\t[3] Actualizar Libro\n"
                        + "\t[4] Obtener Todo los Libro\n"
                        + "\t[5] Volver"
                );
                op = lector.leerInt();
            } while (op < 1 || op > 4);

            switch (op) {
                case 1:
                    libreria.agregar(registro);
                    break;
                case 2:
                    libreria.borrar();
                    break;
                case 3:
                    libreria.actualizar(registro);
                    break;
                case 4:
                    libreria.obtenerTodo();
                    break;
                case 5:
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }

    /*  public void serializacion() {

        try {
            System.out.println("Leyendo");

        } catch (IOException | ClassNotFoundException ex) {
            this.prender();
        } finally {

        }

        try {
            this.serializar(archivo);
        } catch (IOException ex) {
            System.err.println("ERROR: No se pudo Serializar.");
        }
    }
}*/
    public void mostrar() {
        Sistemita sistema = new Sistemita();
        String archivo = "datos.bin";

        try {
            System.out.println("Leer el binario");
            sistema = this.deSerializar(archivo);
            

            for (Articulo a : librero.devolverlistaArticulos()) {
                System.out.println(a.toString());
                DAOLibro aux = new DAOLibro();
                aux.agregar((DTOLibro) a);
                
            }
            System.out.println("Se cargaron los datos");
        } catch (Exception e) {
        } finally {
            System.out.println("Finalizo");
        }

        //   conexxion base de datos 
    }

}
