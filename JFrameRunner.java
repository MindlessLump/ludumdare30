/**
 * Author: Erik Martin
 * Date: 24 August 2014
 * Description: Runs the JFrame in which the game is run.
 */
package mindlesslump.ludumdare30;

import javax.swing.*;

public class JFrameRunner extends JFrame{
	
	public String mapName;
	public JPanel window, tB, buttonField;
	public JLabel imagePanel;
	public JTextArea textField;
	public JButton b1, b2, b3, b4, b5, b6, b7, b8;
	
	private static final long serialVersionUID = 1L;
	
	public JFrameRunner(Location loc) {
		super("Ludum Dare 30: Connected Worlds");
		setSize(816, 439);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		window = new JPanel();
		window.setSize(800, 400);
		
		//Add the map
		mapName = loc.getImagePath();
		imagePanel = new JLabel(new ImageIcon(mapName));
		imagePanel.setSize(400, 400);

		//Add the text
		tB = new JPanel();
		tB.setSize(400, 400);
		textField = new JTextArea("Area: " + loc.getLocationName() + "\n\n" + loc.getLocationText());
		textField.setSize(400, 320);
		textField.setLineWrap(true);
		textField.setWrapStyleWord(true);
		
		//Add the buttons
		buttonField = new JPanel();
		buttonField.setSize(400, 80);
		b1 = new JButton("Button 1");
		b2 = new JButton("Button 2");
		b3 = new JButton("Button 3");
		b4 = new JButton("Button 4");
		b5 = new JButton("Button 5");
		b6 = new JButton("Button 6");
		b7 = new JButton("Button 7");
		b8 = new JButton("Reload");
		
		//Define the layout
		doLayoutWork();
		
		getContentPane().add(window);
		pack();
		setVisible(true);
	}
	
	public void doLayoutWork() {
		//Organize the general layout
		GroupLayout windowLayout = new GroupLayout(window);
		window.setLayout(windowLayout);
		windowLayout.setAutoCreateGaps(true);
		windowLayout.setAutoCreateContainerGaps(true);
		windowLayout.setHorizontalGroup(
				windowLayout.createSequentialGroup()
					.addComponent(imagePanel)
					.addComponent(tB)
		);
		windowLayout.setVerticalGroup(
				windowLayout.createSequentialGroup()
					.addGroup(windowLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(imagePanel)
							.addComponent(tB))
		);
				
		//Organize the text/button layout
		GroupLayout tbLayout = new GroupLayout(tB);
		tB.setLayout(tbLayout);
		tbLayout.setAutoCreateGaps(true);
		tbLayout.setAutoCreateContainerGaps(true);
		tbLayout.setHorizontalGroup(
				tbLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(textField)
					.addComponent(buttonField)
		);
		tbLayout.setVerticalGroup(
				tbLayout.createSequentialGroup()
					.addComponent(textField)
					.addComponent(buttonField)
		);
				
		//Organize the button layout
		GroupLayout buttonLayout = new GroupLayout(buttonField);
		buttonField.setLayout(buttonLayout);
		buttonLayout.setAutoCreateGaps(true);
		buttonLayout.setAutoCreateContainerGaps(true);
		buttonLayout.setHorizontalGroup(
				buttonLayout.createSequentialGroup()
					.addGroup(buttonLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(b1)
							.addComponent(b5))
					.addGroup(buttonLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(b2)
							.addComponent(b6))
					.addGroup(buttonLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(b3)
							.addComponent(b7))
					.addGroup(buttonLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(b4)
							.addComponent(b8))
		);
		buttonLayout.setVerticalGroup(
				buttonLayout.createSequentialGroup()
					.addGroup(buttonLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(b1)
							.addComponent(b2)
							.addComponent(b3)
							.addComponent(b4))
					.addGroup(buttonLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(b5)
							.addComponent(b6)
							.addComponent(b7)
							.addComponent(b8))
		);
	}
}