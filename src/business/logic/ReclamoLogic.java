package business.logic;
import java.sql.*;
import java.util.ArrayList;

import data.ReclamoData;
import data.Conexion;
import util.State;
import business.entities.*;

public class ReclamoLogic {
	
	public Reclamo buscarReclamo(Reclamo re) throws Exception
	{
		try
		{
			ReclamoData rd = new ReclamoData();
			return rd.buscar(re);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<Reclamo> devolverReclamos() throws Exception
	{
		ReclamoData rd = new ReclamoData();
		try {
			return rd.devolverReclamos();
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}
	
	public void guardaCambios(Reclamo re) throws Exception
	{
		try
		{
			ReclamoData rd = new ReclamoData();
			if(re.estado == State.ACTUALIZAR)
			{
				rd.actualizar(re);
			}
			else if (re.estado == State.NUEVO)
			{
				rd.agregarReclamo(re);
			}
			else if (re.estado == State.ELIMINAR)
			{
				rd.eliminar(re);
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}

	
}