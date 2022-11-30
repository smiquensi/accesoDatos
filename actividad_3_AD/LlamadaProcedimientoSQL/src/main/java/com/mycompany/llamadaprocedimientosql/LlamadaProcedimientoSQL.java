package com.mycompany.llamadaprocedimientosql;

import java.sql.*;
import java.text.DecimalFormat;

public class LlamadaProcedimientoSQL {

    public static void main(String[] args) {

        DecimalFormat formato = new DecimalFormat("##,##0.00");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD?allowMultiQueries=true", "root", "San608921482");

            String dep = args[0]; 
            int numDepartamento = Integer.parseInt(dep);
            String sql = "{call NumEmpleados(?,?,?)} "; 

            CallableStatement llamada = conexion.prepareCall(sql);
            llamada.setInt(1, numDepartamento); 
            llamada.registerOutParameter(2, java.sql.Types.INTEGER);
            llamada.registerOutParameter(3, java.sql.Types.FLOAT);

            llamada.executeUpdate();

            String sqlDep = "SELECT * FROM departamentos WHERE dept_no=?";
            PreparedStatement sentencia = conexion.prepareStatement(sqlDep);
            sentencia.setInt(1, numDepartamento);

            ResultSet rs = sentencia.executeQuery();
            if (rs.next() == false) {
                System.out.println("El departamento: " + numDepartamento + " NO existe.");
            } else {

                do {
                    int dept_no = rs.getInt(1);
                    String dnombre = rs.getString(2);
                    String localidad = rs.getString(3);
                    System.out.println("Departamento: " + dept_no + " \tNombre: " + dnombre + " \tLocalidad: " + localidad);
                } while (rs.next());

            }
            System.out.printf("Numero Empleados: %s, Salario Medio: %s %n", llamada.getInt(2), formato.format(llamada.getFloat(3)));
            llamada.close();
            conexion.close();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
