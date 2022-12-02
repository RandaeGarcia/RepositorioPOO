package logico;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Solicitud implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String codigo;
	protected String campLab;
	protected String modalidad;
	protected String tiempo;
	protected String especialidad;
	protected String ubicacion;
	protected ArrayList<String> idiomas;
	protected String sexo;
	protected int exp;
	protected String dispMov;
	protected String vehiculoPropio;
	protected String licencia;
	protected Usuario creador;
	protected boolean estado;
	
	public Solicitud(String codigo, String campLab, String modalidad, String tiempo, String especialidad, String ubicacion,
			ArrayList<String> idiomas, String sexo, int exp, String dispMov, String vehiculoPropio, String licencia,
			Usuario creador, boolean estado) {
		super();
		this.codigo = codigo;
		this.campLab = campLab;
		this.modalidad = modalidad;
		this.tiempo = tiempo;
		this.especialidad = especialidad;
		this.ubicacion = ubicacion;
		this.idiomas = idiomas;
		this.sexo = sexo;
		this.exp = exp;
		this.dispMov = dispMov;
		this.vehiculoPropio = vehiculoPropio;
		this.licencia = licencia;
		this.creador = creador;
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public String getCampLab() {
		return codigo;
	}

	public String getModalidad() {
		return modalidad;
	}

	public String getTiempo() {
		return tiempo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public String getSexo() {
		return sexo;
	}

	public int getExp() {
		return exp;
	}

	public String getDispMov() {
		return dispMov;
	}

	public String getVehiculoPropio() {
		return vehiculoPropio;
	}

	public String getLicencia() {
		return licencia;
	}

	public Usuario getCreador() {
		return creador;
	}
	
	public boolean matcheoSolicitudes(SolicitudEmpleado auxPostulado, Oferta auxOferta)
	{
		int califPostulado = 0;
		int califOferta = 0;
		if (auxPostulado.getEspecialidad().equalsIgnoreCase(auxOferta.getEspecialidad()))
		{
			califPostulado++;
		}
		califOferta++;
		if (auxPostulado.getUbicacion().equalsIgnoreCase(auxOferta.getUbicacion()))
		{
			califPostulado++;
		}
		califOferta++;
		if (auxPostulado.getSalariomin() <= auxOferta.getSalariomax())
		{
			califPostulado++;
		}
		califOferta++;
		if (auxPostulado.getExp() >= auxOferta.getExp())
		{
			califPostulado++;
		}
		califOferta++;
		if (compareSiNoOpcion(auxPostulado.getTiempo(), auxOferta.getTiempo()))
		{
			califPostulado++;
		}
		califOferta++;
		if (compareSiNoOpcion(auxPostulado.getModalidad(), auxOferta.getModalidad()))
		{
			califPostulado++;
		}
		califOferta++;
		if (compareSiNoOpcion(auxPostulado.getLicencia(), auxOferta.getLicencia()))
		{
			califPostulado++;
		}
		califOferta++;
		if (compareSiNoOpcion(auxPostulado.getVehiculoPropio(), auxOferta.getVehiculoPropio()))
		{
			califPostulado++;
		}
		califOferta++;
		if (compareSiNoOpcion(auxPostulado.getDispMov(), auxOferta.getDispMov()))
		{
			califPostulado++;
		}
		califOferta++;
		if (auxPostulado.getSexo().equalsIgnoreCase(auxOferta.getSexo()) || auxOferta.getSexo().equalsIgnoreCase("Ambos"))
		{
			califPostulado++;
		}
		califOferta++;
		if (auxPostulado.getInfo().getCampolaboral().equalsIgnoreCase(auxOferta.getCampLab()))
		{
			califPostulado++;
		}
		califOferta++;
		return calcularResultados(califPostulado, califOferta, auxOferta.getMatchpercent());
	}
	

	private boolean compareSiNoOpcion(String postulado, String oferta)
	{
		boolean compare = false;
		if (postulado.equalsIgnoreCase(oferta) || oferta.equalsIgnoreCase("Ambos"))
		{
			compare = true;
		}
		return compare;
	}
	
	private boolean calcularResultados(int califPostulado, int califOferta, float matchpercent) {
		boolean prueba = false;
		if (califPostulado >= (califOferta * matchpercent))
		{
			prueba = true;
		}
		return prueba;
	}
}