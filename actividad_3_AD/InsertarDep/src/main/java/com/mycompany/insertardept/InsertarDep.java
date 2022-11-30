package com.mycompany.insertardept;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santimiquel
 */
public class InsertarDep {

    public static void main(String[] args) {
        String dept = args[0];
        String nomDept = args[1];
        String locDept = args[2];

        int deptValue = Integer.valueOf(dept);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD", "root", "San608921482");
            String sql = "INSERT INTO departamentos VALUES (" + deptValue + ", \'" + nomDept + "\', \'" + locDept + "\');";
            Statement sentencia = conexion.createStatement();
            boolean valor = sentencia.execute(sql);

            if (valor == true) {
                ResultSet rs = sentencia.getResultSet();
                while (rs.next()) {
                    System.out.printf("%d, %s, %s %n", rs.getInt(1), rs.getString(2), rs.getString(3));
                }
                rs.close();
            } else {
                int filasInsert = sentencia.getUpdateCount();
                System.out.printf("Filas insertadas: %d %n", filasInsert);
            }

            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertarDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertarDep.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
