/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDAO_MS_EZ;

import db_MS_EZ.CN_MS_EZ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos_MS_EZ.DetalleReservacion_MS_EZ;

/**
 *
 * @author EverZr
 */
public class DetalleReservacionDAO_MS_EZ {

    // Listar detalles por reservación
    public List<DetalleReservacion_MS_EZ> listarPorReservacion(int idReservacion) {
        List<DetalleReservacion_MS_EZ> lista = new ArrayList<>();
        String sql = "SELECT * FROM Detalle_Reservacion WHERE ID_Reservacion = ?";

        try (Connection conn = new CN_MS_EZ().getCon();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idReservacion);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetalleReservacion_MS_EZ d = new DetalleReservacion_MS_EZ();
                    d.setIdDetalle(rs.getInt("ID_Detalle"));
                    d.setIdReservacion(rs.getInt("ID_Reservacion"));
                    d.setIdVuelo(rs.getInt("ID_Vuelo"));
                    d.setAsiento(rs.getString("Asiento"));
                    d.setClase(rs.getString("Clase"));
                    lista.add(d);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar detalles: " + e.getMessage());
        }
        return lista;
    }

    // Obtener detalle por ID
    public DetalleReservacion_MS_EZ obtenerPorId(int id) {
        DetalleReservacion_MS_EZ d = null;
        String sql = "SELECT * FROM Detalle_Reservacion WHERE ID_Detalle = ?";

        try (Connection conn = new CN_MS_EZ().getCon();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    d = new DetalleReservacion_MS_EZ();
                    d.setIdDetalle(rs.getInt("ID_Detalle"));
                    d.setIdReservacion(rs.getInt("ID_Reservacion"));
                    d.setIdVuelo(rs.getInt("ID_Vuelo"));
                    d.setAsiento(rs.getString("Asiento"));
                    d.setClase(rs.getString("Clase"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener detalle: " + e.getMessage());
        }
        return d;
    }

    // Insertar detalle
    public boolean insertar(DetalleReservacion_MS_EZ d) {
        String sql = "INSERT INTO Detalle_Reservacion (ID_Reservacion, ID_Vuelo, Asiento, Clase) VALUES (?,?,?,?)";

        try (Connection conn = new CN_MS_EZ().getCon();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, d.getIdReservacion());
            ps.setInt(2, d.getIdVuelo());
            ps.setString(3, d.getAsiento());
            ps.setString(4, d.getClase());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar detalle: " + e.getMessage());
            return false;
        }
    }

    // Actualizar detalle
    public boolean actualizar(DetalleReservacion_MS_EZ d) {
        String sql = "UPDATE Detalle_Reservacion SET ID_Reservacion=?, ID_Vuelo=?, Asiento=?, Clase=? WHERE ID_Detalle=?";

        try (Connection conn = new CN_MS_EZ().getCon();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, d.getIdReservacion());
            ps.setInt(2, d.getIdVuelo());
            ps.setString(3, d.getAsiento());
            ps.setString(4, d.getClase());
            ps.setInt(5, d.getIdDetalle());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle: " + e.getMessage());
            return false;
        }
    }

    // Eliminar detalle
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Detalle_Reservacion WHERE ID_Detalle = ?";

        try (Connection conn = new CN_MS_EZ().getCon();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar detalle: " + e.getMessage());
            return false;
        }
    }
}
