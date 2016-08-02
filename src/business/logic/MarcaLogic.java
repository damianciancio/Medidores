package business.logic;

import java.util.ArrayList;

import business.entities.Marca;
import data.MarcaData;
import util.State;

public class MarcaLogic 
{
	public Marca buscarCalle(Marca ma) throws Exception
	{
		try
		{
			MarcaData md = new MarcaData();
			return md.buscar(ma);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<Marca> devolverMarcas() throws Exception
	{
		MarcaData md = new MarcaData();
		try {
			return md.devolverMarcas();
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}
	
	public void guardaCambios(Marca ma) throws Exception
	{
		try
		{
			MarcaData md = new MarcaData();
			if(ma.estado == State.ACTUALIZAR)
			{
				md.actualizar(ma);
			}
			else if (ma.estado == State.NUEVO)
			{
				//ud.agregarCalle(ca);
			}
			else if (ma.estado == State.ELIMINAR)
			{
				md.eliminar(ma);
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}

}
