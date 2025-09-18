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
import modelos_MS_EZ.Vuelo_MS_EZ;

/**
 *
 * @author EverZr
 */
public class VueloDAO_MS_EZ {

    // Listar todos los vuelos
    public List<Vuelo_MS_EZ> listar() {
        List<Vuelo_MS_EZ> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vuelos";

        try (Connection conn = new CN_MS_EZ().getCon();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vuelo_MS_EZ v = new Vuelo_MS_EZ();
                v.setIdVuelo(rs.getInt("ID_Vuelo"));
                v.setNumeroVuelo(rs.getString("Numero_Vuelo"));
                v.setAerolinea(rs.getString("Aerolinea"));
                v.setOrigen(rs.getString("Origen"));
                v.setDestino(rs.getString("Destino"));
                v.setFechaSalida(rs.getDate("Fecha_Salida"));
                v.setHoraSalida(rs.getTime("Hora_Salida"));
                v.setFechaLlegada(rs.getDate("Fecha_Llegada"));
                v.setHoraLlegada(rs.getTime("Hora_Llegada"));
                v.setAvion(rs.getString("Avion"));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar vuelos: " + e.getMessage());
        }
        return lista;
    }

    // Obtener vuelo por ID
    public Vuelo_MS_EZ obtenerPorId(int id) {
        Vuelo_MS_EZ v = null;
        String sql = "SELECT * FROM Vuelos WHERE ID_Vuelo = ?";

        try (Connection conn = new CN_MS_EZ().getCon();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    v = new Vuelo_MS_EZ();
                    v.setIdVuelo(rs.getInt("ID_Vuelo"));
                    v.setNumeroVuelo(rs.getString("Numero_Vuelo"));
                    v.setAerolinea(rs.getString("Aerolinea"));
                    v.setOrigen(rs.getString("Origen"));
                    v.setDestino(rs.getString("Destino"));
                    v.setFechaSalida(rs.getDate("Fecha_Salida"));
                    v.setHoraSalida(rs.getTime("Hora_Salida"));
                    v.setFechaLlegada(rs.getDate("Fecha_Llegada"));
                    v.setHoraLlegada(rs.getTime("Hora_Llegada"));
                    v.setAvion(rs.getString("Avion"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener vuelo: " + e.getMessage());
        }
        return v;
    }

    // Insertar vuelo
    public boolean insertar(Vuelo_MS_EZ v) {
        String sql = "INSERT INTO Vuelos (Numero_Vuelo, Aerolinea, Origen, Destino, Fecha_Salida, Hora_Salida, Fecha_Llegada, Hora_Llegada, Avion) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conn = new CN_MS_EZ().getCon();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getNumeroVuelo());
            ps.setString(2, v.getAerolinea());
            ps.setString(3, v.getOrigen());
            ps.setString(4, v.getDestino());
            ps.setDate(5, v.getFechaSalida());
            ps.setTime(6, v.getHoraSalida());
            ps.setDate(7, v.getFechaLlegada());
            ps.setTime(8, v.getHoraLlegada());
            ps.setString(9, v.getAvion());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar vuelo: " + e.getMessage());
            return false;
        }
    }

    // Actualizar vuelo
    public boolean actualizar(Vuelo_MS_EZ v) {
        String sql = "UPDATE Vuelos SET Numero_Vuelo=?, Aerolinea=?, Origen=?, Destino=?, Fecha_Salida=?, Hora_Salida=?, Fecha_Llegada=?, Hora_Llegada=?, Avion=? WHERE ID_Vuelo=?";

        try (Connection conn = new CN_MS_EZ().getCon();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getNumeroVuelo());
            ps.setString(2, v.getAerolinea());
            ps.setString(3, v.getOrigen());
            ps.setString(4, v.getDestino());
            ps.setDate(5, v.getFechaSalida());
            ps.setTime(6, v.getHoraSalida());
            ps.setDate(7, v.getFechaLlegada());
            ps.setTime(8, v.getHoraLlegada());
            ps.setString(9, v.getAvion());
            ps.setInt(10, v.getIdVuelo());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar vuelo: " + e.getMessage());
            return false;
        }
    }

    // Eliminar vuelo
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Vuelos WHERE ID_Vuelo = ?";

        try (Connection conn = new CN_MS_EZ().getCon();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar vuelo: " + e.getMessage());
            return false;
        }
    }
}
