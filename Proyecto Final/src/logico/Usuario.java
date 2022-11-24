package logico;

public class Usuario {

	private String username;
	private String password;
	private String tipo;
	private String correo;
	
	public Usuario(String username, String password, String tipo, String correo) {
		super();
		this.username = username;
		this.password = password;
		this.tipo = tipo;
		this.correo = correo;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getTipo() {
		return tipo;
	}

	public String getCorreo() {
		return correo;
	}
	
	
	
}
