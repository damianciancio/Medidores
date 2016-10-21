package business.entities;

public class Calle extends Entidad {
	private int idCalle;
	private String nomCalle;
	
	public int getIdCalle() {
		return idCalle;
	}
	public void setIdCalle(int idCalle) {
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
