package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.TarjetaController;

@WebServlet("/ServletTarjetaListar")
public class ServletTarjetaListar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletTarjetaListar() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TarjetaController tarjeta = new TarjetaController();

        String categoria = request.getParameter("categoria");

        String tarjetaStr = tarjeta.listar(categoria);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(tarjetaStr);
        out.flush();
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
