package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.Calle;
import business.entities.Inspeccion;
import business.entities.Reclamo;
import business.entities.TipoReclamo;

public class InspeccionData {
	
		public void agregarInspeccion(Inspeccion ins) throws SQLException, Exception
		{
		try {
			Connection con = Conexion.obtenerConexion();
			PreparedStatement cmd = null;
			String stringInsert = "insert into inspecciones "+
		    "( nroReclamo, nroMedidor, fechaInspeccion, tipoDoc, nroDoc, "
		    + "codMarca, modelo, nroSerie, cteNominal, factorMultipl, tipoMedi, "
		    + "nClase, estadoContadorAntes, estadoContadorDespues, estadoGeneral, estadoConexion, "
		    + "marchaVacio, perdidas, errorGral, estado, codResultado, lectura1, error1, "
		    + "lectura2, error2, lectura3, error3, observaciones, atendiente) values "+
		    "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		    
			
			
			cmd = con.prepareStatement(stringInsert);
		    cmd.setInt(1, ins.getNroReclamo());
		    cmd.setString(2, ins.getNroMedidor());
		    cmd.setDate(3, ins.getFechaInspeccion());
		    cmd.setString(4, ins.getTipoDoc().getIdTipoDoc());
		    cmd.setInt(5, ins.getNroDoc());
		    cmd.setInt(6, ins.getMarca().getIdMarca());
		    cmd.setString(7, ins.getModelo());
		    cmd.setString(8, ins.getNroSerie());
		    cmd.setString(9, ins.getCteNominal());
		    cmd.setFloat(10, ins.getFactorMultipl());
		    cmd.setString(11, ins.getTipoMedidor());
		    cmd.setInt(12, ins.getClase());
		    cmd.setInt(13, ins.getEstadoContadorAntes());
		    cmd.setInt(14, ins.getEstadoContadorDespues());
		    cmd.setString(15, ins.getEstadoGeneral());
		    cmd.setString(16, ins.getEstadoConexion());
		    cmd.setString(17, ins.getMarchaVacio());
		    cmd.setString(18, ins.getPerdidas());
		    cmd.setFloat(19, ins.getErrorGral());
		    cmd.setString(20, ins.getEstado());
		    cmd.setInt(21, ins.getResultado().getIdResultado());
		    cmd.setFloat(22, ins.getLecturas()[0].getLectura());
		    cmd.setFloat(23, ins.getLecturas()[0].getError());
		    cmd.setFloat(24, ins.getLecturas()[1].getLectura());
		    cmd.setFloat(25, ins.getLecturas()[1].getError());
		    cmd.setFloat(26, ins.getLecturas()[2].getLectura());
		    cmd.setFloat(27, ins.getLecturas()[2].getError());
		    cmd.setString(28, ins.getObservaciones());
		    cmd.setString(29, ins.getAtendiente());
		    
		    
		    
		    
		    
		    
		    
		    cmd.executeUpdate();
		    int a = 0;
		    int b = 1;
		    int c = b/a;
		    
		
		con.close();    							
		} catch (SQLException e)
		{
			throw (new Exception("No se pudo insertar en la base de datos",e));
		}
		catch(ArithmeticException ae)
		{
			throw new Exception("Insertado correctamente",ae);
		}
		catch (Exception ex)
		{
			throw new Exception("No se pudo insertar en la base de datos", ex);
		}
		
	}
	
	

