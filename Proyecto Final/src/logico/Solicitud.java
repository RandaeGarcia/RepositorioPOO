package logico;

import java.util.ArrayList;

public abstract class Solicitud {

	protected String codigo;
	protected String modalidadUbicacion;
	protected String modalidadTiempo;
	protected String ubicacion;
	protected ArrayList<String> idiomas;
	protected String sexo;
	protected boolean oktomove;
	protected boolean vehiculoPropio;
	protected Usuario creador;
	protected boolean estado;
	
	public Solicitud(String codigo, String modalidadUbicacion, String modalidadTiempo, String ubicacion,
			ArrayList<String> idiomas, String sexo, boolean oktomove, boolean vehiculoPropio, Usuario creador) {
		super();
		this.codigo = codigo;
		this.modalidadUbicacion = modalidadUbicacion;
		this.modalidadTiempo = modalidadTiempo;
		this.ubicacion = ubicacion;
		this.idiomas = idiomas;
		this.sexo = sexo;
		this.oktomove = oktomove;
		this.vehiculoPropio = vehiculoPropio;
		this.creador = creador;
		this.estado = true;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getModalidadUbicacion() {
		return modalidadUbicacion;
	}

	public String getModalidadTiempo() {
		return modalidadTiempo;
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

	public boolean isOktomove() {
		return oktomove;
	}

	public boolean isVehiculoPropio() {
		return vehiculoPropio;
	}

	public Usuario getCreador() {
		return creador;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
