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
import modelos_MS_EZ.Pasajero_MS_EZ;

/**
 *
 * @author EverZr
 */
public class PasajeroDAO_MS_EZ {
    public List<Pasajero_MS_EZ> listar() {
        List<Pasajero_MS_EZ> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pasajeros";

        try (Connection con = new CN_MS_EZ().getCon();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pasajero_MS_EZ p = new Pasajero_MS_EZ(
                    rs.getInt("ID_Pasajero"),
                    rs.getString("Nombre_Pasajero"),
                    rs.getString("Nacionalidad"),
                    rs.getString("Pasaporte")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insertar(Pasajero_MS_EZ p) {
        String sql = "INSERT INTO Pasajeros (Nombre_Pasajero, Nacionalidad, Pasaporte) VALUES (?, ?, ?)";
        try (Connection con = new CN_MS_EZ().getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getNacionalidad());
            ps.setString(3, p.getPasaporte());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Pasajero_MS_EZ p) {
        String sql = "UPDATE Pasajeros SET Nombre_Pasajero=?, Nacionalidad=?, Pasaporte=? WHERE ID_Pasajero=?";
        try (Connection con = new CN_MS_EZ().getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getNacionalidad());
            ps.setString(3, p.getPasaporte());
            ps.setInt(4, p.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Pasajeros WHERE ID_Pasajero=?";
        try (Connection con = new CN_MS_EZ().getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Pasajero_MS_EZ obtenerPorId(int id) {
        String sql = "SELECT * FROM Pasajeros WHERE ID_Pasajero=?";
        try (Connection con = new CN_MS_EZ().getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Pasajero_MS_EZ(
                    rs.getInt("ID_Pasajero"),
                    rs.getString("Nombre_Pasajero"),
                    rs.getString("Nacionalidad"),
                    rs.getString("Pasaporte")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
