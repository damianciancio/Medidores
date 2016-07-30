package desktop;


import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


import business.entities.Usuario;
import business.logic.UsuarioLogic;
import util.State;

import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class JUsuarios extends JInternalFrame {
	private JTextField txtID;
	private JTextField txtNombreUsuario;
	private JTable table;
	private JPasswordField txtContraseña;
	private JPasswordField txtConfirmar;

	/**
	 * Launch the application.
	**/ 


/**
	 * Create the frame.
	 */
	public JUsuarios() {
		setBounds(100, 100, 707, 528);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.EAST);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		
		txtConfirmar = new JPasswordField();
		
		JLabel lblConfirmeContrasea = new JLabel("Confirme Contrase\u00F1a");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarUsuario();
			}
		});
		
		JButton btnLimpiarCampos = new JButton("Limpiar Campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsuarios, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblContraseña)
									.addComponent(lblNombreUsuario)
									.addComponent(lblConfirmeContrasea)
									.addComponent(btnGuardar)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtNombreUsuario, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
									.addComponent(txtContraseña)
									.addComponent(txtConfirmar))
								.addComponent(btnLimpiarCampos))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblUsuarios)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreUsuario)
						.addComponent(txtNombreUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContraseña))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtConfirmar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmeContrasea))
					.addPreferredGap(ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLimpiarCampos)
						.addComponent(btnGuardar))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnEditar = new JButton("Editar");
		toolBar.add(btnEditar);
		
		JButton btnBorrar = new JButton("Borrar");
		toolBar.add(btnBorrar);

	}
	
	public void agregarUsuario()
	{
		Usuario usr = new Usuario(State.NUEVO);
		if(validar())
		{
			mapearADatos(usr);
			guardar(usr);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void mapearADatos(Usuario usr)
	{
		usr.setUserNombre(txtNombreUsuario.getText());
		usr.setPass(txtContraseña.getPassword().toString());
		
	}
	public boolean validar()
	{
		boolean valido = true;
		if(txtNombreUsuario.getText().equals("")||txtContraseña.getPassword().toString().length()<8/*||!txtContraseña.getPassword().toString().equals(txtConfirmar.getPassword().toString())*/)
		{
			valido = false;
		}
		return valido;
	}
	
	public void guardar(Usuario usr)
	{
		UsuarioLogic ul = new UsuarioLogic();
		try
		{
			ul.guardaCambios(usr);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void limpiarCampos()
	{
		txtConfirmar.setText("");
		txtContraseña.setText("");
		txtID.setText("");
		txtNombreUsuario.setText("");
	}
}
