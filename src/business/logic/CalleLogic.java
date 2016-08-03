package business.logic;

import java.util.ArrayList;
import java.util.List;

import data.CalleData;
import business.entities.Calle;
import util.State;

public class CalleLogic 

{

	
	
	public Calle buscarCalle(Calle ca) throws Exception
	{
		try
		{
			CalleData cd = new CalleData();
			return cd.buscar(ca);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<Calle> buscarCalle(String palabra) throws Exception
	
	{
		try
		{
			CalleData cd = new CalleData();
			return cd.buscarCoincidencias(palabra);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	
	public ArrayList<Calle> devolvercalles() throws Exception
	{
		CalleData cd = new CalleData();
		try {
			return cd.devolverCalles();
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}
	
	public void guardaCambios(Calle ca) throws Exception
	{
		try
		{
			CalleData ud = new CalleData();
			if(ca.estado == State.ACTUALIZAR)
			{
				ud.actualizar(ca);
			}
			else if (ca.estado == State.NUEVO)
			{
				//ud.agregarCalle(ca);
			}
			else if (ca.estado == State.ELIMINAR)
			{
				ud.eliminar(ca);
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}
	

}
