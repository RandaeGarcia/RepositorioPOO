package logico;

import java.util.ArrayList;

public abstract class Persona {
	protected String cedula;
	protected String nombre;
	protected String telefono;
	protected String pais;
	protected String campoLaboral;
	protected String email;
	protected String estado;
	protected Solicitudes solicitud;
	
	public Persona(String cedula, String nombre, String telefono, String pais, String campoLaboral, String email,
			String estado, Solicitudes solicitud) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.pais = pais;
		this.campoLaboral = campoLaboral;
		this.email = email;
		this.estado = estado;
		this.solicitud = solicitud;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCampoLaboral() {
		return campoLaboral;
	}

	public void setCampoLaboral(String campoLaboral) {
		this.campoLaboral = campoLaboral;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Solicitudes getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitudes solicitud) {
		this.solicitud = solicitud;
	}

	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}
}
