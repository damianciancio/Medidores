package business.logic;

import java.util.ArrayList;

import business.entities.Resultado;
import data.ResultadoData;
import util.State;

public class ResultadoLogic 
{
	public Resultado buscarCalle(Resultado re) throws Exception
	{
		try
		{
			ResultadoData rd = new ResultadoData();
			return rd.buscar(re);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<Resultado> devolverResultados() throws Exception
	{
		ResultadoData rd = new ResultadoData();
		try {
			return rd.devolverResultados();
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}
	
	public void guardaCambios(Resultado re) throws Exception
	{
		try
		{
			ResultadoData rd = new ResultadoData();
			if(re.estado == State.ACTUALIZAR)
			{
				rd.actualizar(re);
			}
			else if (re.estado == State.NUEVO)
			{
				//ud.agregarCalle(ca);
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
