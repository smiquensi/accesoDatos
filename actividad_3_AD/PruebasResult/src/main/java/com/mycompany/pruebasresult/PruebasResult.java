/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.pruebasresult;

import java.sql.*;

/**
 *
 * @author santimiquel
 */
public class PruebasResult {

    public static void main(String[] args) {
        try {
            String tabla = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD", "root", "San608921482");

            DatabaseMetaData dbmd = conexion.getMetaData();

            ResultSet resul = null;
            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();
            String separadorCatalogo = dbmd.getCatalogSeparator();
            String catalogoTerm = dbmd.getCatalogTerm();
//            ResultSet catalog = dbmd.getCatalogs();

            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
            System.out.println(" ==================================");
            System.out.printf("CatalogTerm: %s %n", catalogoTerm);

            System.out.printf("Nombre: %s %n", nombre);
            System.out.printf("Driver: %s %n", driver);
            System.out.printf("URL: %s %n", url);
            System.out.printf("Usuario: %s %n", usuario);

            System.out.printf("%nMAS INFO:%n%n");
            resul = dbmd.getTables("ejercicio3_AD", null, null, null);
            while (resul.next()) {
                String catalogo = resul.getString(1);
                String esquema = resul.getString(2);
                tabla = resul.getString(3);
                String tipo = resul.getString(4);
                System.out.printf("%s – Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
            }
            
            System.out.println("\nINFORMACIÓN SOBRE LAS COLUMNAS:");
            System.out.println(" ==================================");
            ResultSet columnas = null;
            columnas = dbmd.getColumns("ejercicio3_AD", null, "departamentos", null);
            while (columnas.next()) {
                String nombCol = columnas.getString("COLUMN_NAME"); //getString(4)
                String tipoCol = columnas.getString("TYPE_NAME"); //getString(6)
                String tamCol = columnas.getString("COLUMN_SIZE"); //getString(7)
                String nula = columnas.getString("IS_NULLABLE"); //getString(18)
                
                System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser Nula: ? %s %n", nombCol, tipoCol, tamCol, nula);
            }
            ResultSet pk;
            pk = dbmd.getPrimaryKeys("ejercicio3_AD", "ejercicio3_AD", "departamentos");
            while (pk.next()) {                
                System.out.println("La clave primaria de la tabla:  " + tabla +  ", es la columna: "+ pk.getString("COLUMN_NAME"));
            }
            conexion.close();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
