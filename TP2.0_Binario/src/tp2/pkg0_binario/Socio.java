
package tp2.pkg0_binario;
/**
 *
 * @author guzzo
 */
import tp2.pkg0_binario.BaseDeUsuario;
import static FlujoDeDatos.FileObjectBinary.Utilidades.mostrarPorPantalla;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Socio extends Persona {//problemas para usar el socio

    private float cuota;
    private TipoMembrecia membrecia;  
    private ArrayList< Map<Integer, Integer>> partidasJugadas;
    private BaseDeUsuario usuarios;

    public Socio(BaseDeUsuario lista, TipoMembrecia membrecia, int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto) {
        super(DNI, fechaDeIngreso, nombre, apellido, direccion, edad, genero, numContacto);

        this.cuota = -1;
        this.membrecia = membrecia;
        this.partidasJugadas = new ArrayList<>();
        this.usuarios = lista;
    }

    @Override
    public void calcular() {
        //COMPLETAR USTEDES
        //
        // cambia segun la antiguedad
        //
        //COMPLETAR USTEDES
        
        //COMPLETADO
        
        switch (this.membrecia) {
            case Bronce:
                this.cuota = 5000;
                break;
            case Plata:
                this.cuota = 10000;
                break;
            case Oro:
                this.cuota = 20000;
                break;
            case Black:
                this.cuota = 50000;
                break;
            case Platino:
                this.cuota = 100000;
                break;
        }
        
        long añoActual = new Date(System.currentTimeMillis()).getYear() + 1900;
        int antiguedad = (int) añoActual - this.fechaDeIngreso.getYear();
        
        if (antiguedad < 2){
            this.cuota = this.cuota;
        }else if(antiguedad < 5){
            this.cuota -= this.cuota * 0.2;
        }else if(antiguedad < 10){
            this.cuota -= this.cuota * 0.3;
        }else if(antiguedad > 10){
            this.cuota -= this.cuota * 0.5;
        }
    }

    public void mostrarDatos() {
        Utilidades.mostrarPorPantalla("SOCIO: \n"
                + "\t NOMBRE: " + this.nombre + "\n"
                + "\t APELLIDO: " + this.apellido + "\n"
                + "\t DIRECCION: " + this.direccion + "\n"
                + "\t GENERO: " + this.genero + "\n"
                + "\t TEL: " + this.numContacto + "\n"
                + "\t DNI: " + this.DNI + "\n"
                + "----------------------\n"
                + "\t CUOTA: " + this.cuota + "\n"
                + "\t MEMBRECIA: " + this.membrecia + "\n"
                + "....................................\n"
        );

        Utilidades.mostrarListaArray(this.partidasJugadas);
        Utilidades.mostrarPorPantalla("+ \"=\\n\"");
    }

    @Override
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                //COMPLETAR USTEDES
                //
                // agregar opcion para cambiar membresia.
                // verificar que que no explote las cargas de datos nuevos
                // ni los pedidos de mostrar datos far falta de ellos.
                //
                //COMPLETAR USTEDES
                
                //COMPLETADO
                
                mostrarPorPantalla(
                        "\tMENÚ SOCIO\n\n"
                        + "\t[1] Cargar un Socio\n"
                        + "\t[2] Cargar un Partidas de un Socio\n"
                        + "\t[3] Calcular Cuota\n"
                        + "\t[4] Mostrar Socios\n"
                        + "\t[5] Mostrar Partidas por socios\n"
                        + "\t[6] Cambiar Membresia\n"
                        + "\t[7] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '7');

            switch (op) {
                case '1':
                    this.cargarNuevoSocio();
                    break;
                case '2':
                    this.cargarPartida((Socio) usuarios.elegirUsuario(Socio.class));
                    break;
                case '3':
                    usuarios.actualizarSueldosCoutas();
                    break;
                case '4':
                    usuarios.mostrarPersonas(Socio.class);
                    break;
                case '5':
                    usuarios.mostrarPartidasSocios();
                    break;
                case '6':
                    this.cambiarMembresia((Socio) usuarios.elegirUsuario(Socio.class));
                    break;
                case '7':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }
//nose como seguir

    private void cambiarMembresia(Socio socio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarPorPantalla(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarNuevoSocio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarPartida(Socio socio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void proceder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
