package ejercici5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author santimiquel
 */
public class Ejercicio5 {
    public static void main(String[] args) {
         try {
            //Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer conexión con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio3_AD", "root", "San608921482");

            Statement sentencia = conexion.createStatement();
            String query = "SELECT apellido , oficio , salario FROM empleados WHERE dept_no = 30;";
            ResultSet result = sentencia.executeQuery(query);

            
            while (result.next()) {
                System.out.printf("Apellido:  %s\tOficio: %s\tSalario: %d%n", 
                        result.getString("apellido"),
                        result.getString("oficio"),
                        result.getInt("salario")
                        );
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
