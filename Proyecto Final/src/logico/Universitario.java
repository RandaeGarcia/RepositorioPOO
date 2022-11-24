package logico;

import java.util.Date;

public class Universitario extends Persona {
	
	private String carrera;
	private int yearGraduacion;
	
	public Universitario(String nombre, String cedula, String telefono, String pais, String sexo, String campolaboral,
			String email, Date fechaNacimiento, String carrera, int yearGraduacion) {
		super(nombre, cedula, telefono, pais, sexo, campolaboral, email, fechaNacimiento);
		this.carrera = carrera;
		this.yearGraduacion = yearGraduacion;
	}

	public String getCarrera() {
		return carrera;
	}

	public int getYearGraduacion() {
		return yearGraduacion;
	}

}
