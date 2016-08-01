package business.logic;

import java.util.ArrayList;

import business.entities.Localidad;
import data.LocalidadData;
import util.State;

public class LocalidadLogic 
{
	public Localidad buscar(Localidad loc) throws Exception
	{
		try
		{
			LocalidadData lc = new LocalidadData();
			return lc.buscar(loc);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<Localidad> devolverLocalidades() throws Exception
	{
		LocalidadData ld = new LocalidadData();
		try {
			return ld.devolverLocalidades();
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}
	
	public void guardaCambios(Localidad lc) throws Exception
	{
		try
		{
			LocalidadData ud = new LocalidadData();
			if(lc.estado == State.ACTUALIZAR)
			{
				ud.actualizar(lc);
			}
			else if (lc.estado == State.NUEVO)
			{
				//ud.agregarLocalidad(lc);
			}
			else if (lc.estado == State.ELIMINAR)
			{
				ud.eliminar(lc);
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}

}
