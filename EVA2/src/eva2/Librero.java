/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Soft 07
 */
public class Librero implements Serializable{
    private final long serialVersionUID = -1000L;
    LinkedList<Articulo> articulos = new LinkedList<>();

    public Librero() {
    }
    
    public void agregarArticulo(Articulo a){
        System.out.println(articulos.add(a));
    }
    public Articulo devolverArticulo(int i){
        return articulos.get(i);
    }
    public LinkedList<Articulo> devolverlistaArticulos(){
        return articulos;
    }
}
