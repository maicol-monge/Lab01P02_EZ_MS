/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author EverZr
 */
public class Pasajero {
    
    private int id;
    private String nombre;
    private String nacionalidad;
    private String pasaporte;

    public Pasajero() {}

    public Pasajero(int id, String nombre, String nacionalidad, String pasaporte) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.pasaporte = pasaporte;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public String getPasaporte() { return pasaporte; }
    public void setPasaporte(String pasaporte) { this.pasaporte = pasaporte; }
    
}
