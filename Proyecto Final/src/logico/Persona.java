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
	protected String nivelEst;
	protected String email;
	protected boolean estado;
	protected Date fechaNacimiento;
	
	public Persona(String nombre, String cedula, String telefono, String pais, String sexo, String nivelEst,
			String email, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.pais = pais;
		this.sexo = sexo;
		this.nivelEst = nivelEst;
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

	public String getNivelEst() {
		return nivelEst;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
