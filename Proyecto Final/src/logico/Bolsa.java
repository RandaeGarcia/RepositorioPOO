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
		listempresas = new ArrayList<>();
		listpersonas = new ArrayList<>();
		listsolicitudes = new ArrayList<>();
		listusuarios = new ArrayList<>();
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
	
	public void setListusuarios(ArrayList<Usuario> listusuarios) {
		this.listusuarios = listusuarios;
	}

	public ArrayList<Solicitud> getListsolicitudes() {
		return listsolicitudes;
	}
	
	public void setListsolicitudes(ArrayList<Solicitud> listsolicitudes) {
		this.listsolicitudes = listsolicitudes;
	}

	public ArrayList<Empresa> getListempresas() {
		return listempresas;
	}
	
	public void setListempresass(ArrayList<Empresa> listempresas) {
		this.listempresas = listempresas;
	}

	public ArrayList<Persona> getListpersonas() {
		return listpersonas;
	}

	public void setListpersonas(ArrayList<Persona> listpersonas) {
		this.listpersonas = listpersonas;
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

	public void modificarSolicitud(Solicitud modificar) {
		int pos = -1;
		pos = posSolicitud(modificar.getCodigo());
		listsolicitudes.remove(pos);
		listsolicitudes.add(modificar);
	}

	private int posSolicitud(String codigo) {
		int ind = -1;
		boolean find = false;
		while (ind < listsolicitudes.size() && find)
		{
			if (listsolicitudes.get(ind).getCodigo().contentEquals(codigo))
			{
				find = true;
			}
			ind++;
		}
		return ind;
	}

	public void matcheoSolicitudes(Oferta auxOferta)
	{
		int vacantes = 0;
		int posMayor = 0;
		int puestosDisp = auxOferta.getCantpuestos();
		int califPostulado = 0;
		int califMayor = 0;
		float califOferta = 100 / auxOferta.getMatchpercent();
		boolean omitir = false;
		SolicitudEmpleado auxPostulado = null;
		
		while (vacantes < puestosDisp && omitir)
		{
			califPostulado = 0;
			for (int ind = 0; ind < Bolsa.getinstance().getListsolicitudes().size(); ind++) 
			{
				califPostulado = 0;
				if (Bolsa.getinstance().getListsolicitudes().get(ind) instanceof SolicitudEmpleado)
				{
					if (Bolsa.getinstance().getListsolicitudes().get(ind).isEstado())
					{
						if (compareSiNoOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getTiempo(), auxOferta.getTiempo()))
						{
							califPostulado =+ 10;
						}
						
						if (compareSiNoOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getModalidad(), auxOferta.getModalidad()))
						{
							califPostulado =+ 10;
						}
						
						if (compareSiNoOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getLicencia(), auxOferta.getLicencia()))
						{
							califPostulado =+ 5;
						}
						
						if (compareSiNoOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getVehiculoPropio(), auxOferta.getVehiculoPropio()))
						{
							califPostulado =+ 5;
						}
						
						if (compareSiNoOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getDispMov(), auxOferta.getDispMov()))
						{
							califPostulado =+ 10;
						}
						
						if (Bolsa.getinstance().getListsolicitudes().get(ind).getSexo().equalsIgnoreCase(auxOferta.getSexo()) || auxOferta.getSexo().equalsIgnoreCase("Ambos"))
						{
							califPostulado =+ 5;
						}
						
						if (Bolsa.getinstance().getListsolicitudes().get(ind).getUbicacion().equalsIgnoreCase(auxOferta.getUbicacion()))
						{
							califPostulado =+ 20;
						}
						
						/*if (Bolsa.getinstance().getListsolicitudes().get(ind).getSalariomin() <= auxOferta.getSalariomax())
						{
							califPostulado =+ 10;
						}*/
						
						if (Bolsa.getinstance().getListsolicitudes().get(ind).getExp() >= auxOferta.getExp())
						{
							califPostulado =+ 5;
						}
						
						if (Bolsa.getinstance().getListsolicitudes().get(ind).getNivelEst().equalsIgnoreCase(auxOferta.getNivelEst()))
						{
							if (Bolsa.getinstance().getListsolicitudes().get(ind).getEspecialidad().equalsIgnoreCase(auxOferta.getEspecialidad()))
							{
								califPostulado =+ 10;
							}
						}
					}
					
					if (califPostulado >= califMayor)
					{
						califMayor = califPostulado;
						posMayor = ind;
						auxPostulado = (SolicitudEmpleado) Bolsa.getinstance().getListsolicitudes().get(ind);
					}
				}
				
				if (ind == Bolsa.getinstance().getListsolicitudes().size())
				{
					omitir = true;
				}
			}
			vacantes++;
			
			if (califMayor >= califOferta)
			{
				auxOferta.getPostulados().add(auxPostulado);
				Bolsa.getinstance().getListsolicitudes().get(posMayor).setEstado(false);
				califMayor = 0;
			}
		}
		
		
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
}
