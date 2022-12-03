package visual;

import java.awt.BorderLayout;

import logico.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarPersona extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JPanel panel;
	private JTextField txtemailprevio;
	private JTextField txtemailnuevo;
	private JTextField txttelefonoprevio;
	private JTextField txttelefononuevo;


	public ModificarPersona(Persona persona, Empresa empresa) {
		if(persona != null) {
			setTitle("Modificación a "+persona.getNombre());
		}else {
			setTitle("Modificación a "+empresa.getNombreEmpresa());
		}
		setBounds(100, 100, 499, 213);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("Email previo:");
			lblNewLabel.setBounds(10, 11, 76, 14);
			panel.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Email nuevo:");
			lblNewLabel_1.setBounds(10, 67, 76, 14);
			panel.add(lblNewLabel_1);

			txtemailprevio = new JTextField();
			txtemailprevio.setEnabled(false);
			txtemailprevio.setBounds(10, 36, 188, 20);
			panel.add(txtemailprevio);
			txtemailprevio.setColumns(10);
			if(persona != null) {
				txtemailprevio.setText(persona.getEmail());
			}else {
				txtemailprevio.setText(empresa.getEmail());
			}
			txtemailnuevo = new JTextField();
			txtemailnuevo.setBounds(10, 92, 188, 20);
			panel.add(txtemailnuevo);
			txtemailnuevo.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Telefono previo:");
			lblNewLabel_2.setBounds(242, 11, 92, 14);
			panel.add(lblNewLabel_2);

			txttelefonoprevio = new JTextField();
			txttelefonoprevio.setEnabled(false);
			txttelefonoprevio.setBounds(242, 36, 175, 20);
			panel.add(txttelefonoprevio);
			txttelefonoprevio.setColumns(10);
			if(persona != null) {
				txttelefonoprevio.setText(persona.getTelefono());
			}else {
				txttelefonoprevio.setText(empresa.getTelefono());
			}

			JLabel lblNewLabel_3 = new JLabel("Telefono nuevo:");
			lblNewLabel_3.setBounds(242, 67, 92, 14);
			panel.add(lblNewLabel_3);

			txttelefononuevo = new JTextField();
			txttelefononuevo.setBounds(242, 92, 175, 20);
			panel.add(txttelefononuevo);
			txttelefononuevo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(persona != null) {
							if(!txtemailnuevo.getText().isEmpty() && !txttelefononuevo.getText().isEmpty()) {
								persona.setEmail(txtemailnuevo.getText().toString());
								persona.setTelefono(txttelefononuevo.getText().toString());
								JOptionPane.showMessageDialog(null, "Modificación de email y telefono satisfactoria.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
							if(!txtemailnuevo.getText().isEmpty() && txttelefononuevo.getText().isEmpty()) {
								persona.setEmail(txtemailnuevo.getText().toString());
								JOptionPane.showMessageDialog(null, "Modificación de email satisfactoria.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
							if(txtemailnuevo.getText().isEmpty() && !txttelefononuevo.getText().isEmpty()) {
								persona.setTelefono(txttelefononuevo.getText().toString());
								JOptionPane.showMessageDialog(null, "Modificación de telefono satisfactoria.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
							if(txtemailnuevo.getText().isEmpty() && txttelefononuevo.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Modificación fallida.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							if(!txtemailnuevo.getText().isEmpty() && !txttelefononuevo.getText().isEmpty()) {
								empresa.setEmail(txtemailnuevo.getText().toString());
								empresa.setTelefono(txttelefononuevo.getText().toString());
								JOptionPane.showMessageDialog(null, "Modificación de email y telefono satisfactoria.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
							if(!txtemailnuevo.getText().isEmpty() && txttelefononuevo.getText().isEmpty()) {
								empresa.setEmail(txtemailnuevo.getText().toString());
								JOptionPane.showMessageDialog(null, "Modificación de email satisfactoria.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
							if(txtemailnuevo.getText().isEmpty() && !txttelefononuevo.getText().isEmpty()) {
								empresa.setTelefono(txttelefononuevo.getText().toString());
								JOptionPane.showMessageDialog(null, "Modificación de telefono satisfactoria.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
							if(txtemailnuevo.getText().isEmpty() && txttelefononuevo.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Modificación fallida.", "Información", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						dispose();
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
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
}
