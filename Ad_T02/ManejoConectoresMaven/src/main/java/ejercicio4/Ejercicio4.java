package ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author santimiquel
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        try {
            //Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer conexión con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio3_AD", "root", "San608921482");

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

    
    

