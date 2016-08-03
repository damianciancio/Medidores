package business.entities;

import java.sql.*;

public class Reclamo extends Entidad {
	private int idReclamo;
	private String nomTitular;
	private Calle calle;
	private int altura;
	private String piso;
	private String depto;
	private String letraDir;
	private boolean bis;
	private TipoReclamo tipoReclamo;
	private Date fechaIngreso;
	private int idEstado;
	private String estadoAux;
	
	
	
	
	public String getEstadoAux() {
		return estadoAux;
	}

	public void setEstadoAux(String estadoAux) {
		this.estadoAux = estadoAux;
	}

	public String devolverDatos()
	{
		return this.getNomTitular();
	}
	
	public String getBis()
	{
		if (bis) return "SI"; else return "NO";
	}
	
	public int getIdReclamo() {
		return idReclamo;
	}
	public void setIdReclamo(int idReclamo) {
		this.idReclamo = idReclamo;
	}
	public String getNomTitular() {
		return nomTitular;
	}
	public void setNomTitular(String nomTitular) {
		this.nomTitular = nomTitular;
	}
	public Calle getCalle() {
		return calle;
	}
	public void setCalle(Calle codCalle) {
		this.calle = codCalle;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	public String getLetraDir() {
		return letraDir;
	}
	public void setLetraDir(String letraDir) {
		this.letraDir = letraDir;
	}
	public boolean isBis() {
		return bis;
	}
	public void setBis(boolean bis) {
		this.bis = bis;
	}
	public void setBis(String es)
	{
		if(es.equals("SI")) this.bis = true;
		else this.bis = false;
	}
	public TipoReclamo getTipoReclamo() {
		return tipoReclamo;
	}
	public void setTipoReclamo(TipoReclamo atipoReclamo) {
		this.tipoReclamo = atipoReclamo;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getText()
	{
		if(this.isBis())
		{
			return "SI";
		} else return "NO";
	}
}
