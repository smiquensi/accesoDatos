package com.mycompany.manejosmysql_fk;

import java.sql.*;

/**
 *
 * @author santimiquel
 */
public class ManejosMySQL_FK {

    public static void main(String[] args) {
         try {
            String tabla = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD", "root", "San608921482");

            DatabaseMetaData dbmd = conexion.getMetaData();

            ResultSet pk;
            pk = dbmd.getPrimaryKeys("ejercicio3_AD", null, "departamentos");
            while (pk.next()) {                
                System.out.println("La clave primaria de la tabla: " + pk.getString(3) +  ", es la columna: " + pk.getString(4)+".");
            }
            pk.close();
            conexion.close();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
