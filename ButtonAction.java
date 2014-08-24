/**
 * Author: Erik Martin
 * Date: 23 August 2014
 * Description: Contains information about what the buttons do when pressed. They point to a new location, or do nothing.
 */
package mindlesslump.ludumdare30;

public class ButtonAction {
	
	private int buttonNum;
	private Location buttonTarget;
	
	//Empty constructor
	public ButtonAction() {
		buttonNum = 0;
		buttonTarget = new Location();
	}
	
	//Partial constructor
	public ButtonAction(int num) {
		buttonNum = num;
		buttonTarget = new Location();
	}
	
	//Full constructor
	public ButtonAction(int num, Location loc) {
		buttonNum = num;
		buttonTarget = loc;
	}
	
	public void setButtonNum(int num) {
		buttonNum = num;
	}
	
	public int getButtonNum() {
		return buttonNum;
	}
	
	public void setButtonTarget(Location loc) {
		buttonTarget = loc;
	}
	
	public Location getButtonTarget() {
		return buttonTarget;
	}
}