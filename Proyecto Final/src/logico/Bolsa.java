package logico;

import java.util.ArrayList;

public class Bolsa {

	private ArrayList<Persona> listpersonas;
	private ArrayList<Solicitud> listsolicitudes;
	private ArrayList<Empresa> listempresas;
	public static Bolsa bolsa = null;
	
	public static Bolsa getInstance() {
		if(bolsa == null) {
			bolsa = new Bolsa();
		}
		return bolsa;
	}
	
	private Bolsa() {
		super();
		this.listempresas = new ArrayList<>();
		this.listpersonas = new ArrayList<>();
		this.listsolicitudes = new ArrayList<>();
	}

	public ArrayList<Persona> getListpersonas() {
		return listpersonas;
	}

	public void setListpersonas(Persona newlistpersonas) {
		listpersonas.add(newlistpersonas);
	}

	public ArrayList<Solicitud> getListsolicitudes() {
		return listsolicitudes;
	}

	public void setListsolicitudes(Solicitud newlistsolicitudes) {
		listsolicitudes.add(newlistsolicitudes);
	}

	public ArrayList<Empresa> getListempresas() {
		return listempresas;
	}

	public void setListempresas(Empresa newlistempresas) {
		listempresas.add(newlistempresas);
	}
	
}
