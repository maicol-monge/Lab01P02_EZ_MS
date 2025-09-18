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
import modelosDAO_MS_EZ.DetalleReservacionDAO_MS_EZ;
import modelosDAO_MS_EZ.VueloDAO_MS_EZ;
import modelos_MS_EZ.DetalleReservacion_MS_EZ;

/**
 *
 * @author EverZr
 */
@WebServlet(name = "ControllerDetalleReservacion_MS_EZ", urlPatterns = {"/ControllerDetalleReservacion_MS_EZ"})
public class ControllerDetalleReservacion_MS_EZ extends HttpServlet {

    DetalleReservacionDAO_MS_EZ dao = new DetalleReservacionDAO_MS_EZ();
    VueloDAO_MS_EZ vueloDAO = new VueloDAO_MS_EZ();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        switch (action) {
            case "listar":
                int idReservacion = Integer.parseInt(request.getParameter("idReservacion"));
                List<DetalleReservacion_MS_EZ> lista = dao.listarPorReservacion(idReservacion);
                request.setAttribute("listaDetalles", lista);
                request.setAttribute("idReservacion", idReservacion);
                request.getRequestDispatcher("detalleReservacion/listar.jsp").forward(request, response);
                break;

            case "nuevo":
                int idRes = Integer.parseInt(request.getParameter("idReservacion"));
                request.setAttribute("idReservacion", idRes);
                request.setAttribute("listaVuelos", vueloDAO.listar());
                request.setAttribute("detalle", null);
                request.getRequestDispatcher("detalleReservacion/formulario.jsp").forward(request, response);
                break;

            case "editar":
                int idDetalle = Integer.parseInt(request.getParameter("id"));
                DetalleReservacion_MS_EZ detalle = dao.obtenerPorId(idDetalle);
                request.setAttribute("detalle", detalle);
                request.setAttribute("listaVuelos", vueloDAO.listar());
                request.setAttribute("idReservacion", detalle.getIdReservacion());
                request.getRequestDispatcher("detalleReservacion/formulario.jsp").forward(request, response);
                break;

            case "eliminar":
                int idDel = Integer.parseInt(request.getParameter("id"));
                int idResEliminar = Integer.parseInt(request.getParameter("idReservacion"));
                dao.eliminar(idDel);
                response.sendRedirect("ControllerDetalleReservacion_MS_EZ?action=listar&idReservacion=" + idResEliminar);
                break;

            default:
                response.sendRedirect("ControllerDetalleReservacion_MS_EZ?action=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idDetalleStr = request.getParameter("idDetalle");

        DetalleReservacion_MS_EZ d = new DetalleReservacion_MS_EZ();
        d.setIdReservacion(Integer.parseInt(request.getParameter("idReservacion")));
        d.setIdVuelo(Integer.parseInt(request.getParameter("idVuelo")));
        d.setAsiento(request.getParameter("asiento"));
        d.setClase(request.getParameter("clase"));

        boolean resultado;
        if (idDetalleStr == null || idDetalleStr.isEmpty()) {
            resultado = dao.insertar(d);
        } else {
            d.setIdDetalle(Integer.parseInt(idDetalleStr));
            resultado = dao.actualizar(d);
        }

        if (resultado) {
            response.sendRedirect("ControllerDetalleReservacion_MS_EZ?action=listar&idReservacion=" + d.getIdReservacion());
        } else {
            response.getWriter().println("Error al guardar detalle de reservación");
        }
    }
}