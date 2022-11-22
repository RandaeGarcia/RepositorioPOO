package logico;

import java.util.ArrayList;

public class Obrero extends Persona {
	private ArrayList<String> oficiosConocidos;

	public Obrero(String cedula, String nombre, String telefono, String pais, String campoLaboral, String email,
			String estado, Solicitud solicitud, ArrayList<String> oficiosConocidos) {
		super(cedula, nombre, telefono, pais, campoLaboral, email, estado, solicitud);
		this.oficiosConocidos = new ArrayList<String>();
	}
}
