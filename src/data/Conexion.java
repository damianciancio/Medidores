package data;
import java.sql.*;


public class Conexion {
	static private void registrarConexion()
	{
		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    System.out.println("Driver Mysql encontrado");

		} catch (Exception e) {

		    System.out.println(e.toString());

		}
	}
	
	public static Connection obtenerConexion(String nombreBD)
	{
		
		
		registrarConexion();
		Connection con = null;

		try {

		    con = DriverManager.getConnection(
		            "jdbc:mysql://localhost/"+nombreBD
		            + "?user=root&password=root&useSSL=false");
		    	return con;
		    

		} catch (SQLException ex) {
			
		    System.out.println("SQLException: " + ex.getMessage());
		    return null;
		}
	}
}
