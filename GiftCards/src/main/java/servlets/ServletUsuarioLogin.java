package servlets;

import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletUsuarioLogin")
public class ServletUsuarioLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public ServletUsuarioLogin() {
        super();
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioController usuario = new UsuarioController();
        String username = request.getParameter("username");
        String contrasena = request.getParameter("contrasena");
        String cargo = request.getParameter("cargo");
       
        String result = usuario.login(username, contrasena,cargo);
        

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
    }

    

}
