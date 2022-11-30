/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.ejemploresultsetmetadata2;

import java.sql.*;

/**
 *
 * @author santimiquel
 */
public class EjemploResultSetMetaData2 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio3_AD", "root", "San608921482");
            getResultSetMetaData(con);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        }
        
    }

    public static void getResultSetMetaData(Connection con) {
        try ( Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM empleados;";

            ResultSet rs = stmt.executeQuery(SQL);
            ResultSetMetaData rsmd = rs.getMetaData();

            // Display the column name and type.
            int cols = rsmd.getColumnCount();
            for (int i = 1; i <= cols; i++) {
                System.out.println("NAME: " + rsmd.getColumnName(i) + " " + "TYPE: " + rsmd.getColumnTypeName(i));
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
