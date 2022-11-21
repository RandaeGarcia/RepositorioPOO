package logico;
import java.util.ArrayList;

public class SolicitudTecnico extends Solicitud {

	private String area;
	private int yearsExperiencia;
	
	public SolicitudTecnico(String modalidadubicacion, String modalidadtiempo, String ubicacion,
			ArrayList<String> idiomas, boolean oktomove, boolean licenciaConduccion, int cantpuestos, float salariomin,
			float salariomax, float matchpercent, String area, int yearsExperiencia) {
		super(modalidadubicacion, modalidadtiempo, ubicacion, idiomas, oktomove, licenciaConduccion, cantpuestos,
				salariomin, salariomax, matchpercent);
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
