/**
 * Author: Erik Martin
 * Date: 24 August 2014
 * Description: Runs the game and its logic.
 */
package mindlesslump.ludumdare30;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class GameRunner implements ActionListener{
	
	private Location currentLocation;
	private JFrameRunner frame;
	private int locationsVisited;
	private boolean countdown;
	
	public Location l0p0, l0p1; //This is the letter 'L' and the number '0'
	public Location l1p1, l1p2, l1p3, l1p4;
	public Location l2p1, l2p2, l2p3;
	public Location l3p1, l3p2;
	public Location l4p1, l4p2;
	public Location l5p1, l5p2, l5p3;
	public Location l6p1, l6p2;
	public Location l7p1, l7p2, l7p3;
	public Location l8p1;
	
	public static void main(String args[]) {
		new GameRunner(1);
	}
	
	public GameRunner() {
		
	}
	
	public GameRunner(int num) {
		doSetup();
		currentLocation = l0p0;
		frame = new JFrameRunner(currentLocation);
		doButtonSetup();
		countdown = false;
	}
	
	private void doSetup() {
		l0p0 = new Location("Introduction", "Welcome to NAMELESS GAME, created as a part of the 30th Ludum Dare game jam. This game was created by Erik Martin. Congratulations! You now know that. Enough pleasantries; you're here to play a game, and I'm here to guide you through that game. Press Button 1 to start.");
		l0p1 = new Location("Introduction", "You have lived all your life in the city of Ghalvar. Your father was a prominent merchant, and you had a comfortable life. However, happiness never lasts in this cruel world. A thief broke into the city's temple and stole the Staff of Amaros, the power of which protected the city for centuries. The thief took the Staff and fled across the world bridge to the wild lands of Trelf. Press Button 1 to continue.");
		l1p1 = new Location("Trade Guild", "You are currently in the Trade Guild of Ghalvar, where your father works. Your father is getting old, and he is looking to retire comfortably on the other side of town, in the rich district. However, he does not think you are up to the challenge of running a merchant business, as you spend most of your days wandering the city and countryside looking for drink and company. Now is your chance to prove yourself, both to your father, and to yourself. Retrieve the lost Staff of Amaros, and you will become the richest merchant Ghalvar has ever known. Press Button 1 to continue.");
		l1p2 = new Location("Trade Guild", "The Trade Guild is an elaborate building, with finely worked stone columns and vaulted ceilings. It creates the impression of great wealth and power, which is exactly what the Trade Guild wants you to think. Their reputation is a large part of their business, and they work tirelessly to maintain that reputation. The merchants themselves, however, don't exactly live up to the expectations. Most of them are aging, fat men, overly fond of food and drink, not to mention their love of money. They have diminished somewhat in recent weeks, as the loss of the Staff of Amaros has made all the townspeople feel weaker and less capable. Press Button 1 to continue.");
		l1p3 = new Location("Trade Guild", "Sitting at the long table are a handful of merchants, weighing out goods or tallying costs. Your father is among them: he is the oldest there, and looks tired, but alert. They are all busy, and you doubt they would be very willing to talk to you. A door to the south leads out into the gray haze of the early morning. Press Button 1 to try talking to one of the merchants. Press Button 6 to go outside.");
		l1p4 = new Location("Trade Guild", "You approach the long table and try to strike up a conversation with one of the merchants, whom you have seen often, but rarely spoken to. He grunts in reply, clearly engrossed in his work and unwilling to pause to talk to you. You decide to leave. Press Button 1 to continue.");
		l2p1 = new Location("Side Road", "You leave the Trade Guild behind, and step out into the gray, hazy morning. The street is fairly busy, filled with people going about their business. The proud-looking Trade Guild stands to your north, the road continues to the south, and there is a small alleyway leading to the east. Press Button 2 to go into the Trade Guild. Press Button 6 to follow the road. Press Button 7 to follow the alleyway.");
		l2p2 = new Location("Side Road", "You follow the road to the north. It ends here, with the Trade Guild talking up the end of the street. Press Button 2 to go into the Trade Guild. Press Button 6 to follow the road south. Press Button 7 to follow the alleyway east.");
		l2p3 = new Location("Side Road", "You step out onto the road, glad to be away from the poor area. You feel much safer here. The proud-looking Trade Guild stands to your north, the road continues to the south, and there is a small alleyway leading to the east. Press Button 2 to go into the Trade Guild. Press Button 6 to follow the road. Press Button 7 to follow the alleyway.");
		l3p1 = new Location("Poor Houses", "You follow the alleyway past dirty windows and cracked, aged doors. You emerge in a small side-street, with dozens of ramshackle hovels haphazardly erected all along the street. People stare at you as you pass: you are very out of place here, being the son of a prominent merchant. You're not sure that you'd leave here will all your belongings if you stayed much longer. An alleyway leads west, towards the larger road. The side-street continues south. Press Button 5 to follow the alleyway. Press Button 6 to follow the side-street.");
		l3p2 = new Location("Poor Houses", "You follow the side-street past dirty windows and cracked, aged doors. You are in a small side-street, with dozens of ramshackle hovels haphazardly erected all along the street. People stare at you as you pass: you are very out of place here, being the son of a prominent merchant. You're not sure that you'd leave here will all your belongings if you stayed much longer. An alleyway leads west, towards the larger road. The side-street continues south. Press Button 5 to follow the alleyway. Press Button 6 to follow the side-street.");
		l4p1 = new Location("Poor Houses", "You follow the alleyway past dirty windows and cracked, aged doors. You emerge in a small side-street, with dozens of ramshackle hovels haphazardly erected all along the street. People stare at you as you pass: you are very out of place here, being the son of a prominent merchant. You're not sure that you'd leave here will all your belongings if you stayed much longer. The side-street continues north. An alleyway leads west, towards the larger road. Press Button 2 to follow the side-street. Press Button 5 to follow the alleyway.");
		l4p2 = new Location("Poor Houses", "You follow the side-street past dirty windows and cracked, aged doors. You are in a small side-street, with dozens of ramshackle hovels haphazardly erected all along the street. People stare at you as you pass: you are very out of place here, being the son of a prominent merchant. You're not sure that you'd leave here will all your belongings if you stayed much longer. The side-street continues north. An alleyway leads west, towards the larger road. Press Button 2 to follow the side-street. Press Button 5 to follow the alleyway.");
		l5p1 = new Location("Side Road", "You follow the road to the south. It turns here, continuing west and heading towards the main thoroughfare of the city. You see another alleyway leading to the east. Press Button 2 to go north along the road. Press Button 5 to go west along the road. Press Button 7 to follow the alleyway.");
		l5p2 = new Location("Side Road", "You follow the alleyway back onto the road. It turns here, continuing west towards the main thoroughfare of the city and north towards the trade guild. You see an alleyway leading to the east. Press Button 2 to go north along the road. Press Button 5 to go west along the road. Press Button 7 to follow the alleyway.");
		l5p3 = new Location("Side Road", "You follow the road east. It turns here, continuing west towards the main thoroughfare of the city and north towards the trade guild. You see an alleyway leading to the east. Press Button 2 to go north along the road. Press Button 5 to go west along the road. Press Button 7 to follow the alleyway.");
		l6p1 = new Location("Side Road", "You follow the road west. The road intersects with the main road to your west, and the side road continues to your east. Press Button 5 to go to the main road. Press Button 7 to follow the side road.");
		l6p2 = new Location("Side Road", "You follow the road east. It intersects with the main road to your west, and the side road continues to your east. Press Button 5 to go to the main road. Press Button 7 to follow the side road.");
		l7p1 = new Location("Main Road", "You come to the main road of the city, which is uncommonly busy. Hundreds of people are streaming into the city from the outlying lands. There is a city guard standing nearby, watching the crowd for signs of trouble. The main road continues north, and there is an inn to the west, though you doubt you could get anywhere in this crowd. The gates stand open to your south; you can just make out the legendary world bridge in the distance. Press Button 1 to talk to the guard. Press Button 7 to follow the side road.");
		l7p2 = new Location("Main Road", "You approach the guard. He glances at you, gruffly telling you to move along, then does a double take. Upon realizing who you are, he apologizes and asks what he can to to help you. You ask about the crowd of people hurrying into the city. He explains that, without the Staff of Amaros to protect the city from the wilds of Trelf, all manner of creatures are free to cross the great world bridge and attack the people of Ghalvar. The mayor ordered for all the people living in the outlying settlements to come into the city for protection. Press Button 1 to keep talking to the guard. Press Button 6 to exit the city and begin searching for the Staff of Amaros. Press Button 7 to follow the side road.");
		l7p3 = new Location("Main Road", "The guard also tells you that the city watch will close the gate at sundown, so anyone left on the other side will have to wait until morning - and with so many dangerous creatures coming across the world bridge, they might not live through the night. Nonetheless, you need to retrieve that staff, and fast. You expect that the creatures of Trelf will swarm across the bridge at sundown, and the city's defenses aren't all that strong, as it mainly relied on the staff for protection. You need to retrieve that staff by sundown, or the city of Ghalvar will be lost. Press Button 6 to exit the city and begin searching for the Staff of Amaros. Press Button 7 to follow the side road.");
		
		l0p0.setImagePath("src/mindlesslump/ludumdare30/startMap.jpg");
		l0p0.addButtonAction(1, new ButtonAction(1, l0p1));
		l0p0.addButtonAction(8, new ButtonAction(8, l0p0));
		l0p1.setImagePath("src/mindlesslump/ludumdare30/startMap.jpg");
		l0p1.addButtonAction(1, new ButtonAction(1, l1p1));
		l0p1.addButtonAction(8, new ButtonAction(8, l0p1));
		
		l1p1.setImagePath("src/mindlesslump/ludumdare30/map1.jpg");
		l1p1.addButtonAction(1, new ButtonAction(1, l1p2));
		l1p1.addButtonAction(8, new ButtonAction(8, l1p1));
		l1p2.setImagePath("src/mindlesslump/ludumdare30/map1.jpg");
		l1p2.addButtonAction(1, new ButtonAction(1, l1p3));
		l1p2.addButtonAction(8, new ButtonAction(8, l1p2));
		l1p3.setImagePath("src/mindlesslump/ludumdare30/map1.jpg");
		l1p3.addButtonAction(1, new ButtonAction(1, l1p4));
		l1p3.addButtonAction(6, new ButtonAction(6, l2p1));
		l1p3.addButtonAction(8, new ButtonAction(8, l1p3));
		l1p4.setImagePath("src/mindlesslump/ludumdare30/map1.jpg");
		l1p4.addButtonAction(1, new ButtonAction(1, l2p1));
		l1p4.addButtonAction(8, new ButtonAction(8, l1p4));
		
		l2p1.setImagePath("src/mindlesslump/ludumdare30/map2.jpg");
		l2p1.addButtonAction(2, new ButtonAction(2, l1p3));
		l2p1.addButtonAction(6, new ButtonAction(6, l5p1));
		l2p1.addButtonAction(7, new ButtonAction(7, l3p1));
		l2p1.addButtonAction(8, new ButtonAction(8, l2p1));
		l2p2.setImagePath("src/mindlesslump/ludumdare30/map2.jpg");
		l2p2.addButtonAction(2, new ButtonAction(2, l1p3));
		l2p2.addButtonAction(6, new ButtonAction(6, l5p1));
		l2p2.addButtonAction(7, new ButtonAction(7, l3p1));
		l2p2.addButtonAction(8, new ButtonAction(8, l2p2));
		l2p3.setImagePath("src/mindlesslump/ludumdare30/map2.jpg");
		l2p3.addButtonAction(2, new ButtonAction(2, l1p3));
		l2p3.addButtonAction(6, new ButtonAction(6, l5p1));
		l2p3.addButtonAction(7, new ButtonAction(7, l3p1));
		l2p3.addButtonAction(8, new ButtonAction(8, l2p3));
		
		l3p1.setImagePath("src/mindlesslump/ludumdare30/map3.jpg");
		l3p1.addButtonAction(5, new ButtonAction(5, l2p3));
		l3p1.addButtonAction(6, new ButtonAction(6, l4p2));
		l3p1.addButtonAction(8, new ButtonAction(8, l3p1));
		l3p2.setImagePath("src/mindlesslump/ludumdare30/map3.jpg");
		l3p2.addButtonAction(5, new ButtonAction(5, l2p3));
		l3p2.addButtonAction(6, new ButtonAction(6, l4p2));
		l3p2.addButtonAction(8, new ButtonAction(8, l3p2));
		
		l4p1.setImagePath("src/mindlesslump/ludumdare30/map4.jpg");
		l4p1.addButtonAction(2, new ButtonAction(2, l3p2));
		l4p1.addButtonAction(5, new ButtonAction(5, l5p2));
		l4p1.addButtonAction(8, new ButtonAction(8, l4p1));
		l4p2.setImagePath("src/mindlesslump/ludumdare30/map4.jpg");
		l4p2.addButtonAction(2, new ButtonAction(2, l3p2));
		l4p2.addButtonAction(5, new ButtonAction(5, l5p2));
		l4p2.addButtonAction(8, new ButtonAction(8, l4p2));
		
		l5p1.setImagePath("src/mindlesslump/ludumdare30/map5.jpg");
		l5p1.addButtonAction(2, new ButtonAction(2, l2p2));
		l5p1.addButtonAction(5, new ButtonAction(5, l6p1));
		l5p1.addButtonAction(7, new ButtonAction(7, l4p1));
		l5p1.addButtonAction(8, new ButtonAction(8, l5p1));
		l5p2.setImagePath("src/mindlesslump/ludumdare30/map5.jpg");
		l5p2.addButtonAction(2, new ButtonAction(2, l2p2));
		l5p2.addButtonAction(5, new ButtonAction(5, l6p1));
		l5p2.addButtonAction(7, new ButtonAction(7, l4p1));
		l5p2.addButtonAction(8, new ButtonAction(8, l5p2));
		l5p3.setImagePath("src/mindlesslump/ludumdare30/map5.jpg");
		l5p3.addButtonAction(2, new ButtonAction(2, l2p2));
		l5p3.addButtonAction(5, new ButtonAction(5, l6p1));
		l5p3.addButtonAction(7, new ButtonAction(7, l4p1));
		l5p3.addButtonAction(8, new ButtonAction(8, l5p3));
		
		l6p1.setImagePath("src/mindlesslump/ludumdare30/map6.jpg");
		l6p1.addButtonAction(5, new ButtonAction(5, l7p1));
		l6p1.addButtonAction(7, new ButtonAction(7, l5p3));
		l6p1.addButtonAction(8, new ButtonAction(8, l6p1));
		l6p2.setImagePath("src/mindlesslump/ludumdare30/map6.jpg");
		l6p2.addButtonAction(5, new ButtonAction(5, l7p1));
		l6p2.addButtonAction(7, new ButtonAction(7, l5p3));
		l6p2.addButtonAction(8, new ButtonAction(8, l6p2));
		
		l7p1.setImagePath("src/mindlesslump/ludumdare30/map7.jpg");
		l7p1.addButtonAction(1, new ButtonAction(1, l7p2));
		l7p1.addButtonAction(7, new ButtonAction(7, l6p2));
		l7p1.addButtonAction(8, new ButtonAction(8, l7p1));
		l7p2.setImagePath("src/mindlesslump/ludumdare30/map7b.jpg");
		l7p2.addButtonAction(1, new ButtonAction(1, l7p3));
		l7p2.addButtonAction(6, new ButtonAction(6, l8p1));
		l7p2.addButtonAction(7, new ButtonAction(7, l6p2));
		l7p2.addButtonAction(8, new ButtonAction(8, l7p2));
		l7p3.setImagePath("src/mindlesslump/ludumdare30/map7b.jpg");
		l7p3.addButtonAction(6, new ButtonAction(6, l8p1));
		l7p3.addButtonAction(7, new ButtonAction(7, l6p2));
		l7p3.addButtonAction(8, new ButtonAction(8, l7p3));
	}
	
	private void doButtonSetup() {
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
				if(getCurrentLocation().getButtonAction(1).hasTarget()) {
					setCurrentLocation(getCurrentLocation().getButtonAction(1).getButtonTarget());
					locationsVisited++;
				}
			}
			if(e.getSource().equals(frame.b2)) {
				if(getCurrentLocation().getButtonAction(2).hasTarget()) {
					setCurrentLocation(getCurrentLocation().getButtonAction(2).getButtonTarget());
					locationsVisited++;
				}
			}
			if(e.getSource().equals(frame.b3)) {
				if(getCurrentLocation().getButtonAction(3).hasTarget()) {
					setCurrentLocation(getCurrentLocation().getButtonAction(3).getButtonTarget());
					locationsVisited++;
				}
			}
			if(e.getSource().equals(frame.b4)) {
				if(getCurrentLocation().getButtonAction(4).hasTarget()) {
					setCurrentLocation(getCurrentLocation().getButtonAction(4).getButtonTarget());
					locationsVisited++;
				}
			}
			if(e.getSource().equals(frame.b5)) {
				if(getCurrentLocation().getButtonAction(5).hasTarget()) {
					setCurrentLocation(getCurrentLocation().getButtonAction(5).getButtonTarget());
					locationsVisited++;
				}
			}
			if(e.getSource().equals(frame.b6)) {
				if(getCurrentLocation().getButtonAction(6).hasTarget()) {
					setCurrentLocation(getCurrentLocation().getButtonAction(6).getButtonTarget());
					locationsVisited++;
				}
			}
			if(e.getSource().equals(frame.b7)) {
				if(getCurrentLocation().getButtonAction(7).hasTarget()) {
					setCurrentLocation(getCurrentLocation().getButtonAction(7).getButtonTarget());
					locationsVisited++;
				}
			}
			if(e.getSource().equals(frame.b8)) {
				if(getCurrentLocation().getButtonAction(8).hasTarget()) {
					setCurrentLocation(getCurrentLocation().getButtonAction(8).getButtonTarget());
					locationsVisited++;
				}
			}
		}
		
		//If the location has a new image to show, show that image
		if(!getCurrentLocation().getImagePath().equals("")) {
			frame.mapName = getCurrentLocation().getImagePath();
			frame.imagePanel.setIcon(new ImageIcon(frame.mapName));
		}
		
		//Change the text
		if(!getCurrentLocation().equals(l8p1)) {
			locationsVisited = 0;
			countdown = true;
		}
		if(!countdown) {
			frame.textField.setText("Area: " + getCurrentLocation().getLocationName() + "\n" + getCurrentLocation().getLocationText());
		}
		else {
			int temp = 20 - locationsVisited;
			frame.textField.setText("Time until sundown: " + temp + "\n\n" + "Area: " + getCurrentLocation().getLocationName() + "\n" + getCurrentLocation().getLocationText());
		}
	}
	
	public void setCurrentLocation(Location loc) {
		currentLocation = loc;
	}
	
	public Location getCurrentLocation() {
		return currentLocation;
	}
}