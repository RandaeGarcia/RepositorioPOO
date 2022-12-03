package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import logico.*;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

public class Registros extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnObrero;
	private JTextField txtCorreo;
	private JTextField txttelefono;
	private JLabel lblareadetrabajo;
	private JSpinner spnExperiencia;
	private JComboBox<String> cbxAreaTrabajo;
	private JLabel lblexperiencia;
	private JTextField txtOficiosConocidos;
	private JButton btnAgregar;
	private JButton btnregistrar;
	private JPanel panel3;
	private JPanel panel5;
	private JPanel panel4;
	private JRadioButton rdbtnPersona;
	private JRadioButton rdbtnEmpresa;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JPanel panelempresa;
	private JPanel panel_3;
	private JLabel lblNewLabel_11;
	private JTextField txtcodigo;
	private JLabel lblNewLabel_12;
	private JTextField txtNombreEmpresa;
	private JLabel lblNewLabel_13;
	private JTextField txtTelefonoEmpresa;
	private JLabel lblNewLabel_14;
	private JTextField txtCorreoempresa;
	private JLabel lblNewLabel_15;
	private JComboBox<String> cbxProvinciaEmpresa;
	private JPanel panelpersona;
	private JPanel panel2;
	private JComboBox<String> cbxCarrera;
	private JSpinner spnFechaGraduacion;
	private JSpinner spnfechanacimiento;
	private ArrayList<String> oficios;
	private JComboBox<String> cbxprovincia;
	private JComboBox<String> cbxEspecialidadObrero;
	private JLabel lblNewLabel_17;
	private JComboBox<String> cbxAreaTrabajoEmpresa;
	private JComboBox<String> cbxEspecialidadUniversitario;
	private JComboBox<String> cbxEspecialidadTecnico;
	
	public Registros() {
		setTitle("Registro");
		setBounds(100, 100, 512, 569);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panelpersona = new JPanel();
			panelpersona.setBounds(5, 43, 486, 450);
			panelpersona.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panelpersona);
			panelpersona.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 11, 466, 322);
			panelpersona.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("C\u00E9dula:");
			lblNewLabel_1.setBounds(10, 11, 46, 14);
			panel_1.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Nombre:");
			lblNewLabel_2.setBounds(218, 11, 54, 14);
			panel_1.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Telefono:");
			lblNewLabel_3.setBounds(218, 79, 54, 14);
			panel_1.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Correo:");
			lblNewLabel_4.setBounds(10, 79, 46, 14);
			panel_1.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento:");
			lblNewLabel_5.setBounds(10, 135, 120, 14);
			panel_1.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Sexo:");
			lblNewLabel_6.setBounds(10, 197, 46, 14);
			panel_1.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Provincia:");
			lblNewLabel_7.setBounds(218, 135, 80, 14);
			panel_1.add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Nivel Estudios:");
			lblNewLabel_8.setBounds(10, 283, 92, 14);
			panel_1.add(lblNewLabel_8);
			
			
			
			rdbtnTecnico = new JRadioButton("T\u00E9cnico:");
			rdbtnTecnico.setSelected(true);
			rdbtnTecnico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbtnTecnico.setSelected(true);
					rdbtnUniversitario.setSelected(false);
					rdbtnObrero.setSelected(false);
					
					panel3.setVisible(true);
					panel5.setVisible(false);
					panel4.setVisible(false);
					
					cbxAreaTrabajo.setEnabled(true);
					spnExperiencia.setEnabled(true);
					cbxCarrera.setEnabled(false);
					spnFechaGraduacion.setEnabled(false);
					txtOficiosConocidos.setEnabled(false);
					btnAgregar.setEnabled(false);
					
					cbxEspecialidadTecnico.setVisible(true);
					cbxEspecialidadObrero.setVisible(false);
					cbxEspecialidadUniversitario.setVisible(false);
					cbxEspecialidadTecnico.setEnabled(true);
					cbxEspecialidadObrero.setEnabled(false);
					cbxEspecialidadUniversitario.setEnabled(false);
				}
			});
			rdbtnTecnico.setBounds(114, 279, 92, 23);
			panel_1.add(rdbtnTecnico);
			
			rdbtnUniversitario = new JRadioButton("Universitario");
			rdbtnUniversitario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbtnUniversitario.setSelected(true);
					rdbtnObrero.setSelected(false);
					rdbtnTecnico.setSelected(false);
					
					panel4.setVisible(true);
					panel3.setVisible(false);
					panel5.setVisible(false);
					
					cbxAreaTrabajo.setEnabled(false);
					spnExperiencia.setEnabled(false);
					cbxCarrera.setEnabled(true);
					spnFechaGraduacion.setEnabled(true);
					txtOficiosConocidos.setEnabled(false);
					btnAgregar.setEnabled(false);
					
					cbxEspecialidadUniversitario.setVisible(true);
					cbxEspecialidadObrero.setVisible(false);
					cbxEspecialidadTecnico.setVisible(false);
					cbxEspecialidadUniversitario.setEnabled(true);
					cbxEspecialidadObrero.setEnabled(false);
					cbxEspecialidadTecnico.setEnabled(false);
				}
			});
			rdbtnUniversitario.setBounds(218, 279, 109, 23);
			panel_1.add(rdbtnUniversitario);
			
			rdbtnObrero = new JRadioButton("Obrero");
			rdbtnObrero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbtnObrero.setSelected(true);
					rdbtnTecnico.setSelected(false);
					rdbtnUniversitario.setSelected(false);
					
					panel3.setVisible(false);
					panel4.setVisible(false);
					panel5.setVisible(true);
					
					cbxAreaTrabajo.setEnabled(false);
					spnExperiencia.setEnabled(false);
					cbxCarrera.setEnabled(false);
					spnFechaGraduacion.setEnabled(false);
					txtOficiosConocidos.setEnabled(true);
					btnAgregar.setEnabled(true);
					
					cbxEspecialidadObrero.setVisible(true);
					cbxEspecialidadUniversitario.setVisible(false);
					cbxEspecialidadTecnico.setVisible(false);
					cbxEspecialidadObrero.setEnabled(true);
					cbxEspecialidadUniversitario.setEnabled(false);
					cbxEspecialidadTecnico.setEnabled(false);
					
				}
			});
			rdbtnObrero.setBounds(339, 279, 109, 23);
			panel_1.add(rdbtnObrero);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(10, 36, 185, 20);
			panel_1.add(txtCedula);
			txtCedula.setColumns(10);
			
			spnfechanacimiento = new JSpinner();
			spnfechanacimiento.setModel(new SpinnerDateModel(new Date(1669262400000L), null, null, Calendar.MONTH));
			spnfechanacimiento.setBounds(10, 160, 140, 20);
			panel_1.add(spnfechanacimiento);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(218, 36, 230, 20);
			panel_1.add(txtNombre);
			txtNombre.setColumns(10);
			
			rdbtnMasculino = new JRadioButton("M");
			rdbtnMasculino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnFemenino.setSelected(false);
					rdbtnMasculino.setSelected(true);
				}
			});
			rdbtnMasculino.setBounds(10, 225, 38, 23);
			panel_1.add(rdbtnMasculino);
			
			rdbtnFemenino = new JRadioButton("F");
			rdbtnFemenino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnFemenino.setSelected(true);
					rdbtnMasculino.setSelected(false);
				}
			});
			rdbtnFemenino.setBounds(64, 225, 54, 23);
			panel_1.add(rdbtnFemenino);
			
			txtCorreo = new JTextField();
			txtCorreo.setBounds(10, 104, 185, 20);
			panel_1.add(txtCorreo);
			txtCorreo.setColumns(10);
			
			cbxprovincia = new JComboBox<String>();
			cbxprovincia.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "San Crist\u00F3bal", "San Jos\u00E9 de Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "S\u00E1nchez Ram\u00EDrez", "Santiago", "Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
			cbxprovincia.setBounds(218, 160, 230, 20);
			panel_1.add(cbxprovincia);
			
			txttelefono = new JTextField();
			txttelefono.setBounds(218, 104, 230, 20);
			panel_1.add(txttelefono);
			txttelefono.setColumns(10);
			
			JLabel lblNewLabel_16 = new JLabel("Especialidad:");
			lblNewLabel_16.setBounds(218, 197, 92, 14);
			panel_1.add(lblNewLabel_16);
			
			cbxEspecialidadTecnico = new JComboBox<String>();
			cbxEspecialidadTecnico.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", "Cocina", "Dise\u00F1o Grafico", "Enfermeria", "Electronica Basica", "Mantenimiento de PC", "Ofimatica", "Refigeracion", "Tecnologia"}));
			cbxEspecialidadTecnico.setBounds(218, 226, 230, 20);
			panel_1.add(cbxEspecialidadTecnico);
			
			cbxEspecialidadUniversitario = new JComboBox<String>();
			cbxEspecialidadUniversitario.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", "Administracion", "Audiovisual", 
					"Computo", "Electronica", "Redes", "Programacion", "Turismo", "Medicina", "Economia", "Tecnologia", "Publicidad"}));
			cbxEspecialidadUniversitario.setBounds(218, 226, 230, 20);
			panel_1.add(cbxEspecialidadUniversitario);
			
			cbxEspecialidadObrero = new JComboBox<String>();
			cbxEspecialidadObrero.setBounds(218, 226, 230, 20);
			panel_1.add(cbxEspecialidadObrero);
			cbxEspecialidadObrero.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", "Cocinero", "Electricista", "Constructor", "Chofer"}));
			
			panel2 = new JPanel();
			panel2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel2.setBounds(10, 344, 466, 95);
			panelpersona.add(panel2);
			panel2.setLayout(null);
			
			panel3 = new JPanel();
			panel3.setBounds(0, 0, 466, 95);
			panel2.add(panel3);
			panel3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel3.setLayout(null);
			
			
			lblareadetrabajo = new JLabel("\u00C1rea t\u00E9cnica:");
			lblareadetrabajo.setBounds(10, 25, 96, 14);
			panel3.add(lblareadetrabajo);
			
			lblexperiencia = new JLabel("Experiencia:");
			lblexperiencia.setBounds(10, 65, 96, 14);
			panel3.add(lblexperiencia);
			
			cbxAreaTrabajo = new JComboBox<String>();
			cbxAreaTrabajo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
			cbxAreaTrabajo.setBounds(97, 22, 149, 20);
			panel3.add(cbxAreaTrabajo);
			
			spnExperiencia = new JSpinner();
			spnExperiencia.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnExperiencia.setToolTipText("");
			spnExperiencia.setBounds(97, 62, 72, 20);
			panel3.add(spnExperiencia);
			
			panel4 = new JPanel();
			panel4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel4.setBounds(0, 0, 466, 95);
			panel2.add(panel4);
			panel4.setLayout(null);
			
			JLabel lblcarrera = new JLabel("Carrera:");
			lblcarrera.setBounds(10, 14, 61, 14);
			panel4.add(lblcarrera);
			
			cbxCarrera = new JComboBox<String>();
			cbxCarrera.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n Social", "Derecho", "Direcci\u00F3n Empresarial", "Dise\u00F1o e Interiorismo", "Econom\u00EDa", "Eduaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial y de Sistemas", "Ingenier\u00EDa en Mecatr\u00F3nica", "Ingenier\u00EDa de Ciencias de la Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Ingenier\u00EDa Ambiental", "Medicina", "Marketing", "Nutici\u00F3n y Diet\u00E9tica", "Psicolog\u00EDa", "Terapia F\u00EDsica", "Trabajo Social", "Hospitalidad y Turismo"}));
			cbxCarrera.setBounds(81, 11, 188, 20);
			panel4.add(cbxCarrera);
			
			JLabel lblNewLabel_9 = new JLabel("Graduaci\u00F3n:");
			lblNewLabel_9.setBounds(10, 54, 72, 14);
			panel4.add(lblNewLabel_9);
			
			spnFechaGraduacion = new JSpinner();
			spnFechaGraduacion.setModel(new SpinnerNumberModel(new Integer(2022), new Integer(1920), null, new Integer(1)));
			spnFechaGraduacion.setBounds(91, 51, 144, 20);
			panel4.add(spnFechaGraduacion);
			
			panel5 = new JPanel();
			panel5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel5.setBounds(0, 0, 466, 95);
			panel2.add(panel5);
			panel5.setLayout(null);
			
			JLabel lblNewLabel_10 = new JLabel("Oficios conocidos:");
			lblNewLabel_10.setBounds(10, 30, 114, 14);
			panel5.add(lblNewLabel_10);
			
			txtOficiosConocidos = new JTextField();
			txtOficiosConocidos.setBounds(119, 27, 174, 20);
			panel5.add(txtOficiosConocidos);
			txtOficiosConocidos.setColumns(10);
			
			btnAgregar = new JButton("Agregar");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(repeticionOficios(txtOficiosConocidos.getText())) {
						oficios.add(txtOficiosConocidos.getText());
						txtOficiosConocidos.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Oficio previamente ingresado.", "Información", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnAgregar.setBounds(316, 26, 89, 23);
			panel5.add(btnAgregar);
		}
		
		oficios = new ArrayList<>();
		panel3.setVisible(true);
		panel5.setVisible(false);
		panel4.setVisible(false);
		cbxAreaTrabajo.setEnabled(true);
		spnExperiencia.setEnabled(true);
		cbxCarrera.setEnabled(false);
		spnFechaGraduacion.setEnabled(false);
		txtOficiosConocidos.setEnabled(false);
		btnAgregar.setEnabled(false);
		
		panelempresa = new JPanel();
		panelempresa.setBounds(5, 43, 486, 450);
		contentPanel.add(panelempresa);
		panelempresa.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelempresa.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		lblNewLabel_11 = new JLabel("C\u00F3digo:");
		lblNewLabel_11.setBounds(10, 26, 54, 14);
		panel_3.add(lblNewLabel_11);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(10, 51, 230, 20);
		txtcodigo.setText("EMP-"+Bolsa.getinstance().getGeneradorCodEmpresa());
		panel_3.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Nombre:");
		lblNewLabel_12.setBounds(10, 86, 54, 14);
		panel_3.add(lblNewLabel_12);
		
		txtNombreEmpresa = new JTextField();
		txtNombreEmpresa.setBounds(10, 111, 230, 20);
		panel_3.add(txtNombreEmpresa);
		txtNombreEmpresa.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Telefono:");
		lblNewLabel_13.setBounds(10, 206, 54, 14);
		panel_3.add(lblNewLabel_13);
		
		txtTelefonoEmpresa = new JTextField();
		txtTelefonoEmpresa.setBounds(10, 231, 230, 20);
		panel_3.add(txtTelefonoEmpresa);
		txtTelefonoEmpresa.setColumns(10);
		
		lblNewLabel_14 = new JLabel("Correo:");
		lblNewLabel_14.setBounds(10, 146, 46, 14);
		panel_3.add(lblNewLabel_14);
		
		txtCorreoempresa = new JTextField();
		txtCorreoempresa.setBounds(10, 171, 230, 20);
		panel_3.add(txtCorreoempresa);
		txtCorreoempresa.setColumns(10);
		
		lblNewLabel_15 = new JLabel("Provincia:");
		lblNewLabel_15.setBounds(10, 266, 65, 14);
		panel_3.add(lblNewLabel_15);
		
		cbxProvinciaEmpresa = new JComboBox<String>();
		cbxProvinciaEmpresa.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "San Crist\u00F3bal", "San Jos\u00E9 de Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "S\u00E1nchez Ram\u00EDrez", "Santiago", "Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
		cbxProvinciaEmpresa.setBounds(10, 291, 230, 20);
		panel_3.add(cbxProvinciaEmpresa);
		
	
		txtcodigo.setEnabled(false);
		txtCorreoempresa.setEnabled(false);
		txtNombreEmpresa.setEnabled(false);
		txtTelefonoEmpresa.setEnabled(false);
		cbxProvinciaEmpresa.setEnabled(false);
		
		lblNewLabel_17 =  new JLabel("Areas Trabajo:");
		lblNewLabel_17.setBounds(10, 326, 87, 14);
		panel_3.add(lblNewLabel_17);
		
		cbxAreaTrabajoEmpresa = new JComboBox<String>();
		cbxAreaTrabajoEmpresa.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Turismo", "Medicina", "Economia", "Tecnologia"}));
		cbxAreaTrabajoEmpresa.setBounds(10, 351, 230, 20);
		panel_3.add(cbxAreaTrabajoEmpresa);
		cbxAreaTrabajoEmpresa.setEnabled(false);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 486, 38);
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel.setToolTipText("");
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("Tipo:");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(lblNewLabel);
			}
			{
				rdbtnPersona = new JRadioButton("Persona");
				rdbtnPersona.setSelected(true);
				rdbtnPersona.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setBounds(100, 100, 512, 567);
						setLocationRelativeTo(null);
						rdbtnPersona.setSelected(true);
						rdbtnEmpresa.setSelected(false);
						panelpersona.setVisible(true);
						panelempresa.setVisible(false);
						panel2.setVisible(true);
						txtCorreoempresa.setEnabled(false);
						txtNombreEmpresa.setEnabled(false);
						txtTelefonoEmpresa.setEnabled(false);
						cbxProvinciaEmpresa.setEnabled(false);
						cbxAreaTrabajoEmpresa.setEnabled(false);
					}
				});
				panel.add(rdbtnPersona);
			}
			{
				rdbtnEmpresa = new JRadioButton("Empresa");
				rdbtnEmpresa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setBounds(100, 100, 512, 567);
						setLocationRelativeTo(null);
						rdbtnEmpresa.setSelected(true);
						rdbtnPersona.setSelected(false);
						panelempresa.setVisible(true);
						panelpersona.setVisible(false);
						panel2.setVisible(false);
						cbxProvinciaEmpresa.setEnabled(true);
						txtCorreoempresa.setEnabled(true);
						txtNombreEmpresa.setEnabled(true);
						txtTelefonoEmpresa.setEnabled(true);
						cbxAreaTrabajoEmpresa.setEnabled(true);
					}
				});
				panel.add(rdbtnEmpresa);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnregistrar = new JButton("Registrar");
				btnregistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Persona auxPersona = null;
						if(!Bolsa.getinstance().nombreOrCedulaRepetidos(txtCedula.getText()) && !Bolsa.getinstance().nombreOrCedulaRepetidos(txtNombreEmpresa.getText())
								&& !Bolsa.getinstance().emailRepetido(txtCorreo.getText()) && !Bolsa.getinstance().emailRepetido(txtCorreoempresa.getText())) {
							if (rdbtnPersona.isSelected()) {
								String sexoaux = "";
								if (rdbtnFemenino.isSelected()) {
									sexoaux = "Femenino";
								}
								else {
									sexoaux = "Masculino";
								}
								
								if (rdbtnTecnico.isSelected()) {
									 auxPersona = new Tecnico(txtNombre.getText(), txtCedula.getText(), txttelefono.getText(), cbxprovincia.getSelectedItem().toString(), sexoaux,
											 cbxEspecialidadTecnico.getSelectedItem().toString(), txtCorreo.getText(), (Date) spnfechanacimiento.getValue(), 
											cbxAreaTrabajo.getSelectedItem().toString(), (int) spnExperiencia.getValue());
								}
								if (rdbtnUniversitario.isSelected()) {
									auxPersona = new Universitario(txtNombre.getText(), txtCedula.getText(), txttelefono.getText(), cbxprovincia.getSelectedItem().toString(), 
											sexoaux, cbxEspecialidadUniversitario.getSelectedItem().toString(), txtCorreo.getText(), 
											(Date) spnfechanacimiento.getValue(), cbxCarrera.getSelectedItem().toString(), (int) spnFechaGraduacion.getValue());
								}
								if (rdbtnObrero.isSelected()) {
									auxPersona = new Obrero(txtNombre.getText(), txtCedula.getText(), txttelefono.getText(), cbxprovincia.getSelectedItem().toString(), sexoaux, 
											cbxEspecialidadObrero.getSelectedItem().toString(), txtCorreo.getText(), (Date) spnfechanacimiento.getValue(), oficios);
								}
								Bolsa.getinstance().registrarPersona(auxPersona);
								JOptionPane.showMessageDialog(null, "Registro de persona satisfactorio.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								Empresa auxEmpresa = new Empresa(txtcodigo.getText(), txtNombreEmpresa.getText(), cbxAreaTrabajoEmpresa.getSelectedItem().toString(), txtTelefonoEmpresa.getText(), 
										txtCorreoempresa.getText(), cbxProvinciaEmpresa.getSelectedItem().toString());
								Bolsa.getinstance().registrarEmpresa(auxEmpresa);
								JOptionPane.showMessageDialog(null, "Registro de empresa satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
							clean();
						}
						else if(rdbtnPersona.isSelected()) {
							if(Bolsa.getinstance().nombreOrCedulaRepetidos(txtCedula.getText()) && !txtCedula.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Cédula ya registrada. Intente de nuevo.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
							if(Bolsa.getinstance().emailRepetido(txtCorreo.getText()) && !txtCorreo.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Correo ya registrado. Intente de nuevo.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else if(rdbtnEmpresa.isSelected()) {
							if(Bolsa.getinstance().nombreOrCedulaRepetidos(txtNombreEmpresa.getText()) && !txtNombreEmpresa.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Nombre de empresa ya registrado. Intente de nuevo.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
							if(Bolsa.getinstance().emailRepetido(txtCorreoempresa.getText()) && !txtCorreoempresa.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Correo ya registrado. Intente de nuevo.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				});
				btnregistrar.setActionCommand("OK");
				buttonPane.add(btnregistrar);
				getRootPane().setDefaultButton(btnregistrar);
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

	private void clean() {
		panelpersona.setVisible(true);
		panelempresa.setVisible(false);
		panel2.setVisible(true);
		panel3.setVisible(true);
		panel5.setVisible(false);
		panel4.setVisible(false);
		
		rdbtnPersona.setSelected(true);
		rdbtnTecnico.setSelected(true);
		rdbtnUniversitario.setSelected(false);
		rdbtnObrero.setSelected(false);
		rdbtnEmpresa.setSelected(false);
		rdbtnMasculino.setSelected(false);
		rdbtnFemenino.setSelected(false);
		
		txtCedula.setText("");
		txtNombre.setText("");
		txtCorreo.setText("");
		txttelefono.setText("");
		cbxprovincia.setSelectedIndex(0);
		cbxEspecialidadObrero.setSelectedIndex(0);
		
		txtcodigo.setEnabled(false);
		txtCorreoempresa.setEnabled(false);
		txtNombreEmpresa.setEnabled(false);
		txtTelefonoEmpresa.setEnabled(false);
		cbxProvinciaEmpresa.setEnabled(false);
		cbxAreaTrabajoEmpresa.setEnabled(false);
	  	
		cbxAreaTrabajo.setEnabled(true);
		spnExperiencia.setEnabled(true);
		cbxCarrera.setEnabled(false);
		spnFechaGraduacion.setEnabled(false);
		txtOficiosConocidos.setEnabled(false);
		txtOficiosConocidos.setText("");
		btnAgregar.setEnabled(false);
		oficios.removeAll(oficios);
	}
	
	private boolean repeticionOficios(String text) {
		boolean aux = true;
		for (String oficio : oficios) {
			if(oficio.equalsIgnoreCase(text)) {
				aux = false;
			}
		}
		
		return aux;
	}
}
