package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.Marca;

public class MarcaData 
{
	public ArrayList<Marca> devolverMarcas() throws Exception
	{
	
		Connection con = Conexion.obtenerConexion("medidores");
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<Marca> marcas = new ArrayList<Marca>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM marcas");
		    while(rs.next())
			{
				Marca ma = new Marca();
				this.mapear(rs, ma);
				marcas.add(ma);
			}
		
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select. " + e.getStackTrace());
			throw new Exception("Error al obtener las marcas. Intente nuevamente. Si el problema persiste, llame a alguien.", e);
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
		
		return marcas;
	}
	
	
	public Marca mapear(ResultSet rs, Marca ma)
	{
		try {
			if(rs.next()){
				ma = new Marca();
				ma.setIdMarca(rs.getInt(1));
				ma.setDescMarca(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ma;
	}
	
	
	public Marca buscar(Marca ma) throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		
		ResultSet rs = null;
		Statement cmd = null;
		Marca find = null;
		try {
	
		    cmd = con.createStatement();
		    rs = cmd.executeQuery("select idMarca, descMarca "+
		    						"from marcas "+
		    						"where marcas.idIdMarca =" + ma.getIdMarca());
		    find = this.mapear(rs, find);
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select para buscar marca. "+ e.getStackTrace());
			throw new Exception("Error al buscar la marca. Intente nuevamente, si el problema persiste, llame a alguien. ", e);
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

	public void actualizar(Marca ma) throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		Statement cmd = null;
		
		try
		{
			cmd = con.createStatement();
			cmd.executeQuery("update marcas (descMarca)values (" + ma.getDescMarca()+")");
			
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
	public void eliminar(Marca ma)throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		Statement cmd = null;
		try
		{
			
			cmd = con.createStatement();
			cmd.executeQuery("delete from marcas "+
								"where idMarca = " + ma.getIdMarca() );		
		}
		catch(Exception e)
		{
			System.out.println("No se elimino marca "+ e.getStackTrace());
			throw new Exception("No se elimin� marca. Intente nuevamente. Si el problema persiste, llame a alguien",e);
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
