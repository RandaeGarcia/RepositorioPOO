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

	private int posSolicitud(String codigo) {
		int ind=0, i=-1;
		
		for (Solicitud solicitud : listsolicitudes) {
			
			if(solicitud.getCodigo().equalsIgnoreCase(codigo)) {
				ind = i;
			}
			i++;
		}
		return ind;
	}

	public Oferta matcheoSolicitudes(Oferta oferta)
	{
		Oferta auxOferta = oferta;
		int vacantes = 0;
		int puestosDisp = auxOferta.getCantpuestos();
		int califPostulado = 0;
		int cantsolis = 0;
		float califOferta = 100 * auxOferta.getMatchpercent();
		boolean omitir = false;
		ArrayList<SolicitudEmpleado> saveCalif = new ArrayList<>();
		ArrayList<Integer> calif = new ArrayList<>();
		
		while (vacantes < puestosDisp && !omitir && cantsolis < cantSolicitudesEmpleados())
		{
			califPostulado = 0;
			for (int ind = 0; ind < Bolsa.getinstance().getListsolicitudes().size(); ind++) 
			{
				califPostulado = 0;
				if (Bolsa.getinstance().getListsolicitudes().get(ind) instanceof SolicitudEmpleado)
				{
					if (Bolsa.getinstance().getListsolicitudes().get(ind).isEstado())
					{
						if (compareOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getTiempo(), auxOferta.getTiempo()))
						{
							califPostulado += 10;
						}
						
						if (compareOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getModalidad(), auxOferta.getModalidad()))
						{
							califPostulado += 10;
						}
						
						if (compareOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getLicencia(), auxOferta.getLicencia()))
						{
							califPostulado += 5;
						}
						
						if (compareOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getVehiculoPropio(), auxOferta.getVehiculoPropio()))
						{
							califPostulado += 5;
						}
						
						if (compareOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getDispMov(), auxOferta.getDispMov()))
						{
							califPostulado += 10;
						}
						
						/*if (compareOpcion(Bolsa.getinstance().getListsolicitudes().get(ind).getSexo(), auxOferta.getSexo()))
						{
							califPostulado += 5;
						}*/
						
						if (Bolsa.getinstance().getListsolicitudes().get(ind).getUbicacion().equalsIgnoreCase(auxOferta.getUbicacion()))
						{
							califPostulado += 20;
						}
						
						if (((SolicitudEmpleado) Bolsa.getinstance().getListsolicitudes().get(ind)).getSalariomin() <= auxOferta.getSalariomax())
						{
							califPostulado += 10;
						}
						
						if (Bolsa.getinstance().getListsolicitudes().get(ind).getExp() >= auxOferta.getExp())
						{
							califPostulado += 5;
						}
						
						if (Bolsa.getinstance().getListsolicitudes().get(ind).getNivelEst().equalsIgnoreCase(auxOferta.getNivelEst()))
						{
							if (Bolsa.getinstance().getListsolicitudes().get(ind).getEspecialidad().equalsIgnoreCase(auxOferta.getEspecialidad()))
							{
								califPostulado += 10;
							}
						}
						
						for (String auxIdiomas : Bolsa.getinstance().getListsolicitudes().get(ind).getIdiomas()) 
						{
							for (String idiomaOferta : auxOferta.getIdiomas()) {
								if (auxIdiomas.equalsIgnoreCase(idiomaOferta))
								{
									califPostulado += 2;
								}
								
								if (idiomaOferta.equalsIgnoreCase("Cualquiera") || auxIdiomas.equalsIgnoreCase("Otros"))
								{
									califPostulado += 4;
								}
							}
						}
					}
					System.out.println(califOferta);  //50.0
					System.out.println(califPostulado); //69
					if (califPostulado >= califOferta)
					{
						saveCalif.add((SolicitudEmpleado) Bolsa.getinstance().getListsolicitudes().get(ind));
						calif.add(califPostulado);
					}
				}
				
				if (ind == Bolsa.getinstance().getListsolicitudes().size())
				{
					omitir = true;
				}
			}
			vacantes++;

			for (int pos = 0; pos < saveCalif.size(); pos++) 
			{
				if (calif.get(pos) >= califOferta && puestosDisp > 0)
				{
					puestosDisp--;
					saveCalif.get(pos).setEstado(false);
					auxOferta.getPostulados().add(saveCalif.get(pos));
					auxOferta.setCantpuestos(puestosDisp);
					int emp = posSolicitud(saveCalif.get(pos).getCodigo());
					Bolsa.getinstance().getListsolicitudes().get(emp).setEstado(false);
				}
			}
			cantsolis++;
		}
		
		return auxOferta;
	}
	

	private boolean compareOpcion(String postulado, String oferta)
	{
		boolean compare = false;
		if (postulado.equalsIgnoreCase(oferta))
		{
			compare = true;
		}
		else if (oferta.equalsIgnoreCase("Ambos"))
		{
			compare = true;
		}
		return compare;
	}
}
