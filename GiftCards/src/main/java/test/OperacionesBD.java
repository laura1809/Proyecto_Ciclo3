package test;

public class OperacionesBD {

    public static void main(String[] args) {

        //TarjetaSQL.insertarTarjeta(1789076520, "Adidas", "Ropa", 18000, 3, 1, "APG56JO142P");
        //TarjetaSQL.actualizarTarjeta(1789076520, "Adidas", "Ropa", 21000, 5, 0, "APG56JO142P");
        //TarjetaSQL.eliminarTarjeta(1789076520);
        //TarjetaSQL.listarTarjeta();
        //UsuarioSQL.insertarUsuario("Wilmer200", "NewPassword", "Wilmer", "Rojas", "wilrr_18@hotmail.com", 60000, "Cliente");
        
        UsuarioSQL.actualizarUsuario("password", "Alejandro", "Ardila", "pop@outlook.com","William204");
        //UsuarioSQL.eliminarUsuario("Wilmer200");
        UsuarioSQL.listarUsuario();
    }

}
