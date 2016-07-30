package business.logic;


import java.util.ArrayList;

import data.*;
import business.entities.Calle;


public class CatalogoCalles {
	
	ArrayList<Calle> calles = new ArrayList<Calle>();
	
	public ArrayList<Calle> getCalles() {
		return calles;
	}

	public CatalogoCalles()
	{	
		Operaciones op = new Operaciones();
		calles = op.devolverCalles();
	}
	
}
