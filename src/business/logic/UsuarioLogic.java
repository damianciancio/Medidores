package business.logic;
import util.*;

import java.util.ArrayList;
import java.util.List;

import data.UsuarioData;
import business.entities.Usuario;

public class UsuarioLogic 
{
	
	
	public Usuario buscarUsuario(Usuario user) throws DataBaseException
	{
		try
		{
			UsuarioData ud = new UsuarioData();
			return ud.buscar(user);
		}
		catch (DataBaseException e)
		{
			throw e;
		}
	}
	
	public ArrayList<Usuario> devolverUsuarios() throws Exception
	{
		try
		{
			UsuarioData ud = new UsuarioData();
			return ud.devolverUsuarios();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public void guardaCambios(Usuario usr) throws Exception
	{
		try
		{
			UsuarioData ud = new UsuarioData();
			if(usr.estado == State.ACTUALIZAR)
			{
				ud.actualizar(usr);
			}
			else if (usr.estado == State.NUEVO)
			{
				ud.agregarUsuario(usr);
			}
			else if (usr.estado == State.ELIMINAR)
			{
				ud.eliminar(usr);
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}
	
	
}
