package logico;

import java.util.ArrayList;

public class SolicitudObrero extends Solicitud {

	private ArrayList<String> listoficios;

	public SolicitudObrero(String modalidadubicacion, String modalidadtiempo, String ubicacion,
			ArrayList<String> idiomas, boolean oktomove, boolean licenciaConduccion, int cantpuestos, float salariomin,
			float salariomax, float matchpercent, ArrayList<String> listoficios) {
		super(modalidadubicacion, modalidadtiempo, ubicacion, idiomas, oktomove, licenciaConduccion, cantpuestos,
				salariomin, salariomax, matchpercent);
		this.listoficios = listoficios;
	}

	public ArrayList<String> getListoficios() {
		return listoficios;
	}
	
}
