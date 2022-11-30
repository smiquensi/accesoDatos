package com.mycompany.visualizarpreparedstatement;

import java.sql.*;
import java.text.DecimalFormat;

public class VisualizarPreparedStatement {

    public static void main(String[] args) {
        String dep = args[0];
        int departamento = Integer.parseInt(dep);
        DecimalFormat formato = new DecimalFormat("##,##0.00");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD?allowMultiQueries=true", "root", "San608921482");
            String sql = "SELECT apellido, salario, oficio FROM empleados WHERE dept_no = ? ;";

            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, departamento);

            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                do {
                    String apellido = rs.getString(1);
                    Float salario = rs.getFloat(2);
                    String oficio = rs.getString(3);
                    String salarioFormat = formato.format(salario);
                    System.out.printf("Apellido: %s \tSalario: %s \tOficio: %s \n", apellido, salarioFormat, oficio);
                } while (rs.next());
                getMediaEmpl(conexion, departamento);
            } else {
                System.out.printf("El departamento: %d NO existe en esta tabla", departamento);
            }
        } catch (SQLException es) {
            es.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getMediaEmpl(Connection conexion, int departamento) throws SQLException {
        int totalEmpleados = 0;
        float mediaSueldo = 0f;
        String sqlMediaSueldo = "SELECT count(emp_no), avg(salario) FROM empleados WHERE dept_no = ? ;";
        PreparedStatement sentMediaEmp =  conexion.prepareStatement(sqlMediaSueldo);
        sentMediaEmp.setInt(1, departamento);
        ResultSet rsMediaEmp = sentMediaEmp.executeQuery();
        while (rsMediaEmp.next()) {
            totalEmpleados = rsMediaEmp.getInt(1);
            mediaSueldo = rsMediaEmp.getFloat(2);
            
        }
        System.out.printf("\nEn el departamento %s hay %d empleados.%n", departamento, totalEmpleados);
        System.out.printf("En el departamento %s tiene una media de sueldo de %.2f.%n", departamento, mediaSueldo);
    }
}
