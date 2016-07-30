package desktop;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.entities.Usuario;
import business.logic.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private ControladorLogin controladorLogin = new ControladorLogin();
	private JPasswordField txtPassword;
	private Medidores ppal;


	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public Login(Medidores med) {
		
		ppal = med;
		setTitle("Login");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
			}
		});
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					iniciarSesion();
			}
		});
		
		
		
		
		
		
		
		JButton btnOlvideLaContrasea = new JButton("Olvide la contrase\u00F1a");
		
		JLabel lblInicioDeSesin = new JLabel("Inicio de sesi\u00F3n");
		
		txtPassword = new JPasswordField();
		txtPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarSesion();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblContrasea)
							.addGap(18)
							.addComponent(txtPassword))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUsuario)
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInicioDeSesin)
								.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(117, Short.MAX_VALUE)
					.addComponent(btnIngresar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(btnOlvideLaContrasea))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addComponent(lblInicioDeSesin)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIngresar)
						.addComponent(btnCancelar))
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(btnOlvideLaContrasea))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void iniciarSesion()
	{
		
			Usuario usr = new Usuario();
			char[] c = txtPassword.getPassword();
			String str = new String(c);
			usr.setUserNombre(txtUsuario.getText());
			usr.setPass(str);
			try
			{
				if(controladorLogin.validarUsuario(usr)!=null)
				{
					JOptionPane.showMessageDialog(null, "Sesion Iniciada", "Login", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
					ppal.setUsrActual(controladorLogin.validarUsuario(usr));
					ppal.getFrmProgramaMedidores().setTitle("Programa medidores - Usuario actual: " + ppal.getUsrActual().getUserNombre());
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "Datos erróneos", "Login",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e.getMessage(),"Login",  JOptionPane.ERROR_MESSAGE);
			}

	}
	
	public void cerrarVentana()
	{
		this.dispose();
		ppal.getFrmProgramaMedidores().dispose();
	}
}
