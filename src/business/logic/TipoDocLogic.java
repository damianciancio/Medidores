package business.logic;

import java.util.ArrayList;

import business.entities.TipoDoc;
import data.TipoDocData;
import util.State;

public class TipoDocLogic 
{
	public TipoDoc buscarTipoDoc(TipoDoc td) throws Exception
	{
		try
		{
			TipoDocData tdd = new TipoDocData();
			return tdd.buscar(td);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<TipoDoc> devolverTiposDoc() throws Exception
	{
		TipoDocData tdd = new TipoDocData();
		try {
			return tdd.devolverTiposDoc();
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}
	
	public void guardaCambios(TipoDoc td) throws Exception
	{
		try
		{
			TipoDocData tdd = new TipoDocData();
			if(td.estado == State.ACTUALIZAR)
			{
				tdd.actualizar(td);
			}
			else if (td.estado == State.NUEVO)
			{
				//ud.agregarCalle(ca);
			}
			else if (td.estado == State.ELIMINAR)
			{
				tdd.eliminar(td);
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}

}
