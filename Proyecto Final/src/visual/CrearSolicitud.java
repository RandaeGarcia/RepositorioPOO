package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Toolkit;

import logico.Bolsa;
import logico.Empresa;
import logico.Obrero;
import logico.Oferta;
import logico.Persona;
import logico.Solicitud;
import logico.SolicitudEmpleado;
import logico.Tecnico;
import logico.Universitario;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class CrearSolicitud extends JDialog implements Serializable {

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
	private JPanel pnlSolicitante;
	private JPanel pnlEncuesta;
	private JRadioButton rdbtnAmbosModalidad;
	private JRadioButton rdbtnAmbosLM;
	private JRadioButton rdbtnAmbosVP;
	private JRadioButton rdbtnAmbosDM;
	private JLabel lblProv;
	private JComboBox<String> cbxProvEncuesta;
	private JSpinner spnPuestosDisp;
	private JLabel lblSexo;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JRadioButton rbtnAmbosSexo;
	private JLabel lblExp;
	private JSpinner spnExp;
	private JSpinner spnPorcentaje;
	private JRadioButton rbtnTecnicoCL;
	private JRadioButton rbtnObreroCL;
	private JRadioButton rbtnUniversitarioCL;
	private JLabel lblSalario;
	private JRadioButton rdbtnAmbosTiempo;
	private JTextField txtTelefono;
	private JLabel lblIdentificacion;
	private JLabel lblNombre;
	private JTextField txtCodigo;
	private JTextField txtProvincia;
	private JComboBox<String> cbxEspecialidadObrero;
	private JComboBox<String> cbxEspecialidadUniversitario;
	private JComboBox<String> cbxEspecialidadTecnico;

	private String modalidad = null;
	private String tiempo = null;
	private String provincia = null;
	private String sexo = null;
	private ArrayList<String> idioma = new ArrayList<>();
	private float salario = 0;
	private String licencia = null;
	private String vehiculo = null;
	private String dispManejo = null;
	private String nivelEst = null;
	private int puestosDisp = 0;
	private Float porcentaje = null;
	private int experiencia = 0;
	private Persona postulado = null;
	private Empresa empresa = null;
	private Solicitud local = null;

	public CrearSolicitud(Solicitud recibo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("iconosolicitudes.png"));
		local = recibo;
		setTitle("Crear Solicitud");
		setBounds(100, 100, 587, 137);
		if (local != null)
		{
			setTitle("Modificar Solicitud");
			if (local instanceof SolicitudEmpleado)
			{
				setBounds(100, 100, 587, 499);
				postulado = ((SolicitudEmpleado) local).getInfo();
			}
			else
			{
				setBounds(100, 100, 587, 557);
				empresa = ((Oferta) local).getInfo();
			}
		}
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
			if (local != null)
			{
				rbtnPostulacion.setEnabled(false);
			}
			
			if (local instanceof SolicitudEmpleado)
			{
				rbtnPostulacion.setSelected(true);
			}
			rbtnPostulacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setBounds(100, 100, 587, 499);
					lblIdentificacion.setText("Cedula:");
					lblNombre.setText("Nombre:");
					lblSalario.setText("Salario Minimo");
					rdbtnOtros.setText("Otros");
					setLocationRelativeTo(null);
					pnlEncuesta.setBounds(10, 187, 541, 221);
					pnlSolicitante.setBounds(10, 53, 541, 123);
					rbtnOferta.setSelected(false);
					lblProv.setVisible(false);
					cbxProvEncuesta.setVisible(false);
					rdbtnAmbosModalidad.setVisible(false);
					rdbtnAmbosLM.setVisible(false);
					rdbtnAmbosVP.setVisible(false);
					rdbtnAmbosDM.setVisible(false);
					rdbtnAmbosTiempo.setVisible(false);
				}
			});
			rbtnPostulacion.setBounds(55, 7, 93, 23);
			panel_1.add(rbtnPostulacion);

			rbtnOferta = new JRadioButton("Oferta Trabajo");
			if (local != null)
			{
				rbtnOferta.setEnabled(false);
			}

			if (local instanceof Oferta)
			{
				rbtnOferta.setSelected(true);
			}
			rbtnOferta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setBounds(100, 100, 587, 557);
					lblIdentificacion.setText("Codigo:");
					lblNombre.setText("Empresa:");
					lblSalario.setText("Salario Maximo");
					rdbtnOtros.setText("Cualquiera");
					pnlEncuesta.setBounds(10, 160, 541, 302);
					setLocationRelativeTo(null);
					pnlSolicitante.setBounds(10, 53, 541, 96);
					rbtnPostulacion.setSelected(false);
					lblProv.setVisible(true);
					cbxProvEncuesta.setVisible(true);
					rdbtnAmbosModalidad.setVisible(true);
					rdbtnAmbosLM.setVisible(true);
					rdbtnAmbosVP.setVisible(true);
					rdbtnAmbosDM.setVisible(true);
					rdbtnAmbosTiempo.setVisible(true);
				}
			});
			rbtnOferta.setBounds(150, 7, 126, 23);
			panel_1.add(rbtnOferta);

			txtCodigo = new JTextField();
			txtCodigo.setEnabled(false);
			txtCodigo.setText("SOLI-" + String.valueOf(Bolsa.getinstance().getGeneradorCodSolicitud()));
			if (local != null)
			{
				txtCodigo.setText(local.getCodigo().toString());
			}
			txtCodigo.setBounds(339, 8, 186, 20);
			panel_1.add(txtCodigo);
			txtCodigo.setColumns(10);

			pnlSolicitante = new JPanel();
			pnlSolicitante.setBounds(10, 53, 541, 96);
			if (local != null)
			{
				if (local instanceof Oferta)
				{
					pnlSolicitante.setBounds(10, 53, 541, 96);
				}
				else
				{
					pnlSolicitante.setBounds(10, 53, 541, 123);
				}
			}
			panel.add(pnlSolicitante);
			pnlSolicitante.setLayout(null);

			lblIdentificacion = new JLabel("Cedula:");
			lblIdentificacion.setBounds(10, 11, 46, 14);
			if (local != null)
			{
				if (local instanceof Oferta)
				{
					lblIdentificacion.setText("Codigo:");;
				}
			}
			pnlSolicitante.add(lblIdentificacion);

			txtIdentificacion = new JTextField();
			txtIdentificacion.setBounds(80, 10, 186, 17);
			if (local != null)
			{
				txtIdentificacion.setEnabled(false);
			}
			pnlSolicitante.add(txtIdentificacion);
			txtIdentificacion.setColumns(10);

			JButton btnBuscar = new JButton("Buscar");
			if (local != null)
			{
				btnBuscar.setEnabled(false);
			}
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
									postulado = Bolsa.getinstance().buscarPersonaByCedula(txtIdentificacion.getText());
									if (postulado != null)
									{
										loadPostulado();
									}
								}
							}
							if (rbtnUniversitario.isSelected())
							{
								cbxEspecialidadTecnico.setVisible(false);
								cbxEspecialidadObrero.setVisible(false);
								cbxEspecialidadUniversitario.setVisible(true);
							}
							else if (rbtnObrero.isSelected())
							{
								cbxEspecialidadTecnico.setVisible(false);
								cbxEspecialidadObrero.setVisible(true);
								cbxEspecialidadUniversitario.setVisible(false);
							}
							else if (rbtnTecnico.isSelected())
							{
								cbxEspecialidadTecnico.setVisible(true);
								cbxEspecialidadObrero.setVisible(false);
								cbxEspecialidadUniversitario.setVisible(false);
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
									empresa = Bolsa.getinstance().buscarEmpresaByCode(txtIdentificacion.getText());
									if (empresa != null)
									{
										loadEmpresa();
									}
								}
							}
						}
					}
				}
			});
			btnBuscar.setBounds(276, 7, 89, 23);
			pnlSolicitante.add(btnBuscar);

			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 41, 60, 14);
			if (local != null)
			{
				if (local instanceof Oferta)
				{
					lblNombre.setText("Empresa:");
				}
			}
			pnlSolicitante.add(lblNombre);

			txtNombre = new JTextField();
			txtNombre.setEnabled(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(80, 38, 186, 17);
			pnlSolicitante.add(txtNombre);

			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setBounds(10, 69, 46, 14);
			pnlSolicitante.add(lblCorreo);

			txtCorreo = new JTextField();
			txtCorreo.setEnabled(false);
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(80, 66, 186, 20);
			pnlSolicitante.add(txtCorreo);

			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(276, 41, 60, 14);
			pnlSolicitante.add(lblTelefono);

			txtTelefono = new JTextField();
			txtTelefono.setEnabled(false);
			txtTelefono.setBounds(339, 38, 186, 17);
			pnlSolicitante.add(txtTelefono);
			txtTelefono.setColumns(10);

			JLabel lblProvincia = new JLabel("Provincia:");
			lblProvincia.setBounds(276, 69, 60, 14);
			pnlSolicitante.add(lblProvincia);

			txtProvincia = new JTextField();
			txtProvincia.setEnabled(false);
			txtProvincia.setColumns(10);
			txtProvincia.setBounds(339, 68, 186, 17);
			pnlSolicitante.add(txtProvincia);

			JLabel lblCampoLaboral = new JLabel("Nivel Estudios:");
			lblCampoLaboral.setBounds(10, 97, 91, 14);
			pnlSolicitante.add(lblCampoLaboral);

			rbtnTecnico = new JRadioButton("Tecnico");
			rbtnTecnico.setEnabled(false);
			rbtnTecnico.setBounds(107, 93, 78, 23);
			pnlSolicitante.add(rbtnTecnico);

			rbtnObrero = new JRadioButton("Obrero");
			rbtnObrero.setEnabled(false);
			rbtnObrero.setBounds(185, 93, 66, 23);
			pnlSolicitante.add(rbtnObrero);

			rbtnUniversitario = new JRadioButton("Universitario");
			rbtnUniversitario.setEnabled(false);
			rbtnUniversitario.setBounds(253, 93, 109, 23);
			pnlSolicitante.add(rbtnUniversitario);

			pnlEncuesta = new JPanel();
			pnlEncuesta.setBounds(10, 160, 541, 302);
			if (local != null)
			{
				if (local instanceof SolicitudEmpleado)
				{
					pnlEncuesta.setBounds(10, 187, 541, 221);
				}
				else
				{
					pnlEncuesta.setBounds(10, 160, 541, 302);
				}
			}
			panel.add(pnlEncuesta);
			pnlEncuesta.setLayout(null);

			lblSalario = new JLabel("Salario Minimo:");
			if (local != null)
			{
				if (local instanceof Oferta)
				{
					lblSalario.setText("Salario Maximo");
				}
			}
			lblSalario.setBounds(10, 42, 92, 14);
			pnlEncuesta.add(lblSalario);

			spnSalario = new JSpinner();
			spnSalario.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			salario = Float.valueOf(spnSalario.getValue().toString());
			spnSalario.setBounds(106, 39, 81, 20);
			pnlEncuesta.add(spnSalario);

			JLabel lblLicenciaManejo = new JLabel("Licencia Manejo:");
			lblLicenciaManejo.setBounds(10, 145, 104, 14);
			pnlEncuesta.add(lblLicenciaManejo);

			rdbtnSiLM = new JRadioButton("Si");
			rdbtnSiLM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnNoLM.setSelected(false);
					rdbtnAmbosLM.setSelected(false);
					licencia = "Si";				}
			});
			rdbtnSiLM.setBounds(106, 141, 81, 23);
			pnlEncuesta.add(rdbtnSiLM);

			rdbtnNoLM = new JRadioButton("No");
			rdbtnNoLM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnSiLM.setSelected(false);
					rdbtnAmbosLM.setSelected(false);
					licencia = "No";
				}
			});
			rdbtnNoLM.setBounds(197, 141, 69, 23);
			pnlEncuesta.add(rdbtnNoLM);

			rdbtnAmbosLM = new JRadioButton("Ambos");
			if (local != null)
			{
				if (local instanceof Oferta)
				{
					rdbtnAmbosLM.setVisible(true);
				}
			}
			rdbtnAmbosLM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnSiLM.setSelected(false);
					rdbtnNoLM.setSelected(false);
					licencia = "Ambos";
				}
			});
			rdbtnAmbosLM.setBounds(290, 141, 69, 23);
			pnlEncuesta.add(rdbtnAmbosLM);

			JLabel lblTiempo = new JLabel("Tiempo:");
			lblTiempo.setBounds(10, 94, 46, 14);
			pnlEncuesta.add(lblTiempo);

			rdbtnCompleto = new JRadioButton("Completo");
			rdbtnCompleto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMedio.setSelected(false);
					rdbtnAmbosTiempo.setSelected(false);
					tiempo = "Completo";
				}
			});
			rdbtnCompleto.setBounds(106, 90, 81, 23);
			pnlEncuesta.add(rdbtnCompleto);

			rdbtnMedio = new JRadioButton("Medio");
			rdbtnMedio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnCompleto.setSelected(false);
					rdbtnAmbosTiempo.setSelected(false);
					tiempo = "Medio";
				}
			});
			rdbtnMedio.setBounds(197, 90, 81, 23);
			pnlEncuesta.add(rdbtnMedio);

			rdbtnAmbosTiempo = new JRadioButton("Ambos");
			if (local != null)
			{
				if (local instanceof Oferta)
				{
					rdbtnAmbosTiempo.setVisible(true);
				}
			}
			rdbtnAmbosTiempo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnCompleto.setSelected(false);
					rdbtnMedio.setSelected(false);
					tiempo = "Ambos";
				}
			});
			rdbtnAmbosTiempo.setBounds(290, 90, 81, 23);
			pnlEncuesta.add(rdbtnAmbosTiempo);

			JLabel lblModalidad = new JLabel("Modalidad:");
			lblModalidad.setBounds(10, 120, 69, 14);
			pnlEncuesta.add(lblModalidad);

			rdbtnRemoto = new JRadioButton("Remoto");
			rdbtnRemoto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnPresencial.setSelected(false);
					rdbtnAmbosModalidad.setSelected(false);
					modalidad = "Remoto";					
				}
			});
			rdbtnRemoto.setBounds(106, 116, 81, 23);
			pnlEncuesta.add(rdbtnRemoto);

			rdbtnPresencial = new JRadioButton("Presencial");
			rdbtnPresencial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnRemoto.setSelected(false);
					rdbtnAmbosModalidad.setSelected(false);
					modalidad = "Presencial";
				}
			});
			rdbtnPresencial.setBounds(197, 116, 91, 23);
			pnlEncuesta.add(rdbtnPresencial);

			rdbtnAmbosModalidad = new JRadioButton("Ambos");
			if (local != null)
			{
				if (local instanceof Oferta)
				{
					rdbtnAmbosModalidad.setVisible(true);
				}
			}
			rdbtnAmbosModalidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnRemoto.setSelected(false);
					rdbtnPresencial.setSelected(false);
					modalidad = "Ambos";
				}
			});
			rdbtnAmbosModalidad.setBounds(290, 116, 81, 23);
			pnlEncuesta.add(rdbtnAmbosModalidad);

			JLabel lblVehiculoPropio = new JLabel("Vehiculo Propio:");
			lblVehiculoPropio.setBounds(10, 171, 92, 14);
			pnlEncuesta.add(lblVehiculoPropio);

			rbtnSiVP = new JRadioButton("Si");
			rbtnSiVP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnNoVP.setSelected(false);
					rdbtnAmbosVP.setSelected(false);
					vehiculo = "Si";
				}
			});
			rbtnSiVP.setBounds(106, 167, 81, 23);
			pnlEncuesta.add(rbtnSiVP);

			rbtnNoVP = new JRadioButton("No");
			rbtnNoVP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiDM.setSelected(false);
					rdbtnAmbosVP.setSelected(false);
					vehiculo = "No";
				}
			});
			rbtnNoVP.setBounds(197, 167, 68, 23);
			pnlEncuesta.add(rbtnNoVP);

			rdbtnAmbosVP = new JRadioButton("Ambos");
			if (local != null)
			{
				if (local instanceof Oferta)
				{
					rdbtnAmbosVP.setVisible(true);
				}
			}
			rdbtnAmbosVP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiVP.setSelected(false);
					rbtnNoVP.setSelected(false);
					vehiculo = "Ambos";
				}
			});
			rdbtnAmbosVP.setBounds(290, 167, 68, 23);
			pnlEncuesta.add(rdbtnAmbosVP);

			JLabel lblDispMovilidad = new JLabel("Disp. Movilidad:");
			lblDispMovilidad.setBounds(10, 196, 92, 14);
			pnlEncuesta.add(lblDispMovilidad);

			rbtnSiDM = new JRadioButton("Si");
			rbtnSiDM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnNoDM.setSelected(false);
					rdbtnAmbosDM.setSelected(false);
					dispManejo = "Si";
				}
			});
			rbtnSiDM.setBounds(106, 192, 81, 23);
			pnlEncuesta.add(rbtnSiDM);

			rbtnNoDM = new JRadioButton("No");
			rbtnNoDM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnSiDM.setSelected(false);
					rdbtnAmbosDM.setSelected(false);
					dispManejo = "No";
				}
			});
			rbtnNoDM.setBounds(197, 192, 81, 23);
			pnlEncuesta.add(rbtnNoDM);

			rdbtnAmbosDM = new JRadioButton("Ambos");
			if (local != null)
			{
				if (local instanceof Oferta)
				{
					rdbtnAmbosDM.setVisible(true);
				}
			}
			rdbtnAmbosDM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnNoDM.setSelected(false);
					rbtnSiDM.setSelected(false);
					dispManejo = "Ambos";
				}
			});
			rdbtnAmbosDM.setBounds(290, 192, 81, 23);
			pnlEncuesta.add(rdbtnAmbosDM);

			JLabel lblEspecialidad = new JLabel("Especialidad:");
			lblEspecialidad.setBounds(10, 14, 104, 14);
			pnlEncuesta.add(lblEspecialidad);

			cbxEspecialidadTecnico = new JComboBox<String>();
			cbxEspecialidadTecnico.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", "Cocina", 
					"Dise\u00F1o Grafico", "Enfermeria", "Electronica Basica", "Mantenimiento de PC", "Ofimatica", 
					"Refigeracion", "Tecnologia"}));
			cbxEspecialidadTecnico.setBounds(106, 11, 160, 20);
			pnlEncuesta.add(cbxEspecialidadTecnico);

			cbxEspecialidadUniversitario = new JComboBox<String>();
			cbxEspecialidadUniversitario.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", "Administracion", "Audiovisual", 
					"Computo", "Electronica", "Redes", "Programacion", "Turismo", "Medicina", "Economia", "Tecnologia", "Publicidad"}));
			cbxEspecialidadUniversitario.setBounds(106, 11, 160, 20);
			pnlEncuesta.add(cbxEspecialidadUniversitario);

			cbxEspecialidadObrero = new JComboBox<String>();
			cbxEspecialidadObrero.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", 
					"Cocinero", "Electricista", "Constructor", "Chofer"}));
			cbxEspecialidadObrero.setBounds(106, 11, 160, 20);
			pnlEncuesta.add(cbxEspecialidadObrero);

			if (local instanceof Oferta || rbtnOferta.isSelected())
			{
				if (local.getNivelEst().equalsIgnoreCase("Universitario"))
				{
					cbxEspecialidadTecnico.setVisible(false);
					cbxEspecialidadObrero.setVisible(false);
					cbxEspecialidadUniversitario.setVisible(true);
				}
				else if (local.getNivelEst().equalsIgnoreCase("Obrero"))
				{
					cbxEspecialidadTecnico.setVisible(false);
					cbxEspecialidadObrero.setVisible(true);
					cbxEspecialidadUniversitario.setVisible(false);
				}
				else if (local.getNivelEst().equalsIgnoreCase("Tecnico"))
				{
					cbxEspecialidadTecnico.setVisible(true);
					cbxEspecialidadObrero.setVisible(false);
					cbxEspecialidadUniversitario.setVisible(false);
				}
			}
			else if (local instanceof SolicitudEmpleado || rbtnPostulacion.isSelected())
			{
				if (((SolicitudEmpleado) local).getInfo().getNivelEst().equalsIgnoreCase("Universitario"))
				{
					cbxEspecialidadTecnico.setVisible(false);
					cbxEspecialidadObrero.setVisible(false);
					cbxEspecialidadUniversitario.setVisible(true);
				}
				else if (((SolicitudEmpleado) local).getInfo().getNivelEst().equalsIgnoreCase("Obrero"))
				{
					cbxEspecialidadTecnico.setVisible(false);
					cbxEspecialidadObrero.setVisible(true);
					cbxEspecialidadUniversitario.setVisible(false);
				}
				else if (((SolicitudEmpleado) local).getInfo().getNivelEst().equalsIgnoreCase("Tecnico"))
				{
					cbxEspecialidadTecnico.setVisible(true);
					cbxEspecialidadObrero.setVisible(false);
					cbxEspecialidadUniversitario.setVisible(false);
				}
			}

			JLabel lblIdioma = new JLabel("Idioma:");
			lblIdioma.setBounds(10, 67, 46, 14);
			pnlEncuesta.add(lblIdioma);

			rdbtnEspanol = new JRadioButton("Espa\u00F1ol");
			rdbtnEspanol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					idioma.add("Espa\u00F1ol");
				}
			});
			rdbtnEspanol.setBounds(106, 63, 81, 23);
			pnlEncuesta.add(rdbtnEspanol);

			rdbtnIngles = new JRadioButton("Ingles");
			rdbtnIngles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma.add("Ingles");
				}
			});
			rdbtnIngles.setBounds(197, 63, 69, 23);
			pnlEncuesta.add(rdbtnIngles);

			rdbtnFrances = new JRadioButton("Frances");
			rdbtnFrances.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma.add("Frances".toString());
				}
			});
			rdbtnFrances.setBounds(290, 63, 81, 23);
			pnlEncuesta.add(rdbtnFrances);

			rdbtnOtros = new JRadioButton("Otros");
			if (local instanceof Oferta)
			{
				rdbtnOtros.setText("Cualquiera");
			}
			rdbtnOtros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (rbtnOferta.isSelected())
					{
						idioma.add("Cualquiera");
					}
					else
					{
						idioma.add("Otros");
					}
				}
			});
			rdbtnOtros.setBounds(376, 63, 69, 23);
			pnlEncuesta.add(rdbtnOtros);

			lblProv = new JLabel("Provincia:");
			lblProv.setBounds(276, 14, 60, 14);
			if (local != null)
			{
				if (local instanceof SolicitudEmpleado)
				{
					lblProv.setVisible(false);
				}
				else
				{
					lblProv.setVisible(true);
				}
			}
			pnlEncuesta.add(lblProv);

			cbxProvEncuesta = new JComboBox<String>();
			if (local != null)
			{
				if (local instanceof SolicitudEmpleado)
				{
					cbxProvEncuesta.setVisible(false);
				}
				else
				{
					cbxProvEncuesta.setVisible(true);
				}
			}
			cbxProvEncuesta.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", "Az\u00FAa", "Barahona", "Distrito Nacional", 
					"Independencia", "La Altagracia", "La Romana", "La Vega", "Puerto Plata", "Samana", "San Cristobal", "San Juan", 
					"San Pedro de Macor\u00EDs", "Santiago", "Santo Domingo"}));
			cbxProvEncuesta.setEnabled(false);
			cbxProvEncuesta.setBounds(365, 11, 160, 20);
			pnlEncuesta.add(cbxProvEncuesta);
			provincia = cbxProvEncuesta.getSelectedItem().toString();

			JLabel lblPuestoDisp = new JLabel("Puestos Disp.:");
			lblPuestoDisp.setBounds(10, 275, 85, 14);
			pnlEncuesta.add(lblPuestoDisp);

			spnPuestosDisp = new JSpinner();
			spnPuestosDisp.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
			spnPuestosDisp.setBounds(106, 272, 81, 20);
			pnlEncuesta.add(spnPuestosDisp);
			puestosDisp = Integer.valueOf(spnPuestosDisp.getValue().toString());

			lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(10, 222, 46, 14);
			pnlEncuesta.add(lblSexo);

			rdbtnMasculino = new JRadioButton("Masculino");
			rdbtnMasculino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnFemenino.setSelected(false);
					rbtnAmbosSexo.setSelected(false);
					sexo = rdbtnMasculino.getText();
				}
			});
			rdbtnMasculino.setBounds(106, 218, 89, 23);
			pnlEncuesta.add(rdbtnMasculino);

			rdbtnFemenino = new JRadioButton("Femenino");
			rdbtnFemenino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMasculino.setSelected(false);
					rbtnAmbosSexo.setSelected(false);
					sexo = rdbtnFemenino.getText();
				}
			});
			rdbtnFemenino.setBounds(197, 218, 81, 23);
			pnlEncuesta.add(rdbtnFemenino);

			rbtnAmbosSexo = new JRadioButton("Ambos");
			rbtnAmbosSexo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMasculino.setSelected(false);
					rdbtnFemenino.setSelected(false);
					sexo = rbtnAmbosSexo.getText();
				}
			});
			rbtnAmbosSexo.setBounds(290, 218, 81, 23);
			pnlEncuesta.add(rbtnAmbosSexo);

			lblExp = new JLabel("A\u00F1os Exp.:");
			lblExp.setBounds(276, 42, 104, 14);
			pnlEncuesta.add(lblExp);

			spnExp = new JSpinner();
			spnExp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnExp.setBounds(365, 39, 81, 20);
			pnlEncuesta.add(spnExp);
			experiencia = Integer.valueOf(spnExp.getValue().toString());

			JLabel lblPorcentajeMatch = new JLabel("Puntaje:");
			lblPorcentajeMatch.setBounds(276, 275, 104, 14);
			pnlEncuesta.add(lblPorcentajeMatch);

			spnPorcentaje = new JSpinner();
			spnPorcentaje.setModel(new SpinnerNumberModel(new Integer(50), new Integer(0), null, new Integer(1)));
			spnPorcentaje.setBounds(365, 272, 81, 20);
			pnlEncuesta.add(spnPorcentaje);
			porcentaje = Float.valueOf(spnPorcentaje.getValue().toString()) / 100;

			JLabel lblNivelEst = new JLabel("Nivel Estudios:");
			lblNivelEst.setBounds(10, 247, 91, 14);
			pnlEncuesta.add(lblNivelEst);

			rbtnTecnicoCL = new JRadioButton("Tecnico");
			rbtnTecnicoCL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnObreroCL.setSelected(false);
					rbtnUniversitarioCL.setSelected(false);
					nivelEst = "Tecnico";

					cbxEspecialidadObrero.setVisible(false);
					cbxEspecialidadUniversitario.setVisible(false);
					cbxEspecialidadTecnico.setVisible(true);
					cbxEspecialidadObrero.setEnabled(false);
					cbxEspecialidadUniversitario.setEnabled(false);
					cbxEspecialidadTecnico.setEnabled(true);
				}
			});
			rbtnTecnicoCL.setBounds(106, 243, 78, 23);
			pnlEncuesta.add(rbtnTecnicoCL);

			rbtnObreroCL = new JRadioButton("Obrero");
			rbtnObreroCL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnTecnicoCL.setSelected(false);
					rbtnUniversitarioCL.setSelected(false);
					nivelEst = "Obrero";

					cbxEspecialidadObrero.setVisible(true);
					cbxEspecialidadUniversitario.setVisible(false);
					cbxEspecialidadTecnico.setVisible(false);
					cbxEspecialidadObrero.setEnabled(true);
					cbxEspecialidadUniversitario.setEnabled(false);
					cbxEspecialidadTecnico.setEnabled(false);
				}
			});
			rbtnObreroCL.setBounds(197, 243, 66, 23);
			pnlEncuesta.add(rbtnObreroCL);

			rbtnUniversitarioCL = new JRadioButton("Universitario");
			rbtnUniversitarioCL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbtnTecnicoCL.setSelected(false);
					rbtnObreroCL.setSelected(false);
					nivelEst = "Universitario";

					cbxEspecialidadObrero.setVisible(false);
					cbxEspecialidadUniversitario.setVisible(true);
					cbxEspecialidadTecnico.setVisible(false);
					cbxEspecialidadObrero.setEnabled(false);
					cbxEspecialidadUniversitario.setEnabled(true);
					cbxEspecialidadTecnico.setEnabled(false);
				}
			});
			rbtnUniversitarioCL.setBounds(290, 243, 109, 23);
			pnlEncuesta.add(rbtnUniversitarioCL);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCrear = new JButton("Crear");
				if (local != null)
				{
					btnCrear.setText("Modificar");
				}
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Solicitud auxSoli = null;
						if (local == null)
						{
							if (rbtnPostulacion.isSelected())
							{
								if (!Bolsa.getinstance().nombreOrCedulaRepetidos(postulado.getCedula()))
								{

									if (postulado instanceof Obrero)
									{
										auxSoli = new SolicitudEmpleado(txtCodigo.getText().toString(), "Obrero", modalidad, 
												tiempo, cbxEspecialidadObrero.getSelectedItem().toString(), postulado.getPais(), idioma, sexo, experiencia, dispManejo, 
												vehiculo, licencia, Bolsa.getLoginUser(), true, salario, postulado);
									}
									else if (postulado instanceof Tecnico)
									{
										auxSoli = new SolicitudEmpleado(txtCodigo.getText().toString(), "Tecnico", modalidad, 
												tiempo, cbxEspecialidadTecnico.getSelectedItem().toString(), postulado.getPais(), idioma, sexo, experiencia, dispManejo, 
												vehiculo, licencia, Bolsa.getLoginUser(), true, salario, 
												postulado);
									}
									else if (postulado instanceof Universitario)
									{
										auxSoli = new SolicitudEmpleado(txtCodigo.getText().toString(), "Universitario", modalidad, 
												tiempo, cbxEspecialidadUniversitario.getSelectedItem().toString(), postulado.getPais(), idioma, sexo, experiencia, dispManejo, 
												vehiculo, licencia, Bolsa.getLoginUser(), true, salario, 
												postulado);
									}
									
									if (auxSoli != null)
									{
										Bolsa.getinstance().registrarSolicitud(auxSoli);
										JOptionPane.showMessageDialog(null, "Registro de solicitud satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
									}

									clean();
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Registro no satisfactorio, Postulado/Empresa ya existente", "Información", JOptionPane.INFORMATION_MESSAGE);
								}
							}
							else if (rbtnOferta.isSelected())
							{
								if (rbtnTecnicoCL.isSelected())
								{
									auxSoli = new Oferta(txtCodigo.getText().toString(), nivelEst, modalidad, tiempo, cbxEspecialidadObrero.getSelectedItem().toString(), 
											provincia, idioma, sexo, experiencia, dispManejo, vehiculo,
											licencia, Bolsa.getLoginUser(), true, puestosDisp, salario, porcentaje, 
											empresa);
								}
								else if (rbtnUniversitarioCL.isSelected())
								{
									auxSoli = new Oferta(txtCodigo.getText().toString(), nivelEst, modalidad, tiempo, cbxEspecialidadUniversitario.getSelectedItem().toString(), 
											provincia, idioma, sexo, experiencia, dispManejo, vehiculo,									
											licencia, Bolsa.getLoginUser(), true, puestosDisp, salario, porcentaje,
											empresa);
								}
								else if (rbtnTecnicoCL.isSelected())
								{
									auxSoli = new Oferta(txtCodigo.getText().toString(), nivelEst, modalidad, tiempo, cbxEspecialidadTecnico.getSelectedItem().toString(), 
											provincia, idioma, sexo, experiencia, dispManejo, vehiculo,
											licencia, Bolsa.getLoginUser(), true, puestosDisp, salario, porcentaje, 
											empresa);
								}
								
								if (auxSoli != null)
								{
									Bolsa.getinstance().registrarSolicitud(auxSoli);
									JOptionPane.showMessageDialog(null, "Registro de oferta satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
								}

								clean();
							}

						}
						else
						{
							if (local instanceof SolicitudEmpleado)
							{
								if (((SolicitudEmpleado) recibo).getInfo().getNivelEst().equalsIgnoreCase("Tecnico"))
								{
									recibo.setModalidad(modalidad);
									recibo.setTiempo(tiempo);
									recibo.setNivelEst("Tecnico");
									recibo.setEspecialidad(cbxEspecialidadObrero.getSelectedItem().toString());
									recibo.setUbicacion(postulado.getPais());
									recibo.setSexo(sexo);
									recibo.setExp(experiencia);
									recibo.setDispMov(dispManejo);
									recibo.setVehiculoPropio(vehiculo);
									recibo.setLicencia(licencia);
									recibo.setEstado(true);
									((SolicitudEmpleado) recibo).setSalariomin(salario);
								}
								else if (((SolicitudEmpleado) recibo).getInfo().getNivelEst().equalsIgnoreCase("Universitario"))
								{
									recibo.setModalidad(modalidad);
									recibo.setTiempo(tiempo);
									recibo.setNivelEst("Universitario");
									recibo.setEspecialidad(cbxEspecialidadObrero.getSelectedItem().toString());
									recibo.setUbicacion(postulado.getPais());
									recibo.setSexo(sexo);
									recibo.setExp(experiencia);
									recibo.setDispMov(dispManejo);
									recibo.setVehiculoPropio(vehiculo);
									recibo.setLicencia(licencia);
									recibo.setEstado(true);
									((SolicitudEmpleado) recibo).setSalariomin(salario);
								}
								else if (((SolicitudEmpleado) recibo).getInfo().getNivelEst().equalsIgnoreCase("Obrero"))
								{
									recibo.setModalidad(modalidad);
									recibo.setTiempo(tiempo);
									recibo.setNivelEst("Obrero");
									recibo.setEspecialidad(cbxEspecialidadObrero.getSelectedItem().toString());
									recibo.setUbicacion(postulado.getPais());
									recibo.setSexo(sexo);
									recibo.setExp(experiencia);
									recibo.setDispMov(dispManejo);
									recibo.setVehiculoPropio(vehiculo);
									recibo.setLicencia(licencia);
									recibo.setEstado(true);
									((SolicitudEmpleado) recibo).setSalariomin(salario);
								}
								ListSolicitudesEmpleados.loadSolicitudes();
							}
							else
							{
								if (rbtnTecnicoCL.isSelected())
								{
									recibo.setModalidad(modalidad);
									recibo.setTiempo(tiempo);
									recibo.setNivelEst("Tecnico");
									recibo.setEspecialidad(cbxEspecialidadObrero.getSelectedItem().toString());
									recibo.setUbicacion(postulado.getPais());
									recibo.setSexo(sexo);
									recibo.setExp(experiencia);
									recibo.setDispMov(dispManejo);
									recibo.setVehiculoPropio(vehiculo);
									recibo.setLicencia(licencia);
									((Oferta) recibo).setSalariomax(salario);
								}
								else if (rbtnUniversitarioCL.isSelected())
								{
									recibo.setModalidad(modalidad);
									recibo.setTiempo(tiempo);
									recibo.setNivelEst("Universitario");
									recibo.setEspecialidad(cbxEspecialidadObrero.getSelectedItem().toString());
									recibo.setUbicacion(postulado.getPais());
									recibo.setSexo(sexo);
									recibo.setExp(experiencia);
									recibo.setDispMov(dispManejo);
									recibo.setVehiculoPropio(vehiculo);
									recibo.setLicencia(licencia);
									((Oferta) recibo).setSalariomax(salario);
								}
								else if (rbtnTecnicoCL.isSelected())
								{
									recibo.setModalidad(modalidad);
									recibo.setTiempo(tiempo);
									recibo.setNivelEst("Obrero");
									recibo.setEspecialidad(cbxEspecialidadObrero.getSelectedItem().toString());
									recibo.setUbicacion(postulado.getPais());
									recibo.setSexo(sexo);
									recibo.setExp(experiencia);
									recibo.setDispMov(dispManejo);
									recibo.setVehiculoPropio(vehiculo);
									recibo.setLicencia(licencia);
									((Oferta) recibo).setSalariomax(salario);
								}
								ListOfertas.loadOfertas();
							}
							JOptionPane.showMessageDialog(null, "Modificacion satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							dispose();
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
		if (local != null)
		{
			if (local instanceof SolicitudEmpleado)
			{
				loadPostulado();
				loadSolicitud((SolicitudEmpleado) local);
				ListSolicitudesEmpleados.loadSolicitudes();
			}
			else
			{
				loadEmpresa();
				loadOferta((Oferta) local);
				ListOfertas.loadOfertas();
			}

		}
	}

	private void loadPostulado()
	{
		if (postulado != null)
		{
			txtIdentificacion.setText(postulado.getCedula());
			txtNombre.setText(postulado.getNombre());
			txtCorreo.setText(postulado.getEmail());
			txtTelefono.setText(postulado.getTelefono());
			txtProvincia.setText(postulado.getPais());
			if (postulado.getNivelEst().equalsIgnoreCase("Obrero"))
			{
				rbtnObrero.setSelected(true);
			}
			else if (postulado.getNivelEst().equalsIgnoreCase("Tecnico"))
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
			txtIdentificacion.setText(empresa.getCodigo());
			txtNombre.setText(empresa.getNombreEmpresa());
			txtCorreo.setText(empresa.getEmail());
			txtTelefono.setText(empresa.getTelefono());
			txtProvincia.setText(empresa.getPais());	
		}
	}

	private void clean() {
		cbxEspecialidadObrero.setSelectedIndex(0);
		cbxEspecialidadTecnico.setSelectedIndex(0);
		cbxEspecialidadUniversitario.setSelectedIndex(0);

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

		rbtnPostulacion.setSelected(false);
		rbtnOferta.setSelected(false);

		modalidad = null;
		tiempo = null;
		provincia = null;
		sexo = null;
		idioma = null;
		salario = 0;
		salario = 0;
		licencia = null;
		vehiculo = null;
		dispManejo = null;
		nivelEst = null;
		puestosDisp = 0;
		porcentaje = null;
		experiencia = 0;
		postulado = null;
		empresa = null;

		txtCodigo.setText(null);
		txtNombre.setText(null);
		txtTelefono.setText(null);
		txtCorreo.setText(null);
		txtProvincia.setText(null);
		rbtnObrero.setSelected(false);
		rbtnTecnico.setSelected(false);
		rbtnUniversitario.setSelected(false);

		setBounds(100, 100, 587, 137);
		setLocationRelativeTo(null);
	}

	private void loadSolicitud(SolicitudEmpleado modificable)
	{
		spnSalario.setValue(modificable.getSalariomin());
		spnExp.setValue(modificable.getExp());

		if (modificable.getInfo() instanceof Tecnico)
		{
			cbxEspecialidadObrero.setVisible(false);
			cbxEspecialidadUniversitario.setVisible(false);
			cbxEspecialidadTecnico.setVisible(true);
			cbxEspecialidadTecnico.setSelectedItem(modificable.getEspecialidad().toString());
		}
		else if (modificable.getInfo() instanceof Obrero)
		{
			cbxEspecialidadObrero.setVisible(true);
			cbxEspecialidadUniversitario.setVisible(false);
			cbxEspecialidadTecnico.setVisible(false);
			cbxEspecialidadObrero.setSelectedItem(modificable.getEspecialidad().toString());
		}
		else
		{
			cbxEspecialidadObrero.setVisible(false);
			cbxEspecialidadUniversitario.setVisible(true);
			cbxEspecialidadTecnico.setVisible(false);
			cbxEspecialidadUniversitario.setSelectedItem(modificable.getEspecialidad().toString());
		}

		if (modificable.getVehiculoPropio().equalsIgnoreCase("Si"))
		{
			rbtnSiVP.setSelected(true);
		}
		else
		{
			rbtnNoVP.setSelected(true);
		}

		if (modificable.getLicencia().equalsIgnoreCase("Si"))
		{
			rdbtnSiLM.setSelected(true);
		}
		else
		{
			rdbtnNoLM.setSelected(true);
		}

		if (modificable.getDispMov().equalsIgnoreCase("Si"))
		{
			rbtnSiDM.setSelected(true);
		}
		else
		{
			rbtnNoDM.setSelected(true);
		}

		if (modificable.getModalidad().equalsIgnoreCase("Remoto"))
		{
			rdbtnRemoto.setSelected(true);
		}
		else
		{
			rdbtnPresencial.setSelected(true);
		}

		if (modificable.getTiempo().equalsIgnoreCase("Completo"))
		{
			rdbtnCompleto.setSelected(true);
		}
		else
		{
			rdbtnMedio.setSelected(true);
		}

	}

	private void loadOferta(Oferta ofrt)
	{
		spnSalario.setValue(ofrt.getSalariomax());
		spnExp.setValue(ofrt.getExp());
		spnPorcentaje.setValue(ofrt.getMatchpercent());
		spnPuestosDisp.setValue(ofrt.getCantpuestos());
		cbxProvEncuesta.setSelectedItem(ofrt.getUbicacion());

		if (ofrt.getNivelEst().equalsIgnoreCase("Tecnico"))
		{
			cbxEspecialidadObrero.setVisible(false);
			cbxEspecialidadUniversitario.setVisible(false);
			cbxEspecialidadTecnico.setVisible(true);
			cbxEspecialidadTecnico.setSelectedItem(ofrt.getEspecialidad().toString());
		}
		else if (ofrt.getNivelEst().equalsIgnoreCase("Obrero"))
		{
			cbxEspecialidadObrero.setVisible(true);
			cbxEspecialidadUniversitario.setVisible(false);
			cbxEspecialidadTecnico.setVisible(false);
			cbxEspecialidadObrero.setSelectedItem(ofrt.getEspecialidad().toString());
		}
		else
		{
			cbxEspecialidadObrero.setVisible(false);
			cbxEspecialidadUniversitario.setVisible(true);
			cbxEspecialidadTecnico.setVisible(false);
			cbxEspecialidadUniversitario.setSelectedItem(ofrt.getEspecialidad().toString());
		}

		if (ofrt.getVehiculoPropio().equalsIgnoreCase("Si"))
		{
			rbtnSiVP.setSelected(true);
		}
		else if (ofrt.getVehiculoPropio().equalsIgnoreCase("No"))
		{
			rbtnNoVP.setSelected(true);
		}
		else
		{
			rdbtnAmbosVP.setSelected(true);
		}

		if (ofrt.getLicencia().equalsIgnoreCase("Si"))
		{
			rdbtnSiLM.setSelected(true);
		}
		else if (ofrt.getLicencia().equalsIgnoreCase("No"))
		{
			rdbtnNoLM.setSelected(true);
		}
		else
		{
			rdbtnAmbosLM.setSelected(true);
		}

		if (ofrt.getDispMov().equalsIgnoreCase("Si"))
		{
			rbtnSiDM.setSelected(true);
		}
		else if (ofrt.getDispMov().equalsIgnoreCase("No"))
		{
			rbtnNoDM.setSelected(true);
		}
		else
		{
			rdbtnAmbosDM.setSelected(true);
		}

		if (ofrt.getModalidad().equalsIgnoreCase("Remoto"))
		{
			rdbtnRemoto.setSelected(true);
		}
		else if (ofrt.getModalidad().equalsIgnoreCase("Presencial"))
		{
			rdbtnPresencial.setSelected(true);
		}
		else
		{
			rdbtnAmbosModalidad.setSelected(true);
		}

		if (ofrt.getTiempo().equalsIgnoreCase("Completo"))
		{
			rdbtnCompleto.setSelected(true);
		}
		else if (local.getTiempo().equalsIgnoreCase("Medio"))
		{
			rdbtnMedio.setSelected(true);
		}
		else
		{
			rdbtnAmbosTiempo.setSelected(true);
		}

		if (ofrt.getSexo().equalsIgnoreCase("Masculino"))
		{
			rdbtnMasculino.setSelected(true);
		}
		else if (ofrt.getSexo().equalsIgnoreCase("Femenino"))
		{
			rdbtnFemenino.setSelected(true);
		}
		else
		{
			rbtnAmbosSexo.setSelected(true);
		}
	}
}
