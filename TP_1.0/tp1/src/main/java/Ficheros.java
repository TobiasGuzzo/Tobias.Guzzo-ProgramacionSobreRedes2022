/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
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



