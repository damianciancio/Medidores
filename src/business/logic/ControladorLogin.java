package business.logic;
import data.*;
import business.entities.Usuario;

public class ControladorLogin {

	
		
	public Usuario validarUsuario(Usuario usr) throws Exception
	{
		try
		{
			UsuarioLogic ul = new UsuarioLogic();
			return ul.buscarUsuario(usr);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	
	
}
