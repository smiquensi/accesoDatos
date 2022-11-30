package com.mycompany.modificarsalario;

import java.sql.*;

/**
 *
 * @author santimiquel
 */
public class ModificarSalario {

    public static void main(String[] args) {
        String dept = args[0];

        int deptValue = Integer.valueOf(dept);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD", "root", "San608921482");
            String sql = "UPDATE empleados SET salario = salario + 100 WHERE dept_no = " + deptValue + ";";
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
            ex.printStackTrace();
        } catch (SQLException es) {
            es.printStackTrace();
          
        }

    }
}
