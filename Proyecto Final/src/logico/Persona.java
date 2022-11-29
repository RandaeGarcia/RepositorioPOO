package logico;

import java.io.Serializable;
import java.util.Date;

public abstract class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String cedula;
	protected String telefono;
	protected String pais;
	protected String sexo;
	protected String campolaboral;
	protected String email;
	protected boolean estado;
	protected Date fechaNacimiento;
	
	public Persona(String nombre, String cedula, String telefono, String pais, String sexo, String campolaboral,
			String email, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.pais = pais;
		this.sexo = sexo;
		this.campolaboral = campolaboral;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = true;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getPais() {
		return pais;
	}

	public String getSexo() {
		return sexo;
	}

	public String getCampolaboral() {
		return campolaboral;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	
}
