package com.mycompany.manejoprocedure;

import java.sql.*;

public class ManejoProcedure {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio3_AD", "root", "San608921482");

            Statement sentencia = conexion.createStatement();
            String borrarProcedure = "DROP PROCEDURE IF EXISTS incrementoSueldo"; // sentencia para eliminar procedure si existe

            String subida = "CREATE PROCEDURE incrementoSueldo()\n"
                    + "BEGIN\n"
                    + "SET SQL_SAFE_UPDATES=0;\n"
                    + "UPDATE empleados\n"
                    + "SET salario = salario + 100\n"
                    + "WHERE dept_no = 30;\n"
                    + "END";
            sentencia.executeUpdate(borrarProcedure);
            sentencia.executeUpdate(subida);

            //Seleccionamos los campos que queremos mostrar de la tabla empleados        
            String mostrarEmpleados = "SELECT apellido, salario, dept_no FROM empleados WHERE dept_no = 30;";
            ResultSet resultPre = sentencia.executeQuery(mostrarEmpleados); //ejecutamos el query anterior para ver los salarios previos
            // Mostramos la información de apellido y salario antes de la subida
            System.out.println("DATOS ANTES DE LA SUBIDA DE SALARIO:");
            while (resultPre.next()) {
                System.out.printf("\tApellido: %s \tSalario: %d \tDepartamento: %d\n", resultPre.getString("apellido"), resultPre.getInt("salario"), resultPre.getInt("dept_no"));
            }

            // Realizamos la subida 
            sentencia.executeQuery("CALL incrementoSueldo()"); //ejecutamos el procedimiento subida
            ResultSet resultPost = sentencia.executeQuery(mostrarEmpleados); 
            System.out.println("\nDATOS DESPUES DE LA SUBIDA DE SALARIO:");
            while (resultPost.next()) {
                System.out.printf("\tApellido: %s \tSalario: %d \tDepartamento: %d\n", resultPost.getString("apellido"), resultPost.getInt("salario"), resultPost.getInt("dept_no"));
            }

            
            resultPost.close();
            resultPre.close();
            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
