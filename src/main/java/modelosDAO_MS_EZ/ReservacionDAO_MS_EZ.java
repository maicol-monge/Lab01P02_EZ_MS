/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDAO;

import db.CN;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import modelos.Reservacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author EverZr
 */
public class ReservacionDAO {
     public List<Reservacion> listar() {
        List<Reservacion> lista = new ArrayList<>();
        String sql = "SELECT r.ID_Reservacion, r.Fecha_Reservacion, r.Pasajero_ID, p.Nombre_Pasajero " +
                     "FROM Reservaciones_Vuelos r " +
                     "INNER JOIN Pasajeros p ON r.Pasajero_ID = p.ID_Pasajero";

        try (Connection con = new CN().getCon(); // 👈 Usar solo este método
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reservacion r = new Reservacion();
                r.setId(rs.getInt("ID_Reservacion"));
                r.setFecha(rs.getDate("Fecha_Reservacion"));
                r.setPasajeroId(rs.getInt("Pasajero_ID"));
                r.setNombrePasajero(rs.getString("Nombre_Pasajero")); 
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insertar(Reservacion r) {
        String sql = "INSERT INTO Reservaciones_Vuelos (Fecha_Reservacion, Pasajero_ID) VALUES (?, ?)";
        try (Connection con = new CN().getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, r.getFecha());
            ps.setInt(2, r.getPasajeroId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Reservacion r) {
        String sql = "UPDATE Reservaciones_Vuelos SET Fecha_Reservacion=?, Pasajero_ID=? WHERE ID_Reservacion=?";
        try (Connection con = new CN().getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, r.getFecha());
            ps.setInt(2, r.getPasajeroId());
            ps.setInt(3, r.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Reservaciones_Vuelos WHERE ID_Reservacion=?";
        try (Connection con = new CN().getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Reservacion obtenerPorId(int id) {
        String sql = "SELECT * FROM Reservaciones_Vuelos WHERE ID_Reservacion=?";
        try (Connection con = new CN().getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reservacion r = new Reservacion();
                r.setId(rs.getInt("ID_Reservacion"));
                r.setFecha(rs.getDate("Fecha_Reservacion"));
                r.setPasajeroId(rs.getInt("Pasajero_ID"));
                return r;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
