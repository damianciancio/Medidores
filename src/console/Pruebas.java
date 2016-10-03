package console;
import business.entities.Inspeccion;
import business.logic.*;
public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReporteReclamos r = new ReporteReclamos();
		Inspeccion ins = new Inspeccion();
		ins.setNroReclamo(797);
		try {
			r.reportInspeccion(ins);
			System.out.println("listo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
