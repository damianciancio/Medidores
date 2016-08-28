package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.TipoIva;

public class TipoIvaData 
{
	public ArrayList<TipoIva> devolverTiposIva() throws Exception
	{
	
		Connection con = Conexion.obtenerConexion();
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<TipoIva> tiposiva = new ArrayList<TipoIva>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM tipos_iva");
		    while(rs.next())
			{
				TipoIva ti = new TipoIva();
				this.mapear(rs, ti);
				tiposiva.add(ti);
			}
		
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select tipos_iva. " + e.getStackTrace());
			throw new Exception("Error al conectar a la base de datos. Intente nuevamente. Si el problema persiste, llame a alguien.", e);
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
		
		return tiposiva;
	}
	
	
	public TipoIva mapear(ResultSet rs, TipoIva ti)
	{
		try {
			if(rs.next()){
				ti = new TipoIva();
				ti.setIdTipoIva(rs.getInt(1));
				ti.setDescTipoIva(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ti;
	}
	
	
	public TipoIva buscar(TipoIva ti) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		
		ResultSet rs = null;
		Statement cmd = null;
		TipoIva find = null;
		try {
	
		    cmd = con.createStatement();
		    rs = cmd.executeQuery("select id, col "+
		    						"from tipos_iva "+
		    						"where tipos_iva.id =" + ti.getIdTipoIva());
		    find = this.mapear(rs, find);
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select para buscar tipo iva. "+ e.getStackTrace());
			throw new Exception("Error al conectar a la base de datos. Intente nuevamente, si el problema persiste, llame a alguien. ", e);
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

	public void actualizar(TipoIva ti) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		Statement cmd = null;
		
		try
		{
			cmd = con.createStatement();
			cmd.executeQuery("update tipos_iva (col)values (" + ti.getDescTipoIva()+")");
			
		}
		catch (Exception e)
		{
			System.out.println("No se cerro conexion. " + e.getStackTrace());
			throw new Exception("Error al conectar a la base de datos, si la aplicaci�n se torna lento, guarde lo que necesita y reiniciela.", e);
		}
		finally
		{
			con.close();
		}
	}
	public void eliminar(TipoIva ti)throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		Statement cmd = null;
		try
		{
			
			cmd = con.createStatement();
			cmd.executeQuery("delete from tipos_iva "+
								"where id = " + ti.getIdTipoIva() );		
		}
		catch(Exception e)
		{
			System.out.println("No se elimino TIPO "+ e.getStackTrace());
			throw new Exception("No se eliminó Tipo iva. Intente nuevamente. Si el problema persiste, llame a alguien",e);
		}
		finally
		{
			try
		
			{
				con.close();
			}
			catch (Exception e)
			{
				System.out.println("No se cerr� la conexi�n a la base de datos."+e.getStackTrace());
				throw new Exception("No se cerr� una conexi�n a la base de datos. De tener problemas de lentitud, guarde todo lo necesario y reinicie la aplicacion",e);
			}
		}
	}
}
