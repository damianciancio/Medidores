package desktop;

import javax.swing.JPanel;

import java.sql.Date;
import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import util.Comunes;
public class JDatosAtendiente extends JPanel {
	private JTextField txtatendientenomap;
	private JTextField txtDni;
	private JTextField txtFechaInspeccion;

	/**
	 * Create the panel.
	 */
	public JDatosAtendiente() {
		
		JLabel lblAtendiente = new JLabel("Atendiente y datos medidor");
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido:");
		
		txtatendientenomap = new JTextField();
		txtatendientenomap.setText("");
		txtatendientenomap.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setText("");
		txtDni.setColumns(10);
		
		JComboBox cmbTipoDoc = new JComboBox();
		
		JLabel lblFechaInspeccion = new JLabel("Fecha Inspeccion:");
		
		txtFechaInspeccion = new JTextField();

		
		txtFechaInspeccion.setText(new Comunes().getFechaHoy());
		txtFechaInspeccion.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFechaInspeccion)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFechaInspeccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAtendiente)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreYApellido)
								.addComponent(cmbTipoDoc, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtatendientenomap, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblAtendiente)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreYApellido)
						.addComponent(txtatendientenomap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbTipoDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaInspeccion)
						.addComponent(txtFechaInspeccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(164, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
