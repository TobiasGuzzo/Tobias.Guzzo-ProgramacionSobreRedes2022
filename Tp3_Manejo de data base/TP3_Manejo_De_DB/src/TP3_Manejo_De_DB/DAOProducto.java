
package TP3_Manejo_De_DB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tobias Guzzo
 */
public class DAOProducto  {

    public DAOProducto() {
    }


    @Override
    public void agregar(DTOProducto registro) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            String consulta = "INSERT INTO libro( nombre, autor, paginas,codigo, genero) VALUES (?,?,?,?,?)";

            
            con = ConexionesFactory.getInstance().getConection();
            
            ps = con.prepareStatement(consulta);

            //ps.setDate(1, (Date) registro.getFechaDeIngreso());
            ps.setString(1, registro.getNombre());
           
           
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public void borrar(int codigo) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            String consulta = "DELETE FROM libro WHERE codigo = ? ";

            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta);

            ps.setInt(1, codigo);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void actualizar(DTOProducto registro) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            String consulta = "UPDATE libro SET nombre=?, autor=?, paginas=?,genero=? WHERE codigo=?";
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta);

            ps.setString(1, registro.getNombre());
     

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public ArrayList<DTOProducto> obtenerTodo() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //String sql = "SELECT * FROM libro WHERE codigo=?";
            String sql = "SELECT * FROM libro";

            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            ArrayList<DTOProducto> librero = new ArrayList<>();

            while (rs.next()) {
                DTOProducto aux = new Producto(
                 
                        rs.getString("nombre"),
                 
                System.out.println(aux.toString());
            }

            return librero;
        } catch (SQLException ex) {

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public DTOProducto obtener(int codigo) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM trabajador WHERE id=?";
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            DTOProducto aux = new Producto(
 
                    rs.getString("nombre"),
            
            
            return aux;

        } catch (SQLException ex) {

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
