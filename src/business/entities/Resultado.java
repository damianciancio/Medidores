package business.entities;

public class Resultado extends Entidad
{
	private int idResultado;
	private String descResultado;
	
	public int getIdResultado() {
		return idResultado;
	}
	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}
	public String getDescResultado() {
		return descResultado;
	}
	public void setDescResultado(String descResultado) {
		this.descResultado = descResultado;
	}
	public String toString()
	{
		return this.getDescResultado();
	}
}
