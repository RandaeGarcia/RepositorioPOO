package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Bolsa;
import logico.Obrero;
import logico.Tecnico;
import logico.Universitario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListPersonas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btncancelar;
	private JButton btnEliminar;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListPersonas dialog = new ListPersonas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListPersonas() {
		setTitle("Lista de Personas");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					String[] columnas = {"Cédula","Nombre","Sexo","Email","Tipo"};
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					
					table.setBorder(new EmptyBorder(0, 0, 0, 0));
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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
		loadPersonas();
	}

	private void loadPersonas() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (int i = 0; i < Bolsa.getinstance().getListpersonas().size(); i++) {
			rows[0] = Bolsa.getinstance().getListpersonas().get(i).getCedula();
			rows[1] = Bolsa.getinstance().getListpersonas().get(i).getNombre();
			rows[2] = Bolsa.getinstance().getListpersonas().get(i).getSexo();
			rows[3] = Bolsa.getinstance().getListpersonas().get(i).getEmail();
			if(Bolsa.getinstance().getListpersonas().get(i) instanceof Tecnico) {

			}
			if(Bolsa.getinstance().getListpersonas().get(i) instanceof Tecnico) {
				rows[4] = "Técnico";
			}
			if(Bolsa.getinstance().getListpersonas().get(i) instanceof Universitario) {
				rows[4] = "Universitario";
			}
			if(Bolsa.getinstance().getListpersonas().get(i) instanceof Obrero) {
				rows[4] = "Obrero";
			}
			model.addRow(rows);
		}	
		
	}

}
