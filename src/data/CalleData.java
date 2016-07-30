package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.Calle;

public class CalleData {

	
	public ArrayList<Calle> devolverCalles() throws Exception
	{
	
		Connection con = Conexion.obtenerConexion("medidores");
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<Calle> calles = new ArrayList<Calle>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM callesrosario");
		    while(rs.next())
			{
				Calle ca = new Calle();
				this.mapear(rs, ca);
				calles.add(ca);
			}
		
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select. " + e.getStackTrace());
			throw new Exception("Error al obtener todas las calles. Intente nuevamente. Si el problema persiste, llame a alguien.", e);
		}
		
		try
		{
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se cerro conexion. " + e.getStackTrace());
			throw new Exception("Error al cerrar una conexion a la base de datos, si la aplicación se torna lento, guarde lo que necesita y reiniciela.", e);
		}
		
		return calles;
	}
	
	
	public Calle mapear(ResultSet rs, Calle ca)
	{
		try {
			if(rs.next()){
				ca = new Calle();
				ca.setIdCalle(rs.getString(1));
				ca.setNomCalle(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ca;
	}
	
	
	public Calle buscar(Calle ca) throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		
		ResultSet rs = null;
		Statement cmd = null;
		Calle find = null;
		try {
	
		    cmd = con.createStatement();
		    rs = cmd.executeQuery("select idcallesRosario, callesRosariocol "+
		    						"from callesrosario "+
		    						"where callesrosario.idcallesRosario =" + ca.getIdCalle());
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

	public void actualizar(Calle ca) throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		Statement cmd = null;
		
		try
		{
			cmd = con.createStatement();
			cmd.executeQuery("update callesRosario (callesrosariocol)values (" + ca.getNomCalle()+")");
			
		}
		catch (Exception e)
		{
			System.out.println("No se cerro conexion. " + e.getStackTrace());
			throw new Exception("Error al cerrar una conexion a la base de datos, si la aplicación se torna lento, guarde lo que necesita y reiniciela.", e);
		}
		finally
		{
			con.close();
		}
	}
	public void eliminar(Calle ca)throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		Statement cmd = null;
		try
		{
			
			cmd = con.createStatement();
			cmd.executeQuery("delete from callesrosario "+
								"where idcallesrosario = " + ca.getIdCalle() );		
		}
		catch(Exception e)
		{
			System.out.println("No se elimino calle "+ e.getStackTrace());
			throw new Exception("No se eliminó calle. Intente nuevamente. Si el problema persiste, llame a alguien",e);
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

	
	

