package com.mycompany.llamadafunctionmysql;

import java.sql.*;

public class LlamadaFunctionMySQL {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexión = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD?allowMultiQueries=true", "root", "San608921482");

            String dep = args[0]; //departamento
            String nomDep = "";
            String sql = "{? = CALL depNombre (?)}";

            CallableStatement llamada = conexión.prepareCall(sql);

            llamada.registerOutParameter(1, Types.VARCHAR);
            llamada.setInt(2, Integer.parseInt(dep));

            llamada.executeUpdate();
            
            System.out.printf("El departamento nº %s corresponde al departamento %s %n", dep, llamada.getString(1));
//            ResultSet rs = llamada.executeQuery();
//
//            while (rs.next()) {
//                System.out.println("El nombre del departamento es " + rs.getString(1));
//            }

            llamada.close();
            conexión.close();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
