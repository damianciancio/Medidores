package business.entities;

public class Lectura {
	private float lectura;
	private float error;
	public float getLectura() {
		return lectura;
	}
	public void setLectura(float lectura) {
		this.lectura = lectura;
	}
	public float getError() {
		return error;
	}
	public void setError(float error) {
		this.error = error;
	}
	public Lectura(float lectura, float error)
	{
		this.lectura = lectura;
		this.error = error;
	}
}
