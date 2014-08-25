/**
 * Author: Erik Martin
 * Date: 24 August 2014
 * Description: Contains information about each location: what text to display and what the buttons do.
 */
package mindlesslump.ludumdare30;

import java.util.ArrayList;

public class Location{
	
	private String locationName;
	private String locationText;
	private ArrayList<ButtonAction> buttons;
	private String imagePath;
	
	//Empty constructor
	public Location() {
		locationName = "";
		locationText = "";
		buttons = new ArrayList<ButtonAction>();
		imagePath = "";
	}
	
	//Partial constructor; this one is most likely to be used
	public Location(String name, String text) {
		locationName = name;
		locationText = text;
		buttons = new ArrayList<ButtonAction>();
		for(int j = 0; j < 8; j++) {
			buttons.add(new ButtonAction());
		}
		imagePath = "";
	}
	
	//Full constructor
	public Location(String name, String text, ArrayList<ButtonAction> b) {
		locationName = name;
		locationText = text;
		buttons = b;
		imagePath = "";
	}
	
	public void setLocationName(String name) {
		locationName = name;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationText(String text) {
		locationText = text;
	}
	
	public String getLocationText() {
		return locationText;
	}
	
	public void addButtonAction(int num, ButtonAction b) {
		buttons.set(num-1, b);
	}
	
	public void removeButtonAction(int num) {
		buttons.remove(num-1);
	}
	
	public ButtonAction getButtonAction(int num) {
		return buttons.get(num-1);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<ButtonAction> getButtonActions() {
		return (ArrayList<ButtonAction>)buttons.clone();
	}
	
	public void setImagePath(String path) {
		imagePath = path;
	}
	
	public String getImagePath() {
		return imagePath;
	}

}