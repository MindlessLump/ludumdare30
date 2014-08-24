package mindlesslump.ludumdare30;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class GameRunner implements ActionListener{
	
	private Location currentLocation;
	private JFrameRunner frame;
	
	public Location l0; //This is the letter 'L' and the number '0'
	public Location l1p1, l1p2;
	
	public static void main(String args[]) {
		new GameRunner(1);
	}
	
	public GameRunner() {
		
	}
	
	public GameRunner(int num) {
		doSetup();
		currentLocation = l0;
		frame = new JFrameRunner(currentLocation);
		doButtonSetup();
	}
	
	private void doSetup() {
		l0 = new Location("Introduction", "Welcome to NAMELESS GAME, created as a part of the 30th Ludum Dare game jam. This game was created by Erik Martin. Congratulations! You now know that. Enough pleasantries; you're here to play a game, and I'm here to guide you through that game. Press any button to start.");
		l1p1 = new Location("Prologue", "You have lived all your life in the city of Ghalvar. Your father was a prominent merchant, and you had a comfortable life. However, happiness never lasts in this cruel world. A thief broke into the city's temple and stole the Staff of Amaros, the power of which protected the city for centuries. The thief took the Staff and fled across the world bridge to the wild lands of Trelf. Press any button to continue.");
		l1p2 = new Location();
				l0.setImagePath("src/mindlesslump/ludumdare30/startMap.jpg");
				l0.addButtonAction(1, new ButtonAction(1, l1p1));
				l0.addButtonAction(2, new ButtonAction(2, l1p1));
				l0.addButtonAction(3, new ButtonAction(3, l1p1));
				l0.addButtonAction(4, new ButtonAction(4, l1p1));
				l0.addButtonAction(5, new ButtonAction(5, l1p1));
				l0.addButtonAction(6, new ButtonAction(6, l1p1));
				l0.addButtonAction(7, new ButtonAction(7, l1p1));
				l0.addButtonAction(8, new ButtonAction(8, l0));
				l1p1.setImagePath("src/mindlesslump/ludumdare30/startMap.jpg");
				l1p1.addButtonAction(1, new ButtonAction(1, l1p2));
				l1p1.addButtonAction(2, new ButtonAction(2, l1p2));
				l1p1.addButtonAction(3, new ButtonAction(3, l1p2));
				l1p1.addButtonAction(4, new ButtonAction(4, l1p2));
				l1p1.addButtonAction(5, new ButtonAction(5, l1p2));
				l1p1.addButtonAction(6, new ButtonAction(6, l1p2));
				l1p1.addButtonAction(7, new ButtonAction(7, l1p2));
				l1p1.addButtonAction(8, new ButtonAction(8, l1p1));
	}
	
	private void doButtonSetup() {
		frame.b1.setActionCommand("button1");
		frame.b2.setActionCommand("button2");
		frame.b3.setActionCommand("button3");
		frame.b4.setActionCommand("button4");
		frame.b5.setActionCommand("button5");
		frame.b6.setActionCommand("button6");
		frame.b7.setActionCommand("button7");
		frame.b8.setActionCommand("button8");
		
		frame.b1.addActionListener(this);
		frame.b2.addActionListener(this);
		frame.b3.addActionListener(this);
		frame.b4.addActionListener(this);
		frame.b5.addActionListener(this);
		frame.b6.addActionListener(this);
		frame.b7.addActionListener(this);
		frame.b8.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		//Change the current location as determined by which button was pressed.
		if(!e.getSource().equals(null)) {
			if(e.getSource().equals(frame.b1)) {
				if(!getCurrentLocation().getButtonAction(1).equals(null))
					setCurrentLocation(getCurrentLocation().getButtonAction(1).getButtonTarget());
			}
			if(e.getSource().equals(frame.b2)) {
				if(!getCurrentLocation().getButtonAction(2).equals(null))
					setCurrentLocation(getCurrentLocation().getButtonAction(2).getButtonTarget());
			}
			if(e.getSource().equals(frame.b3)) {
				if(!getCurrentLocation().getButtonAction(3).equals(null))
					setCurrentLocation(getCurrentLocation().getButtonAction(3).getButtonTarget());
			}
			if(e.getSource().equals(frame.b4)) {
				if(!getCurrentLocation().getButtonAction(4).equals(null))
					setCurrentLocation(getCurrentLocation().getButtonAction(4).getButtonTarget());
			}
			if(e.getSource().equals(frame.b5)) {
				if(!getCurrentLocation().getButtonAction(5).equals(null))
					setCurrentLocation(getCurrentLocation().getButtonAction(5).getButtonTarget());
			}
			if(e.getSource().equals(frame.b6)) {
				if(!getCurrentLocation().getButtonAction(6).equals(null))
					setCurrentLocation(getCurrentLocation().getButtonAction(6).getButtonTarget());
			}
			if(e.getSource().equals(frame.b7)) {
				if(!getCurrentLocation().getButtonAction(7).equals(null))
					setCurrentLocation(getCurrentLocation().getButtonAction(7).getButtonTarget());
			}
			if(e.getSource().equals(frame.b8)) {
				if(!getCurrentLocation().getButtonAction(8).equals(null))
					setCurrentLocation(getCurrentLocation().getButtonAction(8).getButtonTarget());
			}
		}
		
		//If the location has a new image to show, show that image
		if(!getCurrentLocation().getImagePath().equals("")) {
			frame.mapName = getCurrentLocation().getImagePath();
			frame.imagePanel.setIcon(new ImageIcon(frame.mapName));
		}
		
		//Change the text
		frame.textField.setText("Area: " + getCurrentLocation().getLocationName() + "\n\n" + getCurrentLocation().getLocationText());
	}
	
	public void setCurrentLocation(Location loc) {
		currentLocation = loc;
	}
	
	public Location getCurrentLocation() {
		return currentLocation;
	}
}