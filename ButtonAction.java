/**
 * Author: Erik Martin
 * Date: 24 August 2014
 * Description: Contains information about what the buttons do when pressed. They point to a new location, or do nothing.
 */
package mindlesslump.ludumdare30;

public class ButtonAction {
	
	private int buttonNum;
	private Location buttonTarget;
	private boolean hasTarget;
	
	//Empty constructor
	public ButtonAction() {
		buttonNum = 0;
		buttonTarget = new Location();
		hasTarget = false;
	}
	
	//Partial constructor
	public ButtonAction(int num) {
		buttonNum = num;
		buttonTarget = new Location();
		hasTarget = false;
	}
	
	//Full constructor
	public ButtonAction(int num, Location loc) {
		buttonNum = num;
		buttonTarget = loc;
		hasTarget = true;
	}
	
	public void setButtonNum(int num) {
		buttonNum = num;
	}
	
	public int getButtonNum() {
		return buttonNum;
	}
	
	public void setButtonTarget(Location loc) {
		buttonTarget = loc;
		hasTarget = true;
	}
	
	public Location getButtonTarget() {
		return buttonTarget;
	}
	
	public boolean hasTarget() {
		return hasTarget;
	}
}