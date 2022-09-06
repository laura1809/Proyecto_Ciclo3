package beans;

import java.sql.Date;
/**
 *
 * @author Laura
 */
public class Compra {
        private int id_tarjeta;
        private String username;
        private Date fecha_compra;

        public Compra(int id_tarjeta, String username, Date fecha_compra) {
            this.id_tarjeta = id_tarjeta;
            this.username = username;
            this.fecha_compra = fecha_compra;
        }

        public int getId_tarjeta() {
            return id_tarjeta;
        }

        public void setId_tarjeta(int id_tarjeta) {
            this.id_tarjeta = id_tarjeta;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Date getFecha_compra() {
            return fecha_compra;
        }

        public void setFecha_compra(Date fecha_compra) {
            this.fecha_compra = fecha_compra;
        }   
}