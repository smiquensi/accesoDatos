/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.pruebasresultselect;

import java.sql.*;

/**
 *
 * @author santimiquel
 */
public class PruebasResultSelect {

    public static void main(String[] args) {
        try {
            String tabla = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD", "root", "San608921482");

            Statement consulta = conexion.createStatement();
            ResultSet resu = consulta.executeQuery("SELECT * FROM empleados;");
            ResultSetMetaData rsmd = resu.getMetaData();
            int columns = rsmd.getColumnCount();

            while (resu.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(resu.getString(i) + "-");
                }
                System.out.println("");
            }

            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet rs = dbmd.getPseudoColumns("ejercicio3_AD", null, "empleados", null);
            ResultSetMetaData rsmd2 = rs.getMetaData();
            int cols = rsmd2.getColumnCount();
            System.out.println(cols);
            
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rsmd2.getColumnName(i) + "-");
                }
                System.out.println("");
            }

//
//            while (resu.next()) {
//                System.out.print(resu.getString(1) + "-");
//                System.out.print(resu.getString(2) + "-");
//                System.out.print(resu.getString(3) + "-");
//                System.out.print(resu.getString(4) + "-");
//                System.out.print(resu.getString(5) + "-");
//                System.out.print(resu.getString(6) + "-");
//                System.out.print(resu.getString(7) + "-");
//                System.out.print(resu.getString(8) + "-");
//                System.out.println("");
//
//            }
//            DatabaseMetaData dbmd = conexion.getMetaData();
//            ResultSet pk;
//            pk = dbmd.getColumns("ejercicio3_AD", null, "empleados", null);
//            while (pk.next()) {
//                System.out.println(pk.getString(1));
//                System.out.println(pk.getString(2));
//                System.out.println(pk.getString(3));
//                System.out.println(pk.getString(4));
//                System.out.println(pk.getString(5));
//                System.out.println(pk.getString(6));
//                System.out.println(pk.getString(7));
//                System.out.println(pk.getString(8));
//                System.out.println(pk.getString(9));
//                System.out.println(pk.getString(10));
//                System.out.println(pk.getString(11));
//                System.out.println(pk.getString(12));
//                System.out.println(pk.getString(13));
//                System.out.println(pk.getString(14));
//                System.out.println(pk.getString(15));
//                System.out.println(pk.getString(16));
//                System.out.println(pk.getString(17));
//                System.out.println(pk.getString(18));
//                System.out.println(pk.getString(19));
//                System.out.println(pk.getString(12));
//                System.out.println(pk.getString(21));
//                
//                System.out.println("");
//                System.out.println("Esto de antes");
//                String tablas = pk.getString(7);
//                String foreKey = pk.getString(4);
//                System.out.println("Tablas que referencian a la tabla departamentos: " + tablas);
//                System.out.println("Clave ajena que referencia a la tabla departamentos: " + foreKey);
//            }
//            pk.close();
            conexion.close();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
