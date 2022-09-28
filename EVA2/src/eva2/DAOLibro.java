/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2;

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
 * @author allan
 */
public class DAOLibro implements DAOGeneral<DTOLibro> {

    public DAOLibro() {
    }

    
    @Override
    public void agregar(DTOLibro registro) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            String consulta = "INSERT INTO libro( nombre, autor, paginas,codigo, genero) VALUES (?,?,?,?,?)";

            
            con = ConexionesFactory.getInstance().getConection();
            
            ps = con.prepareStatement(consulta);

            //ps.setDate(1, (Date) registro.getFechaDeIngreso());
            ps.setString(1, registro.getNombre());
            ps.setString(2, registro.getAutor());
            ps.setInt(3, registro.getPaginas());
            ps.setInt(4, registro.getCodigo());
            ps.setString(5, registro.getGenero());
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOLibro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOLibro.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DAOLibro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOLibro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void actualizar(DTOLibro registro) {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            String consulta = "UPDATE libro SET nombre=?, autor=?, paginas=?,genero=? WHERE codigo=?";
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta);

            ps.setString(1, registro.getNombre());
            ps.setString(2, registro.getAutor());
            ps.setInt(3, registro.getPaginas());
            ps.setString(4, registro.getGenero());
            ps.setInt(5, registro.getCodigo());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOLibro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOLibro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public ArrayList<DTOLibro> obtenerTodo() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //String sql = "SELECT * FROM libro WHERE codigo=?";
            String sql = "SELECT * FROM libro";

            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            ArrayList<DTOLibro> librero = new ArrayList<>();

            while (rs.next()) {
                DTOLibro aux = new DTOLibro(
                        rs.getDate("fechaDeIngreso"),
                        rs.getString("autor"),
                        rs.getInt("paginas"),
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("genero"));
                librero.add(aux);
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
                Logger.getLogger(DAOLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public DTOLibro obtener(int codigo) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM trabajador WHERE id=?";
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            DTOLibro aux = new DTOLibro(
                    rs.getDate("fechaDeIngreso"),
                    rs.getString("autor"),
                    rs.getInt("paginas"),
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("genero"));
            
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
                Logger.getLogger(DAOLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
