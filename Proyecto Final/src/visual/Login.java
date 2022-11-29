package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import logico.Bolsa;
import logico.Usuario;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField pswContra;
	private JButton btnlogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream bolsaTrabajoIn;
				FileOutputStream bolsaTrabajoOut;
				ObjectInputStream bolsaTrabajoRead;
				ObjectOutputStream bolsaTrabajoWrite;
				try {
					bolsaTrabajoIn = new FileInputStream("bolsaTrabajo.dat");
					bolsaTrabajoRead = new ObjectInputStream(bolsaTrabajoIn);
					Bolsa aux = (Bolsa) bolsaTrabajoRead.readObject();
					Bolsa.setBolsa(aux);
					bolsaTrabajoIn.close();
					bolsaTrabajoRead.close();
				} catch (FileNotFoundException e) {
					try {
						bolsaTrabajoOut = new FileOutputStream("bolsaTrabajo.dat");
						bolsaTrabajoWrite = new ObjectOutputStream(bolsaTrabajoOut);
						Usuario auxUsu = new Usuario("admin", "Admin", "Administrador", "USU-1");
						Bolsa.getinstance().registrarUsuario(auxUsu);
						bolsaTrabajoWrite.writeObject(Bolsa.getinstance());
						bolsaTrabajoOut.close();
						bolsaTrabajoWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
					}					
				} catch (IOException e) {
				} catch (ClassNotFoundException e) {
					e.printStackTrace();				}

				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Inicio de Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre de usuario:");
		lblNewLabel.setBounds(41, 46, 120, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(287, 46, 81, 14);
		panel.add(lblNewLabel_1);

		txtUserName = new JTextField();
		txtUserName.setBounds(26, 71, 151, 20);
		panel.add(txtUserName);
		txtUserName.setColumns(10);

		pswContra = new JTextField();
		pswContra.setBounds(252, 71, 151, 20);
		panel.add(pswContra);
		pswContra.setColumns(10);

		btnlogin = new JButton("Iniciar sesi\u00F3n");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Bolsa.getinstance().verificarLogin(txtUserName.getText(), pswContra.getText()))
				{
					Principal principal = new Principal();
					principal.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña Incorrecta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnlogin.setBounds(155, 136, 120, 23);
		panel.add(btnlogin);
	}
}
