package desktop;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import business.entities.Calle;
import business.entities.Reclamo;
import business.logic.CalleLogic;
import business.logic.ReclamoLogic;
import util.ModoFrame;
import util.State;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ListSelectionModel;

public class Jreclamos extends JInternalFrame {
	private JTable table;
	private JTextField txtNomTitular;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtdepto;
	private JTextField txtNroReclamo;
	private JTextField txtFechaIngreso;
	private JTextField txtLetraDir;
	private JComboBox<business.entities.Calle> cmbCalles;
	private JCheckBox chckbxBis;
	public ModoFrame modo;
	
	
	
	public Jreclamos() 
	{
		this.setModo(ModoFrame.ALTA);
		setBounds(100, 100, 677, 518);
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		JLabel lblNuevoReclamo = new JLabel("Nuevo Reclamo");
		
		JLabel lblNombreTitular = new JLabel("Nombre Titular");
		
		txtNomTitular = new JTextField();
		txtNomTitular.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle");
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		
		cmbCalles = new JComboBox<Calle>();
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCoincidenciaCalle();
			}
		});
		
		JLabel lblAltura = new JLabel("Altura");
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso");
		
		txtPiso = new JTextField();
		txtPiso.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		
		txtdepto = new JTextField();
		txtdepto.setColumns(10);
		
		txtNroReclamo = new JTextField();
		txtNroReclamo.setColumns(10);
		

		this.txtNroReclamo.setEnabled(false);
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso");
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setText("aaaa-mm-dd");
		txtFechaIngreso.setColumns(10);
		
		txtLetraDir = new JTextField();
		txtLetraDir.setColumns(10);
		
		JLabel lblLetraDir = new JLabel("Letra Dir");
		
		JLabel lblNro = new JLabel("NRO");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCambios();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		chckbxBis = new JCheckBox("Bis");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCalle)
										.addComponent(lblNombreTitular))
									.addGap(4))
								.addComponent(lblNuevoReclamo)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblAltura)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDepartamento)
										.addComponent(lblPiso)
										.addComponent(lblLetraDir))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtLetraDir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblNro)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(txtNroReclamo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(cmbCalles, 0, 113, Short.MAX_VALUE)
													.addComponent(txtCalle, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnBuscar))
											.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(txtAltura, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
													.addComponent(txtPiso, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
													.addComponent(txtdepto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(chckbxBis)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGap(12))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(txtNomTitular, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblFechaIngreso)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFechaIngreso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAceptar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNuevoReclamo)
						.addComponent(txtNroReclamo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNro))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNomTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombreTitular))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar)
						.addComponent(lblCalle))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cmbCalles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAltura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAltura)
						.addComponent(chckbxBis))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPiso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPiso))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtdepto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDepartamento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLetraDir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLetraDir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFechaIngreso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaIngreso))
					.addPreferredGap(ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setearTablaReclamos();
		scrollPane.setViewportView(table);
		CalleLogic ca = new CalleLogic();
		try {
			rellenarComboBoxCalles(ca.devolvercalles(), cmbCalles);
		} catch (Exception e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void setModo(ModoFrame mo)
	{
		this.modo = mo;
	}
	
	public ModoFrame getModo()
	{
		return this.modo;
	}
	public void setearTablaReclamos()
	{
		ArrayList<Reclamo> rec;
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre titular");
		modelo.addColumn("Calle");
		modelo.addColumn("Altura");
		modelo.addColumn("Piso");
		modelo.addColumn("Depto");
		modelo.addColumn("Fecha");
		modelo.addColumn("Estado");
		table.setModel(modelo);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		ReclamoLogic cat = new ReclamoLogic();
		try
		{
			rec = cat.devolverReclamos();
			Object[] arre;
			for (Reclamo reclamo : rec) 
			{
				arre = new Object[8];
				arre[0] = reclamo.getIdReclamo();
				arre[1] = reclamo.getNomTitular();
				arre[2] = reclamo.getCalle();
				arre[3] = reclamo.getAltura();
				arre[4] = reclamo.getPiso();
				arre[5] = reclamo.getDepto();
				arre[6] = reclamo.getFechaIngreso();
				arre[7] = reclamo.getEstadoAux();
	 			modelo.addRow(arre);
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
						
		
	}
	
	public void buscarCoincidenciaCalle()
	{
		CalleLogic cl = new CalleLogic();
		if(this.txtCalle.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Inserte nombre de calle a buscar");
		}
		else
		{
			ArrayList<Calle> calles = new ArrayList<Calle>();
			try
			{
				calles = cl.buscarCalle(this.txtCalle.getText());
				this.rellenarComboBoxCalles(calles, cmbCalles);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		}
	}
	
	public void guardarCambios()
	{
		try
		{
			ReclamoLogic rl = new ReclamoLogic();
			Reclamo r = new Reclamo();
			switch (this.modo) {
			case ALTA:
				r.estado = State.NUEVO;
				break;
			case BAJA:
				r.estado = State.ELIMINAR;
				break;
			case MODIFICACION:
				r.estado = State.ACTUALIZAR;
				break;
			case CONSULTA:
				break;

			default:
				break;
			}
			try
			{
				r = this.mapearADatos();
				rl.guardaCambios(r);
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			finally
			{
				actualizar();
			}
		}
		catch(NumberFormatException e1)
		{
			JOptionPane.showMessageDialog(null, "Ingrese una altura válida","Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		catch(IllegalArgumentException e2)
		{
			JOptionPane.showMessageDialog(null, "Ingrese una fecha válida","Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public void rellenarComboBoxCalles(ArrayList<Calle> arrayList, JComboBox<Calle> cmb) throws Exception, Exception, Exception
	{
		try
		{

			cmb.invalidate();
			cmb.removeAllItems();
			cmb.validate();
			for(int i=0; i< arrayList.size();i++)
			{
				cmb.addItem(arrayList.get(i));
			}
			cmb.validate();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	private Reclamo mapearADatos()
	{
		Reclamo rec = new Reclamo();
		if (this.modo == ModoFrame.MODIFICACION )
		{
			rec.estado = State.ACTUALIZAR;
			rec.setIdReclamo(Integer.parseInt(txtNroReclamo.getText()));
		}
		else
			if(this.modo == ModoFrame.ALTA)
			{
				rec.estado = State.NUEVO;
			}
			else
				if(this.modo == ModoFrame.BAJA)
				{
					rec.estado = State.ELIMINAR;
					rec.setIdReclamo(Integer.parseInt(txtNroReclamo.getText()));
				}
		rec.setNomTitular(txtNomTitular.getText());
		rec.setCalle(((Calle)cmbCalles.getSelectedItem()));
		rec.setAltura(Integer.parseInt(txtAltura.getText()));
		rec.setBis(chckbxBis.isSelected());
		rec.setPiso(txtPiso.getText());
		rec.setDepto(txtdepto.getText());
		rec.setFechaIngreso(Date.valueOf(txtFechaIngreso.getText()));
		return rec;
	}
	
	private void mapearDesdeTabla() throws Exception
	{
		if(table.getSelectedRow() == -1) throw new Exception("Seleccione una fila de la tabla para editarla"); 
		else
		{
			Reclamo rec = new Reclamo();
			int index = table.getSelectedRow();
			Object[] arre = new Object[table.getModel().getColumnCount()];
			for (int i = 0; i < table.getModel().getColumnCount(); i++)
			{
				arre[i] = table.getModel().getValueAt(index, i);
			}
			
			rec.setIdReclamo((int)arre[0]);
			rec.setNomTitular((String)arre[1]);
			rec.setCalle((Calle)arre[2]);
			rec.setAltura((int)arre[3]);
			rec.setPiso((String)arre[4]);
			rec.setDepto((String)arre[5]);
			rec.setFechaIngreso((Date)arre[6]);	
			
			this.txtNomTitular.setText(rec.getNomTitular());
			this.txtCalle.setText(rec.getCalle().toString());
			this.txtAltura.setText(Integer.toString(rec.getAltura()));
			this.txtPiso.setText(rec.getPiso());
			this.txtdepto.setText(rec.getDepto());
			this.txtFechaIngreso.setText(rec.getFechaIngreso().toString());
		}
	}
	public void editar()
	{
		try
		{
			this.mapearDesdeTabla();
			this.setModo(ModoFrame.MODIFICACION);
			this.guardarCambios();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void actualizar()
	{
		this.table.removeAll();
		this.setearTablaReclamos();
	}
	
}
