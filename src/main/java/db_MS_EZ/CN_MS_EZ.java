/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author EverZr
 */
public class CN {

    private Connection con;

    public CN() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String cadena = "jdbc:mysql://localhost:3306/reservavuelos";
            this.con = DriverManager.getConnection(cadena, "root", "");
//terminado la guía borrar esta línea
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
//terminado la guía borrar esta línea
            System.out.println("Erro no conectado");
        }
    }

    public Connection getCon() {
        return this.con;
    }
}
