/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2;

import java.util.ArrayList;

/**
 *
 * @author allan
 */
public interface DAOGeneral<T> {
    public void agregar( T registro);
    public void borrar(int id);
    public void actualizar( T registro );
    public ArrayList<T> obtenerTodo();
    public T obtener( int id );
}
