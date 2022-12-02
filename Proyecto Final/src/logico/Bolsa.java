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
	public static int generadorCodEmpresa = 1;
	public static int generadorCodPersona = 1;
	public static int generadorCodUsuario = 1;
	public static int generadorCodSolicitud = 1;
	
	private Bolsa() {
		super();
		this.listempresas = new ArrayList<>();
		this.listpersonas = new ArrayList<>();
		this.listsolicitudes = new ArrayList<>();
		this.listusuarios = new ArrayList<>();
	}
	
	public static Bolsa getinstance() {
		if(bolsa == null) {
			Usuario auxUsu = new Usuario("admin", "admin", "Administrador", "USU-" + String.valueOf(Bolsa.generadorCodUsuario));
			bolsa = new Bolsa();
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

	public void setListusuarios(Usuario newusuario) {
		listusuarios.add(newusuario);
	}

	public ArrayList<Solicitud> getListsolicitudes() {
		return listsolicitudes;
	}

	public void setListsolicitudes(Solicitud newsolicitud) {
		listsolicitudes.add(newsolicitud);
	}

	public ArrayList<Empresa> getListempresas() {
		return listempresas;
	}

	public void setListempresas(Empresa newempresa) {
		listempresas.add(newempresa);
	}

	public ArrayList<Persona> getListpersonas() {
		return listpersonas;
	}

	public void setListpersonas(Persona newpersona) {
		listpersonas.add(newpersona);
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

	public void modificarUsuario(Usuario local) {
		int pos = buscarPosUsuario(local.getCodigo());
		listusuarios.remove(pos);
		listusuarios.add(local);
	}

	private int buscarPosUsuario(String codigo) {
		int pos = 0;
		int ind = 0;
		boolean find = false;
		ArrayList<Usuario> auxUsu = listusuarios;
		while (!find)
		{
			if (auxUsu.get(ind).getCodigo().equals(codigo))
			{
				find = true;
				pos = ind;
			}
			ind++;
		}
		return pos;
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

	public void conteoGeneradores() {
		generadorCodEmpresa = listempresas.size();
		generadorCodPersona = listpersonas.size();
		generadorCodUsuario = listusuarios.size();
		generadorCodSolicitud = listsolicitudes.size();
	}
}
