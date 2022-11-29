package logico;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String tipo;
	private String codigo;
	
	public Usuario(String username, String password, String tipo, String codigo) {
		super();
		this.username = username;
		this.password = password;
		this.tipo = tipo;
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public String getCodigo() {
		return codigo;
	}
}
