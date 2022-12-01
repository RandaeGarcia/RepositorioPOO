package logico;

import java.util.ArrayList;

public class SolicitudEmpleado extends Solicitud {

	private float salariomin;
	private Persona info;
	
	public SolicitudEmpleado(String codigo, String campLab, String modalidad, String tiempo, String puesto, String ubicacion,
			ArrayList<String> idiomas, String sexo, int exp, String dispMov, String vehiculoPropio, String licencia,
			Usuario creador, boolean estado, float salariomin, Persona info) {
		super(codigo, campLab, modalidad, tiempo, puesto, ubicacion, idiomas, sexo, exp, dispMov, vehiculoPropio, licencia,
				creador, estado);
		this.salariomin = salariomin;
		this.info = info;
	}	

	public float getSalariomin() {
		return salariomin;
	}

	public Persona getInfo() {
		return info;
	}
}
