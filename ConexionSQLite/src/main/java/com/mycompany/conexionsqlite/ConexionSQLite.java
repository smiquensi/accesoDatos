package com.mycompany.conexionsqlite;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionSQLite {

    public static void main(String[] args) {
try {
            //Cargar driver
            Class.forName("org.sqlite.JDBC");
            // Establecer conexión con la BD
            Connection conexion = DriverManager.getConnection("jdbc:sqlite://Users/santimiquel/BD/actividad_1_AD");
            // Preparamos la cosulta
            Statement sentecia = conexion.createStatement();
            String sql = "SELECT * FROM departamentos";
            ResultSet resul = sentecia.executeQuery(sql);
            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros y se van mostrando
            while (resul.next()) {
                System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
            }
            

            resul.close();
            sentecia.close();
            conexion.close();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
