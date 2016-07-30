package desktop;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import business.entities.Calle;
import business.entities.Reclamo;
import business.logic.CatalogoReclamos;
import business.logic.ControladorABMReclamos;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ABMCReclamos extends JInternalFrame {
	private JTable table;
	private JTextField txtNroReclamo;
	private JTextField txtNomTitular;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepto;
	private JTextField txtLetraDir;
	private JTextField txtFechaIngreso;
	JComboBox cmbTipoReclamo;
	JCheckBox chkBis;
	JComboBox cmbCalles;
	private ControladorABMReclamos cont;
	private JScrollBar scrlReclamos;
	private JTable tblReclamos;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCReclamos frame = new ABMCReclamos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public ABMCReclamos() {
		setBounds(100, 100, 678, 539);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLUE);
		getContentPane().add(panel, BorderLayout.WEST);
		
		JLabel lblNroReclamo = new JLabel("Nro Reclamo:");
		
		txtNroReclamo = new JTextField();
		txtNroReclamo.setColumns(10);
		
		JLabel lblNombreTitular = new JLabel("Nombre Titular");
		
		txtNomTitular = new JTextField();
		txtNomTitular.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle");
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		
		cmbCalles = new JComboBox();
		
		JLabel lblAltura = new JLabel("Altura");
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso");
		
		txtPiso = new JTextField();
		txtPiso.setColumns(10);
		
		JLabel lblDepto = new JLabel("Depto");
		
		txtDepto = new JTextField();
		txtDepto.setColumns(10);
		
		JLabel lblLetraDir = new JLabel("Letra Dir");
		
		txtLetraDir = new JTextField();
		txtLetraDir.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setText("AAAA-MM-DD");
		txtFechaIngreso.setColumns(10);
		
		chkBis = new JCheckBox("Bis");
		
		cmbTipoReclamo = new JComboBox();
		rellenarComboBox(cont.obtenerCalles(),cmbCalles);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarReclamo();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(cmbTipoReclamo, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblDepto)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDepto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblLetraDir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtLetraDir, 0, 0, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblAltura)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtAltura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(lblPiso)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPiso, 0, 0, Short.MAX_VALUE))
						.addComponent(cmbCalles, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblNroReclamo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNroReclamo, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreTitular)
								.addComponent(lblCalle))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtCalle)
								.addComponent(txtNomTitular, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblFecha)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFechaIngreso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(chkBis)))
					.addGap(17))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(143, Short.MAX_VALUE)
					.addComponent(btnAceptar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNroReclamo)
						.addComponent(txtNroReclamo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreTitular)
						.addComponent(txtNomTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCalle)
						.addComponent(txtCalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbCalles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAltura)
						.addComponent(lblPiso)
						.addComponent(txtPiso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAltura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDepto)
						.addComponent(txtDepto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLetraDir)
						.addComponent(txtLetraDir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFecha)
						.addComponent(txtFechaIngreso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkBis))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbTipoReclamo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		getContentPane().add(table, BorderLayout.EAST);
		
		
		
		
	
		ArrayList<Reclamo> rec;
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre titular");
		modelo.addColumn("Calle");
		modelo.addColumn("Altura");
		modelo.addColumn("Piso");
		modelo.addColumn("Depto");
		tblReclamos.setModel(modelo);
		CatalogoReclamos cat = new CatalogoReclamos();
		rec = cat.getReclamos();
		Object[] arre;
		for (Reclamo reclamo : rec) {
			arre = new Object[6];
			arre[0]=reclamo.getIdReclamo();
			arre[1]= reclamo.getNomTitular();
			arre[2] = reclamo.getCodCalle();
			arre[3] = reclamo.getAltura();
			arre[4] = reclamo.getPiso();
			arre[5] = reclamo.getDepto();
			modelo.addRow(arre);
			}
		JScrollPane jscroll = new JScrollPane(tblReclamos);
		getContentPane().add(jscroll, BorderLayout.CENTER);
	
	}
	
	public void agregarReclamo()
	{
		int alt;
		
		
		try
		{
			Reclamo rec = new Reclamo();
			rec.setNomTitular(txtNomTitular.getText());
			rec.setCodCalle(((Calle)cmbCalles.getSelectedItem()).getIdCalle());
			rec.setAltura(Integer.parseInt(txtAltura.getText()));
			rec.setBis(chkBis.isSelected());
			rec.setPiso(txtPiso.getText());
			rec.setDepto(txtDepto.getText());
			rec.setFechaIngreso(Date.valueOf(txtFechaIngreso.getText()));
			
			cont.agregarReclamo(rec);
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
	
	public void cerrarVentana()
	{
		this.dispose();
	}
	
	public void rellenarComboBox(ArrayList<Calle> arrayList, JComboBox<Calle> cmb)
	{
		for(int i=0; i< arrayList.size();i++)
		{
			cmb.addItem(arrayList.get(i));
		}
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
		tblReclamos.setModel(modelo);
		CatalogoReclamos cat = new CatalogoReclamos();
		rec = cat.getReclamos();
		Object[] arre;
		for (Reclamo reclamo : rec) {
			arre = new Object[6];
			arre[0]=reclamo.getIdReclamo();
			arre[1]= reclamo.getNomTitular();
			arre[2] = reclamo.getCodCalle();
			arre[3] = reclamo.getAltura();
			arre[4] = reclamo.getPiso();
			arre[5] = reclamo.getDepto();
			modelo.addRow(arre);
			JScrollPane jscroll = new JScrollPane(tblReclamos);
			getContentPane().add(jscroll, BorderLayout.CENTER);
		}
	}
}
