package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.Localidad;

public class LocalidadData 
{
	public ArrayList<Localidad> devolverLocalidades() throws Exception
	{
	
		Connection con = Conexion.obtenerConexion();
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM localidades");
		    while(rs.next())
			{
				Localidad loc = new Localidad();
				this.mapear(rs, loc);
				localidades.add(loc);
			}
		
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select. " + e.getStackTrace());
			throw new Exception("Error al obtener las localidades. Intente nuevamente. Si el problema persiste, llame a alguien.", e);
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
		
		return localidades;
	}
	
	
	public Localidad mapear(ResultSet rs, Localidad loc)
	{
		try {
			if(rs.next()){
				loc = new Localidad();
				loc.setIdLocalidad(rs.getInt(1));
				loc.setDescLocalidad(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loc;
	}
	
	
	public Localidad buscar(Localidad loc) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		
		ResultSet rs = null;
		Statement cmd = null;
		Localidad find = null;
		try {
	
		    cmd = con.createStatement();
		    rs = cmd.executeQuery("select idlocalidad, descLocalidad "+
		    						"from localidades "+
		    						"where localidades.idlocalidad =" + loc.getIdLocalidad());
		    find = this.mapear(rs, find);
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select para buscar calle. "+ e.getStackTrace());
			throw new Exception("Error al buscar la calle. Intente nuevamente, si el problema persiste, llame a alguien. ", e);
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

	public void actualizar(Localidad loc) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		Statement cmd = null;
		
		try
		{
			cmd = con.createStatement();
			cmd.executeQuery("update localidades (desclocalidad)values (" + loc.getDescLocalidad()+""
								+ " where localidades.idlocalidad = "+loc.getIdLocalidad()+")");
			
		}
		catch (Exception e)
		{
			System.out.println("No se cerro conexion. " + e.getStackTrace());
			throw new Exception("Error al cerrar una conexion a la base de datos, si la aplicaci�n se torna lento, guarde lo que necesita y reiniciela.", e);
		}
		finally
		{
			con.close();
		}
	}
	public void eliminar(Localidad loc)throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		Statement cmd = null;
		try
		{
			
			cmd = con.createStatement();
			cmd.executeQuery("delete from localidades "+
								"where localidades.idlocalidad = " + loc.getIdLocalidad() );		
		}
		catch(Exception e)
		{
			System.out.println("No se elimino localidad "+ e.getStackTrace());
			throw new Exception("No se elimin� localidad. Intente nuevamente. Si el problema persiste, llame a alguien",e);
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
