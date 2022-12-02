package visual;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.border.TitledBorder;

import logico.Bolsa;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JButton;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnPersona;
	private JMenu mnAdministracion;
	private JMenu mnEmpresa;
	private JMenu mnReportes;
	private JMenuItem mntmCrearUsuario;
	private JMenuItem mntmRegistrar;
	private JMenuItem mntmListarUsuarios;
	private JMenuItem mntmCrearOferta;
	private JMenuItem mntmListarOfertas;
	private JMenuItem mntmListarSolicitud;
	private JMenuItem mntmListarPersonas;
	private JMenuItem mntmListarEmpresas;
	private JMenuItem mntmCrearSolicitud;
	private JButton btnCerrarSesion;

	public Principal() {		
		setTitle("Bolsa de Trabajo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(900,650);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		mntmCrearSolicitud = new JMenuItem("Crear solicitud");
		mntmCrearSolicitud.setEnabled(true);
		if (Bolsa.generadorCodPersona == 1)
		{
			mntmCrearSolicitud.setEnabled(false);
		}
		mntmCrearSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearSolicitud crearsolicitud = new CrearSolicitud();
				crearsolicitud.setModal(true);
				crearsolicitud.setVisible(true);
			}
		});
		mnPersona.add(mntmCrearSolicitud);
		
		mntmListarSolicitud = new JMenuItem("Listar solicitudes");
		mntmListarSolicitud.setEnabled(true);
		if (Bolsa.generadorCodSolicitud == 1)
		{
			mntmListarSolicitud.setEnabled(false);
		}
		mntmListarSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListSolicitudesEmpleados listSolicitudesEmpleados = new ListSolicitudesEmpleados();
				listSolicitudesEmpleados.setModal(true);
				listSolicitudesEmpleados.setVisible(true);
			}
		});
		mnPersona.add(mntmListarSolicitud);
		
		mntmListarPersonas = new JMenuItem("Listar personas");
		mntmListarPersonas.setEnabled(true);
		if (Bolsa.generadorCodPersona == 1)
		{
			mntmListarPersonas.setEnabled(false);
		}
		mntmListarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPersonas listpersonas = new ListPersonas();
				listpersonas.setModal(true);
				listpersonas.setVisible(true);
			}
		});
		mnPersona.add(mntmListarPersonas);
		
		mnEmpresa = new JMenu("Empresa");
		menuBar.add(mnEmpresa);
		
		mntmCrearOferta = new JMenuItem("Crear oferta");
		mntmCrearOferta.setEnabled(true);
		if (Bolsa.generadorCodEmpresa == 1)
		{
			mntmCrearOferta.setEnabled(false);
		}
		mntmCrearOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearSolicitud crearsolicitud = new CrearSolicitud();
				crearsolicitud.setModal(true);
				crearsolicitud.setVisible(true);
			}
		});
		mnEmpresa.add(mntmCrearOferta);
		
		mntmListarOfertas = new JMenuItem("Listar ofertas");
		mntmListarOfertas.setEnabled(true);
		if (Bolsa.generadorCodSolicitud == 1)
		{
			mntmListarOfertas.setEnabled(false);
		}
		mntmListarOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListOfertas listofertas = new ListOfertas();
				listofertas.setModal(true);
				listofertas.setVisible(true);
			}
		});
		mnEmpresa.add(mntmListarOfertas);
		
		mntmListarEmpresas = new JMenuItem("Listar empresas");
		mntmListarEmpresas.setEnabled(true);
		if (Bolsa.generadorCodEmpresa == 1)
		{
			mntmListarEmpresas.setEnabled(false);
		}
		mntmListarEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListEmpresas listempresas = new ListEmpresas();
				listempresas.setModal(true);
				listempresas.setVisible(true);
			}
		});
		mnEmpresa.add(mntmListarEmpresas);
		
		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mnAdministracion = new JMenu("Administraci\u00F3n");
		menuBar.add(mnAdministracion);
		
		mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registros registrar = new Registros();
				registrar.setModal(true);
				registrar.setVisible(true);
			}
		});
		mnAdministracion.add(mntmRegistrar);
		
		mntmCrearUsuario = new JMenuItem("Crear usuario");
		if (!Bolsa.getLoginUser().getTipo().equalsIgnoreCase("Administrador"))
		{
			mntmCrearUsuario.setEnabled(false);
		}
		mntmCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuario crearusuario = new CrearUsuario();
				crearusuario.setModal(true);
				crearusuario.setVisible(true);
			}
		});
		mnAdministracion.add(mntmCrearUsuario);
		
		mntmListarUsuarios = new JMenuItem("Listar usuarios");
		mntmListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListUsuarios listusuarios = new ListUsuarios();
				listusuarios.setModal(true);
				listusuarios.setVisible(true);
			}
		});
		mnAdministracion.add(mntmListarUsuarios);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream bolsaTrabajoOut;
				ObjectOutputStream bolsaTrabajoWrite;
					try {
						bolsaTrabajoOut = new FileOutputStream("bolsaTrabajo.dat");
						bolsaTrabajoWrite = new ObjectOutputStream(bolsaTrabajoOut);
						bolsaTrabajoWrite.writeObject(Bolsa.getinstance());
						Login login = new Login();
						login.setVisible(true);
						dispose();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnCerrarSesion.setBounds(10, 538, 170, 41);
		panel.add(btnCerrarSesion);
	}
}
