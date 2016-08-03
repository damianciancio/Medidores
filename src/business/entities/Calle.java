package business.entities;

public class Calle extends Entidad {
	private String idCalle;
	private String nomCalle;
	
	public String getIdCalle() {
		return idCalle;
	}
	public void setIdCalle(String idCalle) {
		this.idCalle = idCalle;
	}
	public String getNomCalle() {
		return nomCalle;
	}
	public void setNomCalle(String nomCalle) {
		this.nomCalle = nomCalle;
	}
	
	
	
	public String toString()
	{
		return this.getNomCalle();
	}
}
