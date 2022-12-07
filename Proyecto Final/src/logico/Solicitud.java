package logico;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Solicitud implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String codigo;
	protected String nivelEst;
	protected String modalidad;
	protected String tiempo;
	protected String especialidad;
	protected String ubicacion;
	protected ArrayList<String> idiomas;
	protected String sexo;
	protected int exp;
	protected String dispMov;
	protected String vehiculoPropio;
	protected String licencia;
	protected Usuario creador;
	protected boolean estado;
	
	public Solicitud(String codigo, String nivelEst, String modalidad, String tiempo, String especialidad, String ubicacion,
			ArrayList<String> idiomas, String sexo, int exp, String dispMov, String vehiculoPropio, String licencia,
			Usuario creador, boolean estado) {
		super();
		this.codigo = codigo;
		this.nivelEst = nivelEst;
		this.modalidad = modalidad;
		this.tiempo = tiempo;
		this.especialidad = especialidad;
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
	
	public String getNivelEst() {
		return nivelEst;
	}

	public String getModalidad() {
		return modalidad;
	}

	public String getTiempo() {
		return tiempo;
	}

	public String getEspecialidad() {
		return especialidad;
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

	public String getDispMov() {
		return dispMov;
	}

	public String getVehiculoPropio() {
		return vehiculoPropio;
	}

	public String getLicencia() {
		return licencia;
	}

	public Usuario getCreador() {
		return creador;
	}
}