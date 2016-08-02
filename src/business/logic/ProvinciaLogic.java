package business.logic;

import java.util.ArrayList;

import business.entities.Provincia;
import data.ProvinciaData;
import util.State;

public class ProvinciaLogic 
{
	public Provincia buscar(Provincia pro) throws Exception
	{
		try
		{
			ProvinciaData pd = new ProvinciaData();
			return pd.buscar(pro);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<Provincia> devolverProvincias() throws Exception
	{
		ProvinciaData pd = new ProvinciaData();
		try {
			return pd.devolverProvincias();
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}
	
	
}
