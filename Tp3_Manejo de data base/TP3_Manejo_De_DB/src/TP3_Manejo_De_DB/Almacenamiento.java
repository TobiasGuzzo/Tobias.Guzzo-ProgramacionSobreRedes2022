
package TP3_Manejo_De_DB;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Toibias Guzzo
 */
public class Almacenamiento implements Serializable{
    private final long serialVersionUID = -1000L;
    LinkedList<Articulacion> articulos = new LinkedList<>();

    public Almacenamiento() {
    }
    
    public void agregarArticulo(Articulacion a){
        System.out.println(articulos.add(a));
    }
    public Articulacion devolverArticulo(int i){
        return articulos.get(i);
    }
    public LinkedList<Articulacion> devolverlistaArticulos(){
        return articulos;
    }
}
