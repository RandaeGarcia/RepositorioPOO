package logico;

import java.util.Date;

public class Tecnico extends Persona {

	private String area;
	private int yearsExperiencia;
	
	public Tecnico(String nombre, String cedula, String telefono, String pais, String sexo, String campolaboral,
			String email, Date fechaNacimiento, String area, int yearsExperiencia) {
		super(nombre, cedula, telefono, pais, sexo, campolaboral, email, fechaNacimiento);
		this.area = area;
		this.yearsExperiencia = yearsExperiencia;
	}

	public String getArea() {
		return area;
	}

	public int getYearsExperiencia() {
		return yearsExperiencia;
	}
	
}
