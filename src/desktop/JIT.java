package desktop;

import java.awt.EventQueue;
import util.ModoFrame;
import javax.swing.JInternalFrame;

public class JIT extends JInternalFrame {
	public ModoFrame modo;
	
	public ModoFrame getModo() {
		return modo;
	}
	public void setModo(ModoFrame modo) {
		this.modo = modo;
	}
	
	public JIT() {
		setBounds(100, 100, 450, 300);

	}

}
