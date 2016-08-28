package data;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import com.mysql.jdbc.MySQLConnection;


public class Conexion {
	
	static String host;
	static String nombreBD;
	static String user;
	static String password;
	static String useSSL;
	
	static private void registrarConexion()
	{
		Properties propiedades = new Properties();
	    InputStream entrada = null;
		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    System.out.println("Driver Mysql encontrado");
		    
		    entrada = new FileInputStream("configuracion.properties");
		    propiedades.load(entrada);
		    
		    host = propiedades.getProperty("host");
		    nombreBD = propiedades.getProperty("nombreBD");
		    user = propiedades.getProperty("user");
		    password = propiedades.getProperty("password");
		    useSSL = propiedades.getProperty("useSSL");
		    
		} catch (Exception e) {

		    System.out.println(e.toString());

		}
	}
	
	public static Connection obtenerConexion()
	{
		
		registrarConexion();
		Connection con = null;

		try {
		    
			con = DriverManager.getConnection(
		            "jdbc:mysql://"+host+"/"+nombreBD
		            + "?user="+user+"&password="+password+"&useSSL="+useSSL);
		    	return con;
		    

		} catch (SQLException ex) {
			
		    System.out.println("SQLException: " + ex.getMessage());
		    return null;
		}
	}
}
