/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2;

import java.util.Date;

/**
 *
 * @author Soft 07
 */
public class DTOLibro extends Articulo implements DTOGeneral {

    private Date fechaDeIngreso;
    private String autor;
    private int paginas;

    public DTOLibro(Date fechaDeIngreso, String autor, int paginas, int codigo, String nombre, String genero) {
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
