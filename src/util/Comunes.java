package util;

import java.util.Calendar;

public class Comunes {
	public String getFechaHoy()
	{
		return String.valueOf(Calendar.getInstance().get(Calendar.YEAR))+
		'-'+String.valueOf(Calendar.getInstance().get(Calendar.MONTH))+
		'-'+String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	}
}
