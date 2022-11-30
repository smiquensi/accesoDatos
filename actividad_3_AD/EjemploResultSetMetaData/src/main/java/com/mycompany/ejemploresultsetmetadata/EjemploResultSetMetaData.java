/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.ejemploresultsetmetadata;

import java.sql.*;

/**
 *
 * @author santimiquel
 */
public class EjemploResultSetMetaData {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD", "root", "San608921482");
            Statement sentecia = conexion.createStatement();
            ResultSet rs = sentecia.executeQuery("SELECT * FROM empleados;");
            ResultSetMetaData rsmd = rs.getMetaData();

            int nColumns = rsmd.getColumnCount();
            String nula;
            System.out.printf("Numero de columnas recuperadas: %d%n", nColumns);
            for (int i = 1; i < nColumns; i++) {
                System.out.printf("Columna: %d %n", i);
                System.out.printf("Nombre: %s %n", rsmd.getColumnName(i));
                System.out.printf("Tipo: %s %n", rsmd.getColumnTypeName(i));
                if (rsmd.isNullable(i) == 0) {
                    nula = "NO";
                } else {
                    nula = "SI";
                }
                System.out.printf("Puede ser nula? : %s %n", nula);
                System.out.printf("Maximo ancho de la columna: %d %n", rsmd.getColumnDisplaySize(i));
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
