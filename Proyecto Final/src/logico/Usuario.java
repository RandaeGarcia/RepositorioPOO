package logico;

public class Usuario {

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
	
	public String setPassword() {
		return password;
	}

	public String getTipo() {
		return tipo;
	}

	public String getCodigo() {
		return codigo;
	}
}
