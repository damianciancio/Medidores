package desktop;
import util.*;

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
	private Action accion;
	private JTextField txtNroMedidor;
	private JTextField txtModelo;
	private JTextField txtNroSerie;
	private JTextField txtCteNominal;
	private JTextField txtClase;
	private JTextField txtFactorMult;
	public Action getAccion() {
		return accion;
	}
	public void setAccion(Action accion) {
		this.accion = accion;
	}
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
		
		JLabel lblNroMedidor = new JLabel("Nro medidor:");
		
		txtNroMedidor = new JTextField();
		txtNroMedidor.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		
		JComboBox cmbMarca = new JComboBox();
		
		JLabel lblModelo = new JLabel("Modelo:");
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		
		JLabel lblNroSerie = new JLabel("Nro serie:");
		
		txtNroSerie = new JTextField();
		txtNroSerie.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		
		JComboBox cmbTipoMedidor = new JComboBox();
		
		JLabel lblCorrienteNominal = new JLabel("Corriente nominal:");
		
		txtCteNominal = new JTextField();
		txtCteNominal.setColumns(10);
		
		JLabel lblFactorMultiplicativo = new JLabel("Factor multiplicativo:");
		
		JLabel lblClase = new JLabel("Clase:");
		
		txtClase = new JTextField();
		txtClase.setColumns(10);
		
		txtFactorMult = new JTextField();
		txtFactorMult.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAtendiente)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreYApellido)
								.addComponent(cmbTipoDoc, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtatendientenomap, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblClase)
								.addComponent(lblFactorMultiplicativo)
								.addComponent(lblCorrienteNominal)
								.addComponent(lblTipo)
								.addComponent(lblNroMedidor)
								.addComponent(lblFechaInspeccion)
								.addComponent(lblMarca)
								.addComponent(lblModelo)
								.addComponent(lblNroSerie))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbTipoMedidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNroSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNroMedidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFechaInspeccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtCteNominal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtClase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtFactorMult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(85)))))
					.addGap(65))
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
						.addComponent(txtFechaInspeccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaInspeccion))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNroMedidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNroMedidor))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMarca))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModelo))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNroSerie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNroSerie))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbTipoMedidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorrienteNominal)
						.addComponent(txtCteNominal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFactorMultiplicativo)
						.addComponent(txtFactorMult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClase)
						.addComponent(txtClase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
