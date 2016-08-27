package business.logic;

import java.util.ArrayList;

import business.entities.Inspeccion;
import data.InspeccionData;
import util.State;

public class InspeccionLogic 
{
	public Inspeccion buscar(Inspeccion in) throws Exception
	{
		try
		{
			InspeccionData id = new InspeccionData();
			return id.buscar(in);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
//	public ArrayList<Inspeccion> devolverInspecciones() throws Exception
//	{
//		InspeccionData id = new InspeccionData();
//		try {
//			return id.devolverInspecciones();
//		}
//		catch (Exception e)
//		{
//			throw new Exception(e);
//		}
//	}
	
	public void guardaCambios(Inspeccion in) throws Exception
	{
		try
		{
			InspeccionData id = new InspeccionData();
			if(in.estado == State.ACTUALIZAR)
			{
				id.agregarInspeccion(in);
			}
			else if (in.estado == State.NUEVO)
			{
				id.agregarInspeccion(in);
			}
//			else if (in.estado == State.ELIMINAR)
//			{
//				id.eliminar(in);
//			}
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}

}