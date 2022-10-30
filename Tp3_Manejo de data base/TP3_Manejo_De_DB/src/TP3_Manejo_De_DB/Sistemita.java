package TP3_Manejo_De_DB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Toibias Guzzo
 */
public class Sistemita implements Serializable {

    private static final long serialVersionUID = -1000L;
    private Almacenamiento librero;

    public Sistemita() {
        librero = new Almacenamiento();
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

        Articulacion a1 = new DTOProducto(new Date(2003, 10, 05), "autor1", 300, 1, "nombre1", "genero1");


        librero.agregarArticulo(a1);
    }

    public boolean mostrarMenu() {
        Lectura lector = new Lectura();
        DAOProducto libreria = new DAOProducto();
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            int op;
            do {

                System.out.println(
                        "\tMENÚ EMPLEADO\n\n"
                        + "\t[1] Agregar un Producto\n"
                        + "\t[2] Borrar Producto\n"
                        + "\t[3] Actualizar Producto\n"
                        + "\t[4] Obtener Producto\n"
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
    }i

    public void mostrar() {
        Sistemita sistema = new Sistemita();
        String archivo = "datos.bin";

        try {
            System.out.println("Leer el binario");
            sistema = this.deSerializar(archivo);
            

            for (Articulacion a : librero.devolverlistaArticulos()) {
                System.out.println(a.toString());
                DAOProducto aux = new DAOProducto();
                aux.agregar((DTOProducto) a);
                
            }
            System.out.println("Se cargaron los datos");
        } catch (Exception e) {
        } finally {
            System.out.println("Finalizo");
        }

        //   conexxion base de datos 
    }

}
