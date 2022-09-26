package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Tarjeta;
import connection.DBConnection;

public class TarjetaController implements ITarjetaController {

    @Override
    public String listar(String categoria) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM tarjeta WHERE categoria='"+categoria+"';";

        

        List<String> tarjetas = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id_tarjeta");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int unidades_disponibles = rs.getInt("unidades_disponibles");
                boolean descuento = rs.getBoolean("descuento");
                String codigo_canjeo = rs.getString("codigo_canjeo");
                String ruta_imagen = rs.getString("ruta_imagen");

                Tarjeta tarjeta = new Tarjeta(id, nombre,categoria,precio,unidades_disponibles,descuento,codigo_canjeo,ruta_imagen);

                tarjetas.add(gson.toJson(tarjeta));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(tarjetas);

    }
    
  
}