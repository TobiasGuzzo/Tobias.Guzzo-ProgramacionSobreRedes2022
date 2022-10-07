/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_2.pkg1_binario;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Tobias 
 * intento de base de datos 
 */
public class BaseDeDatos implements Serializable {
    private static final long serialVersionUID = -1000L;
    private List<Cliente> bUsuario;
    public BaseDeDatos() {
        bUsuario = new LinkedList<>();
    }

    /*Métodos base de usuarios*/
    public void agregarUsuario(Cliente c) {
        if (c != null) {
            bUsuario.add(c);
        }
    }

    void mostrarClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

}
