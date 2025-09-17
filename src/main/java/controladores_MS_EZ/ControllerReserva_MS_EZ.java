/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores_MS_EZ;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos_MS_EZ.Reservacion_MS_EZ;
import modelosDAO_MS_EZ.PasajeroDAO_MS_EZ;
import modelosDAO_MS_EZ.ReservacionDAO_MS_EZ;

/**
 *
 * @author EverZr
 */
@WebServlet(name = "ControllerReserva", urlPatterns = {"/ControllerReserva"})
public class ControllerReserva_MS_EZ extends HttpServlet {

private ReservacionDAO_MS_EZ dao = new ReservacionDAO_MS_EZ();
    private PasajeroDAO_MS_EZ pasajeroDAO = new PasajeroDAO_MS_EZ(); // Para combos en formularios

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "nuevo":
                request.setAttribute("pasajeros", pasajeroDAO.listar()); // Combo de pasajeros
                request.getRequestDispatcher("reservacion/formulario.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("reservacion", dao.obtenerPorId(idEditar));
                request.setAttribute("pasajeros", pasajeroDAO.listar());
                request.getRequestDispatcher("reservacion/formulario.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("ControllerReserva?action=listar");
                break;

            default:
                request.setAttribute("lista", dao.listar());
                request.getRequestDispatcher("reservacion/listar.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = request.getParameter("id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("id"));
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        int pasajeroId = Integer.parseInt(request.getParameter("pasajeroId"));

        Reservacion_MS_EZ reservacion = new Reservacion_MS_EZ();
        reservacion.setId(id);
        reservacion.setFecha(fecha);
        reservacion.setPasajeroId(pasajeroId);

        if (id == 0) {
            dao.insertar(reservacion);
        } else {
            dao.actualizar(reservacion);
        }
        response.sendRedirect("ControllerReserva?action=listar");
    }

}
