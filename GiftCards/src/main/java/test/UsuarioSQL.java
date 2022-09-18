package test;

import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import beans.Usuario;

/**
 *
 * @author Laura
 */
public class UsuarioSQL {

    //Método para insertar un nuevo usuario en la BD
    public static void insertarUsuario(String username, String contrasena, String nombre, String apellido, String email, double saldo, String cargo) {
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO usuario VALUES('" + username + "','" + contrasena + "','" + nombre + "','" + apellido + "','" + email + "'," + saldo + ",'" + cargo + "');";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    //Método para listar todas las tarjetas en la BD
    public static void listarUsuario() {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM usuario;";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("username");
                String contrasena = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo");
                String cargo = rs.getString("cargo");

                Usuario usuario = new Usuario(username, contrasena, nombre, apellido, email, saldo, cargo);
                System.out.println(usuario.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    //Método para actualizar los datos de un usuario en la BD
    public static void actualizarUsuario(String contrasena, String nombre, String apellido, String email,String username) {
        DBConnection con = new DBConnection();
        String sql = "UPDATE Usuario SET contrasena='" + contrasena + "',nombre='" + nombre + "',apellido='" + apellido + "',email='" + email + "' WHERE Username=\"" + username + "\";";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            System.out.println("listo");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }
    
     //Método para actualizar los datos de un usuario en la BD
    public static void eliminarUsuario(String username) {
        DBConnection con = new DBConnection();
        String sql = "DELETE FROM usuario WHERE Username=\"" + username + "\";";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            System.out.println("listo");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

}
