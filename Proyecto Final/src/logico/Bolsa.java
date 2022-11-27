package logico;

import java.util.ArrayList;

public class Bolsa {

	private ArrayList<Usuario> listusuarios;
	private ArrayList<Solicitud> listsolicitudes;
	private ArrayList<Empresa> listempresas;
	private ArrayList<Persona> listpersonas;
	private static Bolsa bolsa = null;
	public static int generadorcodempresa = 1;
	
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
		if (buscarUsuarioByUser(userName) != null)
		{
			if (buscarUsuarioByUser(userName).getPassword().compareTo(password) == 0)
			{
				verif = true;
			}
		}
		return verif;
	}
	
	public Usuario buscarUsuarioByUser(String userName)
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
	}
	
}
