package desktop;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import business.entities.Calle;
import business.entities.Reclamo;
import business.entities.Usuario;
import business.logic.ReclamoLogic;
import business.logic.UsuarioLogic;

public class Util {
	
	
	public void setearTablaReclamos(JTable tblReclamos)
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
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void rellenarComboBox(ArrayList<Calle> arrayList, JComboBox<Calle> cmb)
	{
		for(int i=0; i< arrayList.size();i++)
		{
			cmb.addItem(arrayList.get(i));
		}
	}

	public Usuario validarUsuario(Usuario usr) throws Exception
	{
		try
		{
			UsuarioLogic ul = new UsuarioLogic();
			return ul.buscarUsuario(usr);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
}

