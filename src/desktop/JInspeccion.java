package desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import business.entities.Reclamo;
import util.Action;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInspeccion extends JInternalFrame {

	
	public JInspeccion(Reclamo re) {
		setBounds(100, 100, 1124, 790);
		
		ArrayList<JPanel> paneles = new ArrayList<JPanel>();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		JPanel panelEstado = new JPanel();
		getContentPane().add(panelEstado, BorderLayout.WEST);
		
		JLabel lblEstadoActual = new JLabel("Estado Actual");
		
		JLabel lblNombreTitular = new JLabel("Nombre Titular");
		
		JLabel lblTipoReclamo = new JLabel("Tipo Reclamo");
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso");
		GroupLayout gl_panelEstado = new GroupLayout(panelEstado);
		gl_panelEstado.setHorizontalGroup(
			gl_panelEstado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEstado.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelEstado.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEstadoActual, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelEstado.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panelEstado.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipoReclamo)
								.addComponent(lblNombreTitular)
								.addComponent(lblDireccion)
								.addComponent(lblFechaIngreso))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelEstado.setVerticalGroup(
			gl_panelEstado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEstado.createSequentialGroup()
					.addGap(5)
					.addComponent(lblEstadoActual, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNombreTitular)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTipoReclamo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDireccion)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblFechaIngreso)
					.addContainerGap(559, Short.MAX_VALUE))
		);
		panelEstado.setLayout(gl_panelEstado);
		
		lblTipoReclamo.setText(re.getTipoReclamo().getDescTipoReclamo());
		lblNombreTitular.setText(re.getNomTitular());
		lblDireccion.setText(re.getCalle().getNomCalle()+ ' ' + re.getAltura());
		lblFechaIngreso.setText(re.getFechaIngreso().toString());
		JDatosAtendiente panel1 = new JDatosAtendiente(re);

		this.getContentPane().add(panel1, BorderLayout.CENTER);

	}
}
