package desktop;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import business.entities.Usuario;
import business.logic.*;
import util.State;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class JUsuarios extends JInternalFrame {
	private JTextField txtID;
	private JTextField txtUsuario;
	private Usuario newUser;
	private Usuario oldUser;
	private String errorString;
	private JPasswordField txtOldPass;
	private JPasswordField txtNewPass;
	private JPasswordField txtConfirmNewPass;
	private JCheckBox chckbxHabilitado;
	
	public JUsuarios(Usuario usr) {
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblDatosUsuario = new JLabel("Datos Usuario");
		getContentPane().add(lblDatosUsuario, "6, 4");
		
		JLabel lblId = new JLabel("ID");
		getContentPane().add(lblId, "4, 8, right, default");
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		getContentPane().add(txtID, "6, 8, fill, default");
		txtID.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		getContentPane().add(lblUsuario, "4, 10, right, default");
		
		txtUsuario = new JTextField();
		getContentPane().add(txtUsuario, "6, 10, fill, default");
		txtUsuario.setColumns(10);
		
		JLabel lblContraseaAntigua = new JLabel("Contrase\u00F1a antigua");
		getContentPane().add(lblContraseaAntigua, "4, 12, right, default");
		
		txtOldPass = new JPasswordField();
		getContentPane().add(txtOldPass, "6, 12, fill, default");
		
		JLabel lblNuevaContrasea = new JLabel("Nueva Contrase\u00F1a");
		getContentPane().add(lblNuevaContrasea, "4, 14, right, default");
		
		txtNewPass = new JPasswordField();
		getContentPane().add(txtNewPass, "6, 14, fill, default");
		
		JLabel lblConfirmarNuevaContrasea = new JLabel("Confirmar Nueva Contrase\u00F1a");
		getContentPane().add(lblConfirmarNuevaContrasea, "4, 16, right, default");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarCambios();
			}
		});
		
		txtConfirmNewPass = new JPasswordField();
		getContentPane().add(txtConfirmNewPass, "6, 16, fill, top");
		
		chckbxHabilitado = new JCheckBox("Habilitado");
		getContentPane().add(chckbxHabilitado, "6, 18");
		getContentPane().add(btnAceptar, "8, 20");
		
		JButton btnCancelar = new JButton("Cancelar");
		getContentPane().add(btnCancelar, "10, 20");

		inicializar(usr);
	}
	
	public void inicializar(Usuario usr)
	{
		this.oldUser = usr;
		this.newUser = new Usuario();
		mapearDeDatos(oldUser);
		this.chckbxHabilitado.setSelected(true);
		this.chckbxHabilitado.setEnabled(false);
	}
	
	public void guardarCambios()
	{
		if(validar())
		{
			UsuarioLogic ul = new UsuarioLogic();
			newUser = mapearADatos();
			newUser.estado = State.ACTUALIZAR;
			try {
				ul.guardaCambios(newUser);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, errorString);
		}
	}
	
	public boolean validar()
	{
		errorString = "";
		boolean valido = true;
		if(txtUsuario.getText().length()<8)
		{
			errorString = errorString + "El usuario debe tener mas de 8 caracteres.\n";
			valido = false;
		}
		
		String old = new String(txtOldPass.getPassword()); 
		String newP = new String(txtNewPass.getPassword());
		String newConP = new String(txtConfirmNewPass.getPassword());
		
		System.out.println(old + " " + newP + " " + " " + newConP);
		
		if(old.length()<8 || newP.length()<8 || newConP.length()<8)
		{
			errorString = errorString + "La contraseña debe tener mas de 8 caracteres.\n";
			valido = false;
		}
		if(!newP.equals(newConP))
		{
			errorString = errorString + "Las contraseñas no coinciden.\n";
			valido = false;
		}
		if(valido)
		{
			UsuarioLogic ul = new UsuarioLogic();
			try
			{
				Usuario tempUser = ul.buscarUsuario(oldUser);
				if(tempUser== null)
				{
					errorString = errorString + "Usuario inexistente\n";
					valido = false;
				}
				else
					if(tempUser.getPass().equals(new String(txtNewPass.getPassword())))
					{
						errorString = errorString + "Contraseña antigua incorrecta.\n";
						valido = false;
					}
			}
			catch(Exception e)
			{
				errorString = errorString + e.getMessage();
			}
		}
		return valido;
	}
	
	public Usuario mapearADatos()
	{
		Usuario usuarioEnCuestion = new Usuario();
		usuarioEnCuestion.setIdUsuario(Integer.parseInt(txtID.getText()));
		usuarioEnCuestion.setUserNombre(txtUsuario.getText());
		usuarioEnCuestion.setPass(new String(txtNewPass.getPassword()));
		usuarioEnCuestion.setHabilitado(this.chckbxHabilitado.isSelected());
		return usuarioEnCuestion;
	}
	
	public void mapearDeDatos(Usuario usuarioEnCuestion)
	{
		txtID.setText(String.valueOf(usuarioEnCuestion.getIdUsuario()));
		txtUsuario.setText(usuarioEnCuestion.getUserNombre());
		chckbxHabilitado.setSelected(usuarioEnCuestion.isHabilitado());
	}

}
