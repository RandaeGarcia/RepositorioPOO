package logico;

import java.util.ArrayList;

public class Oferta extends Solicitud {
	
	private Persona solicitante;
	private int cantpuestos;
	private float salariomax;
	private float matchpercent;
	private Empresa info;
	
	public Oferta(String codigo, String modalidadUbicacion, String modalidadTiempo, String ubicacion,
			ArrayList<String> idiomas, String sexo, boolean oktomove, boolean vehiculoPropio, Usuario creador,
			int cantpuestos, float salariomax, float matchpercent, Empresa info) {
		super(codigo, modalidadUbicacion, modalidadTiempo, ubicacion, idiomas, sexo, oktomove, vehiculoPropio, creador);
		this.cantpuestos = cantpuestos;
		this.salariomax = salariomax;
		this.matchpercent = matchpercent;
		this.info = info;
	}

	public Persona getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Persona solicitante) {
		this.solicitante = solicitante;
	}

	public int getCantpuestos() {
		return cantpuestos;
	}

	public void setCantpuestos(int cantpuestos) {
		this.cantpuestos = cantpuestos;
	}

	public float getSalariomax() {
		return salariomax;
	}

	public float getMatchpercent() {
		return matchpercent;
	}

	public Empresa getInfo() {
		return info;
	}

	
}
