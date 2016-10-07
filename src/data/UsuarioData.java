package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import business.entities.Usuario;
import util.DataBaseException;

public class UsuarioData {
	public ArrayList<Usuario> devolverUsuarios() throws DataBaseException
	{
	
		Connection con = Conexion.obtenerConexion();
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM usuarios");
		    while(rs.next())
			{
				usuarios.add(this.mapear(rs));
			}
	
		    
		} catch (SQLException e)
		{
			throw new DataBaseException("No se pueden encontrar los usuarios. Intente nuevamente. Si este problema persiste, llame a alguien.", e);
		}
		catch(DataBaseException dbe)
		{
			throw dbe;
		}
		
					
		try 
			{
			con.close();
			}
		catch(SQLException e) {
			System.out.println("Conexion no cerrada. " + e.getStackTrace());
		}
		finally
		{
			cmd = null;
			try {
				con.close();
			} catch (SQLException e) {
				throw new DataBaseException("No se pudo cerrar la conexion.", e);
			}
			return usuarios;
		}
	}
	
	
	public Usuario mapear(ResultSet rs) throws DataBaseException
	{
		Usuario usr = new Usuario();
		try {

				usr.setIdUsuario(rs.getInt(1));
				usr.setUserNombre(rs.getString(2));
				usr.setPass(rs.getString(3));
				usr.setHabilitado(rs.getBoolean(4));
			
		} catch (SQLException e) {
			throw new DataBaseException("Problema con result set",e);
		}
		return usr;
	}
	
	
	public Usuario buscar(Usuario usr) throws DataBaseException
	{
		Connection con = Conexion.obtenerConexion();
		
		ResultSet rs = null;
		PreparedStatement cmd = null;
		Usuario find = null;
		try {
			
		    String query = "SELECT * FROM usuarios " + 
					"where( usuarios.userName = ? and usuarios.pass = ?)";
		    cmd = con.prepareStatement(query);
		    cmd.setString(1,usr.getUserNombre());
		    cmd.setString(2,usr.getPass());
		    rs = cmd.executeQuery();

		    
		    if(rs.next())
		    	try
		    {
		    		find = this.mapear(rs);
		    }
		    catch (DataBaseException dbe)
		    {
		    	throw dbe;
		    }
		} catch (SQLException e)
		{
			throw new DataBaseException("Fallo al buscar Usuario. De persistir este problema, consulte a alguien.",e);
		}
		
		finally
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				throw new DataBaseException("No se cerro una conexion a la base de datos. De tener problemas de lentitud, guarde todo lo necesario y reinicie la aplicacion",e);
			}
		}
		return find;
	}

	public void actualizar(Usuario usr) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		PreparedStatement cmd = null;
		
		try
		{
			String query = "update usuarios set userName= ?, pass= ?, habilitado= ? "
					+ "where idusuarios = ?";
			cmd = con.prepareStatement(query);
			cmd.setString(1, usr.getUserNombre());
			cmd.setString(2, usr.getPass());
			cmd.setBoolean(3, usr.isHabilitado());
			cmd.setInt(4, usr.getIdUsuario());
			cmd.executeUpdate();
			
		}
		catch (SQLException e)
		{
			throw new DataBaseException("Error al actualizar usuario "+usr.getUserNombre(), e);
		}
		finally
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				throw new DataBaseException("No se cerro una conexion a la base de datos. De tener problemas de lentitud, guarde todo lo necesario y reinicie la aplicacion",e);
			}
		}
	}
	public void agregarUsuario(Usuario usr)throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		PreparedStatement cmd = null;
		try 
		{

		    String query = new String("Insert into usuarios (userName, pass) "
		    		+ "values (? , ?)");
		    cmd = con.prepareStatement(query);
		    cmd.setString(1, usr.getUserNombre());
		    cmd.setString(2, usr.getPass());
		    cmd.execute();
		    
		} 
		catch (SQLException e)
		{
			System.out.println("Fallo el insert");
			throw new DataBaseException("No se pudo agregar usuario a la base de datos. Intente nuevamente. Si el problema persiste llamar a alguien", e);
		}
		finally
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				throw new DataBaseException("No se cerro una conexion a la base de datos. De tener problemas de lentitud, guarde todo lo necesario y reinicie la aplicacion",e);
			}
			cmd = null;
		}
		
	}
	
	public void eliminar(Usuario usr) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		PreparedStatement cmd = null;
		try
		{
			String query = "delete from usuarios "+
					"where idusuarios = ?" ;
			cmd = con.prepareStatement(query);
			cmd.executeQuery();		
		}
		catch(Exception e)
		{
			System.out.println("No se elimino usuario "+ e.getStackTrace());
			throw new Exception("No se elimin� usuario. Intente nuevamente. Si el problema persiste, llame a alguien",e);
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
