package logico;

public class Tecnico extends Persona {
	private String area;
	private int yearsExperiencia;
	
	public Tecnico(String cedula, String nombre, String telefono, String pais, String campoLaboral, String email,
			String estado, Solicitud solicitud, String area, int yearsExperiencia) {
		super(cedula, nombre, telefono, pais, campoLaboral, email, estado, solicitud);
		this.area = area;
		this.yearsExperiencia = yearsExperiencia;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getYearsExperiencia() {
		return yearsExperiencia;
	}

	public void setYearsExperiencia(int yearsExperiencia) {
		this.yearsExperiencia = yearsExperiencia;
	}
}
