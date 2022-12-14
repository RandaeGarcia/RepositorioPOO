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
import logico.Empresa;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.awt.Toolkit;

public class ListEmpresas extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Empresa aux = null;
	private JButton btnmodificar;
	private int rowselected;

	public static void main(String[] args) {
		try {
			ListEmpresas dialog = new ListEmpresas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListEmpresas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("listicon.png"));
		setTitle("Lista de Empresas");
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
					String[] columnas = {"C?digo","Nombre","Campo laboral","Email"};
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							rowselected = -1;
							rowselected = table.getSelectedRow();
							if(rowselected >= 0 && Bolsa.getLoginUser().getTipo().equalsIgnoreCase("Administrador")) {
								btnmodificar.setEnabled(true);
								btnEliminar.setEnabled(true);
								aux = Bolsa.getinstance().buscarEmpresaByCode(table.getValueAt(table.getSelectedRow(), 0).toString());
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
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option;
						if(aux != null) {
							option = JOptionPane.showConfirmDialog(null,"?Est? seguro que desea eliminar la empresa seleccionada? ", "Confirmaci?n", JOptionPane.YES_NO_OPTION);
							if(option == JOptionPane.OK_OPTION){
								Bolsa.getinstance().getListempresas().remove(aux);
								btnEliminar.setEnabled(false);
								btnmodificar.setEnabled(false);
								loadEmpresas();
							}
						}
					}
				});
				{
					btnmodificar = new JButton("Modificar");
					btnmodificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int option;
							if(aux != null) {
								option = JOptionPane.showConfirmDialog(null,"Se modificaran el telefono e email. ?Desea continuar?", "Confirmaci?n", JOptionPane.YES_NO_OPTION);
								if(option == JOptionPane.OK_OPTION){
									ModificarPersona modificar = new ModificarPersona(null, Bolsa.getinstance().getListempresas().get(rowselected));
									modificar.setModal(true);
									modificar.setVisible(true);
									btnEliminar.setEnabled(false);
									btnmodificar.setEnabled(false);
									loadEmpresas();
								}
							}
						}
					});
					btnmodificar.setEnabled(false);
					buttonPane.add(btnmodificar);
				}
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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
		loadEmpresas();
	}

	private void loadEmpresas() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (int i = 0; i < Bolsa.getinstance().getListempresas().size(); i++) {
			rows[0] = Bolsa.getinstance().getListempresas().get(i).getCodigo();
			rows[1] = Bolsa.getinstance().getListempresas().get(i).getNombreEmpresa();
			rows[2] = Bolsa.getinstance().getListempresas().get(i).getCampolaboral();
			rows[3] = Bolsa.getinstance().getListempresas().get(i).getEmail();
			model.addRow(rows);
		}
		
	}

}
