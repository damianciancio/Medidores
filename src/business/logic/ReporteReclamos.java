package business.logic;

import data.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReporteReclamos {
	public void reportearTodos() throws JRException, Exception
	{
		try {
			JasperReport reporte = (JasperReport) JRLoader.loadObject("D:/Software/WORKSPACE JAVA CON GIT/Medidores/GetAllReclamos.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, Conexion.obtenerConexion());
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint); 
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("reportePDF.pdf"));
			exporter.exportReport();
		} catch (JRException jre) {
			throw new Exception ("Error al generar el reporte", jre);
		}
		catch(Exception e){
			throw new Exception("Error al generar el reporte", e);
		}
	}
}
