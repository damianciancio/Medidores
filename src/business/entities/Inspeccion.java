package business.entities;

import java.sql.Date;
import java.util.ArrayList;

public class Inspeccion extends Entidad{
	private int idInspeccion;
	private int nroReclamo;
	private String nroMedidor;
	private Date fechaInspeccion;
	private TipoDoc tipoDoc;
	private int nroDoc;
	private Marca marca;
	private String modelo;
	private String nroSerie;
	private String cteNominal;
	private float factorMultipl;
	private String tipoMedidor;
	private int clase;
	private int estadoContadorAntes;
	private int estadoContadorDespues;
	private String estadoGeneral;
	private String estadoConexion;
	private boolean marchaVacio;
	private boolean perdidas;
	private float errorGral;
	private String estadoIns;
	private Resultado resultado;
	private Lectura[] lecturas;
	private String observaciones;
	private String atendiente;
	
	
	public int getIdInspeccion() {
		return idInspeccion;
	}
	public void setIdInspeccion(int idInspeccion) {
		this.idInspeccion = idInspeccion;
	}
	public int getNroReclamo() {
		return nroReclamo;
	}
	public void setNroReclamo(int nroReclamo) {
		this.nroReclamo = nroReclamo;
	}
	public String getNroMedidor() {
		return nroMedidor;
	}
	public void setNroMedidor(String nroMedidor) {
		this.nroMedidor = nroMedidor;
	}
	public Date getFechaInspeccion() {
		return fechaInspeccion;
	}
	public void setFechaInspeccion(Date fechaInspeccion) {
		this.fechaInspeccion = fechaInspeccion;
	}
	public TipoDoc getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(TipoDoc tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public int getNroDoc() {
		return nroDoc;
	}
	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNroSerie() {
		return nroSerie;
	}
	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}
	public String getCteNominal() {
		return cteNominal;
	}
	public void setCteNominal(String cteNominal) {
		this.cteNominal = cteNominal;
	}
	public float getFactorMultipl() {
		return factorMultipl;
	}
	public void setFactorMultipl(float factorMultipl) {
		this.factorMultipl = factorMultipl;
	}
	public String getTipoMedidor() {
		return tipoMedidor;
	}
	public void setTipoMedidor(String tipoMedidor) {
		this.tipoMedidor = tipoMedidor;
	}
	public int getClase() {
		return clase;
	}
	public void setClase(int clase) {
		this.clase = clase;
	}
	public int getEstadoContadorAntes() {
		return estadoContadorAntes;
	}
	public void setEstadoContadorAntes(int estadoContadorAntes) {
		this.estadoContadorAntes = estadoContadorAntes;
	}
	public int getEstadoContadorDespues() {
		return estadoContadorDespues;
	}
	public void setEstadoContadorDespues(int estadoContadorDespues) {
		this.estadoContadorDespues = estadoContadorDespues;
	}
	public String getEstadoGeneral() {
		return estadoGeneral;
	}
	public void setEstadoGeneral(String estadoGeneral) {
		this.estadoGeneral = estadoGeneral;
	}
	public String getEstadoConexion() {
		return estadoConexion;
	}
	public void setEstadoConexion(String estadoConexion) {
		this.estadoConexion = estadoConexion;
	}
	public boolean isMarchaVacio() {
		return marchaVacio;
	}
	public void setMarchaVacio(boolean marchaVacio) {
		this.marchaVacio = marchaVacio;
	}
	public boolean isPerdidas() {
		return perdidas;
	}
	public void setPerdidas(boolean perdidas) {
		this.perdidas = perdidas;
	}
	public float getErrorGral() {
		return errorGral;
	}
	public void setErrorGral(float errorGral) {
		this.errorGral = errorGral;
	}
	public String getEstado() {
		return estadoIns;
	}
	public void setEstado(String estado) {
		this.estadoIns = estado;
	}
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	public Lectura[] getLecturas() {
		return lecturas;
	}
	public void setLecturas(Lectura[] lecturas) {
		this.lecturas = lecturas;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getAtendiente() {
		return atendiente;
	}
	public void setAtendiente(String atendiente) {
		this.atendiente = atendiente;
	}
	public String getMarchaVacio()
	{
		if(marchaVacio){
			return "SI";
		}
		else
		{
			return "NO";
		}
	}
	public String getPerdidas()
	{
		if (perdidas) {
			return "SI";
		}
		else{
			return "NO";
		}
	}
	
	public Inspeccion()
	{
		lecturas = new Lectura[3];
	}
}
