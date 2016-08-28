package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.Provincia;

public class ProvinciaData 
{
	public ArrayList<Provincia> devolverProvincias() throws Exception
	{
	
		Connection con = Conexion.obtenerConexion();
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<Provincia> provincias = new ArrayList<Provincia>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM provincias");
		    while(rs.next())
			{
				Provincia pro = new Provincia();
				this.mapear(rs, pro);
				provincias.add(pro);
			}
		
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select. " + e.getStackTrace());
			throw new Exception("Error al obtener las provincias. Intente nuevamente. Si el problema persiste, llame a alguien.", e);
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
		
		return provincias;
	}
	
	
	public Provincia mapear(ResultSet rs, Provincia pro)
	{
		try {
			if(rs.next()){
				pro = new Provincia();
				pro.setIdProvincia(rs.getString(1));
				pro.setDescProvincia(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pro;
	}
	
	
	public Provincia buscar(Provincia pro) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		
		ResultSet rs = null;
		Statement cmd = null;
		Provincia find = null;
		try {
	
		    cmd = con.createStatement();
		    rs = cmd.executeQuery("select idprovincia, descprovincia "+
		    						"from provincias "+
		    						"where provincias.idprovincia =" + pro.getIdProvincia());
		    find = this.mapear(rs, find);
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select para buscar provincia. "+ e.getStackTrace());
			throw new Exception("Error al buscar la provincia. Intente nuevamente, si el problema persiste, llame a alguien. ", e);
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

	
		
}
