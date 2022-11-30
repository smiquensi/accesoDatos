/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ejemplogetmetada;

import com.mysql.cj.jdbc.DatabaseMetaData;
import java.sql.*;


/**
 *
 * @author santimiquel
 */
public class EjemploGetMetada {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio3_AD", "root", "San608921482");
            
            DatabaseMetaData dbmd = (DatabaseMetaData) conexion.getMetaData();
            ResultSet resul = null;
            String nombre = dbmd.getDatabaseProductName ();
            String driver = dbmd.getDriverName(); 
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();
            
            
            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:"); 
            System.out.println(" =================================="); 
            System.out.printf("Nombre: %s %n", nombre); 
            System.out.printf("Driver: %s %n", driver); 
            System.out.printf("URL: %s %n", url); 
            System.out.printf("Usuario: %s %n", usuario);
            
            
            //Obtener información de las tablas y vistas que hay 
            resul = dbmd.getTables("ejercicio3_AD", null, null, null); 
            while (resul.next()) {
                String catalogo = resul.getString(1); //columna1 
                String esquema = resul.getString(2); //columna2 
                String tabla = resul.getString(3); //columna3 
                String tipo = resul.getString(4); //columna4
                System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
            }
            
            System.out.println ("COLUMNAS TABLA DEPARTAMENTOS:");
            System.out.println("================================"); 
            ResultSet columnas=null;
            columnas = dbmd.getColumns("ejercicio3_AD", null, "departamentos", null); 
            while (columnas.next()){
                String nombCol = columnas.getString ("COLUMN_NAME"); // getString(4) 
                String tipoCol = columnas.getString ("TYPE_NAME"); //getString(6) 
                String tamCol = columnas.getString ("COLUMN_SIZE"); // getString(7) 
                String nula = columnas.getString ("IS_NULLABLE"); // getString(18) 
                System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s,¿Puede ser Nula: ? %s %n", nombCol, tipoCol, tamCol, nula); }
            
            ResultSet pk = null;
            pk = dbmd.getPrimaryKeys("ejercicio3_AD", null, "departamentos");
            ResultSetMetaData rsmd = pk.getMetaData();
            
            int cols = rsmd.getColumnCount();
            while (pk.next()) {
                for (int i = 1; i <= cols; i++) {
                    System.out.println(pk.getString(i));
                }
                
            }
//            while (pk.next()) {
//                String pkString = pk.getString("pk");
//                System.out.println(pkString);
//            }
            
            conexion.close();
            
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
