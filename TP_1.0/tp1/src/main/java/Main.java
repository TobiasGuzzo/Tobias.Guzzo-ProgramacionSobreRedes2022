/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import.util.arrayList;
        
/**
 *
 * @author guzzo
 */
public class Main {
    /**
     * 
     * @param args
     * @throws IOException
     * 
     * Este es el metodo ejecutable
     */
public static void main(String[] args )throws IOException{
    
Ficheros memoriav = new Ficheros("E:\escritorio\carpeta del tp 1","");
Ficheros error = new Ficheros("E:\\escritorio\\carpeta del tp 1","");
Ficheros respuesta = new Ficheros("E:\\escritorio\\carpeta del tp 1",);    
Lectura leer = new Lectura();
Mostrar pt = new Mostrar();

arrayList<Integer> memoria = new Arraylist<>();    
/**
 * agrego voy leyendo los datos ingresados y guardar archivos
 */
for(int i = 0; i <=4; i++){
    String a = leer.leer();
    memoria.add(Integer.parseInt(a));
    memoriav.guardarArchivo(a);
   
}





}
/**
 * 
 */
public void eje2(){
  for(int i = 0; i<= 4 ; i++){
      respuesta.guardarArchivo(String.valueOf(memoria[i] / (memoria[i + 1]- 3)));
  
  }
}
}