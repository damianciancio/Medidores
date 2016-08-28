package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.TipoDoc;

public class TipoDocData 
{
	public ArrayList<TipoDoc> devolverTiposDoc() throws Exception
	{
	
		Connection con = Conexion.obtenerConexion();
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<TipoDoc> tipod = new ArrayList<TipoDoc>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM tiposdoc");
		    while(rs.next())
			{
				tipod.add(this.mapear(rs));
			}
		
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select. " + e.getStackTrace());
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
		
		return tipod;
	}
	
	
	public TipoDoc mapear(ResultSet rs)
	{
		TipoDoc td = new TipoDoc();
		try {
			if(rs.next()){
				td.setIdTipoDOc(rs.getString(1));
				td.setDescTipoDoc(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return td;
	}
	
	
	public TipoDoc buscar(TipoDoc td) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		
		ResultSet rs = null;
		Statement cmd = null;
		TipoDoc find = null;
		try {
	
		    cmd = con.createStatement();
		    rs = cmd.executeQuery("select idtipo, desctipo "+
		    						"from tiposdoc "+
		    						"where tiposdoc.idtipo =" + td.getIdTipoDoc());
		    find = this.mapear(rs);
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select para buscar tipos Doc. "+ e.getStackTrace());
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

	public void actualizar(TipoDoc td) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		Statement cmd = null;
		
		try
		{
			cmd = con.createStatement();
			cmd.executeQuery("update tiposdoc (desctipo)values (" + td.getDescTipoDoc()+")");
			
		}
		catch (Exception e)
		{
			System.out.println("No se hizo el update en tipos doc. " + e.getStackTrace());
			throw new Exception("Error al conectar a la base de datos.", e);
		}
		finally
		{
			con.close();
		}
	}
	public void eliminar(TipoDoc td)throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		Statement cmd = null;
		try
		{
			
			cmd = con.createStatement();
			cmd.executeQuery("delete from tiposdoc "+
								"where idtipo = " + td.getIdTipoDoc() );		
		}
		catch(Exception e)
		{
			System.out.println("No se elimino tipo doc "+ e.getStackTrace());
			throw new Exception("No se eliminó Tipo doc. Intente nuevamente. Si el problema persiste, llame a alguien",e);
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
