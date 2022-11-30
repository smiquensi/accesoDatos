package com.mycompany.manejomysql_pk;

//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author santimiquel
 */
public class ManejoMySQL_PK {

    public static void main(String[] args) {
        try {
            String tabla = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD", "root", "San608921482");

            DatabaseMetaData dbmd = conexion.getMetaData();

            ResultSet pk;
            pk = dbmd.getExportedKeys("ejercicio3_AD", null, "departamentos");
            while (pk.next()) {
                String tablas = pk.getString(7);
                String foreKey = pk.getString(4);
                System.out.println("Tablas que referencian a la tabla departamentos: " + tablas);
                System.out.println("Clave ajena que referencia a la tabla departamentos: " + foreKey);
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
