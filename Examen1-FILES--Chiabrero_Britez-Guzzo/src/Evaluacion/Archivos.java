
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluacion;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.*;

/**
 * ACA TODO LO QUE TENGA QUE VER CON LEER DATOS DE UN ARCHIVO, ESCRIBIR, BORRAR
 * FUNCIONALIDAD DE ARREGLADO DE FORMATO, Y OJO!! ACA DEBE ESTAR LA
 * DUNCIONALIDAD DE MOSTRAR LOS DATOS DEL ARCHIVO
 *
 * @author
 */
public class Archivos {

    private static final Logger LOG = Logger.getLogger(Archivos.class.getName());
    PrintStream PS;
    FileReader FR = null;
    BufferedReader BR = null;
    InputStreamReader is;

    public Archivos() {
        PS = new PrintStream(System.out);
    }
    
    
    public void Remplazo()
    {
        
    }
    /**
     *
     */
    
    /**
     * Intento de lectura de archivo
     */
    public void mostrar() {
        is = new InputStreamReader( System.in );
        BR = new BufferedReader( is );

        String texto = "";

        try {
            PS.print(">");
            texto = BR.readLine();

        } catch (IOException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                return;
            }
    }

    /**
     *
     */
    public void arreglar() {

    }

    /**
     * Intento de lectura
     */
    public void leer() {
        int[] vector = new int[5];
        String linea = "";
        
        try {
            File juegos = new File(ruta);
            FR = new FileReader(juegos);
            BR = new BufferedReader(FR);

            int V = 0;
            while ((linea = BR.readLine()) != null) {
                vector[V] = Integer.parseInt(linea);
                V += 1;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                
                if(BR != null){
                    BR.close();                    
                }
                
                if(FR != null){
                    FR.close();                
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return vector;

    }

    /**
     *
     */
    public void eliminar() {

    }

    /**
     *Intento de metodo de escritura
     */
    public void escribir(String date, File document)
    {
        FileWriter FW = null;
        PrintWriter PW = null;

       try {
        if (!document.exists()) {
            try {
                document.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FW = new FileWriter(document, true);

        PW = new PrintWriter(FW);
        PW.println(date);
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (PW != null) {
                    PW.close();
                }

                if (FW != null) {
                    FW.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}