package test;

import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import beans.Tarjeta;

/**
 *
 * @author Laura
 */
public class TarjetaSQL {

    //Método para listar todas las tarjetas en la BD
    public static void listarTarjeta() {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM tarjeta;";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id_tarjeta = rs.getInt("id_tarjeta");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int unidades_disponibles = rs.getInt("unidades_disponibles");
                boolean descuento = rs.getBoolean("descuento");
                String codigo_canjeo = rs.getString("codigo_canjeo");

                Tarjeta tarjeta = new Tarjeta(id_tarjeta, nombre, categoria, precio, unidades_disponibles, descuento, codigo_canjeo);
                System.out.println(tarjeta.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    //Método para insertar una nueva tarjeta en la BD
    public static void insertarTarjeta(int id_tarjeta, String nombre, String categoria, double precio, int unidades_disponibles, int descuento, String codigo_canjeo) {
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO tarjeta VALUES(" + id_tarjeta + ",'" + nombre + "','" + categoria + "'," + precio + "," + unidades_disponibles + "," + descuento + ",'" + codigo_canjeo + "');";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    //Método para actualizar los datos de una tarjeta en la BD
    public static void actualizarTarjeta(int id_tarjeta, String nombre, String categoria, double precio, int unidades_disponibles, int descuento, String codigo_canjeo) {
        DBConnection con = new DBConnection();
        String sql = "UPDATE tarjeta SET nombre='" + nombre + "',categoria='" + categoria + "',precio=" + precio + ",unidades_disponibles=" + unidades_disponibles + ",descuento=" + descuento + ",codigo_canjeo='" + codigo_canjeo + "'WHERE id_tarjeta="+id_tarjeta+";";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }
}
