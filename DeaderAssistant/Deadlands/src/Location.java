import java.util.HashMap;

public class Location {

	//A location can have name
	String locationName; //Left arm, right leg, mutant left arm 2, Dragon tail... you name it literally!
	
	//A location can have a wound level counter
	int locationWoundLevel = 0;
	
	//A location can have a armor value
	int locationArmorValue = 0; //0 is default, this value can change when equiping gear or casting spells
	
	//A location can have map of String Name of the location with the Gear associated with it
	HashMap<String, Gear> locationHashMapStringGear = new HashMap<String, Gear>(); //Right Arm: winter coat right arm, Police pistol, junker watch
	
	public Location(String lName, int lWoundLevel, int lArmorValue)
	{
		this.setLocationName(lName);
		this.setLocationWoundLevel(lWoundLevel);
		this.setLocationArmorValue(lArmorValue);
		
		
	}
	
//Public Methods
	
	
	
	
//getters and setters
	
	public void setLocationArmorValue(int lArmorValue) 
	{
		this.locationArmorValue = lArmorValue;
	}

	public int getLocationArmorValue() 
	{
		return this.locationArmorValue;
	}
	
	public void setLocationWoundLevel(int lWoundLevel) 
	{
		this.locationWoundLevel = lWoundLevel;
	}

	public int getLocationWoundLevel() 
	{
		return this.locationWoundLevel;
	}
	
	public void setLocationName(String lName)
	{
		this.locationName = lName;
	}
	
	public String getLocationName()
	{
		return this.locationName;
	}
	
}
