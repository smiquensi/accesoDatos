package com.mycompany.insertempleado;
import java.sql.*;

public class InsertEmpleado {

    public static void main(String[] args) {
        boolean existDept;
        boolean existNumEmp;
        boolean existDir;

        String numEmpleado = args[0];
        int nEmple = Integer.valueOf(numEmpleado);
        String apellido = args[1];
        String oficio = args[2];
        String dir = args[3];
        int director = Integer.valueOf(dir);
        String fechAlta = args[4];
        String salario = args[5];
        double sal = Double.valueOf(salario);
        String comision = args[6];
        double comi = Double.parseDouble(comision);
        String deptNo = args[7];
        int depto = Integer.parseInt(deptNo);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD", "root", "San608921482");
            String sql = "SELECT dept_no FROM departamentos WHERE dept_no = " + depto + ";";
            Statement sentencia = conexion.createStatement();
            ResultSet rsDept = sentencia.executeQuery(sql);
            if (rsDept.next()) {
                System.out.printf("El departamento %s existe en la tabla departamentos%n", depto);
                existDept = true;
            } else {
                existDept = false;
                System.out.printf("El departamento %s NO existe en la tabla departamentos%n", depto);
            }
            String sqlBuscaEmpl = "SELECT emp_no FROM empleados WHERE emp_no = " + nEmple + ";";
            ResultSet rsEmpleado = sentencia.executeQuery(sqlBuscaEmpl);
            if (rsEmpleado.next()) {
                System.out.printf("El número de empleado %d ya existe en la BD%n", nEmple);
                existNumEmp = true;
            } else {
                existNumEmp = false;
                System.out.printf("El número de empleado %d es valido para esta BD%n", nEmple);
            }
            String sqlBusqDirector = "SELECT dir FROM empleados WHERE dir = " + director;
            ResultSet rsDir = sentencia.executeQuery(sqlBusqDirector);
            if (rsDir.next()) {
                existDir = true;
                System.out.printf("El director %s existe en la tabla empleados%n", director);
            } else {
                existDir = false;
                System.out.printf("El director %s NO existe en la tabla empleados%n", director);
            }
            if (existDept == true && existNumEmp == false && existDir == true && sal > 0 && !apellido.equalsIgnoreCase("null") && !oficio.equalsIgnoreCase("null") && fechAlta.equalsIgnoreCase("2022-10-25")) {
                String sqlINSERT = "INSERT INTO empleados (emp_no,apellido,oficio,dir,fecha_alt,salario,comision,dept_no)" + " VALUES (" + nEmple + ", \"" + apellido + "\", \"" + oficio + "\", \"" + director + "\", \"" + fechAlta + "\", " + sal + "," + comi + "," + depto + ")";
                sentencia.execute(sqlINSERT);
                System.out.println("Inserción de datos realizada correctamente");
            } else {
                if (apellido.equalsIgnoreCase("null")) {
                    System.out.println("Apellido no puede ser nulo");
                }else if (oficio.equalsIgnoreCase("NULL")) {
                    System.out.println("Oficio no puede ser nulo");
                }else if (!fechAlta.equalsIgnoreCase("2022-10-25")) {
                    System.out.println("La fecha no coincide con la fecha actual");
                }
                System.out.println("No se ha podido realizar la inserción de datos");
            }
            rsDept.close();
            rsEmpleado.close();
            rsDir.close();
            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException es) {
            es.printStackTrace();

        }
    }
}
