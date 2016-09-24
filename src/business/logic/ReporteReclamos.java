package business.logic;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import data.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRPrintXmlLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public class ReporteReclamos {
	public void reportearTodos() throws JRException, Exception
	{
		try {
			
			String reportSrcFile = "D:\\Software\\WORKSPACE JAVA CON GIT\\Medidores\\GetAllReclamos.jrxml";
			JasperReport reporte = JasperCompileManager.compileReport(reportSrcFile);
			Conexion con = new Conexion();
			Connection conn = con.obtenerConexion();
			Map<String,Object> parameters = new HashMap<String,Object>();
			File outDir = new File("C:/jasperoutput");
	        outDir.mkdirs();
			JasperPrint printer = JasperFillManager.fillReport(reporte, parameters,conn);
	        JRPdfExporter exporter = new JRPdfExporter();
	        ExporterInput exInput = new SimpleExporterInput(printer);
	        exporter.setExporterInput(exInput);
	        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
	                "C:/jasperoutput/Listado completo.pdf");
	        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
	        exporter.setConfiguration(configuration);
	        exporter.exportReport();		
	        } 
		catch (JRException jre) {
			throw new Exception ("Error al generar el reporte", jre);
		}
		catch(Exception e){
			throw new Exception("Error al generar el reporte", e);
		}
	}
}
