package util;

public class DataBaseException extends Exception
{
	private String mensaje;
	public String getMessage()
	{
		return mensaje;
	}
	public DataBaseException(String msj, Exception causa)
	{
		this.mensaje = msj;
		this.initCause(causa);
	}
}
