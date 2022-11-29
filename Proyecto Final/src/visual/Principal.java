package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.border.TitledBorder;

import logico.Bolsa;
import logico.Usuario;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension dim;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream bolsaTrabajoOut;
				ObjectOutputStream bolsaTrabajoWrite;
					try {
						bolsaTrabajoOut = new FileOutputStream("bolsaTrabajo.dat");
						bolsaTrabajoWrite = new ObjectOutputStream(bolsaTrabajoOut);
						bolsaTrabajoWrite.writeObject(Bolsa.getinstance());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		});
		
		setTitle("Bolsa de Trabajo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(900,650);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		JMenuItem mntmCrearSolicitud = new JMenuItem("Crear solicitud");
		mntmCrearSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearSolicitud crearsolicitud = new CrearSolicitud();
				crearsolicitud.setModal(true);
				crearsolicitud.setVisible(true);
			}
		});
		mnPersona.add(mntmCrearSolicitud);
		
		mntmListarSolicitud = new JMenuItem("Listar solicitudes");
		mnPersona.add(mntmListarSolicitud);
		
		mntmListarPersonas = new JMenuItem("Listar personas");
		mnPersona.add(mntmListarPersonas);
		
		mnEmpresa = new JMenu("Empresa");
		menuBar.add(mnEmpresa);
		
		mntmCrearOferta = new JMenuItem("Crear oferta");
		mntmCrearOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearSolicitud crearsolicitud = new CrearSolicitud();
				crearsolicitud.setModal(true);
				crearsolicitud.setVisible(true);
			}
		});
		mnEmpresa.add(mntmCrearOferta);
		
		mntmListarOfertas = new JMenuItem("Listar ofertas");
		mnEmpresa.add(mntmListarOfertas);
		
		mntmListarEmpresas = new JMenuItem("Listar empresas");
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
		mnAdministracion.add(mntmListarUsuarios);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
