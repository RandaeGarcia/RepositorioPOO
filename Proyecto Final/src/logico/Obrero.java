package logico;

import java.util.ArrayList;
import java.util.Date;

public class Obrero extends Persona {

	private ArrayList<String> oficiosconocidos;

	public Obrero(String nombre, String cedula, String telefono, String pais, String sexo, String campolaboral,
			String email, Date fechaNacimiento, ArrayList<String> oficiosconocidos) {
		super(nombre, cedula, telefono, pais, sexo, campolaboral, email, fechaNacimiento);
		this.oficiosconocidos = oficiosconocidos;
	}

	public ArrayList<String> getOficiosconocidos() {
		return oficiosconocidos;
	}
	
	
}
