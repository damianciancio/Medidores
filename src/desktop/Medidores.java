package desktop;
import java.awt.EventQueue;

import business.logic.*;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import business.entities.*;

import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;


import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class Medidores {

	private JFrame frmProgramaMedidores;
	

	private JTable table;
	private Usuario usrActual;
	private JTable tblReclamos;
	private JScrollPane jscroll;
	private JDesktopPane dskPane;
	private JInternalFrame actual;
	

	
	
	public static void main(String[] args)
	{
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medidores window = new Medidores();
					window.frmProgramaMedidores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Medidores() {
		initialize();
		configuracionVentana();
	}
	
	public Usuario getUsrActual() {
		return usrActual;
	}

	public void setUsrActual(Usuario usrActual) {
		this.usrActual = usrActual;
	}
	
	public JFrame getFrmProgramaMedidores() {
		return frmProgramaMedidores;
	}

	public void setFrmProgramaMedidores(JFrame frmProgramaMedidores) {
		this.frmProgramaMedidores = frmProgramaMedidores;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProgramaMedidores = new JFrame();
		frmProgramaMedidores.setTitle("Programa Medidores");
		frmProgramaMedidores.setBounds(100, 100, 819, 514);
		frmProgramaMedidores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmProgramaMedidores.setJMenuBar(menuBar);
		
		JMenu mnAbm = new JMenu("ABM");
		menuBar.add(mnAbm);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					abrirLogin();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
		frmProgramaMedidores.getContentPane().setLayout(new BorderLayout(0, 0));
		
		dskPane = new JDesktopPane();
		frmProgramaMedidores.getContentPane().add(dskPane, BorderLayout.CENTER);
		dskPane.setLayout(new BorderLayout(0, 0));		
		
		JMenuItem mntmReclamos = new JMenuItem("Reclamos");
		mntmReclamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reclamo();
					
			}
		});
		mnAbm.add(mntmReclamos);
		
		JMenuItem mntmInspecciones = new JMenuItem("Inspecciones");
		mnAbm.add(mntmInspecciones);
		
		JMenuItem mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarVentana(new JUsuarios());
			}
		});
		mnAbm.add(mntmUsuarios);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarSesion();
			}
		});
		mnUsuario.add(mntmCerrarSesion);
	}
	
	public void configuracionVentana()
	{
		frmProgramaMedidores.setSize(800, 600);
		frmProgramaMedidores.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void abrirLogin()
	{
		Login frame = new Login(this);
		frame.setVisible(true);
				
	}
	
	public void cerrarSesion()
	{
		frmProgramaMedidores.setTitle("Programa medidores");
		usrActual = null;
		abrirLogin();
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
		ReclamoLogic cat = new ReclamoLogic();
		try
		{
			rec = cat.devolverReclamos();
			Object[] arre;
			for (Reclamo reclamo : rec) {
				arre = new Object[6];
				arre[0]=reclamo.getIdReclamo();
				arre[1]= reclamo.getNomTitular();
				arre[2] = reclamo.getCalle();
				arre[3] = reclamo.getAltura();
				arre[4] = reclamo.getPiso();
				arre[5] = reclamo.getDepto();
				modelo.addRow(arre);
				jscroll = new JScrollPane(tblReclamos);
				
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public void agregarVentana(JInternalFrame frame)
	{
		if(actual != null)
		{
			actual.dispose();
		}
		actual = frame;
		actual.setVisible(true);
		dskPane.add(actual);
			
	}
	public void reclamo()
	{
		Jreclamos re = new Jreclamos();
		agregarVentana(re);
		re.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				if (re.getResultado() != null)
				{
					agregarVentana(new JInspeccion(re.getResultado()));
				}
			}
		});;
		
	
	}
}