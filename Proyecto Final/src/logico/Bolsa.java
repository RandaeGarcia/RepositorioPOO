package logico;

import java.util.ArrayList;

public class Bolsa {

	private ArrayList<Usuario> listusuarios;
	private ArrayList<Solicitud> listsolicitudes;
	private ArrayList<Empresa> listempresas;
	private ArrayList<Persona> listpersonas;
	
	public Bolsa() {
		super();
		this.listempresas = new ArrayList<>();
		this.listpersonas = new ArrayList<>();
		this.listsolicitudes = new ArrayList<>();
		this.listusuarios = new ArrayList<>();
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
	
	
}