	public Inspeccion buscar(Inspeccion ins) throws Exception
	{
		Connection con = Conexion.obtenerConexion();
		
		ResultSet rs = null;
		Statement cmd = null;
		Inspeccion find = null;
		try {
	
		    cmd = con.createStatement();
		    rs = cmd.executeQuery("select * "+
		    						"from inspecciones "+
		    						"where inspecciones.idInspeccion =" + ins.getIdInspeccion());
		    //find = this.mapear(rs);
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select para buscar reclamo. "+ e.getStackTrace());
			throw new Exception("Error al recuperar el reclamo. Intente nuevamente, si el problema persiste, llame a alguien. ", e);
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
	

	
//	public ArrayList<Inspeccion> devolverInspecciones()
//	{
//	
//		Connection con = Conexion.obtenerConexion("medidores");
//		
//		ResultSet rs = null;
//		Statement cmd = null;
//		ArrayList<Inspeccion>  ins = new ArrayList<Inspeccion>();
//			
//	
//		try {
//	
//		    cmd = con.createStatement();
//	
//		    rs = cmd.executeQuery("select * FROM INSPECCIONES");
//		    
//		} catch (SQLException e)
//		{
//			System.out.println("Fallo el select");
//		}
//		
//		try {
//			while(rs.next())
//			{
//				Inspeccion inspec = new Inspeccion();
//				//inspec = this.mapear(rs);
//				ins.add(inspec);
//			}
//		
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		
//		
//		
//		try 
//			{
//			con.close();
//			}
//		catch(SQLException e) {
//			System.out.println("Conexion no cerrada");
//		}
//		return ins;
//	}
//	
//	public Inspeccion mapear (ResultSet rs)
//	{
//		Inspeccion in = new Inspeccion();
//		try {
//				
//				
//				
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return rec;
//	}
//
//	public void actualizar(Inspeccion in) throws Exception
//	{
//		Connection con = Conexion.obtenerConexion("medidores");
//			PreparedStatement cmd = null;
//		
//		try
//		{
//			String stringInsert = "update reclamos (nomTitular, codCalle, "+
//		    "altura, piso, depto, letraDir, bis, idtiporeclamo, fechaIngreso, idEstado)values (?,?,?,?,?,?,?,?,?,?)"
//		    + "where idReclamo = ?";
//			cmd = con.prepareStatement(stringInsert);
//		    cmd.setString(1, rec.getNomTitular());
//		    cmd.setString(2, rec.getCalle().getIdCalle());
//		    cmd.setInt(3, rec.getAltura());
//		    if(rec.getPiso() == null)
//		    {
//		    	cmd.setNull(4, java.sql.Types.VARCHAR);
//		    }
//		    else
//		    {
//		    	cmd.setString(4, rec.getPiso());
//		    }
//		    if(rec.getDepto() == null){
//		    	cmd.setNull(5, java.sql.Types.VARCHAR);
//		    }
//		    else{
//		    	cmd.setString(5, rec.getDepto());
//		    }
//		    if(rec.getLetraDir() == null){
//		    	cmd.setNull(6, java.sql.Types.VARCHAR);
//		    }
//		    else{
//		    	cmd.setString(6, rec.getLetraDir());
//		    }
//		    cmd.setString(7, rec.getBis());
//		    cmd.setInt(8, rec.getTipoReclamo().getIdTipoReclamo());
//		    cmd.setDate(9, rec.getFechaIngreso());
//		    cmd.setInt(10, rec.getIdEstado());
//		    cmd.setInt(11, rec.getIdReclamo());
//		}
//		catch (Exception e)
//		{
//			System.out.println("No anduvo update reclamos. " + e.getStackTrace());
//			throw new Exception("Error al conectar a la base de datos, si la aplicaci�n se torna lento, guarde lo que necesita y reiniciela.", e);
//		}
//		finally
//		{
//			con.close();
//		}
//	}
//	public void eliminar(Reclamo re)throws Exception
//	{
//		Connection con = Conexion.obtenerConexion("medidores");
//		Statement cmd = null;
//		try
//		{
//			
//			cmd = con.createStatement();
//			cmd.executeQuery("delete from reclamos "+
//								"where idreclamo = " + re.getIdReclamo() );		
//		}
//		catch(Exception e)
//		{
//			System.out.println("No se eliminó reclamo"+ e.getStackTrace());
//			throw new Exception("No se eliminó reclamo. Intente nuevamente. Si el problema persiste, llame a alguien",e);
//		}
//		finally
//		{
//			try
//		
//			{
//				con.close();
//			}
//			catch (Exception e)
//			{
//				System.out.println("No se cerró la conexión a la base de datos."+e.getStackTrace());
//				throw new Exception("No se cerró una conexión a la base de datos. De tener problemas de lentitud, guarde todo lo necesario y reinicie la aplicacion",e);
//			}
//		}
//	}
}
