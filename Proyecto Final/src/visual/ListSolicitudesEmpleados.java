package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Bolsa;
import logico.Persona;
import logico.Solicitud;
import logico.SolicitudEmpleado;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class ListSolicitudesEmpleados extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnEliminar;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private SolicitudEmpleado aux = null;

	public static void main(String[] args) {
		try {
			ListSolicitudesEmpleados dialog = new ListSolicitudesEmpleados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListSolicitudesEmpleados() {
		setTitle("Lista de Solicitudes de Empleados");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					String[] columnas = {"Código","Solicitante","Campo laboral","Puesto","Tiempo"};
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int rowselected = -1;
							rowselected = table.getSelectedRow();
							if(rowselected >= 0 && Bolsa.getLoginUser().getTipo().equalsIgnoreCase("Administrador")) {
								btnEliminar.setEnabled(true);
								aux = (SolicitudEmpleado) Bolsa.getinstance().buscarSolicitudByCode(table.getValueAt(table.getSelectedRow(), 0).toString());
							}
						}
					});
					
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
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option;
						if(aux != null) {
							option = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea eliminar la cuenta seleccionada? ", "Confirmación", JOptionPane.YES_NO_OPTION);
							if(option == JOptionPane.OK_OPTION){
								Bolsa.getinstance().getListsolicitudes().remove(aux);
								btnEliminar.setEnabled(false);
								loadSolicitudes();
							}
						}
					}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadSolicitudes();
	}

	private void loadSolicitudes() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Solicitud auxSoli : Bolsa.getinstance().getListsolicitudes()) {
			if(auxSoli instanceof SolicitudEmpleado) {
				Persona auxPersona = ((SolicitudEmpleado) auxSoli).getInfo();
				rows[0] = auxSoli.getCodigo();
				rows[1] = auxPersona.getNombre();
				rows[2] = auxSoli.getEspecialidad();
				rows[3] = auxSoli.getTiempo();
				rows[4] = auxPersona.getCampolaboral();
				model.addRow(rows);
			}
		}
	}

}
