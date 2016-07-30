package business.logic;
import java.sql.*;
import java.util.ArrayList;

import data.Conexion;
import data.Operaciones;
import business.entities.Reclamo;

public class CatalogoReclamos {
	ArrayList<Reclamo> reclamos = new ArrayList<Reclamo>();
	Operaciones op;
	
	public ArrayList<Reclamo> getReclamos()
	{
		return reclamos;
	}
	
	public CatalogoReclamos(){
		this.op = new Operaciones();
		this.reclamos = op.devolverReclamos();
	
}
	
	public void agregarReclamo(Reclamo rec)
	{
		reclamos.add(rec);
		op.agregarReclamo(rec);   							
		
	}
	
}