/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos_MS_EZ;

import java.sql.Date;

/**
 *
 * @author EverZr
 */
public class Reservacion_MS_EZ {
    
     private int id;
    private Date fecha;
    private int pasajeroId;

    // Solo para mostrar en la vista
    private String nombrePasajero;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public int getPasajeroId() { return pasajeroId; }
    public void setPasajeroId(int pasajeroId) { this.pasajeroId = pasajeroId; }

    public String getNombrePasajero() { return nombrePasajero; }
    public void setNombrePasajero(String nombrePasajero) { this.nombrePasajero = nombrePasajero; }
    
}
