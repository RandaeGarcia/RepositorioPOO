package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Oferta;
import logico.SolicitudEmpleado;

public class ListaMatch extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;

	public ListaMatch(Oferta local) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("listicon.png"));
		setTitle("Lista de Matcheo");
		setBounds(100, 100, 600, 350);
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
					String[] columnas = {"Código","Nombre","Especialidad","Tiempo","Estado"};
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
		loadOfertas(local);
	}

	public static void loadOfertas(Oferta auxOferta) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (SolicitudEmpleado auxSoli : auxOferta.getPostulados())			
		{
				rows[0] = auxSoli.getCodigo();
				rows[1] = auxSoli.getInfo().getNombre();
				rows[2] = auxSoli.getEspecialidad();
				rows[3] = auxSoli.getTiempo();
				if(auxSoli.isEstado()) {
					rows[4] = "Pendiente";
				}else {
					rows[4] = "Cumplida";
				}
				model.addRow(rows);
		}
	}

}