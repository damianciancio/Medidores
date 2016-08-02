package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.TipoReclamo;

public class TipoReclamoData 
{
	public ArrayList<TipoReclamo> devolverTiposReclamo() throws Exception
	{
	
		Connection con = Conexion.obtenerConexion("medidores");
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<TipoReclamo> tipos = new ArrayList<TipoReclamo>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM tiporeclamo");
		    while(rs.next())
			{
				TipoReclamo tr = new TipoReclamo();
				this.mapear(rs, tr);
				tipos.add(tr);
			}
		
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select. " + e.getStackTrace());
			throw new Exception("Error al obtener tipos de reclamo. Intente nuevamente. Si el problema persiste, llame a alguien.", e);
		}
		
		try
		{
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se cerro conexion. " + e.getStackTrace());
			throw new Exception("Error al cerrar una conexion a la base de datos, si la aplicaci�n se torna lento, guarde lo que necesita y reiniciela.", e);
		}
		
		return tipos;
	}
	
	
	public TipoReclamo mapear(ResultSet rs, TipoReclamo tr)
	{
		try {
			if(rs.next()){
				tr = new TipoReclamo();
				tr.setIdTipoReclamo(rs.getInt(1));
				tr.setDescTipoReclamo(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tr;
	}
	
	
	public TipoReclamo buscar(TipoReclamo tr) throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		
		ResultSet rs = null;
		Statement cmd = null;
		TipoReclamo find = null;
		try {
	
		    cmd = con.createStatement();
		    rs = cmd.executeQuery("select idtiporeclamo, desctiporeclamo "+
		    						"from tiporeclamo "+
		    						"where tiporeclamo.idtiporeclamo =" + tr.getIdTipoReclamo());
		    find = this.mapear(rs, find);
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select para buscar tipo reclamo. "+ e.getStackTrace());
			throw new Exception("Error al buscar en la base de datos. Intente nuevamente, si el problema persiste, llame a alguien. ", e);
		}
		
		
		try 
			{
			con.close();
			}
		catch(SQLException e) {
			System.out.println("Conexion no cerrada");
		}
		finally 
		{
			con.close();
			cmd = null;
			rs = null;
		}
		return find;
	}

	public void actualizar(TipoReclamo tr) throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		Statement cmd = null;
		
		try
		{
			cmd = con.createStatement();
			cmd.executeQuery("update tiporeclamo (desctiporeclamo)values (" + tr.getDescTipoReclamo()+")");
			
		}
		catch (Exception e)
		{
			System.out.println("Falla update en tipo reclamo. " + e.getStackTrace());
			throw new Exception("Error al conectar a la base de datos, si la aplicaci�n se torna lento, guarde lo que necesita y reiniciela.", e);
		}
		finally
		{
			con.close();
		}
	}
	public void eliminar(TipoReclamo tr)throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		Statement cmd = null;
		try
		{
			
			cmd = con.createStatement();
			cmd.executeQuery("delete from tiporeclamo "+
								"where idtiporeclamo = " + tr.getIdTipoReclamo() );		
		}
		catch(Exception e)
		{
			System.out.println("No se elimino tipo reclamo "+ e.getStackTrace());
			throw new Exception("No se eliminó tipo reclamo. Intente nuevamente. Si el problema persiste, llame a alguien",e);
		}
		finally
		{
			try
		
			{
				con.close();
			}
			catch (Exception e)
			{
				System.out.println("No se cerró la conexión a la base de datos."+e.getStackTrace());
				throw new Exception("No se cerró una conexión a la base de datos. De tener problemas de lentitud, guarde todo lo necesario y reinicie la aplicacion",e);
			}
		}
	}
}
