package logico;

import java.io.Serializable;

public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
	private	String codigo;
	private String nombreEmpresa;
	private String campolaboral;
	private String telefono;
	private String email;
	private String pais;
	
	public Empresa(String codigo, String nombreEmpresa, String campolaboral, String telefono, String email,
			String pais) {
		super();
		this.codigo = codigo;
		this.nombreEmpresa = nombreEmpresa;
		this.campolaboral = campolaboral;
		this.telefono = telefono;
		this.email = email;
		this.pais = pais;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getPais() {
		return pais;
	}

	public String getCampolaboral() {
		return campolaboral;
	}
	
}
