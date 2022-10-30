
package TP3_Manejo_De_DB;

import java.io.IOException;

/**
 *
 * @author Tobias Guzzo
 */
public class Main {
    
    public static void main(String[] args) {
        
        Sistemita s = new Sistemita();
        String archivo = "datos.bin";
        
        try
        {
            System.out.println("Leyendo");
            s = s.deSerializar( archivo );
            s.mostrar();
        }catch( IOException | ClassNotFoundException ex ){
            s.prender();
        }finally{
            s.prender();
        }
        
        try
        {
            s.serializar( archivo );
        }catch(IOException ex){
            System.err.println("ERROR: No se pudo Serializar.");
        }
        
    }
    
}
