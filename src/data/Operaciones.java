package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.*;

public class Operaciones {
	
	
	
	public ArrayList<Usuario> devolverUsuarios()
	{
	
		Connection con = Conexion.obtenerConexion("medidores");
		
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM usuarios");
	
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select");
		}
		
		try {
			while(rs.next())
			{
				Usuario usr = new Usuario();
				this.setearValores(rs, usr);
				usuarios.add(usr);
			}
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		try 
			{
			con.close();
			}
		catch(SQLException e) {
			System.out.println("Conexion no cerrada");
		}
		return usuarios;
	}
	
	public ArrayList<Reclamo> devolverReclamos()
	{
	
		Connection con = Conexion.obtenerConexion("medidores");
		
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<Reclamo>  rec = new ArrayList<Reclamo>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM reclamos");
	
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select");
		}
		
		try {
			while(rs.next())
			{
				Reclamo recl = new Reclamo();
				this.setearValores(rs,recl);
				rec.add(recl);
			}
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		try 
			{
			con.close();
			}
		catch(SQLException e) {
			System.out.println("Conexion no cerrada");
		}
		return rec;
	}
	
	public ArrayList<Calle> devolverCalles()
	{
		Connection con = Conexion.obtenerConexion("medidores");
		
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<Calle>  cal = new ArrayList<Calle>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM callesRosario");
	
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select");
		}
		
		try {
			while(rs.next())
			{
				Calle call = new Calle();
				this.setearValores(rs,call);
				cal.add(call);
			}
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		try 
			{
			con.close();
			}
		catch(SQLException e) {
			System.out.println("Conexion no cerrada");
		}
		return cal;
	}
	
	public Usuario setearValores(ResultSet rs, Usuario usr)
	{
		try {
			if(rs.next()){
				usr = new Usuario();
				usr.setIdUsuario(rs.getInt(1));
				usr.setUserNombre(rs.getString(2));
				usr.setPass(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usr;
	}
	
	public void setearValores(ResultSet rs, Calle cal)
	{
		try 
		{
			rs.next();
			cal.setIdCalle(rs.getString(1));
			cal.setNomCalle(rs.getString(2));
			
			} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void setearValores(ResultSet rs, Reclamo rec)
	{
		try {
			
				rec.setIdReclamo(rs.getInt(1));
				rec.setNomTitular(rs.getString(2));
				rec.setCalle(rs.getString(3));
				rec.setAltura(rs.getInt(4));
				rec.setPiso(rs.getString(5));
				rec.setDepto(rs.getString(6));
				rec.setLetraDir(rs.getString(7));
				rec.setBis(rs.getString(8));
				rec.setIdTipoReclamo(rs.getInt(9));
				rec.setFechaIngreso(rs.getDate(10));
				rec.setIdEstado(rs.getInt(11));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario buscar(Usuario usr)
	{
		Connection con = Conexion.obtenerConexion("medidores");
		
		ResultSet rs = null;
		Statement cmd = null;
		Usuario find = null;
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT * FROM usuarios where( usuarios.userName = '"+usr.getUserNombre()+"' and usuarios.pass = '"+usr.getPass()+"')");

		    
		    
			find = this.setearValores(rs, find);
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select");
		}
		
		
		try 
			{
			con.close();
			}
		catch(SQLException e) {
			System.out.println("Conexion no cerrada");
		}
		return find;
	}
	
	public void agregarReclamo(Reclamo rec)
	{
		try {
			Connection con = Conexion.obtenerConexion("medidores");
			Statement cmd = null;
		    cmd = con.createStatement();
		    
		    cmd.execute("call insertar_reclamo "+ this.devolverStringInsert(rec)+";");
		    
		
		    							
		} catch (SQLException e)
		{
			System.out.println("Fallo el insert");
		}
	}
	
	
	public String devolverStringInsert(Reclamo rec)
	{
		String cadena = new String();
		cadena = "(\""+rec.getNomTitular()+"\",\""+rec.getCalle()+"\", "+rec.getAltura()+",\" "+rec.getPiso()+"\", \""+
		"\", \""+rec.getDepto()+"\", \""+rec.getBis()+"\", "+rec.getIdTipoReclamo()+" ,\""+rec.getFechaIngreso()+"\", "+rec.getIdEstado()+")";
		return cadena;
	}
	
}
