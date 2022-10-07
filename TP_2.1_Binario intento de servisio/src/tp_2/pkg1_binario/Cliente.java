/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_2.pkg1_binario;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Tobias
 * creacion del cliente 
 */
public class Cliente extends Persona{
    private BaseDeDatos usuarios;

    public Cliente(BaseDeDatos lista, int dni, String nombre, String apellido, String numContacto) {
        super(dni, nombre, apellido, numContacto);
        this.usuarios = lista;
    }

    public BaseDeDatos getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(BaseDeDatos usuarios) {
        this.usuarios = usuarios;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }
    
    //formato mostrar menu por parte del cliente
    @Override
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                Utilidades.mostrarPorPantalla(
                        "\tMENÚ CLIENTES\n\n"
                        + "\t[5] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '5');

            switch (op) {
                case '1':
                case '2':
                    usuarios.mostrarClientes();                
                    break;
                case '3':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }
    
    
    @Override
    public void mostrarDatos() {
        Utilidades.mostrarPorPantalla("CLIENTE: \n"
                + "\t Nombre: " + this.nombre + "\n"
                + "\t Apellido: " + this.apellido + "\n"
                + "\t Telefono: " + this.numContacto + "\n"
                + "==================================\n"
        );
    }    
    
   

    
  
    
}
