/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_2.pkg1_binario;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tobias 
 */
public class Sistemita implements Serializable {

    private static final long serialVersionUID = -1000L;
    private BaseDeDatos usuarios;
        
    public Sistemita() {
        usuarios = new BaseDeDatos();
    }

    public Sistemita deSerializar(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Sistemita s = (Sistemita) ois.readObject();
        return s;
    }

    public void creacion() {
        Utilidades.mostrarPorPantalla(" Funka el programa . ");
        
        Cliente c = new Cliente(usuarios, 1, "nombre", "apellido", "tel");
      
        
        usuarios.agregarUsuario( c );
        
    }

    public void serializar(String archivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.close();
    }

    public void prender() {
        boolean corriendo = true;
        
        while( corriendo )
        {
            corriendo = mostrarMenu();    
        }
        Utilidades.mostrarPorPantalla("No estallo ");
              
    }


    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                Utilidades.mostrarPorPantalla(
                        "MENÚ PRINCIPAL\n\n"
                        + "[1] Menu de Clientes\n"
                        + "[2] Menu de hacer reserva de turno\n"
                        + "[3] Salir\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '3');

            switch (op) {
                case '2':
                    break;
                case '3':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }     
}
