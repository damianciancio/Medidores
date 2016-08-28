package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import business.entities.Usuario;

public class UsuarioData {
	public ArrayList<Usuario> devolverUsuarios() throws Exception
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
				Usuario usr = new Usuario();
				this.mapear(rs, usr);
				usuarios.add(usr);
			}
	
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select para devolver todos los usuarios. "+ e.getStackTrace());
			throw new Exception("No se pueden encontrar los usuarios. Intente nuevamente. Si este problema persiste, llame a alguien.", e);
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
			con.close();
			return usuarios;
		}
	}
	
	
	public Usuario mapear(ResultSet rs, Usuario usr)
	{
		try {
			if(rs.next()){
				usr = new Usuario();
				usr.setIdUsuario(rs.getInt(1));
				usr.setUserNombre(rs.getString(2));
				usr.setPass(rs.getString(3));
				usr.setHabilitado(rs.getBoolean(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usr;
	}
	
	
	public Usuario buscar(Usuario usr) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		
		ResultSet rs = null;
		Statement cmd = null;
		Usuario find = null;
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM usuarios " + 
		    						"where( usuarios.userName = '"+usr.getUserNombre()+"' and usuarios.pass = '"+usr.getPass()+"')");

		    
		    
			find = this.mapear(rs, find);
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo buscar Usuario "+ e.getStackTrace());
			throw new Exception("Fallo al buscar Usuario. De persistir este problema, consulte a alguien.",e);
		}
		
		finally
		{
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				System.out.println("No se cerr� la conexi�n a la base de datos.");
				throw new Exception("No se cerr� una conexi�n a la base de datos. De tener problemas de lentitud, guarde todo lo necesario y reinicie la aplicacion",e);
			}
		}
		return find;
	}

	public void actualizar(Usuario usr) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		Statement cmd = null;
		
		try
		{
			cmd = con.createStatement();
			cmd.executeQuery("update usuarios (userName, pass) values ("+ usr.getUserNombre() +", "+usr.getPass()+")");
			
		}
		catch (Exception e)
		{
			System.out.println("No se pudo actualizar usuario "+e.getStackTrace());
			throw new Exception("Error en la base de datos, intente nuevamente", e);
		}
		finally
		{
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				System.out.println("No se cerr� la conexi�n a la base de datos.");
				throw new Exception("No se cerr� una conexi�n a la base de datos. De tener problemas de lentitud, guarde todo lo necesario y reinicie la aplicacion",e);
			}
		}
	}
	public void agregarUsuario(Usuario usr)throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		Statement cmd = null;
		try 
		{
			
		    cmd = con.createStatement();
		    String str = new String("Insert into usuarios (userName, pass) values (" + "\"" +  usr.getUserNombre() +"\" , \"" + usr.getPass()+"\")"); 
		    cmd.execute(str);
		    
		} 
		catch (SQLException e)
		{
			System.out.println("Fallo el insert");
			throw new Exception("No se pudo agregar usuario a la base de datos. Intente nuevamente. Si el problema persiste llamar a alguien", e);
		}
		finally
		{
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				System.out.println("No se cerr� la conexi�n a la base de datos.");
				throw new Exception("No se cerr� una conexi�n a la base de datos. De tener problemas de lentitud, guarde todo lo necesario y reinicie la aplicacion",e);
			}
			cmd = null;
		}
		
	}
	
	public void eliminar(Usuario usr) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		Statement cmd = null;
		try
		{
			
			cmd = con.createStatement();
			cmd.executeQuery("delete from usuarios "+
								"where idusuarios = " + usr.getIdUsuario() );		
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
