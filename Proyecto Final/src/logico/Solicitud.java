package logico;

import java.util.ArrayList;

public abstract class Solicitud {

	protected String modalidadubicacion;
	protected String modalidadtiempo;
	protected String ubicacion;
	protected ArrayList<String> idiomas;
	protected boolean oktomove;
	protected boolean licenciaConduccion;
	protected boolean estado;
	protected int cantpuestos;
	protected float salariomin;
	protected float salariomax;
	protected float matchpercent;
	
	public Solicitud(String modalidadubicacion, String modalidadtiempo, String ubicacion, ArrayList<String> idiomas,
			boolean oktomove, boolean licenciaConduccion, int cantpuestos, float salariomin, float salariomax,
			float matchpercent) {
		super();
		this.modalidadubicacion = modalidadubicacion;
		this.modalidadtiempo = modalidadtiempo;
		this.ubicacion = ubicacion;
		this.idiomas = new ArrayList<>();
		this.idiomas = idiomas;
		this.oktomove = oktomove;
		this.licenciaConduccion = licenciaConduccion;
		this.cantpuestos = cantpuestos;
		this.salariomin = salariomin;
		this.salariomax = salariomax;
		this.matchpercent = matchpercent;
		this.estado = true;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCantpuestos() {
		return cantpuestos;
	}

	public void setCantpuestos(int cantpuestos) {
		this.cantpuestos = cantpuestos;
	}

	public String getModalidadubicacion() {
		return modalidadubicacion;
	}

	public String getModalidadtiempo() {
		return modalidadtiempo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public boolean isOktomove() {
		return oktomove;
	}

	public boolean isLicenciaConduccion() {
		return licenciaConduccion;
	}

	public float getSalariomin() {
		return salariomin;
	}

	public float getSalariomax() {
		return salariomax;
	}

	public float getMatchpercent() {
		return matchpercent;
	}
	
	
}
