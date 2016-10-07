package business.logic;
import business.entities.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
	
	
	static String pathTodosLosReclamos;
	static String pathReclamoAntesInspeccion;
	static String pathReclamoDespuesInspeccion;
	static String outPut;
	
	
	public ReporteReclamos() throws Exception
	{
		levantarDirecciones();
	}
	
	
	public static String getOutPutFileSource()
	{
		return outPut;
	}
	
	public void reportearTodos() throws JRException, Exception
	{
		makeReport(pathTodosLosReclamos,new HashMap<String,Object>(),outPut+"Listado completo.pdf");
	}
	
	
	public void levantarDirecciones() throws Exception
	{
		Properties propiedades = new Properties();
	    InputStream entrada = null;
		try
		{
		    entrada = new FileInputStream("configuracion.properties");
		    propiedades.load(entrada);
		    
		    pathTodosLosReclamos = propiedades.getProperty("todosLosReclamos");
		    pathReclamoAntesInspeccion = propiedades.getProperty("reclamoAntesInspeccion");
		    pathReclamoDespuesInspeccion = propiedades.getProperty("reclamoDespuesInspeccion");
		    outPut = propiedades.getProperty("output");
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public void reportInspeccion(Inspeccion ins) throws Exception
	{
		HashMap<String, Object> parameters = new HashMap<String,Object>();
		parameters.put("id", ins.getNroReclamo());
		makeReport(pathReclamoDespuesInspeccion, parameters, outPut+ins.getNroReclamo()+".pdf");
	}
	
	public void reportReclamo(Reclamo rec) throws Exception
	{
		HashMap<String, Object> parameters = new HashMap<String,Object>();
		parameters.put("id", rec.getIdReclamo());
		makeReport(pathReclamoAntesInspeccion, parameters, outPut+rec.getIdReclamo()+".pdf");
		
	}
	
	public void makeReport(String reportSrcFile, HashMap<String,Object> parameters, String srcOutput) throws Exception
	{
		try {
			
			
			JasperReport reporte = JasperCompileManager.compileReport(reportSrcFile);
			Conexion con = new Conexion();
			Connection conn = con.obtenerConexion();
			File outDir = new File(outPut);
	        outDir.mkdirs();
			JasperPrint printer = JasperFillManager.fillReport(reporte, parameters,conn);
	        JRPdfExporter exporter = new JRPdfExporter();
	        ExporterInput exInput = new SimpleExporterInput(printer);
	        exporter.setExporterInput(exInput);
	        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
	                srcOutput);
	        exporter.setExporterOutput(exporterOutput);
	        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
	        exporter.setConfiguration(configuration);
	        exporter.exportReport();		
	        } 
		catch (JRException jre) {
			jre.printStackTrace();
			throw new Exception ("Error al generar el reporte. Exception jre", jre);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Error al generar el reporte", e);
		}
	}
}
