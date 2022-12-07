package logico;

import java.util.ArrayList;

public class Oferta extends Solicitud {
	
	private int cantpuestos;
	private float salariomax;
	private float matchpercent;
	private ArrayList<SolicitudEmpleado> postulados;
	private Empresa info;	

	public Oferta(String codigo, String nivelEst, String modalidad, String tiempo, String especialidad,
			String ubicacion, ArrayList<String> idiomas, String sexo, int exp, String dispMov, String vehiculoPropio,
			String licencia, Usuario creador, boolean estado, int cantpuestos, float salariomax, float matchpercent,
			Empresa info) {
		super(codigo, nivelEst, modalidad, tiempo, especialidad, ubicacion, idiomas, sexo, exp, dispMov, vehiculoPropio,
				licencia, creador, estado);
		this.cantpuestos = cantpuestos;
		this.salariomax = salariomax;
		this.matchpercent = matchpercent;
		postulados = new ArrayList<SolicitudEmpleado>();
		this.info = info;
	}
	
	public ArrayList<SolicitudEmpleado> getPostulados() {
		return postulados;
	}

	public void setPostulados(ArrayList<SolicitudEmpleado> postulados) {
		this.postulados = postulados;
	}

	public int getCantpuestos() {
		return cantpuestos;
	}

	public void setCantpuestos(int cantpuestos) {
		this.cantpuestos = cantpuestos;
	}

	public float getSalariomax() {
		return salariomax;
	}

	public float getMatchpercent() {
		return matchpercent;
	}

	public Empresa getInfo() {
		return info;
	}

	public void setSalariomax(float salariomax) {
		this.salariomax = salariomax;
	}

	public void setMatchpercent(float matchpercent) {
		this.matchpercent = matchpercent;
	}
}
