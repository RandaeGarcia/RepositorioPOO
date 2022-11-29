package logico;

import java.util.ArrayList;

public abstract class Solicitud {

	protected String codigo;
	protected String campLab;
	protected String modalidad;
	protected String tiempo;
	protected String puesto;
	protected String ubicacion;
	protected ArrayList<String> idiomas;
	protected String sexo;
	protected int exp;
	protected boolean dispMov;
	protected boolean vehiculoPropio;
	protected boolean licencia;
	protected Usuario creador;
	protected boolean estado;
	
	public Solicitud(String codigo, String campLab, String modalidad, String tiempo, String puesto, String ubicacion,
			ArrayList<String> idiomas, String sexo, int exp, boolean dispMov, boolean vehiculoPropio, boolean licencia,
			Usuario creador, boolean estado) {
		super();
		this.codigo = codigo;
		this.campLab = campLab;
		this.modalidad = modalidad;
		this.tiempo = tiempo;
		this.puesto = puesto;
		this.ubicacion = ubicacion;
		this.idiomas = idiomas;
		this.sexo = sexo;
		this.exp = exp;
		this.dispMov = dispMov;
		this.vehiculoPropio = vehiculoPropio;
		this.licencia = licencia;
		this.creador = creador;
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public String campLab() {
		return codigo;
	}

	public String getModalidad() {
		return modalidad;
	}

	public String getTiempo() {
		return tiempo;
	}

	public String getPuesto() {
		return puesto;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public String getSexo() {
		return sexo;
	}

	public int getExp() {
		return exp;
	}

	public boolean isDispMov() {
		return dispMov;
	}

	public boolean isVehiculoPropio() {
		return vehiculoPropio;
	}

	public boolean isLicencia() {
		return licencia;
	}

	public Usuario getCreador() {
		return creador;
	}
	
	
}