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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
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
    PrintStream ps;

    public Ficheros() {
        ps = new PrintStream(System.out);

        //Si no existe es la forma de CREAR el archivon(vale para carpeta tambien)
        //archivo = new File("C:\\Users\\"
        //        + "Software-Notebook\\Desktop\\MiArchivo.exe");
        archivo = new File("MiArchivito.dat");

        rutaFiles(archivo);
        crearFileConPrintStreamEasy(archivo);
        crearFileConPrinter(archivo);
        crearFileConBuffer(archivo);

        try {
            ps.println(LeerFileConBuffer(archivo));
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * ESTE TEXTO NO TIENE NINGUNA ETIQUETA DE IDENTIFICACION. ESTO NO VA A
     * AAPARECER :( Tambien se puede agregar referencias a class o methodos o
     * atributos con la instruccion: {
     *
     * @ por ejemplo: {@code <html></html>} o usar {@link String}
     *
     * @param f Este metodo recibe un archivo.
     * @see FlujoDeDatos.File.
     * @since v1.0
     */
    public void rutaFiles(File f) {
        try {
            ps.println("D:\\Documents\\NetBeansProjects\\EnClase2022\\build.xm");
            ps.println("Absolut File: " + f.getAbsoluteFile());
            ps.println("Canonnic: " + f.getCanonicalFile());//remplazado por getPath
            ps.println("Parent: " + f.getParentFile());
            ps.println("Path: " + f.getPath()); //ruta relativa
            ps.println("Name: " + f.getName());
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearFileConPrintStreamEasy(File f) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
            ps = new PrintStream(fos, true);

            ps.println("Escrbo en el archivo.");
            ps.append("Este texto esta con APPEND");
            ps.println("Despues del Appned");
            ps.flush();

            ps.close();

            System.setErr(
                    new PrintStream(
                            new FileOutputStream(
                                    new File("Error.log")), true)
            );

            System.err.println("Errorr.");
            System.err.println("Otro Error.");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void crearFileConPrinter(File f) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            fw = new FileWriter(archivo, true);

            pw = new PrintWriter(fw);
            pw.println("Escribiendo con PrintWriter.");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param f
     */
    public void crearFileConBuffer(File f) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);

            bw.write("Este texto fue escrito por un Buffered .Write.");
            bw.newLine();
            bw.write("Esta es otra linea del Buffered .Write");
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

    /**
     * Descripcion
     *
     * @param f un archivo al leer
     * @return Todo el texto leido.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String LeerFileConBuffer(File f) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String linea = "", texto = "";
        while ((linea = br.readLine()) != null) {
            texto += "\n" + linea;
        }

        br.close();
        fr.close();

        return texto;
    }

    public void leerFileCaracterAcaractet(File f) {
        FileReader fr;
        try {
            fr = new FileReader(f);

            int caracter;
            while ((caracter = fr.read()) != -1) {
                if (caracter == '\n') {
                    ps.println();
                } else {
                    ps.print((char) caracter);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
