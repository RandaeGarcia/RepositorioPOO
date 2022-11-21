package logico;

import java.util.ArrayList;

public class Empresa {

	private String codigo;
	private String nombre;
	private String tipo;
	private String email;
	private String pais;
	private ArrayList<Solicitud> empleos;
	
	public Empresa(String codigo, String nombre, String tipo, String email, String pais) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.email = email;
		this.pais = pais;
		this.empleos = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEmail() {
		return email;
	}

	public String getPais() {
		return pais;
	}

	public ArrayList<Solicitud> getEmpleos() {
		return empleos;
	}
	
	
}
