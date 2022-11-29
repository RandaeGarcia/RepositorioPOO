package logico;

import java.util.ArrayList;

public class Bolsa {

	private ArrayList<Usuario> listusuarios;
	private ArrayList<Solicitud> listsolicitudes;
	private ArrayList<Empresa> listempresas;
	private ArrayList<Persona> listpersonas;
	private static Bolsa bolsa = null;
	private static Usuario loginUser;
	public static int generadorCodEmpresa = 1;
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
			bolsa = new Bolsa();
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
	
	/*public Usuario buscarUsuarioByUser(String userName)
	{
		Usuario auxUsuario = null;
		boolean find = false;
		int ind = 0;
		while (find == false && ind < listusuarios.size())
		{
			if (listusuarios.get(ind).getUsername().equalsIgnoreCase(userName))
			{
				auxUsuario = listusuarios.get(ind);
				find = true;
			}
			ind++;
		}
		return auxUsuario;
	}*/

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
			generadorCodSolicitud++;
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
	
}
