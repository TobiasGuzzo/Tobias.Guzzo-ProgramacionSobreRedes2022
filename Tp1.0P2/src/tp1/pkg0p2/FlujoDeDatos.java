package tp1.pkg0p2;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FlujoDeDatos {

    PrintStream ps;
    InputStreamReader is;
    FileReader fr = null;
    BufferedReader br = null;
    

    
    
    
    public FlujoDeDatos() {
        ps = new PrintStream(System.out);        
    }
    
    public void escribirArchivo(String dato, File archivo){
        
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            fw = new FileWriter(archivo, true);

            pw = new PrintWriter(fw);
            pw.println(dato);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
        
    String leer(){
        is = new InputStreamReader( System.in );
        br = new BufferedReader( is );
        
        String texto = "";
        
        try {
            ps.print(">");
            texto = br.readLine();

        } catch (IOException ex) {
            Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return texto;
        }
    }    
       
}
