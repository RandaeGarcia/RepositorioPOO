package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.border.LineBorder;

import logico.Bolsa;
import logico.Empresa;
import logico.Oferta;
import logico.Persona;
import logico.Solicitud;
import logico.SolicitudEmpleado;
import logico.Usuario;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class CrearSolicitud extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCrear;
	private JButton btnCancelar;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JRadioButton rbtnPostulacion;
	private JRadioButton rbtnOferta;
	private JRadioButton rbtnTecnico;
	private JRadioButton rbtnObrero;
	private JRadioButton rbtnUniversitario;
	private JTextField txtIdentificacion;
	private JRadioButton rdbtnOtros;
	private JRadioButton rdbtnFrances;
	private JRadioButton rdbtnIngles;
	private JRadioButton rdbtnEspanol;
	private JSpinner spnSalario;
	private JComboBox<String> cbxPuesto;
	private JRadioButton rbtnSiDM;
	private JRadioButton rbtnNoDM;
	private JRadioButton rdbtnNoLM;
	private JRadioButton rdbtnSiLM;
	private JRadioButton rdbtnRemoto;
	private JRadioButton rdbtnPresencial;
	private JRadioButton rdbtnCompleto;
	private JRadioButton rdbtnMedio;
	private JRadioButton rbtnSiVP;
	private JRadioButton rbtnNoVP;
	private JPanel pnlPostulado;
	private JPanel pnlSolicitudPost;
	private JRadioButton rdbtnAmbosModalidad;
	private JRadioButton rdbtnAmbosLM;
	private JRadioButton rdbtnAmbosVP;
	private JRadioButton rdbtnAmbosDM;
	private JLabel lblProv;
	private JComboBox<String> cbxProvEncuesta;
	private JLabel lblPuestoDisp;
	private JSpinner spnPuestosDisp;
	private JLabel lblSalarioMax;
	private JLabel lblSexo;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JRadioButton rbtnAmbosSexo;
	private JLabel lblExp;
	private JSpinner spnExp;
	private JLabel lblPorcentajeMatch;
	private JSpinner spnPorcentaje;
	private JLabel lblCampoLab;
	private JRadioButton rbtnTecnicoCL;
	private JRadioButton rbtnObreroCL;
	private JRadioButton rbtnUniversitarioCL;
	private JLabel lblSalarioMin;
	private JRadioButton rdbtnAmbosTiempo;
	private JLabel lblCodigo;
	private JLabel lblEmpresa;
	private JTextField txtTelefono;
	private JLabel lblCedula;
	private JLabel lblNombre;
	private JComboBox<String> cbxEmpresa;
	private JTextField txtCodigo;

	private Solicitud local;
	private Persona auxPersona;
	private Empresa auxEmpresa;
	private Usuario creador;
	private String puesto = null;
	private String modalidad = null;
	private String tiempo = null;
	private String provincia = null;
	private String sexo = null;
	private ArrayList<String> idioma = null;
	private float salMin = 0;
	private float salMax = 0;
	private boolean licencia = false;
	private boolean vehiculo = false;
	private boolean dispManejo = false;
	private String campoLab = null;
	private int puestosDisp = 0;
	private int porcentaje = 0;
	private int experiencia = 0;
	private Persona postulado;
	private Empresa empresa;
	private JTextField txtProvincia;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearSolicitud dialog = new CrearSolicitud();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearSolicitud() {
		setTitle("Crear Solicitud");
		setBounds(100, 100, 587, 138);

		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.setBounds(10, 11, 541, 33);
			panel.add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(276, 11, 46, 14);
			panel_1.add(lblNewLabel);

			JLabel label = new JLabel("Crear:");
			label.setBounds(10, 11, 34, 14);
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			panel_1.add(label);

			rbtnPostulacion = new JRadioButton("Postulacion");
			rbtnPostulacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setBounds(100, 100, 587, 499);
					setLocationRelativeTo(null);
					pnlSolicitudPost.setBounds(10, 187, 541, 221);
					rbtnOferta.setSelected(false);
					pnlPostulado.setBounds(10, 53, 541, 123);
					lblCedula.setVisible(true);
					lblCodigo.setVisible(false);
					lblNombre.setVisible(true);
					lblEmpresa.setVisible(false);
					lblSalarioMin.setVisible(true);
					lblSalarioMax.setVisible(false);
					lblProv.setVisible(false);
					lblProv.setEnabled(false);
					cbxProvEncuesta.setVisible(false);
					cbxProvEncuesta.setEnabled(false);
					rdbtnAmbosModalidad.setVisible(false);
					rdbtnAmbosLM.setVisible(false);
					rdbtnAmbosVP.setVisible(false);
					rdbtnAmbosDM.setVisible(false);
					rdbtnAmbosModalidad.setEnabled(false);
					rdbtnAmbosLM.setEnabled(false);
					rdbtnAmbosVP.setEnabled(false);
					rdbtnAmbosDM.setEnabled(false);
					rdbtnAmbosTiempo.setEnabled(false);
					rdbtnAmbosTiempo.setVisible(false);
					spnPuestosDisp.setVisible(false);
					spnPuestosDisp.setEnabled(false);
					lblPuestoDisp.setVisible(false);
					lblPuestoDisp.setEnabled(false);
				}
			});
			rbtnPostulacion.setBounds(55, 7, 93, 23);
			panel_1.add(rbtnPostulacion);

			rbtnOferta = new JRadioButton("Oferta Trabajo");
			rbtnOferta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setBounds(100, 100, 587, 557);
					pnlPostulado.setBounds(10, 53, 541, 96);
					pnlSolicitudPost.setBounds(10, 160, 541, 302);
					setLocationRelativeTo(null);
					rbtnPostulacion.setSelected(false);
					lblCedula.setVisible(false);
					lblCodigo.setVisible(true);
					lblNombre.setVisible(false);
					lblEmpresa.setVisible(true);
					lblSalarioMin.setVisible(false);
					lblSalarioMax.setVisible(true);
					lblProv.setVisible(true);
					lblProv.setEnabled(true);
					cbxProvEncuesta.setVisible(true);
					cbxProvEncuesta.setEnabled(true);
					rdbtnAmbosModalidad.setVisible(true);
					rdbtnAmbosLM.setVisible(true);
					rdbtnAmbosVP.setVisible(true);
					rdbtnAmbosDM.setVisible(true);
					rdbtnAmbosModalidad.setEnabled(true);
					rdbtnAmbosLM.setEnabled(true);
					rdbtnAmbosVP.setEnabled(true);
					rdbtnAmbosDM.setEnabled(true);
					rdbtnAmbosTiempo.setEnabled(true);
					spnPuestosDisp.setVisible(true);
					spnPuestosDisp.setEnabled(true);
					lblPuestoDisp.setVisible(true);
					lblPuestoDisp.setEnabled(true);
				}
			});
			rbtnOferta.setBounds(150, 7, 126, 23);
			panel_1.add(rbtnOferta);

			txtCodigo = new JTextField();
			txtCodigo.setEnabled(false);
			txtCodigo.setText("SOLI-" + String.valueOf(Bolsa.generadorCodSolicitud));
			txtCodigo.setBounds(339, 8, 186, 20);
			panel_1.add(txtCodigo);
			txtCodigo.setColumns(10);

			pnlPostulado = new JPanel();
			pnlPostulado.setBounds(10, 53, 541, 96);
			panel.add(pnlPostulado);
			pnlPostulado.setLayout(null);

			lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(10, 11, 46, 14);
			pnlPostulado.add(lblCedula);

			txtIdentificacion = new JTextField();
			txtIdentificacion.setBounds(80, 10, 186, 17);
			pnlPostulado.add(txtIdentificacion);
			txtIdentificacion.setColumns(10);

			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 41, 60, 14);
			pnlPostulado.add(lblNombre);

			txtNombre = new JTextField();
			txtNombre.setEnabled(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(80, 38, 186, 17);
			pnlPostulado.add(txtNombre);

			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setBounds(10, 69, 46, 14);
			pnlPostulado.add(lblCorreo);

			txtCorreo = new JTextField();
			txtCorreo.setEnabled(false);
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(80, 66, 186, 20);
			pnlPostulado.add(txtCorreo);

			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(276, 41, 60, 14);
			pnlPostulado.add(lblTelefono);

			JLabel lblProvincia = new JLabel("Provincia:");
			lblProvincia.setBounds(276, 69, 60, 14);
			pnlPostulado.add(lblProvincia);

			JLabel lblCampoLaboral = new JLabel("Nivel Estudios");
			lblCampoLaboral.setBounds(10, 97, 91, 14);
			pnlPostulado.add(lblCampoLaboral);

			rbtnTecnico = new JRadioButton("Tecnico");
			rbtnTecnico.setEnabled(false);
			rbtnTecnico.setBounds(107, 93, 78, 23);
			pnlPostulado.add(rbtnTecnico);

			rbtnObrero = new JRadioButton("Obrero");
			rbtnObrero.setEnabled(false);
			rbtnObrero.setBounds(185, 93, 66, 23);
			pnlPostulado.add(rbtnObrero);

			rbtnUniversitario = new JRadioButton("Universitario");
			rbtnUniversitario.setEnabled(false);
			rbtnUniversitario.setBounds(253, 93, 109, 23);
			pnlPostulado.add(rbtnUniversitario);

			lblCodigo = new JLabel("Codigo:");
			lblCodigo.setBounds(10, 11, 46, 14);
			pnlPostulado.add(lblCodigo);

			lblEmpresa = new JLabel("Empresa:");
			lblEmpresa.setBounds(10, 41, 60, 14);
			pnlPostulado.add(lblEmpresa);

			txtTelefono = new JTextField();
			txtTelefono.setEnabled(false);
			txtTelefono.setBounds(339, 38, 186, 17);
			pnlPostulado.add(txtTelefono);
			txtTelefono.setColumns(10);

			cbxEmpresa = new JComboBox();
			cbxEmpresa.setEnabled(false);
			cbxEmpresa.setBounds(80, 38, 186, 17);
			pnlPostulado.add(cbxEmpresa);

			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int opcion;
					if (txtIdentificacion != null)
					{
						if (rbtnPostulacion.isSelected())
						{
							postulado = Bolsa.getinstance().buscarPersonaByCedula(txtIdentificacion.getText());
							if (postulado != null)
							{
								loadPostulado();
							}
							else
							{
								opcion = JOptionPane.showConfirmDialog(null, "Postulado no encontrado, desea registrarlo?", "ERROR", JOptionPane.YES_NO_OPTION);
								if (opcion == JOptionPane.YES_OPTION)
								{
									Registros registrar = new Registros();
									registrar.setModal(true);
									registrar.setVisible(true);
								}
							}
						}
						else if (rbtnOferta.isSelected())
						{
							empresa = Bolsa.getinstance().buscarEmpresaByCode(txtIdentificacion.getText());
							if (empresa != null)
							{
								loadEmpresa();
							}
							else
							{
								opcion = JOptionPane.showConfirmDialog(null, "Empresa no encontrada, desea registrarla?", "ERROR", JOptionPane.YES_NO_OPTION);
								if (opcion == JOptionPane.YES_OPTION)
								{
									Registros registrar = new Registros();
									registrar.setModal(true);
									registrar.setVisible(true);
								}
							}
						}
					}
				}

				
			});
			btnBuscar.setBounds(276, 7, 89, 23);
			pnlPostulado.add(btnBuscar);
			
			txtProvincia = new JTextField();
			txtProvincia.setEnabled(false);
			txtProvincia.setColumns(10);
			txtProvincia.setBounds(339, 68, 186, 17);
			pnlPostulado.add(txtProvincia);

			pnlSolicitudPost = new JPanel();
			pnlSolicitudPost.setBounds(10, 160, 541, 302);
			panel.add(pnlSolicitudPost);
			pnlSolicitudPost.setLayout(null);

			rdbtnSiLM = new JRadioButton("Si");
			rdbtnSiLM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnNoLM.setSelected(false);
					rdbtnAmbosLM.setSelected(false);
					licencia = true;				}
			});
			rdbtnSiLM.setBounds(106, 141, 81, 23);
			pnlSolicitudPost.add(rdbtnSiLM);

			rdbtnAmbosModalidad = new JRadioButton("Ambos");
			rdbtnAmbosModalidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnRemoto.setSelected(false);
					rdbtnPresencial.setSelected(false);
					modalidad = rdbtnAmbosModalidad.getText();
				}
			});
			rdbtnAmbosModalidad.setBounds(280, 116, 81, 23);
			pnlSolicitudPost.add(rdbtnAmbosModalidad);

			JLabel lblTiempo = new JLabel("Tiempo:");
			lblTiempo.setBounds(10, 94, 46, 14);
			pnlSolicitudPost.add(lblTiempo);

			rdbtnCompleto = new JRadioButton("Completo");
			rdbtnCompleto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMedio.setSelected(false);
					rdbtnAmbosTiempo.setSelected(false);
					tiempo = rdbtnCompleto.getText();
				}
			});
			rdbtnCompleto.setBounds(106, 90, 81, 23);
			pnlSolicitudPost.add(rdbtnCompleto);

			rdbtnMedio = new JRadioButton("Medio");
			rdbtnMedio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnCompleto.setSelected(false);
					rdbtnAmbosTiempo.setSelected(false);
					tiempo = rdbtnMedio.getText();
				}
			});
			rdbtnMedio.setBounds(197, 90, 81, 23);
			pnlSolicitudPost.add(rdbtnMedio);

			JLabel lblModalidad = new JLabel("Modalidad:");
			lblModalidad.setBounds(10, 120, 69, 14);
			pnlSolicitudPost.add(lblModalidad);

			rdbtnRemoto = new JRadioButton("Remoto");
			rdbtnRemoto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnPresencial.setSelected(false);
					rdbtnAmbosModalidad.setSelected(false);
					modalidad = rdbtnRemoto.getText();					
				}
			});
			rdbtnRemoto.setBounds(106, 116, 81, 23);
			pnlSolicitudPost.add(rdbtnRemoto);

			rdbtnPresencial = new JRadioButton("Presencial");
			rdbtnPresencial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnRemoto.setSelected(false);
					rdbtnAmbosModalidad.setSelected(false);
					modalidad = rdbtnRemoto.getText();
				}
			});
			rdbtnPresencial.setBounds(197, 116, 104, 23);
			pnlSolicitudPost.add(rdbtnPresencial);

			rdbtnNoLM = new JRadioButton("No");
			rdbtnNoLM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnSiLM.setSelected(false);
					rdbtnAmbosLM.setSelected(false);
					licencia = false;
				}
			});
			rdbtnNoLM.setBounds(197, 141, 69, 23);
			pnlSolicitudPost.add(rdbtnNoLM);

			JLabel lblLicenciaManejo = new JLabel("Licencia Manejo:");
			lblLicenciaManejo.setBounds(10, 145, 104, 14);
			pnlSolicitudPost.add(lblLicenciaManejo);

			JLabel lblVehiculoPropio = new JLabel("Vehiculo Propio:");
			lblVehiculoPropio.setBounds(10, 171, 92, 14);
			pnlSolicitudPost.add(lblVehiculoPropio);

			rbtnSiVP = new JRadioButton("Si");
			rbtnSiVP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnNoVP.setSelected(false);
					rdbtnAmbosVP.setSelected(false);
					vehiculo = true;
				}
			});
			rbtnSiVP.setBounds(106, 167, 81, 23);
			pnlSolicitudPost.add(rbtnSiVP);

			rbtnNoVP = new JRadioButton("No");
			rbtnNoVP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiDM.setSelected(false);
					rdbtnAmbosVP.setSelected(false);
					vehiculo = false;
				}
			});
			rbtnNoVP.setBounds(197, 167, 68, 23);
			pnlSolicitudPost.add(rbtnNoVP);

			JLabel lblDispMovilidad = new JLabel("Disp. Movilidad:");
			lblDispMovilidad.setBounds(10, 196, 92, 14);
			pnlSolicitudPost.add(lblDispMovilidad);

			rbtnSiDM = new JRadioButton("Si");
			rbtnSiDM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnNoDM.setSelected(false);
					rdbtnAmbosDM.setSelected(false);
					dispManejo = true;
				}
			});
			rbtnSiDM.setBounds(106, 192, 81, 23);
			pnlSolicitudPost.add(rbtnSiDM);

			rbtnNoDM = new JRadioButton("No");
			rbtnNoDM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiDM.setSelected(false);
					rdbtnAmbosDM.setSelected(false);
					dispManejo = false;
				}
			});
			rbtnNoDM.setBounds(197, 192, 81, 23);
			pnlSolicitudPost.add(rbtnNoDM);

			JLabel lblEspecialidad = new JLabel("Especialidad:");
			lblEspecialidad.setBounds(10, 14, 104, 14);
			pnlSolicitudPost.add(lblEspecialidad);

			cbxPuesto = new JComboBox();
			cbxPuesto.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Puesto"}));
			puesto = cbxPuesto.getSelectedItem().toString();
			cbxPuesto.setBounds(106, 11, 160, 20);
			pnlSolicitudPost.add(cbxPuesto);

			lblSalarioMin = new JLabel("Salario Minimo:");
			lblSalarioMin.setBounds(10, 42, 92, 14);
			pnlSolicitudPost.add(lblSalarioMin);

			spnSalario = new JSpinner();
			spnSalario.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnSalario.setBounds(106, 39, 81, 20);
			pnlSolicitudPost.add(spnSalario);

			JLabel lblIdioma = new JLabel("Idioma:");
			lblIdioma.setBounds(10, 67, 46, 14);
			pnlSolicitudPost.add(lblIdioma);

			rdbtnEspanol = new JRadioButton("Espa\u00F1ol");
			rdbtnEspanol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma.add("Espa\u00F1ol");
				}
			});
			rdbtnEspanol.setBounds(106, 63, 81, 23);
			pnlSolicitudPost.add(rdbtnEspanol);

			rdbtnIngles = new JRadioButton("Ingles");
			rdbtnIngles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma.add("Ingles");
				}
			});
			rdbtnIngles.setBounds(197, 63, 69, 23);
			pnlSolicitudPost.add(rdbtnIngles);

			rdbtnFrances = new JRadioButton("Frances");
			rdbtnFrances.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma.add("Frances");
				}
			});
			rdbtnFrances.setBounds(280, 63, 81, 23);
			pnlSolicitudPost.add(rdbtnFrances);

			rdbtnOtros = new JRadioButton("Otros");
			rdbtnOtros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma.add(rdbtnOtros.toString());
				}
			});
			rdbtnOtros.setBounds(376, 63, 69, 23);
			pnlSolicitudPost.add(rdbtnOtros);

			rdbtnAmbosTiempo = new JRadioButton("Ambos");
			rdbtnAmbosTiempo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnCompleto.setSelected(false);
					rdbtnMedio.setSelected(false);
					tiempo = rdbtnAmbosTiempo.getText();
				}
			});
			rdbtnAmbosTiempo.setBounds(280, 90, 81, 23);
			pnlSolicitudPost.add(rdbtnAmbosTiempo);

			rdbtnAmbosLM = new JRadioButton("Ambos");
			rdbtnAmbosLM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnSiLM.setSelected(false);
					rdbtnNoLM.setSelected(false);
					licencia = true;
				}
			});
			rdbtnAmbosLM.setBounds(280, 141, 69, 23);
			pnlSolicitudPost.add(rdbtnAmbosLM);

			rdbtnAmbosVP = new JRadioButton("Ambos");
			rdbtnAmbosVP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiVP.setSelected(false);
					rbtnNoVP.setSelected(false);
					vehiculo = true;
				}
			});
			rdbtnAmbosVP.setBounds(280, 167, 68, 23);
			pnlSolicitudPost.add(rdbtnAmbosVP);

			rdbtnAmbosDM = new JRadioButton("Ambos");
			rdbtnAmbosDM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnNoDM.setSelected(false);
					rbtnSiDM.setSelected(false);
					dispManejo = true;
				}
			});
			rdbtnAmbosDM.setBounds(280, 192, 81, 23);
			pnlSolicitudPost.add(rdbtnAmbosDM);

			lblProv = new JLabel("Provincia:");
			lblProv.setBounds(276, 14, 60, 14);
			pnlSolicitudPost.add(lblProv);

			cbxProvEncuesta = new JComboBox();
			cbxProvEncuesta.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Provincia", "Az\u00FAa", "Barahona", "Distrito Nacional", "Independencia", "La Altagracia", "La Romana", "La Vega", "Puerto Plata", "Samana", "San Cristobal", "San Juan", "San Pedro de Macor\u00EDs", "Santiago", "Santo Domingo"}));
			cbxProvEncuesta.setEnabled(false);
			cbxProvEncuesta.setBounds(365, 11, 160, 20);
			pnlSolicitudPost.add(cbxProvEncuesta);
			provincia = cbxProvEncuesta.getSelectedItem().toString();

			lblPuestoDisp = new JLabel("Puestos Disp.:");
			lblPuestoDisp.setBounds(10, 275, 85, 14);
			pnlSolicitudPost.add(lblPuestoDisp);

			spnPuestosDisp = new JSpinner();
			spnPuestosDisp.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
			spnPuestosDisp.setBounds(106, 272, 81, 20);
			pnlSolicitudPost.add(spnPuestosDisp);
			puestosDisp = Integer.valueOf(spnPuestosDisp.getValue().toString());

			lblSalarioMax = new JLabel("Salario Maximo:");
			lblSalarioMax.setBounds(10, 42, 92, 14);
			pnlSolicitudPost.add(lblSalarioMax);

			lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(10, 222, 46, 14);
			pnlSolicitudPost.add(lblSexo);

			rdbtnMasculino = new JRadioButton("Masculino");
			rdbtnMasculino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnFemenino.setSelected(false);
					rbtnAmbosSexo.setSelected(false);
					sexo = rdbtnMasculino.getText();
				}
			});
			rdbtnMasculino.setBounds(106, 218, 89, 23);
			pnlSolicitudPost.add(rdbtnMasculino);

			rdbtnFemenino = new JRadioButton("Femenino");
			rdbtnFemenino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMasculino.setSelected(false);
					rbtnAmbosSexo.setSelected(false);
					sexo = rdbtnFemenino.getText();
				}
			});
			rdbtnFemenino.setBounds(197, 218, 81, 23);
			pnlSolicitudPost.add(rdbtnFemenino);

			rbtnAmbosSexo = new JRadioButton("Ambos");
			rbtnAmbosSexo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMasculino.setSelected(false);
					rdbtnFemenino.setSelected(false);
					sexo = rbtnAmbosSexo.getText();
				}
			});
			rbtnAmbosSexo.setBounds(280, 218, 81, 23);
			pnlSolicitudPost.add(rbtnAmbosSexo);

			lblExp = new JLabel("A\u00F1os Exp.:");
			lblExp.setBounds(276, 42, 104, 14);
			pnlSolicitudPost.add(lblExp);

			spnExp = new JSpinner();
			spnExp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnExp.setBounds(365, 39, 81, 20);
			pnlSolicitudPost.add(spnExp);
			experiencia = Integer.valueOf(spnExp.getValue().toString());

			lblPorcentajeMatch = new JLabel("Puntaje:");
			lblPorcentajeMatch.setBounds(276, 275, 104, 14);
			pnlSolicitudPost.add(lblPorcentajeMatch);

			spnPorcentaje = new JSpinner();
			spnPorcentaje.setModel(new SpinnerNumberModel(new Integer(50), new Integer(0), null, new Integer(1)));
			spnPorcentaje.setBounds(365, 272, 81, 20);
			pnlSolicitudPost.add(spnPorcentaje);
			porcentaje = Integer.valueOf(spnPorcentaje.getValue().toString());

			lblCampoLab = new JLabel("Nivel Estudios:");
			lblCampoLab.setBounds(10, 247, 91, 14);
			pnlSolicitudPost.add(lblCampoLab);

			rbtnTecnicoCL = new JRadioButton("Tecnico");
			rbtnTecnicoCL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnObreroCL.setSelected(false);
					rbtnUniversitarioCL.setSelected(false);
					campoLab = rbtnTecnicoCL.getText();
				}
			});
			rbtnTecnicoCL.setBounds(106, 243, 78, 23);
			pnlSolicitudPost.add(rbtnTecnicoCL);

			rbtnObreroCL = new JRadioButton("Obrero");
			rbtnObreroCL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnTecnicoCL.setSelected(false);
					rbtnUniversitarioCL.setSelected(false);
					campoLab = rbtnObreroCL.getText();
				}
			});
			rbtnObreroCL.setBounds(197, 243, 66, 23);
			pnlSolicitudPost.add(rbtnObreroCL);

			rbtnUniversitarioCL = new JRadioButton("Universitario");
			rbtnUniversitarioCL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnTecnicoCL.setSelected(false);
					rbtnObreroCL.setSelected(false);
					campoLab = rbtnUniversitarioCL.getText();
				}
			});
			rbtnUniversitarioCL.setBounds(280, 243, 109, 23);
			pnlSolicitudPost.add(rbtnUniversitarioCL);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCrear = new JButton("Crear");
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (local == null)
						{
							Solicitud auxSoli = null;
							if (rbtnPostulacion.isSelected())
							{
								auxSoli = new SolicitudEmpleado(txtCodigo.toString(), campoLab, modalidad, 
										tiempo, puesto, provincia, idioma, sexo, experiencia, dispManejo, 
										vehiculo, licencia, creador, true, salMin, auxPersona);
							}
							else if (rbtnOferta.isSelected())
							{
								auxSoli = new Oferta(txtCodigo.toString(), campoLab, modalidad, tiempo, puesto, 
										provincia, idioma, sexo, experiencia, dispManejo, vehiculo,
										licencia, creador, true, puestosDisp, salMax, 
										porcentaje, auxEmpresa);
							}
							Bolsa.getinstance().registrarSolicitud(auxSoli);
							clean();
						}
					}
				});
				btnCrear.setActionCommand("OK");
				buttonPane.add(btnCrear);
				getRootPane().setDefaultButton(btnCrear);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void loadPostulado()
	{
		if (postulado != null)
		{
			txtNombre.setText(postulado.getNombre());
			txtCorreo.setText(postulado.getEmail());
			txtTelefono.setText(postulado.getTelefono());
			txtProvincia.setText(postulado.getPais());
			if (postulado.getCampolaboral().equalsIgnoreCase("Obrero"))
			{
				rbtnObrero.setSelected(true);
			}
			else if (postulado.getCampolaboral().equalsIgnoreCase("Tecnico"))
			{
				rbtnTecnico.setSelected(true);
			}
			else
			{
				rbtnUniversitario.setSelected(true);
			}
		}
	}
	
	private void loadEmpresa() {
		if (empresa != null)
		{
			txtNombre.setText(empresa.getNombreEmpresa());
			txtCorreo.setText(empresa.getEmail());
			txtTelefono.setText(empresa.getTelefono());
			txtProvincia.setText(empresa.getPais());	
		}
	}
	
	private void clean() {
		txtCodigo.setText("SOLI-" + String.valueOf(Bolsa.generadorCodSolicitud));
		cbxPuesto.setSelectedIndex(0);
		spnSalario.setValue(0);
		spnPorcentaje.setValue(50);
		spnExp.setValue(0);
		spnPuestosDisp.setValue(0);
		cbxProvEncuesta.setSelectedIndex(0);
		rdbtnSiLM.setSelected(false);
		rdbtnNoLM.setSelected(false);
		rdbtnAmbosLM.setSelected(false);
		rdbtnRemoto.setSelected(false);
		rdbtnPresencial.setSelected(false);
		rdbtnAmbosModalidad.setSelected(false);
		rdbtnCompleto.setSelected(false);
		rdbtnMedio.setSelected(false);
		rdbtnAmbosTiempo.setSelected(false);
		rbtnUniversitarioCL.setSelected(false);
		rbtnTecnicoCL.setSelected(false);
		rbtnObreroCL.setSelected(false);
		rdbtnMasculino.setSelected(false);
		rdbtnFemenino.setSelected(false);
		rbtnAmbosSexo.setSelected(false);
		rbtnNoDM.setSelected(false);
		rbtnSiDM.setSelected(false);
		rdbtnAmbosDM.setSelected(false);
		rbtnSiVP.setSelected(false);
		rbtnNoVP.setSelected(false);
		rdbtnAmbosVP.setSelected(false);
		rdbtnOtros.setSelected(false);
		rdbtnFrances.setSelected(false);
		rdbtnEspanol.setSelected(false);
		rdbtnIngles.setSelected(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 587, 137);
	}
}
