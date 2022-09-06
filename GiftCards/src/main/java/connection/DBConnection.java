package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Laura
 */
public class DBConnection {
    
    Connection connection;
    static String bd="gift_cards";
    static String port = "3306";
    static String login = "root";
    static String password = "admin";
    
    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:" +this.port + "/" + this.bd;
            connection = DriverManager.getConnection(url,this.login,this.password);
            System.out.println("Conexion");
        } catch (Exception ex){
            System.out.println("Error");
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void desconectar(){
        connection = null;
    }
       
    
}
