package business.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.State;

public class Usuario extends Entidad {
	private int idUsuario;
	private String userNombre;
	private String pass;
	
	public Usuario()
	{
		
	}
	
	public Usuario (State es)
	{
		this();
		this.estado = es;
	}
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUserNombre() {
		return userNombre;
	}
	public void setUserNombre(String userNombre) {
		this.userNombre = userNombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
