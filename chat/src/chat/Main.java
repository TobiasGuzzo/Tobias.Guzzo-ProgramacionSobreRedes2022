/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;

/**
 *
 * @author localuser
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Lectura lector = new Lectura();

        Ficheros archivo = new Ficheros("\\\\SOFTWARE-NOTEBO\\Users\\Public\\Pc-12\\", "chat.tmp");
        Ficheros archivo1 = new Ficheros("\\\\SOFTWARE-NOTEBO\\Users\\Public\\Pc-12\\", "chat.txt");
 
        // archivo.eliminarArchivo("\\\\SOFTWARE-NOTEBO\\Users\\Public\\Pc-12\\chat.txt");
        //System.out.println(archivo.LeerFileConBuffer("\\\\SOFTWARE-NOTEBO\\Users\\Public\\Pc-12\\chat.tmp"));
        int valor;
        boolean valor1 = true;
        while (valor1 != false) {
            System.out.println("1-Leer");
            System.out.println("2-Enviar");
            System.out.println("3-Salir");

            valor = Integer.parseInt(lector.leer());
            if (valor == 1) {
                System.out.println(archivo.LeerFileConBuffer("\\\\SOFTWARE-NOTEBO\\Users\\Public\\Pc-12\\chat.tmp"));
            } else if (valor == 2) {
                archivo.escribirArchivo();
            } else if (valor == 3) {
                valor1 = false;
            } else {
                System.out.println("Numero equivocado");
            }

        }

    }

}
