package logico;

import java.util.ArrayList;

public class SolicitudEmpleado extends Solicitud {

	private Empresa solicitante;
	private float salariomin;
	private Persona info;
	
	public SolicitudEmpleado(String codigo, String modalidadUbicacion, String modalidadTiempo, String ubicacion,
			ArrayList<String> idiomas, String sexo, boolean oktomove, boolean vehiculoPropio, Usuario creador,
			float salariomin, Persona info) {
		super(codigo, modalidadUbicacion, modalidadTiempo, ubicacion, idiomas, sexo, oktomove, vehiculoPropio, creador);
		this.salariomin = salariomin;
		this.info = info;
	}

	public Empresa getSolicitante() {
		return solicitante;
	}

	public float getSalariomin() {
		return salariomin;
	}

	public Persona getInfo() {
		return info;
	}

	public void setSolicitante(Empresa solicitante) {
		this.solicitante = solicitante;
	}
	
	
}
