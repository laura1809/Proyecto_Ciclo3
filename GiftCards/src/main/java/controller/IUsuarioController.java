package controller;

import java.util.Map;

public interface IUsuarioController {
    public String login (String username, String contrasena, String cargo);
    public String register(String username, String contrasena, String nombre, String apellido, String email, double saldo, String cargo);

}

