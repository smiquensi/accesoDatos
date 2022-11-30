package com.mycompany.manejoconectoresmaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author santimiquel
 */
public class ManejoConectoresMaven {

    public static void main(String[] args) {
        try {
            //Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer conexión con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio3_AD", "root", "San608921482");
            // Preparamos la cosulta
//            Statement sentecia = conexion.createStatement();
//            String sql = "SELECT * FROM departamentos";
//            ResultSet resul = sentecia.executeQuery(sql);
            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros y se van mostrando
//            while (resul.next()) {
//                System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
//            }
//            resul.close();
//            sentecia.close();
//            conexion.close();

            Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM departamentos";
            ResultSet result = sentencia.executeQuery(query);
            result.last(); //Nos situamos en el último registro 
            System.out.println("NUMERO DE FILAS: " + result.getRow());
            result.beforeFirst(); //Nos situamos antes del primer registro //Recorremos el resultado para visualizar cada fila
            while (result.next()) {
                System.out.printf("Fila %d: %d, %s, %s %n", 
                        result.getRow(),
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3));
            }
            result.close();
            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
