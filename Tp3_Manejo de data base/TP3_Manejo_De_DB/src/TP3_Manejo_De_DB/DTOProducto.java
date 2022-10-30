
package TP3_Manejo_De_DB;

import java.util.Date;

/**
 *
 * @author Tobias Guzzo
 */
public class DTOProducto  {

    private Date fechaDeIngreso;
    private String autor;
    private int paginas;

    public DTOProducto(Date fechaDeIngreso, String autor, int paginas, int codigo, String nombre, String genero) {
        super(codigo, nombre, genero);
        this.fechaDeIngreso = fechaDeIngreso;
        this.autor = autor;
        this.paginas = paginas;
    }

    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    

    @Override
    public String toString() {
        return "fechaDeIngreso=" + fechaDeIngreso + "\nautor=" + autor + "\npaginas=" + paginas + "\ncodigo=" + codigo + "\nnombre" + nombre + "\ngenero" + genero;
    }
}
