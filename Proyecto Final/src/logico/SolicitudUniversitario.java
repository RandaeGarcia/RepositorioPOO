package logico;
import java.util.ArrayList;

public class SolicitudUniversitario extends Solicitud {

	private String carrera;
	private int yearGraduacion;
	
	public SolicitudUniversitario(String modalidadubicacion, String modalidadtiempo, String ubicacion,
			ArrayList<String> idiomas, boolean oktomove, boolean licenciaConduccion, int cantpuestos, float salariomin,
			float salariomax, float matchpercent, String carrera, int yearGraduacion) {
		super(modalidadubicacion, modalidadtiempo, ubicacion, idiomas, oktomove, licenciaConduccion, cantpuestos,
				salariomin, salariomax, matchpercent);
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
