package logico;

import java.util.ArrayList;

public class SolicitudEmpleado extends Solicitud {

	private float salariomin;
	private Persona info;
	
	public SolicitudEmpleado(String codigo, String campLab, String modalidad, String tiempo, String especialidad, String ubicacion,
			ArrayList<String> idiomas, String sexo, int exp, String dispMov, String vehiculoPropio, String licencia,
			Usuario creador, boolean estado, float salariomin, Persona info) {
		super(codigo, campLab, modalidad, tiempo, especialidad, ubicacion, idiomas, sexo, exp, dispMov, vehiculoPropio, licencia,
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

	public void setSalariomin(float salariomin) {
		this.salariomin = salariomin;
	}

	public void setInfo(Persona info) {
		this.info = info;
	}
}
