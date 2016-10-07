package console;
import business.entities.*;
import business.logic.*;

public class Prueba {
	
	
	public static void main(String[] args)
	{
		try {
			ReporteReclamos rr = new ReporteReclamos();
		Reclamo ins = new Reclamo();
		ins.setIdReclamo(797);
		rr.reportearTodos();
		//	rr.reportReclamo(ins);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
