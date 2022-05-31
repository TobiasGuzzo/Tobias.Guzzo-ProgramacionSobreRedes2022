/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * ESTA PARTE VA A ESTAR EN LA HOJA HTML. Esto tamibien va a estar en el HTML,
 * pero en la parte de la descripcion (aca puse ENTER) de la clase no como
 * titular, y aca podemos dar una (aca puse ENTER) descripcion Gral. del uso y
 * funcionamiento de esta CLASS.
 *
 * @author Software-Notebook
 * @version %I%, %G%
 * @serial
 * @since v1.0
 */
public class Ficheros {

    File archivo;
    String nombre;
    String direccion;
    PrintStream ps;

    public Ficheros( String direccion, String nombre) {
        ps = new PrintStream(System.out);
        archivo = new File(direccion + nombre);
        if(!archivo.exists()){
            
            System.out.println("Se creo el archivo: '" + nombre +"'");
        }
        else{
            System.out.println("Existe el archivo: '" + nombre +"'");
        }
            
        
    }

//main llama a sistema y no hace nada jaja
    public void escribirArchivo() {
        Lectura lector = new Lectura();
        
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);

            bw.write(lector.leer());
            bw.newLine();
            bw.flush();

        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }

                if (bw != null) {
                    bw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String LeerFileConBuffer(String direccion) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(direccion);
        BufferedReader br = new BufferedReader(fr);

        String linea = "", texto = "";
        while ((linea = br.readLine()) != null) {
            texto += "\n" + linea;
            
        }
        br.close();
        fr.close();

        return texto;
    }

    public void eliminarArchivo(String direc){
        File temp = new File(direc);
        temp.delete();
    }
    public boolean existe(){
        
        return true;
    }
}



