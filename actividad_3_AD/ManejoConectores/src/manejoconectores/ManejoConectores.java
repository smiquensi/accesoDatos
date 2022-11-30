/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manejoconectores;

import java.sql.*;

/**
 *
 * @author santimiquel
 */
public class ManejoConectores {

    public static void main(String[] args) {
        try {
            //Cargar driver
            Class.forName(("com.mysql.jbdc.Driver"));
            // Establecer conexión con la BD
            Connection conexion = DriverManager.getConnection("jbdc:mysql://localhost:3306/ejercicio3_AD", "root", "San608921482");
            // Preparamos la cosulta
            Statement sentecia = conexion.createStatement();
            String sql = "SELECT * FROM departamentos";
            ResultSet resul = sentecia.executeQuery(sql);
            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros y se van mostrando
            while (resul.next()) {
                System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
            }
            resul.close();
            sentecia.close();
            conexion.close();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
