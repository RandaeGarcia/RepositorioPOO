package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Bolsa;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class CrearUsuario extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserName = new JTextField();
	private JPasswordField pswContra;
	private JButton btnRegistrar = new JButton();
	private JButton btnCancelar;
	private JRadioButton rdbtnSecre = new JRadioButton();
	private JRadioButton rdbtnAdmin = new JRadioButton();
	private String tipo = null;
	private JTextField txtCodigo = new JTextField();
	private JPasswordField pswConfirmacion;
	private char[] auxContra = null;
	private char[] auxConfirmacion = null;

	
	public CrearUsuario(Usuario local) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("registroicono.png"));
	//public CrearUsuario(Usuario usuario) {
		//local = usuario;
		if (local == null)
		{
			setTitle("Crear Usuario");
		}
		else 
		{
			loadUsuario(local);
		}
		setBounds(100, 100, 335, 277);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(10, 11, 295, 22);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Crear como:");
					lblNewLabel.setBounds(10, 4, 79, 14);
					panel_1.add(lblNewLabel);
				}
				{
					rdbtnAdmin = new JRadioButton("Administrador");
					rdbtnAdmin.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							rdbtnSecre.setSelected(false);
							rdbtnAdmin.setSelected(true);
							tipo = rdbtnAdmin.getText().toString();
						}
					});
					rdbtnAdmin.setBounds(80, 0, 110, 23);
					panel_1.add(rdbtnAdmin);
				}
				{
					rdbtnSecre = new JRadioButton("Secretaria");
					rdbtnSecre.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							rdbtnAdmin.setSelected(false);
							rdbtnSecre.setSelected(true);
							tipo = rdbtnSecre.getText().toString();
						}
					});
					rdbtnSecre.setBounds(192, 0, 86, 23);
					panel_1.add(rdbtnSecre);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(10, 44, 295, 140);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel label = new JLabel("Codigo:");
					label.setBounds(10, 14, 46, 14);
					panel_1.add(label);
				}
				{
					txtCodigo = new JTextField();
					txtCodigo.setEnabled(false);
					txtCodigo.setColumns(10);
					txtCodigo.setText("USU-" + String.valueOf(Bolsa.getinstance().getGeneradorCodUsuario()));
					txtCodigo.setBounds(87, 13, 186, 17);
					panel_1.add(txtCodigo);
				}
				{
					txtUserName = new JTextField();
					txtUserName.setColumns(10);
					txtUserName.setBounds(87, 42, 186, 17);
					panel_1.add(txtUserName);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Usuario");
					lblNewLabel_1.setBounds(10, 43, 46, 14);
					panel_1.add(lblNewLabel_1);
				}

				pswContra = new JPasswordField();
				pswContra.setBounds(87, 71, 186, 17);
				panel_1.add(pswContra);
				{
					JLabel lblContase = new JLabel("Contrase\u00F1a:");
					lblContase.setBounds(10, 72, 76, 14);
					panel_1.add(lblContase);
				}
				
				JLabel lblConfirmar = new JLabel("Confirmar:");
				lblConfirmar.setBounds(10, 100, 76, 14);
				panel_1.add(lblConfirmar);
				
				pswConfirmacion = new JPasswordField();
				pswConfirmacion.setBounds(87, 99, 186, 17);
				panel_1.add(pswConfirmacion);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				if (local != null)
				{
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						auxContra = pswContra.getPassword();
						auxConfirmacion = pswConfirmacion.getPassword();
						if (String.valueOf(auxContra).equals(String.valueOf(auxConfirmacion)))
						{
							if (local == null)
							{
								if (tipo != null)
								{
									Usuario auxUsuario = new Usuario(txtUserName.getText(), String.valueOf(auxContra), tipo, txtCodigo.getText());

									if (!Bolsa.getinstance().existeUusario(auxUsuario.getUsername()))
									{
										Bolsa.getinstance().registrarUsuario(auxUsuario);
										JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Informacion", JOptionPane.INFORMATION_MESSAGE);
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Usuario Existente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
									}
									clean();
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Seleccione Puesto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								}
							}else
							{
								local.setPassword(String.valueOf(auxContra));
								JOptionPane.showMessageDialog(null, "Contraseña modificada correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Cotraseña no Valida", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
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

		loadUsuario(local);
	}

	private void loadUsuario(Usuario local)
	{
		if (local != null)
		{
			setTitle("Modificar Usuario");
			btnRegistrar.setText("Modificar");
			txtUserName.setEnabled(false);
			
			txtCodigo.setText(local.getCodigo());
			txtUserName.setText(local.getUsername());
			if (local.getTipo().equalsIgnoreCase("administrador"))
			{
				rdbtnAdmin.setEnabled(true);
				rdbtnAdmin.setSelected(true);
				rdbtnSecre.setEnabled(false);
			}else 
			{
				rdbtnSecre.setSelected(true);
				rdbtnSecre.setEnabled(true);
				rdbtnAdmin.setEnabled(false);
			}
		}
	}

	private void clean() {
		txtCodigo.setText("USU-" + String.valueOf(Bolsa.getinstance().getGeneradorCodUsuario()));
		txtUserName.setText("");
		pswContra.setText("");
		pswConfirmacion.setText("");
		rdbtnSecre.setSelected(false);
		rdbtnAdmin.setSelected(false);

	}
}

