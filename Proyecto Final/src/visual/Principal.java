package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.border.TitledBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private Dimension dim;
	
	private JPanel contentPane;
	private JMenu mnPersona;
	private JMenu mnadministracion;
	private JMenu mnEmpresa;
	private JMenu mnreportes;

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
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Crear solicitud");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearSolicitud crearsolicitud = new CrearSolicitud();
				crearsolicitud.setModal(true);
				crearsolicitud.setVisible(true);
			}
		});
		mnPersona.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listar solicitudes");
		mnPersona.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listar personas");
		mnPersona.add(mntmNewMenuItem_8);
		
		mnEmpresa = new JMenu("Empresa");
		menuBar.add(mnEmpresa);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Crear oferta");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearSolicitud crearsolicitud = new CrearSolicitud();
				crearsolicitud.setModal(true);
				crearsolicitud.setVisible(true);
			}
		});
		mnEmpresa.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Listar ofertas");
		mnEmpresa.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listar empresas");
		mnEmpresa.add(mntmNewMenuItem_2);
		
		mnreportes = new JMenu("Reportes");
		menuBar.add(mnreportes);
		
		mnadministracion = new JMenu("Administraci\u00F3n");
		menuBar.add(mnadministracion);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Registrar");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registros registrar = new Registros();
				registrar.setModal(true);
				registrar.setVisible(true);
			}
		});
		mnadministracion.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Crear usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuario crearusuario = new CrearUsuario();
				crearusuario.setModal(true);
				crearusuario.setVisible(true);
			}
		});
		mnadministracion.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar usuarios");
		mnadministracion.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
