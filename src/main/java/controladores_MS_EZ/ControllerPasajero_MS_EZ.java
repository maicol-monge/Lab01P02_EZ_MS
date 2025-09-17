/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores_MS_EZ;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos_MS_EZ.Pasajero_MS_EZ;
import modelosDAO_MS_EZ.PasajeroDAO_MS_EZ;

/**
 *
 * @author EverZr
 */
@WebServlet(name = "ControllerPasajero", urlPatterns = {"/ControllerPasajero"})
public class ControllerPasajero_MS_EZ extends HttpServlet { private PasajeroDAO_MS_EZ dao = new PasajeroDAO_MS_EZ();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) action = "listar";

        switch (action) {
            case "nuevo":
                request.getRequestDispatcher("pasajero/formulario.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Pasajero_MS_EZ pasajero = dao.obtenerPorId(idEditar);
                request.setAttribute("pasajero", pasajero);
                request.getRequestDispatcher("pasajero/formulario.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("ControllerPasajero?action=listar");
                break;

            default:
                List<Pasajero_MS_EZ> lista = dao.listar();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("pasajero/listar.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = request.getParameter("id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String nacionalidad = request.getParameter("nacionalidad");
        String pasaporte = request.getParameter("pasaporte");

        Pasajero_MS_EZ pasajero = new Pasajero_MS_EZ(id, nombre, nacionalidad, pasaporte);

        if (id == 0) {
            dao.insertar(pasajero);
        } else {
            dao.actualizar(pasajero);
        }
        response.sendRedirect("ControllerPasajero?action=listar");
    }
}
