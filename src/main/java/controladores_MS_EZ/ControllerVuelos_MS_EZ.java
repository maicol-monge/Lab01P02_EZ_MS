/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores_MS_EZ;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelosDAO_MS_EZ.VueloDAO_MS_EZ;
import modelos_MS_EZ.Vuelo_MS_EZ;

/**
 *
 * @author EverZr
 */
@WebServlet(name = "ControllerVuelos_MS_EZ", urlPatterns = {"/ControllerVuelos_MS_EZ"})
public class ControllerVuelos_MS_EZ extends HttpServlet {

    VueloDAO_MS_EZ dao = new VueloDAO_MS_EZ();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        switch (action) {
            case "listar":
                List<Vuelo_MS_EZ> lista = dao.listar();
                request.setAttribute("listaVuelos", lista);
                request.getRequestDispatcher("vuelos/listar.jsp").forward(request, response);
                break;

            case "nuevo":
                request.setAttribute("vuelo", null);
                request.getRequestDispatcher("vuelos/formulario.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Vuelo_MS_EZ vueloEditar = dao.obtenerPorId(idEditar);
                request.setAttribute("vuelo", vueloEditar);
                request.getRequestDispatcher("vuelos/formulario.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("ControllerVuelos_MS_EZ?action=listar");
                break;

            default:
                response.sendRedirect("ControllerVuelos_MS_EZ?action=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");

        Vuelo_MS_EZ v = new Vuelo_MS_EZ();
        v.setNumeroVuelo(request.getParameter("numeroVuelo"));
        v.setAerolinea(request.getParameter("aerolinea"));
        v.setOrigen(request.getParameter("origen"));
        v.setDestino(request.getParameter("destino"));
        v.setFechaSalida(Date.valueOf(request.getParameter("fechaSalida")));
        v.setHoraSalida(Time.valueOf(request.getParameter("horaSalida") + ":00"));
        v.setFechaLlegada(Date.valueOf(request.getParameter("fechaLlegada")));
        v.setHoraLlegada(Time.valueOf(request.getParameter("horaLlegada") + ":00"));
        v.setAvion(request.getParameter("avion"));

        boolean resultado;
        if (idStr == null || idStr.isEmpty()) {
            resultado = dao.insertar(v);
        } else {
            v.setIdVuelo(Integer.parseInt(idStr));
            resultado = dao.actualizar(v);
        }

        if (resultado) {
            response.sendRedirect("ControllerVuelos_MS_EZ?action=listar");
        } else {
            response.getWriter().println("Error al guardar el vuelo");
        }
    }
}
