package logico;

public class Universitario extends Persona {
	private String carrera;
	private int yearGraduacion;
	
	public Universitario(String cedula, String nombre, String telefono, String pais, String campoLaboral, String email,
			String estado, Solicitud solicitud, String carrera, int yearGraduacion) {
		super(cedula, nombre, telefono, pais, campoLaboral, email, estado, solicitud);
		this.carrera = carrera;
		this.yearGraduacion = yearGraduacion;
	}
	
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getYearGraduacion() {
		return yearGraduacion;
	}
	public void setYearGraduacion(int yearGraduacion) {
		this.yearGraduacion = yearGraduacion;
	}
}
