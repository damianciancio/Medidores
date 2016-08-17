package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.Resultado;

public class ResultadoData 
{
	public ArrayList<Resultado> devolverResultados() throws Exception
	{
	
		Connection con = Conexion.obtenerConexion("medidores");
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<Resultado> resultados = new ArrayList<Resultado>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM resultados");
		    while(rs.next())
			{	
		    	resultados.add(this.mapear(rs));
			}
		
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select. " + e.getStackTrace());
			throw new Exception("Error al obtener resultados. Intente nuevamente. Si el problema persiste, llame a alguien.", e);
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
		
		return resultados;
	}
	
	
	public Resultado mapear(ResultSet rs)
	{
		Resultado re = new Resultado();
		try {
			
			if(rs.next())
			{
				re.setIdResultado(rs.getInt(1));
				re.setDescResultado(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return re;
	}
	
	
	public Resultado buscar(Resultado re) throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		
		ResultSet rs = null;
		Statement cmd = null;
		Resultado find = null;
		try {
	
		    cmd = con.createStatement();
		    rs = cmd.executeQuery("select idresult, descresult "+
		    						"from resultados "+
		    						"where resultados.idresult =" + re.getIdResultado());
		    find = this.mapear(rs);
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select para buscar resultado. "+ e.getStackTrace());
			throw new Exception("Error al buscar la resultado. Intente nuevamente, si el problema persiste, llame a alguien. ", e);
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

	public void actualizar(Resultado re) throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		Statement cmd = null;
		
		try
		{
			cmd = con.createStatement();
			cmd.executeQuery("update resultados (descresult)values (" + re.getDescResultado()+")");
			
		}
		catch (Exception e)
		{
			System.out.println("No funca un update en resultados " + e.getStackTrace());
			throw new Exception("Error al impactar en la base de datos", e);
		}
		finally
		{
			con.close();
		}
	}
	public void eliminar(Resultado re)throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		Statement cmd = null;
		try
		{
			
			cmd = con.createStatement();
			cmd.executeQuery("delete from resultados "+
								"where idresultado = " + re.getIdResultado() );		
		}
		catch(Exception e)
		{
			System.out.println("No se elimino resultado"+ e.getStackTrace());
			throw new Exception("No se eliminó resultado. Intente nuevamente. Si el problema persiste, llame a alguien",e);
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
