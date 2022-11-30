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

import java.awt.CardLayout;
import javax.swing.BoxLayout;
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
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

public class Registros extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btncancelar;
	private JTextField txtcedula;
	private JTextField txtnombre;
	private JRadioButton rdbtntecnico;
	private JRadioButton rdbtnuniversitario;
	private JRadioButton rdbtnobrero;
	private JTextField txtcorreo;
	private JTextField txttelefono;
	private JLabel lblareadetrabajo;
	private JSpinner spnexperiencia;
	private JComboBox cbxareadetrabajo;
	private JLabel lblexperiencia;
	private JTextField txtoficiosconocidos;
	private JButton btnagregar;
	private JButton btnregistrar;
	private JPanel panel3;
	private JPanel panel5;
	private JPanel panel4;
	private JRadioButton rdbtnpersona;
	private JRadioButton rdbtnempresa;
	private JRadioButton rdbtnmasculino;
	private JRadioButton rdbtnfemenino;
	private JPanel panelempresa;
	private JPanel panel_3;
	private JLabel lblNewLabel_11;
	private JTextField txtcodigo;
	private JLabel lblNewLabel_12;
	private JTextField txtnombreempresa;
	private JLabel lblNewLabel_13;
	private JTextField txttelefonoempresa;
	private JLabel lblNewLabel_14;
	private JTextField txtcorreoempresa;
	private JLabel lblNewLabel_15;
	private JComboBox cbxprovinciaempresa;
	private JPanel panelpersona;
	private JPanel panel2;
	private JComboBox cbxcarrera;
	private JSpinner spnfechagraduacion;
	private JSpinner spnfechanacimiento;
	private Persona aux = null;
	private ArrayList<String> oficios;
	private JComboBox cbxprovincia;
	private JComboBox cbxcampolaboral;
	private JLabel lblNewLabel_17;
	private JComboBox cbxcampolaboralempresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registros dialog = new Registros();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registros() {
		setTitle("Registro");
		setBounds(100, 100, 512, 121);
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
			lblNewLabel_8.setBounds(10, 279, 92, 14);
			panel_1.add(lblNewLabel_8);
			
			
			
			rdbtntecnico = new JRadioButton("T\u00E9cnico:");
			rdbtntecnico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbtntecnico.setSelected(true);
					rdbtnuniversitario.setSelected(false);
					rdbtnobrero.setSelected(false);
					
					panel3.setVisible(true);
					panel5.setVisible(false);
					panel4.setVisible(false);
					
					cbxareadetrabajo.setEnabled(true);
					spnexperiencia.setEnabled(true);
					cbxcarrera.setEnabled(false);
					spnfechagraduacion.setEnabled(false);
					txtoficiosconocidos.setEnabled(false);
					btnagregar.setEnabled(false);
				}
			});
			rdbtntecnico.setBounds(114, 275, 92, 23);
			panel_1.add(rdbtntecnico);
			
			rdbtnuniversitario = new JRadioButton("Universitario");
			rdbtnuniversitario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbtnuniversitario.setSelected(true);
					rdbtnobrero.setSelected(false);
					rdbtntecnico.setSelected(false);
					
					panel4.setVisible(true);
					panel3.setVisible(false);
					panel5.setVisible(false);
					
					cbxareadetrabajo.setEnabled(false);
					spnexperiencia.setEnabled(false);
					cbxcarrera.setEnabled(true);
					spnfechagraduacion.setEnabled(true);
					txtoficiosconocidos.setEnabled(false);
					btnagregar.setEnabled(false);
				}
			});
			rdbtnuniversitario.setBounds(218, 275, 109, 23);
			panel_1.add(rdbtnuniversitario);
			
			rdbtnobrero = new JRadioButton("Obrero");
			rdbtnobrero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbtnobrero.setSelected(true);
					rdbtntecnico.setSelected(false);
					rdbtnuniversitario.setSelected(false);
					
					panel3.setVisible(false);
					panel4.setVisible(false);
					panel5.setVisible(true);
					
					cbxareadetrabajo.setEnabled(false);
					spnexperiencia.setEnabled(false);
					cbxcarrera.setEnabled(false);
					spnfechagraduacion.setEnabled(false);
					txtoficiosconocidos.setEnabled(true);
					btnagregar.setEnabled(true);
				}
			});
			rdbtnobrero.setBounds(339, 275, 109, 23);
			panel_1.add(rdbtnobrero);
			
			txtcedula = new JTextField();
			txtcedula.setBounds(10, 36, 185, 20);
			panel_1.add(txtcedula);
			txtcedula.setColumns(10);
			
			spnfechanacimiento = new JSpinner();
			spnfechanacimiento.setModel(new SpinnerDateModel(new Date(1669262400000L), null, null, Calendar.MONTH));
			spnfechanacimiento.setBounds(10, 160, 140, 20);
			panel_1.add(spnfechanacimiento);
			
			txtnombre = new JTextField();
			txtnombre.setBounds(218, 36, 230, 20);
			panel_1.add(txtnombre);
			txtnombre.setColumns(10);
			
			rdbtnmasculino = new JRadioButton("M");
			rdbtnmasculino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnfemenino.setSelected(false);
					rdbtnmasculino.setSelected(true);
				}
			});
			rdbtnmasculino.setBounds(10, 225, 38, 23);
			panel_1.add(rdbtnmasculino);
			
			rdbtnfemenino = new JRadioButton("F");
			rdbtnfemenino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnfemenino.setSelected(true);
					rdbtnmasculino.setSelected(false);
				}
			});
			rdbtnfemenino.setBounds(64, 225, 54, 23);
			panel_1.add(rdbtnfemenino);
			
			txtcorreo = new JTextField();
			txtcorreo.setBounds(10, 104, 185, 20);
			panel_1.add(txtcorreo);
			txtcorreo.setColumns(10);
			
			cbxprovincia = new JComboBox();
			cbxprovincia.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "San Crist\u00F3bal", "San Jos\u00E9 de Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "S\u00E1nchez Ram\u00EDrez", "Santiago", "Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
			cbxprovincia.setBounds(218, 160, 230, 20);
			panel_1.add(cbxprovincia);
			
			txttelefono = new JTextField();
			txttelefono.setBounds(218, 104, 230, 20);
			panel_1.add(txttelefono);
			txttelefono.setColumns(10);
			
			JLabel lblNewLabel_16 = new JLabel("Especialidad:");
			lblNewLabel_16.setBounds(218, 197, 92, 14);
			panel_1.add(lblNewLabel_16);
			
			cbxcampolaboral = new JComboBox();
			cbxcampolaboral.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Turismo", "Medicina", "Economia", "Tecnologia"}));
			cbxcampolaboral.setBounds(218, 226, 230, 20);
			panel_1.add(cbxcampolaboral);
			
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
			
			cbxareadetrabajo = new JComboBox();
			cbxareadetrabajo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
			cbxareadetrabajo.setBounds(97, 22, 149, 20);
			panel3.add(cbxareadetrabajo);
			
			spnexperiencia = new JSpinner();
			spnexperiencia.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnexperiencia.setToolTipText("");
			spnexperiencia.setBounds(97, 62, 72, 20);
			panel3.add(spnexperiencia);
			
			panel4 = new JPanel();
			panel4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel4.setBounds(0, 0, 466, 95);
			panel2.add(panel4);
			panel4.setLayout(null);
			
			JLabel lblcarrera = new JLabel("Carrera:");
			lblcarrera.setBounds(10, 14, 61, 14);
			panel4.add(lblcarrera);
			
			cbxcarrera = new JComboBox();
			cbxcarrera.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n Social", "Derecho", "Direcci\u00F3n Empresarial", "Dise\u00F1o e Interiorismo", "Econom\u00EDa", "Eduaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial y de Sistemas", "Ingenier\u00EDa en Mecatr\u00F3nica", "Ingenier\u00EDa de Ciencias de la Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Ingenier\u00EDa Ambiental", "Medicina", "Marketing", "Nutici\u00F3n y Diet\u00E9tica", "Psicolog\u00EDa", "Terapia F\u00EDsica", "Trabajo Social", "Hospitalidad y Turismo"}));
			cbxcarrera.setBounds(81, 11, 188, 20);
			panel4.add(cbxcarrera);
			
			JLabel lblNewLabel_9 = new JLabel("Graduaci\u00F3n:");
			lblNewLabel_9.setBounds(10, 54, 72, 14);
			panel4.add(lblNewLabel_9);
			
			spnfechagraduacion = new JSpinner();
			spnfechagraduacion.setModel(new SpinnerNumberModel(2020, 1920, 2022, 1));
			spnfechagraduacion.setBounds(91, 51, 144, 20);
			panel4.add(spnfechagraduacion);
			
			panel5 = new JPanel();
			panel5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel5.setBounds(0, 0, 466, 95);
			panel2.add(panel5);
			panel5.setLayout(null);
			
			JLabel lblNewLabel_10 = new JLabel("Oficios conocidos:");
			lblNewLabel_10.setBounds(10, 30, 114, 14);
			panel5.add(lblNewLabel_10);
			
			txtoficiosconocidos = new JTextField();
			txtoficiosconocidos.setBounds(119, 27, 174, 20);
			panel5.add(txtoficiosconocidos);
			txtoficiosconocidos.setColumns(10);
			
			btnagregar = new JButton("Agregar");
			btnagregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					oficios.add(txtoficiosconocidos.getText());
					txtoficiosconocidos.setText("");
					
				}
			});
			btnagregar.setBounds(316, 26, 89, 23);
			panel5.add(btnagregar);
		}
		
		oficios = new ArrayList<>();
		panel3.setVisible(true);
		panel5.setVisible(false);
		panel4.setVisible(false);
		cbxareadetrabajo.setEnabled(true);
		spnexperiencia.setEnabled(true);
		cbxcarrera.setEnabled(false);
		spnfechagraduacion.setEnabled(false);
		txtoficiosconocidos.setEnabled(false);
		btnagregar.setEnabled(false);
		
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
		txtcodigo.setText("EMP-"+Bolsa.generadorCodEmpresa);
		panel_3.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Nombre:");
		lblNewLabel_12.setBounds(10, 86, 54, 14);
		panel_3.add(lblNewLabel_12);
		
		txtnombreempresa = new JTextField();
		txtnombreempresa.setBounds(10, 111, 230, 20);
		panel_3.add(txtnombreempresa);
		txtnombreempresa.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Telefono:");
		lblNewLabel_13.setBounds(10, 206, 54, 14);
		panel_3.add(lblNewLabel_13);
		
		txttelefonoempresa = new JTextField();
		txttelefonoempresa.setBounds(10, 231, 230, 20);
		panel_3.add(txttelefonoempresa);
		txttelefonoempresa.setColumns(10);
		
		lblNewLabel_14 = new JLabel("Correo:");
		lblNewLabel_14.setBounds(10, 146, 46, 14);
		panel_3.add(lblNewLabel_14);
		
		txtcorreoempresa = new JTextField();
		txtcorreoempresa.setBounds(10, 171, 230, 20);
		panel_3.add(txtcorreoempresa);
		txtcorreoempresa.setColumns(10);
		
		lblNewLabel_15 = new JLabel("Provincia:");
		lblNewLabel_15.setBounds(10, 266, 65, 14);
		panel_3.add(lblNewLabel_15);
		
		cbxprovinciaempresa = new JComboBox();
		cbxprovinciaempresa.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "San Crist\u00F3bal", "San Jos\u00E9 de Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "S\u00E1nchez Ram\u00EDrez", "Santiago", "Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
		cbxprovinciaempresa.setBounds(10, 291, 230, 20);
		panel_3.add(cbxprovinciaempresa);
		
	
		txtcodigo.setEnabled(false);
		txtcorreoempresa.setEnabled(false);
		txtnombreempresa.setEnabled(false);
		txttelefonoempresa.setEnabled(false);
		cbxprovinciaempresa.setEnabled(false);
		
		lblNewLabel_17 = new JLabel("Nivel Estudios:");
		lblNewLabel_17.setBounds(10, 326, 87, 14);
		panel_3.add(lblNewLabel_17);
		
		cbxcampolaboralempresa = new JComboBox();
		cbxcampolaboralempresa.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Turismo", "Medicina", "Economia", "Tecnologia"}));
		cbxcampolaboralempresa.setBounds(10, 351, 230, 20);
		panel_3.add(cbxcampolaboralempresa);
		cbxcampolaboralempresa.setEnabled(false);
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
				rdbtnpersona = new JRadioButton("Persona");
				rdbtnpersona.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setBounds(100, 100, 512, 567);
						setLocationRelativeTo(null);
						rdbtnpersona.setSelected(true);
						rdbtnempresa.setSelected(false);
						panelpersona.setVisible(true);
						panelempresa.setVisible(false);
						panel2.setVisible(true);
						txtcorreoempresa.setEnabled(false);
						txtnombreempresa.setEnabled(false);
						txttelefonoempresa.setEnabled(false);
						cbxprovinciaempresa.setEnabled(false);
						cbxcampolaboralempresa.setEnabled(false);
					}
				});
				panel.add(rdbtnpersona);
			}
			{
				rdbtnempresa = new JRadioButton("Empresa");
				rdbtnempresa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setBounds(100, 100, 512, 567);
						setLocationRelativeTo(null);
						rdbtnempresa.setSelected(true);
						rdbtnpersona.setSelected(false);
						panelempresa.setVisible(true);
						panelpersona.setVisible(false);
						panel2.setVisible(false);
						cbxprovinciaempresa.setEnabled(true);
						txtcorreoempresa.setEnabled(true);
						txtnombreempresa.setEnabled(true);
						txttelefonoempresa.setEnabled(true);
						cbxcampolaboralempresa.setEnabled(true);
					}
				});
				panel.add(rdbtnempresa);
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
						if (rdbtnpersona.isSelected()) {
							String sexoaux = "";
							if (rdbtnfemenino.isSelected()) {
								sexoaux = "Femenino";
							}
							else {
								sexoaux = "Masculino";
							}
							
							if (rdbtntecnico.isSelected()) {
								 auxPersona = new Tecnico(txtnombre.getText(), txtcedula.getText(), txttelefono.getText(), cbxprovincia.getSelectedItem().toString(), sexoaux,
										cbxcampolaboral.getSelectedItem().toString(), txtcorreo.getText(), (Date) spnfechanacimiento.getValue(), 
										cbxareadetrabajo.getSelectedItem().toString(), (int) spnexperiencia.getValue());
							}
							if (rdbtnuniversitario.isSelected()) {
								auxPersona = new Universitario(txtnombre.getText(), txtcedula.getText(), txttelefono.getText(), cbxprovincia.getSelectedItem().toString(), 
										sexoaux, cbxcampolaboral.getSelectedItem().toString(), txtcorreo.getText(), 
										(Date) spnfechanacimiento.getValue(), cbxcarrera.getSelectedItem().toString(), (int) spnfechagraduacion.getValue());
							}
							if (rdbtnobrero.isSelected()) {
								auxPersona = new Obrero(txtnombre.getText(), txtcedula.getText(), txttelefono.getText(), cbxprovincia.getSelectedItem().toString(), sexoaux, 
										cbxcampolaboral.getSelectedItem().toString(),
										txtcorreo.getText(), (Date) spnfechanacimiento.getValue(), oficios);
							}
							Bolsa.getinstance().registrarPersona(auxPersona);
							JOptionPane.showMessageDialog(null, "Registro de persona satisfactorio.", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							Empresa auxEmpresa = new Empresa(txtcodigo.getText(), txtnombreempresa.getText(), cbxcampolaboralempresa.getSelectedItem().toString(), txttelefonoempresa.getText(), 
									txtcorreoempresa.getText(), cbxprovinciaempresa.getSelectedItem().toString());
							Bolsa.getinstance().registrarEmpresa(auxEmpresa);
							JOptionPane.showMessageDialog(null, "Registro de empresa satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
						}
						clean();
					}
				});
				btnregistrar.setActionCommand("OK");
				buttonPane.add(btnregistrar);
				getRootPane().setDefaultButton(btnregistrar);
			}
			{
				btncancelar = new JButton("Cancelar");
				btncancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btncancelar.setActionCommand("Cancel");
				buttonPane.add(btncancelar);
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
		
		rdbtnpersona.setSelected(true);
		rdbtntecnico.setSelected(true);
		rdbtnuniversitario.setSelected(false);
		rdbtnobrero.setSelected(false);
		rdbtnempresa.setSelected(false);
		rdbtnmasculino.setSelected(false);
		rdbtnfemenino.setSelected(false);
		
		txtcedula.setText("");
		txtnombre.setText("");
		txtcorreo.setText("");
		txttelefono.setText("");
		cbxprovincia.setSelectedIndex(0);
		cbxcampolaboral.setSelectedIndex(0);
		
		txtcodigo.setEnabled(false);
		txtcorreoempresa.setEnabled(false);
		txtnombreempresa.setEnabled(false);
		txttelefonoempresa.setEnabled(false);
		cbxprovinciaempresa.setEnabled(false);
		cbxcampolaboralempresa.setEnabled(false);
	  	
		cbxareadetrabajo.setEnabled(true);
		spnexperiencia.setEnabled(true);
		cbxcarrera.setEnabled(false);
		spnfechagraduacion.setEnabled(false);
		txtoficiosconocidos.setEnabled(false);
		txtoficiosconocidos.setText("");
		btnagregar.setEnabled(false);
		oficios.removeAll(oficios);
	}
}
