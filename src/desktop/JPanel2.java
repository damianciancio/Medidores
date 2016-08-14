package desktop;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class JPanel2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanel2() {
		
		JLabel lblNewLabel = new JLabel("New label");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(189)
					.addComponent(lblNewLabel)
					.addContainerGap(191, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(138)
					.addComponent(lblNewLabel)
					.addContainerGap(147, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
