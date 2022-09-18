package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuario;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String contrasena,String cargo) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM usuario WHERE username = '" + username + "'AND contrasena = '" + contrasena + "' AND cargo='"+cargo+"';";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo");
                
                Usuario usuario = new Usuario(username, contrasena, nombre, apellido, email, saldo, cargo);

                return gson.toJson(usuario);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }
    
    @Override 
    public String register(String username, String contrasena, String nombre, String apellido, String email, double saldo, String cargo){
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO usuario VALUES('" + username + "','" + contrasena + "','" + nombre + "','" + apellido + "','" + email + "'," + saldo + ",'" + cargo + "');";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            Usuario usuario = new Usuario(username, contrasena, nombre, apellido, email, saldo, cargo);
            st.close();
            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        
                
        return "false";
    }
}
