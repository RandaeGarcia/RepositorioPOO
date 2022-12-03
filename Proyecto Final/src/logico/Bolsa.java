package logico;

import java.io.*;
import java.util.ArrayList;

public class Bolsa implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> listusuarios;
	private ArrayList<Solicitud> listsolicitudes;
	private ArrayList<Empresa> listempresas;
	private ArrayList<Persona> listpersonas;
	private static Bolsa bolsa = null;
	private static Usuario loginUser;
	private int generadorCodEmpresa;
	private int generadorCodPersona;
	private int generadorCodUsuario;
	private int generadorCodSolicitud;
	
	private Bolsa() {
		super();
		this.listempresas = new ArrayList<>();
		this.listpersonas = new ArrayList<>();
		this.listsolicitudes = new ArrayList<>();
		this.listusuarios = new ArrayList<>();
		this.generadorCodEmpresa = 1;
		this.generadorCodPersona = 1;
		this.generadorCodSolicitud = 1;
		this.generadorCodUsuario = 0;
	}
	
	public static Bolsa getinstance() {
		if(bolsa == null) {
			bolsa = new Bolsa();
			Usuario auxUsu = new Usuario("admin", "admin", "Administrador", "USU-" + String.valueOf(Bolsa.getinstance().generadorCodUsuario).toString());
			bolsa.registrarUsuario(auxUsu);
		}
		return bolsa;
	}
	
	public static void setBolsa(Bolsa bolsa) {
		Bolsa.bolsa = bolsa;
	}
	
	public static Usuario getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(Usuario loginUser) {
		Bolsa.loginUser = loginUser;
	}

	public ArrayList<Usuario> getListusuarios() {
		return listusuarios;
	}

	public ArrayList<Solicitud> getListsolicitudes() {
		return listsolicitudes;
	}

	public ArrayList<Empresa> getListempresas() {
		return listempresas;
	}

	public ArrayList<Persona> getListpersonas() {
		return listpersonas;
	}

	public void setListpersonas(Persona newpersona) {
		listpersonas.add(newpersona);
	}
	
	public int getGeneradorCodEmpresa() {
		return generadorCodEmpresa;
	}

	public int getGeneradorCodPersona() {
		return generadorCodPersona;
	}

	public int getGeneradorCodUsuario() {
		return generadorCodUsuario;
	}

	public int getGeneradorCodSolicitud() {
		return generadorCodSolicitud;
	}
	
	public boolean emailRepetido(String email) {
		boolean aux = false;
		for (Empresa empresa : listempresas) {
			if(empresa.getEmail().equalsIgnoreCase(email)) {
				aux = true;
			}
		}
		for (Persona persona : listpersonas) {
			if(persona.getEmail().equalsIgnoreCase(email)) {
				aux = true;
			}
		}
		
		return aux;
	}
	
	public boolean nombreOrCedulaRepetidos(String texto) {
		boolean aux = false;
		
		for (Empresa empresa : listempresas) {
			if(empresa.getNombreEmpresa().equalsIgnoreCase(texto)) {
				aux = true;
			}
		}
		
		for (Persona persona : listpersonas) {
			if(persona.getCedula().equalsIgnoreCase(texto)) {
				aux = true;
			}
		}
		
		return aux;
	}

	public int cantSolicitudesEmpleados() {
		int cant = 0;
		for (Solicitud solicitud : listsolicitudes) {
			if(solicitud instanceof SolicitudEmpleado) {
				cant++;
			}
		}
		
		return cant;
	}
	
	public int cantOfertas() {
		int cant = 0;
		for (Solicitud solicitud : listsolicitudes) {
			if(solicitud instanceof Oferta) {
				cant++;
			}
		}
		
		return cant;
	}
	
	public boolean verificarLogin(String userName, String password)
	{
		boolean verif = false;
		for (Usuario auxUsuario : listusuarios)
		{
			if (auxUsuario.getUsername().equalsIgnoreCase(userName) && auxUsuario.getPassword().equals(password))
			{
				loginUser = auxUsuario;
				verif = true;
			}
		}
		return verif;
	}

	public void registrarUsuario(Usuario auxUsuario) {
		if (auxUsuario != null)
		{
			listusuarios.add(auxUsuario);
			generadorCodUsuario++;
		}
		
	}

	public boolean existeUusario(String username) {
		boolean find = false;
		if (username != null)
		{
			for (Usuario auxUser : listusuarios) {
				if (auxUser.getUsername().equalsIgnoreCase(username))
				{
					find = true;
				}
			}
		}
		return find;
	}

	public void registrarSolicitud(Solicitud auxSoli) {
		if (auxSoli != null)
		{
			listsolicitudes.add(auxSoli);
			generadorCodSolicitud++;
		}		
	}

	public void registrarPersona(Persona auxPersona) {
		if (auxPersona != null)
		{
			listpersonas.add(auxPersona);
			generadorCodPersona++;
		}		
	}

	public void registrarEmpresa(Empresa auxEmpresa) {
		if (auxEmpresa != null)
		{
			listempresas.add(auxEmpresa);
			generadorCodEmpresa++;
		}			
	}

	public Usuario buscarUsuarioByCode(String codigo) {
		Usuario aux = null;
		for (Usuario usuario : listusuarios) {
			if(usuario.getCodigo().equalsIgnoreCase(codigo)) {
				aux = usuario;
			}
		}
		return aux;
	}
	
	public Solicitud buscarSolicitudByCode(String codigo) {
		Solicitud aux = null;
		for (Solicitud solicitud : listsolicitudes) {
			if(solicitud.getCodigo().equalsIgnoreCase(codigo)) {
				aux = solicitud;
			}
		}
		return aux;
	}
	
	public Empresa buscarEmpresaByCode(String codigo) {
		Empresa aux = null;
		for (Empresa empresa : listempresas) {
			if(empresa.getCodigo().equalsIgnoreCase(codigo)) {
				aux = empresa;
			}
		}
		return aux;
	}
	
	
	public Persona buscarPersonaByCedula(String cedulaAux) {
		Persona aux = null;
		for (Persona persona : listpersonas) {
			if(persona.getCedula().equalsIgnoreCase(cedulaAux)) {
				aux = persona;
			}
		}
		return aux;
	}

}
