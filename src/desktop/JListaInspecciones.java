package desktop;
import java.util.regex.*;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import business.entities.Inspeccion;
import business.entities.Reclamo;
import business.logic.InspeccionLogic;
import business.logic.ReclamoLogic;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JListaInspecciones extends JInternalFrame {
	private JTable tblInspecciones;
	private JTextField txtTxtbuscarporcalle;

	public JListaInspecciones() {
		setBounds(100, 100, 450, 300);
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ver();
			}
		});
		toolBar.add(btnVer);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimir();
			}
		});
		toolBar.add(btnImprimir);
		
		txtTxtbuscarporcalle = new JTextField();
		toolBar.add(txtTxtbuscarporcalle);
		txtTxtbuscarporcalle.setColumns(10);
		
		JButton btnBuscarPorCalle = new JButton("Buscar por calle");
		btnBuscarPorCalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		toolBar.add(btnBuscarPorCalle);
		
		tblInspecciones = new JTable();
		JScrollPane scrlInspecciones = new JScrollPane(tblInspecciones);
		getContentPane().add(scrlInspecciones, BorderLayout.CENTER);
		try
		{
			inicializar();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	public void inicializar() throws Exception
	{
		setTabla(new InspeccionLogic().devolverInspecciones());
	}
	
	private void setTabla(ArrayList<Inspeccion> ins)
	{
		DefaultTableModel modelo = makeModel();
		tblInspecciones.setColumnSelectionAllowed(false);
		tblInspecciones.setCellSelectionEnabled(false);
		tblInspecciones.setRowSelectionAllowed(true);
		InspeccionLogic cat = new InspeccionLogic();
		try
		{
			Object[] arre;
			for (Inspeccion inspec : ins) 
			{
				modelo.addRow(mapToArray(inspec));
			}

			tblInspecciones.setModel(modelo);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private Object[] mapToArray(Inspeccion ins)
	{
		Object [] arre = new Object[9];
		arre[0] = ins.getReclamo().getIdReclamo();
		arre[1] = ins.getReclamo().getNomTitular();
		arre[2] = ins.getCalle();
		arre[3] = ins.getReclamo().getAltura();
		arre[4] = ins.getFechaInspeccion();
		arre[5] = ins.getEstado();
		arre[6] = ins.getResultado().getDescResultado();
		arre[7] = ins.getReclamo().getTipoReclamo().getDescTipoReclamo();
		return arre;
	}
	
	private DefaultTableModel makeModel()
	{
		DefaultTableModel modelo = (new DefaultTableModel(){
			public boolean isCellEditable(int rowIndex,int columnIndex)
			{
				return false;
			}
		});
		modelo.addColumn("ID reclamo");
		modelo.addColumn("Nombre titular");
		modelo.addColumn("Calle");
		modelo.addColumn("Altura");
		modelo.addColumn("Fecha inspeccion");
		modelo.addColumn("Estado");
		modelo.addColumn("Resultado");
		modelo.addColumn("Tipo reclamo");
		return modelo;
	}

	public void ver(Inspeccion ins)
	{
		
	}
	
	public void ver()
	{
		ver(getFromTabla());
	}
	

	public void imprimir(Inspeccion ins)
	{
		
	}
	
	public void imprimir()
	{
		imprimir(getFromTabla());
	}
	
	
	public Inspeccion getFromTabla()
	{
		return new Inspeccion();
	}
	
	public void filtrar()
	{
		try {
			setTabla(new InspeccionLogic().filtrarPorCalle(txtTxtbuscarporcalle.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
}
