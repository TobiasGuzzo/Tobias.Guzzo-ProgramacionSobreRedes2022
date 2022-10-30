
package TP3_Manejo_De_DB;

import java.io.Serializable;

/**
 *
 * @author Tobias Guzzo
 */
class Articulacion implements Serializable{
    private final long serialVersionUID = -1000L;
    int codigo;
    String nombre, genero;

    public Articulacion(int codigo, String nombre, String genero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
