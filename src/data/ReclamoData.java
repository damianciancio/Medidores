package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.entities.Calle;
import business.entities.Reclamo;
import business.entities.TipoReclamo;

public class ReclamoData 
{
	
	public void agregarReclamo(Reclamo rec)
	{
		try {
			Connection con = Conexion.obtenerConexion("medidores");
			PreparedStatement cmd = null;
			String stringInsert = "insert into reclamos "+
		    "(nomTitular, codCalle, altura, piso, depto, "+
		    "letraDir, bis, idtiporeclamo, fechaingreso, idestado) values "+
		    "( ?,?,?,?,?,?,?,?,?,?)";
		    
			
			
			cmd = con.prepareStatement(stringInsert);
		    cmd.setString(1, rec.getNomTitular());
		    cmd.setString(2, rec.getCalle().getIdCalle());
		    cmd.setInt(3, rec.getAltura());
		    if(rec.getPiso() == null)
		    {
		    	cmd.setNull(4, java.sql.Types.VARCHAR);
		    }
		    else
		    {
		    	cmd.setString(4, rec.getPiso());
		    }
		    if(rec.getDepto() == null){
		    	cmd.setNull(5, java.sql.Types.VARCHAR);
		    }
		    else{
		    	cmd.setString(5, rec.getDepto());
		    }
		    if(rec.getLetraDir() == null){
		    	cmd.setNull(6, java.sql.Types.VARCHAR);
		    }
		    else{
		    	cmd.setString(6, rec.getLetraDir());
		    }
		    cmd.setString(7, rec.getBis());
		    cmd.setInt(8, rec.getTipoReclamo().getIdTipoReclamo());
		    cmd.setDate(9, rec.getFechaIngreso());
		    cmd.setInt(10, rec.getIdEstado());
		    
		    
		    
		    
		    
		    
		    
		    
		    cmd.executeUpdate();
		    
		
		con.close();    							
		} catch (SQLException e)
		{
			System.out.println("Fallo el insert");
		}
		
	}
	
	

	public Reclamo buscar(Reclamo re) throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		
		ResultSet rs = null;
		Statement cmd = null;
		Reclamo find = null;
		try {
	
		    cmd = con.createStatement();
		    rs = cmd.executeQuery("select * "+
		    						"from reclamos "+
		    						"where reclamos.idreclamo =" + re.getIdReclamo());
		    find = this.mapear(rs);
		    
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
	
	
	public String devolverStringInsert(Reclamo rec)
	{
		String cadena = new String();
		cadena = "(\""+rec.getNomTitular()+"\",\""+rec.getCalle().getIdCalle()+"\", "+rec.getAltura()+",\" "+rec.getPiso()+"\", \""+
		"\", \""+rec.getDepto()+"\", \""+rec.getBis()+"\", "+rec.getTipoReclamo().getIdTipoReclamo()+" ,\""+rec.getFechaIngreso()+"\", "+rec.getIdEstado()+")";
		return cadena;
	}
	public ArrayList<Reclamo> devolverReclamos()
	{
	
		Connection con = Conexion.obtenerConexion("medidores");
		
		ResultSet rs = null;
		Statement cmd = null;
		ArrayList<Reclamo>  rec = new ArrayList<Reclamo>();
			
	
		try {
	
		    cmd = con.createStatement();
	
		    rs = cmd.executeQuery("SELECT idReclamo, nomTitular, codCalle, altura, "+
		    		"piso, depto, letraDir, bis, reclamos.idtiporeclamo, fechaIngreso, "+
		    		"idEstado, callesRosariocol, desctiporeclamo,  ifnull(resultados.descResult, \"Pendiente de inspeccion\") resultado "+
		    		"FROM reclamos "+ 
		    		"inner join callesrosario "+
		    		"on codCalle = idcallesrosario "+ 
		    		"left join tiporeclamo "+
		    		"on reclamos.idtiporeclamo = tiporeclamo.idtiporeclamo "+
		    		"left join inspecciones "+
		    		"on inspecciones.nroReclamo = reclamos.idreclamo "+
		    		"left join resultados "+
		    		"on resultados.idResult = inspecciones.codResultado "+
		    		"order by reclamos.idreclamo desc");
	
		    
		} catch (SQLException e)
		{
			System.out.println("Fallo el select");
		}
		
		try {
			while(rs.next())
			{
				Reclamo recl = new Reclamo();
				recl = this.mapear(rs);
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
	
	public Reclamo mapear (ResultSet rs)
	{
		Reclamo rec = new Reclamo();
		try {
				
				TipoReclamo tr = new TipoReclamo();
				tr.setIdTipoReclamo(rs.getInt(9));
				tr.setDescTipoReclamo(rs.getString(13));
				Calle ca = new Calle();
				ca.setIdCalle(rs.getString(3));
				ca.setNomCalle(rs.getString(12));
				rec.setIdReclamo(rs.getInt(1));
				rec.setNomTitular(rs.getString(2));
				rec.setCalle(ca);
				rec.setAltura(rs.getInt(4));
				rec.setPiso(rs.getString(5));
				rec.setDepto(rs.getString(6));
				rec.setLetraDir(rs.getString(7));
				rec.setBis(rs.getString(8));
				rec.setTipoReclamo(tr);
				rec.setFechaIngreso(rs.getDate(10));
				rec.setIdEstado(rs.getInt(11));
				rec.setEstadoAux(rs.getString(14));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rec;
	}

	public void actualizar(Reclamo re) throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		Statement cmd = null;
		
		try
		{
			cmd = con.createStatement();
			cmd.executeQuery("update reclamos (idReclamo, nomTitular, codCalle, "+
		    "altura, piso, depto, letraDir, bis, idtiporeclamo, fechaIngreso, idEstado)values (" + re.getIdReclamo()+", "+re.getNomTitular()+", "+re.getCalle().getIdCalle()+", "+ 
					re.getAltura()+", "+ re.getPiso()+", "+ re.getDepto()+ ", "+ re.getLetraDir()
					+", "+ re.getBis()+ ", "+ re.getTipoReclamo().getIdTipoReclamo()+", "+re.getFechaIngreso().toString()+", "+re.getIdEstado()+")");
			
		}
		catch (Exception e)
		{
			System.out.println("No anduvo update reclamos. " + e.getStackTrace());
			throw new Exception("Error al conectar a la base de datos, si la aplicaci�n se torna lento, guarde lo que necesita y reiniciela.", e);
		}
		finally
		{
			con.close();
		}
	}
	public void eliminar(Reclamo re)throws Exception
	{
		Connection con = Conexion.obtenerConexion("medidores");
		Statement cmd = null;
		try
		{
			
			cmd = con.createStatement();
			cmd.executeQuery("delete from reclamos "+
								"where idreclamo = " + re.getIdReclamo() );		
		}
		catch(Exception e)
		{
			System.out.println("No se eliminó reclamo"+ e.getStackTrace());
			throw new Exception("No se eliminó reclamo. Intente nuevamente. Si el problema persiste, llame a alguien",e);
		}
		finally
		{
			try
		
			{
				con.close();
			}
			catch (Exception e)
			{
				System.out.println("No se cerró la conexión a la base de datos."+e.getStackTrace());
				throw new Exception("No se cerró una conexión a la base de datos. De tener problemas de lentitud, guarde todo lo necesario y reinicie la aplicacion",e);
			}
		}
	}
}
