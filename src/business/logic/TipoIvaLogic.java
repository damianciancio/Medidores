package business.logic;

import java.util.ArrayList;

import business.entities.TipoIva;
import data.TipoIvaData;
import util.State;

public class TipoIvaLogic 
{
	public TipoIva buscarTipoIva(TipoIva ti) throws Exception
	{
		try
		{
			TipoIvaData tid = new TipoIvaData();
			return tid.buscar(ti);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<TipoIva> devolvercalles() throws Exception
	{
		TipoIvaData tid = new TipoIvaData();
		try {
			return tid.devolverTiposIva();
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}
	
	public void guardaCambios(TipoIva ti) throws Exception
	{
		try
		{
			TipoIvaData tid = new TipoIvaData();
			if(ti.estado == State.ACTUALIZAR)
			{
				tid.actualizar(ti);
			}
			else if (ti.estado == State.NUEVO)
			{
				//ud.agregarCalle(ca);
			}
			else if (ti.estado == State.ELIMINAR)
			{
				tid.eliminar(ti);
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}

}
