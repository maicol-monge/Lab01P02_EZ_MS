/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db_MS_EZ;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author EverZr
 */
public class CN_MS_EZ {

    private Connection con;

    public CN_MS_EZ() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String cadena = "jdbc:mysql://localhost:3306/sistema_vuelos";
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
