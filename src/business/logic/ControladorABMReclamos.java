package business.logic;
import java.util.ArrayList;

import business.entities.Calle;
import business.entities.Reclamo;

public class ControladorABMReclamos {
	
	CatalogoCalles calles = new CatalogoCalles();
	CatalogoReclamos reclamos = new CatalogoReclamos();
	
	
	public void agregarReclamo(Reclamo rec)
	{
		reclamos.agregarReclamo(rec);
	}
	
	public ArrayList<Calle> obtenerCalles()
	{
		return calles.getCalles();
	}
}
