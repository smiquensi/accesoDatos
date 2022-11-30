/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_conexionjasper;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author santimiquel
 */
public class Ad_ConexionJasper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        String reportSource = "/Users/santimiquel/www/accesoDatos/Actividad_2_4_AD/Plantilla.jrxml";
        String reportHTML = "/Users/santimiquel/www/accesoDatos/Actividad_2_4_AD/InformeJR.html";
        String reportPDF = "/Users/santimiquel/www/accesoDatos/Actividad_2_4_AD/InformeJR.pdf";
        String reportXML = "/Users/santimiquel/www/accesoDatos/Actividad_2_4_AD/InformeJR.xml";

        Map<String, Object> parametrosInforme = new HashMap<String, Object>();
        parametrosInforme.put("titulo", "LISTA DE DEPARTAMENTOS.");
        parametrosInforme.put("autor", "SantiMiquel");
        parametrosInforme.put("fecha", (new java.util.Date()).toString());

        try  {
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_AD", "root", "San608921482");
                JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, parametrosInforme, conexion);
                // Visualizar el informe generado por  pantalla
                JasperViewer.viewReport(MiInforme);
                //Convertir el informe a HTML
                JasperExportManager.exportReportToHtmlFile(MiInforme, reportHTML);
                //Convertir el informe PDF
                JasperExportManager.exportReportToPdfFile(MiInforme, reportPDF);
                //Convertir el informe XML.
                JasperExportManager.exportReportToXmlFile(MiInforme, reportXML, false); // añadimos false por que no hay imagenes
                System.out.println("Archivos creados con éxito");

        } catch (CommunicationsException c) {
            System.out.println("Error de conexión con la Base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error del driver");
        } catch (SQLException e) {
            System.out.println("Error al ejecutar sentencia SQL");
        } catch (JRException ex) {
            System.out.println("Error JasperReport");
            ex.printStackTrace();
        }

    }
}

    
    

