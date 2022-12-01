package logico;

import java.util.ArrayList;

public class Oferta extends Solicitud {
	
	private int cantpuestos;
	private float salariomax;
	private float matchpercent;
	private Empresa info;
	
	public Oferta(String codigo, String campLab, String modalidad, String tiempo, String puesto, String ubicacion,
			ArrayList<String> idiomas, String sexo, int exp, String dispMov, String vehiculoPropio, String licencia,
			Usuario creador, boolean estado, int cantpuestos, float salariomax, float matchpercent, Empresa info) {
		super(codigo, campLab, modalidad, tiempo, puesto, ubicacion, idiomas, sexo, exp, dispMov, vehiculoPropio, licencia,
				creador, estado);
		this.cantpuestos = cantpuestos;
		this.salariomax = salariomax;
		this.matchpercent = matchpercent;
		this.info = info;
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
}
