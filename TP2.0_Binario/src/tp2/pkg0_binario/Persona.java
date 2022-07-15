
package tp2.pkg0_binario;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author guzzo
 */
public abstract class Persona implements Serializable {
 
    private static final long serialVersionUID = -1000L;
    
    protected int DNI;
    protected Date fechaDeIngreso;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected int edad;
    protected Genero genero;
    protected String numContacto; 
    /**
     * 
     * @param DNI
     * @param fechaDeIngreso
     * @param nombre
     * @param apellido
     * @param direccion
     * @param edad
     * @param genero
     * @param numContacto 
     */
    public Persona(int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto) {
        this.DNI = DNI;
        this.fechaDeIngreso = fechaDeIngreso;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.genero = genero;
        this.numContacto = numContacto;
    }
    
    /**
     * Distintas acciones dependiendo que tiepo de persona sea
     */
    public abstract void proceder();

    public abstract void mostrarDatos();
    
    public abstract boolean mostrarMenu();
    
    public abstract void calcular();
    
}
