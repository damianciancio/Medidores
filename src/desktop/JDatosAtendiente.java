package desktop;
import util.*;

import javax.swing.JPanel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.sun.media.sound.InvalidFormatException;

import business.entities.Calle;
import business.entities.Inspeccion;
import business.entities.Lectura;
import business.entities.Marca;
import business.entities.Reclamo;
import business.entities.Resultado;
import business.entities.TipoDoc;
import business.logic.InspeccionLogic;
import business.logic.MarcaLogic;
import business.logic.ResultadoLogic;
import business.logic.TipoDocLogic;

import javax.swing.JComboBox;
import util.Comunes;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
	private JTextField txtLectura1;
	private JTextField txtLectura2;
	private JTextField txtLectura3;
	private JTextField txtError1;
	private JTextField txtError2;
	private JTextField txtError3;
	private JTextField txtErrorGral;
	private JTextField txtEstadoAntes;
	private JTextField txtEstadoDespues;
	JTextPane txtPaneObser;
	JComboBox<Marca> cmbMarca;
	JComboBox<TipoDoc> cmbTipoDoc;
	JComboBox<String> cmbTipoMedidor;
	JComboBox<String> cmbEstadoGral;
	JComboBox<String> cmbEstadoConexion;
	JComboBox<Resultado> cmbResultado;
	JCheckBox chckbxMarchaVaco;
	JCheckBox chckbxPrdidas;
	Reclamo reclamoActual;
	ModoFrame modo;
	public Action getAccion() {
		return accion;
	}
	public void setAccion(Action accion) {
		this.accion = accion;
	}
	public ModoFrame getModo(){
		return modo;
	}
	public void setModo(ModoFrame m)
	{
		this.modo = m;
	}
	/**
	 * Create the panel.
	 */
	public JDatosAtendiente(Reclamo rec) {
		
		reclamoActual = rec;
		
		JLabel lblAtendiente = new JLabel("Atendiente y datos medidor");
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido:");
		
		txtatendientenomap = new JTextField();
		txtatendientenomap.setText("");
		txtatendientenomap.setColumns(10);
		txtatendientenomap.requestFocus();
		
		txtDni = new JTextField();
		txtDni.setText("");
		txtDni.setColumns(10);
		
		
		cmbTipoDoc = new JComboBox<TipoDoc>();
		
		JLabel lblFechaInspeccion = new JLabel("Fecha Inspeccion:");
		
		txtFechaInspeccion = new JTextField();

		
		txtFechaInspeccion.setText(new Comunes().getFechaHoy());
		txtFechaInspeccion.setColumns(10);
		
		JLabel lblNroMedidor = new JLabel("Nro medidor:");
		
		txtNroMedidor = new JTextField();
		txtNroMedidor.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		
		cmbMarca = new JComboBox<Marca>();
		
		JLabel lblModelo = new JLabel("Modelo:");
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		
		JLabel lblNroSerie = new JLabel("Nro serie:");
		
		txtNroSerie = new JTextField();
		txtNroSerie.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		
		cmbTipoMedidor = new JComboBox<String>();
		
		JLabel lblCorrienteNominal = new JLabel("Corriente nominal:");
		
		txtCteNominal = new JTextField();
		txtCteNominal.setColumns(10);
		
		JLabel lblFactorMultiplicativo = new JLabel("Factor multiplicativo:");
		
		JLabel lblClase = new JLabel("Clase:");
		
		txtClase = new JTextField();
		txtClase.setColumns(10);
		
		txtFactorMult = new JTextField();
		txtFactorMult.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		
		JLabel lblLectura = new JLabel("Lectura 1:");
		
		JLabel lblError1 = new JLabel("Error 1:");
		
		JLabel lblLectura2 = new JLabel("Lectura 2:");
		
		JLabel lblLectura3 = new JLabel("Lectura 3:");
		
		JLabel lblError2 = new JLabel("Error 2:");
		
		JLabel lblError3 = new JLabel("Error3:");
		
		JLabel lblErrorGeneral = new JLabel("Error General");
		
		txtLectura1 = new JTextField();
		txtLectura1.setColumns(10);
		
		txtLectura2 = new JTextField();
		txtLectura2.setColumns(10);
		
		txtLectura3 = new JTextField();
		txtLectura3.setColumns(10);
		
		txtError1 = new JTextField();
		txtError1.setColumns(10);
		
		txtError2 = new JTextField();
		txtError2.setColumns(10);
		
		txtError3 = new JTextField();
		txtError3.setColumns(10);
		
		txtErrorGral = new JTextField();
		txtErrorGral.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ponerPromedio();
			}
		});
		txtErrorGral.setColumns(10);
		
		chckbxMarchaVaco = new JCheckBox("Marcha Vacío");
		
		chckbxPrdidas = new JCheckBox("Pérdidas");
		
		JLabel lblEstadoContadorAntes = new JLabel("Estado Contador Antes");
		
		JLabel lblEstadoContadorDespus = new JLabel("Estado Contador Después");
		
		txtEstadoAntes = new JTextField();
		txtEstadoAntes.setColumns(10);
		
		txtEstadoDespues = new JTextField();
		txtEstadoDespues.setColumns(10);
		
		JLabel lblEstadoGeneral = new JLabel("Estado General");
		
		JLabel lblEstadoConexin = new JLabel("Estado Conexión");
		
		cmbEstadoGral = new JComboBox();
		
		cmbEstadoConexion = new JComboBox();
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		
		txtPaneObser = new JTextPane();
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizar();
			}
		});
		
		cmbResultado = new JComboBox();
		
		JLabel lblResultado = new JLabel("Resultado");
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
								.addComponent(cmbTipoDoc, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
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
								.addComponent(txtCteNominal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtClase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFactorMult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(37)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLectura)
										.addComponent(lblLectura2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLectura3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblErrorGeneral, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtErrorGral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtLectura1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtLectura2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtLectura3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblError2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtError2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblError1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtError1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblError3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtError3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addComponent(chckbxMarchaVaco)
								.addComponent(chckbxPrdidas)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEstadoContadorAntes)
										.addComponent(lblEstadoContadorDespus)
										.addComponent(lblEstadoGeneral)
										.addComponent(lblEstadoConexin))
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(cmbEstadoConexion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
											.addComponent(lblResultado)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(cmbResultado, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
										.addComponent(cmbEstadoGral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEstadoDespues, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEstadoAntes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblObservaciones)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtPaneObser, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFinalizar)))
					.addContainerGap())
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
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 497, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLectura)
						.addComponent(lblError1)
						.addComponent(txtLectura1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtError1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLectura2)
						.addComponent(lblError2)
						.addComponent(txtLectura2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtError2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLectura3)
						.addComponent(txtLectura3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblError3)
						.addComponent(txtError3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblErrorGeneral)
						.addComponent(txtErrorGral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(chckbxMarchaVaco)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxPrdidas)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstadoContadorAntes)
						.addComponent(txtEstadoAntes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstadoContadorDespus)
						.addComponent(txtEstadoDespues, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstadoGeneral)
						.addComponent(cmbEstadoGral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEstadoConexin)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(cmbEstadoConexion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmbResultado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblResultado)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblObservaciones)
						.addComponent(txtPaneObser, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFinalizar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		MarcaLogic ml = new MarcaLogic();
		TipoDocLogic tdl = new TipoDocLogic();
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("MONOFASICO");
		tipos.add("TRIFÁSICO");
		ArrayList<String> estados = new ArrayList<String>();
		estados.add("BUENO");
		estados.add("MALO");
		ResultadoLogic rl = new ResultadoLogic();
		try
		{
			this.rellenarComboBoxMarca(ml.devolverMarcas(), this.cmbMarca);
			this.rellenarComboBoxTipoDoc(tdl.devolverTiposDoc(), this.cmbTipoDoc);
			this.rellenarComboBoxString(tipos,this.cmbTipoMedidor);
			this.rellenarComboBoxString(estados, cmbEstadoConexion);
			this.rellenarComboBoxString(estados, cmbEstadoGral);
			this.rellenarComboBoxResultado(rl.devolverResultados(), cmbResultado);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
		
	private boolean validar()
	{
		boolean valido = true;
		String cadenaError = "";
		if(txtatendientenomap.getText().equals(""))
		{
			valido = false;
			cadenaError = "Ingrese nombre y apellido de atendiente\n";
		}
		if(txtDni.getText().equals(""))
		{
			valido = false;
			cadenaError = cadenaError+ "Ingrese DNI\n";
		}
		else 
		try
		{
			int a = Integer.parseInt(txtDni.getText());
		}
		catch (NumberFormatException e)
		{
			cadenaError = cadenaError + "El dni deben ser solo numeros\n";
			valido = false;
		}
		
		if(txtClase.getText().equals(""))
		{
					valido = false;
					cadenaError = cadenaError+ "Ingrese Clase\n";
		}
		else 
			try
			{
				int a = Integer.parseInt(txtClase.getText());
			
			}
			catch (NumberFormatException e)
			{
				cadenaError = cadenaError + "La clase deben ser solo numeros\n";
				valido = false;
			}
		if(txtFechaInspeccion.getText().equals(""))
		{
			valido = false;
			cadenaError = cadenaError + "Ingrese fecha\n";
		}
		try
		{
			Date.valueOf(txtFechaInspeccion.getText());
		}
		catch(IllegalArgumentException e)
		{
			valido = false;
			cadenaError = cadenaError + "Ingrese fecha con formato 'aaaa-mm-dd\n'";
		
		}
		if(txtNroMedidor.getText().equals(""))
		{
			valido = false;
			cadenaError = cadenaError + "Ingrese nro medidor\n";
		}
		if(txtCteNominal.getText().equals(""))
		{
			valido = false;
			cadenaError = cadenaError + "Ingrese corriente nominal\n";
		}
		if(txtFactorMult.getText().equals(""))
		{
			valido = false;
			cadenaError = cadenaError+ "Ingrese factor multiplicativo\n";
		}
		else 
			try
			{
				float a = Float.parseFloat(txtFactorMult.getText());
			}
			catch (NumberFormatException e)
			{
				valido = false;
				cadenaError = cadenaError + "El factor multiplicativo deben ser solo numeros\n";
			}
		
		if(cmbMarca.getSelectedItem().equals(null))
		{
			valido = false;
			cadenaError = cadenaError + "Seleccione marca\n";
		}
		if(cmbTipoDoc.getSelectedItem().equals(null))
		{
			valido = false;
			cadenaError = cadenaError + "Seleccione Tipo de Documento\n";
		}
		if(cmbTipoMedidor.getSelectedItem().equals(null))
		{
			valido = false;
			cadenaError = cadenaError + "Seleccione tipo de medidor\n";
		}
		if(txtError1.getText().equals("") ||txtError2.getText().equals("")||txtError3.getText().equals("") || txtErrorGral.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this, "El error debe ser numérico");
		}
		else 
			try
			{
				float a = Float.parseFloat(txtError1.getText());
				a = Float.parseFloat(txtError2.getText());
				a = Float.parseFloat(txtError3.getText());
				a = Float.parseFloat(txtErrorGral.getText());
			}
			catch (NumberFormatException e)
			{
				valido = false;
				cadenaError = cadenaError + "El error debe ser solo numeros\n";
			}
		if(txtLectura1.getText().equals("") ||txtLectura2.getText().equals("")||txtLectura3.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Las lecturas deben ser numéricas");
		}
		else 
			try
			{
				float a = Float.parseFloat(txtLectura1.getText());
				a = Float.parseFloat(txtLectura2.getText());
				a = Float.parseFloat(txtLectura3.getText());
			}
			catch (NumberFormatException e)
			{
				valido = false;
				cadenaError = cadenaError + "La lectura debe ser solo numeros\n";
			}
		if(txtEstadoAntes.getText().equals("") ||txtEstadoDespues.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Ingrese estado contador");
		}
		else 
			try
			{
				int a = Integer.parseInt(txtEstadoAntes.getText());
				a = Integer.parseInt(txtEstadoDespues.getText());
			}
			catch (NumberFormatException e)
			{
				valido = false;
				cadenaError = cadenaError + "El estado contador debe ser solo numeros\n";
			}
		if(!valido)
		{
			JOptionPane.showMessageDialog(this, cadenaError);
		}
		return valido;
	}
	
	private void ponerPromedio()
	{
		if(!txtError1.getText().equals("")&&!txtError2.getText().equals("")&&!txtError3.getText().equals(""))
		{
			int e1, e2, e3;
			try
			{
				e1 = Integer.parseInt(txtError1.getText());
				e2 = Integer.parseInt(txtError2.getText());
				e3 = Integer.parseInt(txtError3.getText());
				this.txtErrorGral.setText(String.valueOf((e1 + e2 + e3)/3));
			}
			catch(NumberFormatException e)
			{
				
			}
		}
	}

	private void rellenarComboBoxMarca(ArrayList<Marca> arrayList, JComboBox<Marca> cmb) throws Exception
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
	
	private void rellenarComboBoxString(ArrayList<String> arrayList, JComboBox<String> cmb) throws Exception
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

	private void rellenarComboBoxTipoDoc(ArrayList<TipoDoc> arrayList, JComboBox<TipoDoc> cmb) throws Exception
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

	private void rellenarComboBoxResultado(ArrayList<Resultado> arrayList, JComboBox<Resultado> cmb) throws Exception
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

	private void finalizar()
	{
		if(validar())
		{
			this.modo = ModoFrame.ALTA;
			
			try
			{
			Inspeccion in = new Inspeccion();
			in = mapearADatos();
			this.guardarCambios(in);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}
	
	private Inspeccion mapearADatos()
	{
		Inspeccion in = new Inspeccion();
		in.setAtendiente(txtatendientenomap.getText());
		in.setClase(Integer.parseInt(txtClase.getText()));
		in.setCteNominal(txtCteNominal.getText());
		in.setErrorGral(Float.parseFloat(txtErrorGral.getText()));
		//in.setEstado();
		in.setEstadoConexion((String)cmbEstadoConexion.getSelectedItem());
		in.setEstadoGeneral((String)cmbEstadoGral.getSelectedItem());
		in.setEstadoContadorAntes(Integer.parseInt(txtEstadoAntes.getText()));
		in.setEstadoContadorDespues(Integer.parseInt(txtEstadoDespues.getText()));
		in.setFactorMultipl(Float.parseFloat(txtFactorMult.getText()));
		in.setFechaInspeccion(Date.valueOf(txtFechaInspeccion.getText()));
		Lectura lecturas[] = 
			{new Lectura(Float.valueOf(txtLectura1.getText()),Float.valueOf(txtError1.getText())),
					new Lectura(Float.valueOf(txtLectura2.getText()),Float.valueOf(txtError2.getText())),
					new Lectura(Float.valueOf(txtLectura3.getText()),Float.valueOf(txtError3.getText()))
							};
		in.setLecturas(lecturas);
		in.setMarca((Marca)cmbMarca.getSelectedItem());
		in.setMarchaVacio(chckbxMarchaVaco.isSelected());
		in.setModelo(txtModelo.getText());
		in.setNroDoc(Integer.parseInt(txtDni.getText()));
		in.setNroMedidor(txtNroMedidor.getText());
		in.setNroReclamo(reclamoActual.getIdReclamo());
		in.setNroSerie(txtNroSerie.getText());
		in.setObservaciones(txtPaneObser.getText());
		in.setPerdidas(chckbxPrdidas.isSelected());
		in.setResultado((Resultado)cmbResultado.getSelectedItem());
		in.setTipoDoc((TipoDoc)cmbTipoDoc.getSelectedItem());
		in.setTipoMedidor((String)cmbTipoMedidor.getSelectedItem());
		
		
		return in;
	}

	private void guardarCambios(Inspeccion in) throws Exception
	{
		InspeccionLogic il = new InspeccionLogic();
		if(this.modo == ModoFrame.ALTA)
		{
			in.estado = State.NUEVO;
		}
		il.guardaCambios(in);
	}
}
