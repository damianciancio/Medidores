package business.logic;

import java.util.ArrayList;

import business.entities.TipoReclamo;
import data.TipoReclamoData;
import util.State;

public class TipoReclamoLogic 
{
	public TipoReclamo buscarTr(TipoReclamo tr) throws Exception
	{
		try
		{
			TipoReclamoData trd = new TipoReclamoData();
			return trd.buscar(tr);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<TipoReclamo> devolverTiposReclamo() throws Exception
	{
		TipoReclamoData trd = new TipoReclamoData();
		try {
			return trd.devolverTiposReclamo();
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}
	
	public void guardaCambios(TipoReclamo tr) throws Exception
	{
		try
		{
			TipoReclamoData ud = new TipoReclamoData();
			if(tr.estado == State.ACTUALIZAR)
			{
				ud.actualizar(tr);
			}
			else if (tr.estado == State.NUEVO)
			{
				//ud.agregarCalle(ca);
			}
			else if (tr.estado == State.ELIMINAR)
			{
				ud.eliminar(tr);
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}

}
