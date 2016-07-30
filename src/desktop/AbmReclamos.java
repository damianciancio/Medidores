package desktop;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import business.entities.Calle;
import business.entities.Entidad;
import business.entities.Reclamo;
import business.logic.ControladorABMReclamos;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class AbmReclamos extends JPanel {
	private JTextField txtNombreTitular;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtTxtdepartamento;
	private JTextField txtFechaIngreso;
	private JTextField txtNumeroReclamo;
	JComboBox<Calle> cmbCalles;
	JCheckBox chkBis;
	ControladorABMReclamos cont;

	/**
	 * Create the panel.
	 */
	public AbmReclamos(JInternalFrame jifPadre) {
		cont = new ControladorABMReclamos();
		JLabel lblAltaReclamos = new JLabel("Alta Reclamos");
		lblAltaReclamos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNombreTitular = new JLabel("Nombre Titular");
		lblNombreTitular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblBis = new JLabel("Bis");
		lblBis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso");
		lblFechaIngreso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cmbCalles = new JComboBox<Calle>();
		
		
		txtNombreTitular = new JTextField();
		txtNombreTitular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreTitular.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAltura.setColumns(10);
		
		chkBis = new JCheckBox("");
		
		txtPiso = new JTextField();
		txtPiso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPiso.setColumns(10);
		
		txtTxtdepartamento = new JTextField();
		txtTxtdepartamento.setColumns(10);
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFechaIngreso.setText("dd/mm/aaaa");
		txtFechaIngreso.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 jifPadre.dispose();
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarReclamo();
			}
		});
		
		
		txtNumeroReclamo = new JTextField();
		txtNumeroReclamo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNumeroReclamo.setColumns(10);
		
		JLabel lblNro = new JLabel("Nro");
		lblNro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAltaReclamos)
							.addGap(18)
							.addComponent(lblNro)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNumeroReclamo, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNombreTitular)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtNombreTitular, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPiso)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtPiso, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAltura)
									.addGap(18)
									.addComponent(txtAltura, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFechaIngreso)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFechaIngreso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCalle)
							.addGap(18)
							.addComponent(cmbCalles, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBis)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chkBis))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDepartamento)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTxtdepartamento, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAceptar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAltaReclamos)
						.addComponent(txtNumeroReclamo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNro))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreTitular)
						.addComponent(txtNombreTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCalle)
								.addComponent(cmbCalles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBis)
								.addComponent(chkBis))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDepartamento)
								.addComponent(txtTxtdepartamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaIngreso)
								.addComponent(txtFechaIngreso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAltura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAltura))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPiso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPiso))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		setLayout(groupLayout);
		
		rellenarComboBoxCalles(cont.obtenerCalles(), cmbCalles);
//		///////Como reutilizar codigo aca?
		
		
	}
	
	public void agregarReclamo()
	{
		int alt;
		
		
		try
		{
			Reclamo rec = new Reclamo();
			rec.setNomTitular(txtNombreTitular.getText());
			rec.setCodCalle(((Calle)cmbCalles.getSelectedItem()).getIdCalle());
			rec.setAltura(Integer.parseInt(txtAltura.getText()));
			rec.setBis(chkBis.isSelected());
			rec.setPiso(txtPiso.getText());
			rec.setDepto(txtTxtdepartamento.getText());
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
	
	public void rellenarComboBoxCalles(ArrayList<Calle> arrayList, JComboBox<Calle> cmb)
	{
		for(int i=0; i< arrayList.size();i++)
		{
			cmb.addItem(arrayList.get(i));
		}
	}
	
	/////Rellenar Combo box
}
