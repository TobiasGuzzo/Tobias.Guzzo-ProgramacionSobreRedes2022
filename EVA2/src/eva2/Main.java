/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2;

import java.io.IOException;

/**
 *
 * @author Software-Notebook
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
