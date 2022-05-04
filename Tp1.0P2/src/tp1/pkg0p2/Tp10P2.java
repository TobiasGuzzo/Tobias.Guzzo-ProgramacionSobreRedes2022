/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.pkg0p2;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author guzzo
 */
public class Tp10P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
    }
    
    public class Sistema {
    PrintStream ps;
    FlujoDeDatos f;
    File archivo;

    public Sistema() {
    ps = new PrintStream(System.out);
    f = new FlujoDeDatos();
    }
    public void ejercicio3(int[] o1, int[] o2){
    archivo = new File("resultados.txt");
    File error = new File("error.txt");

    if(archivo.exists() | error.exists()){
        archivo.delete();
        error.delete();
    }
    ArrayList<Integer> listaAux = new ArrayList<Integer>();         

    for (int i = 0; i < o1.length; i++) {
        listaAux.add(o1[i]);
    }

    for (int i = 0; i < o2.length; i++) {
        listaAux.add(o2[i]);
    }


    for(int i: listaAux){
        System.out.println(i);
    }

    double respuesta = 0;  

    try{
        if(listaAux.get(0) == 0 || listaAux.get(1) == 0){                   
            throw new ArithmeticException();
        }else{
            respuesta = (listaAux.get(0)*1.0) / (listaAux.get(1)*1.0);
            f.escribirArchivo(listaAux.get(0) + "/" + listaAux.get(1) + "=" + respuesta, archivo);  
        }           
    }catch(ArithmeticException | NullPointerException  ex ){
        f.escribirArchivo((listaAux.get(0) + "/" + listaAux.get(1) + "=error"), error);
    }

    for (int i = 2; i < listaAux.size(); i++) {  
        try{
            if(listaAux.get(i) == 0){
                throw new ArithmeticException(); 
            }else{                    
                f.escribirArchivo(respuesta + "/" + listaAux.get(i) + "=" + respuesta/listaAux.get(i), archivo);            
                respuesta /= listaAux.get(i);
            }          
        }catch(ArithmeticException | NullPointerException  ex ){
            f.escribirArchivo((respuesta + "/" + listaAux.get(i) + "=error"), error);
    }
    }            
    }  
    }
    }
