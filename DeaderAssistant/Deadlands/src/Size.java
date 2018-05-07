import java.util.HashMap;

public class Size {

	//A size can have a classification of the varmint
	String sizeClassification; //Humanoid, Deader, mutant, a pile of goo... whatever shape your entity takes and what so special about its shape
	
	//A size can have a size Number indicating how big this thing is compared to other things
	int sizeNumber; //1 = rat, 4 = dog, 6 = human, 14 = truck, 20 = mohave ratler
	
	//A size can have a map of locations by Name Strings and Location Objects that hold gear and count wounds
	HashMap<String, Location> sizeHashMapStringLocation = new HashMap<String, Location>();
	
	//A size can have a map of locations by Die Roll and String Name
	HashMap<Integer, String> sizeHashMapIntString = new HashMap<Integer, String>();
		
	
	public Size() 
	{
		//Used to Associate the Size object to the not compelted entity
	}
	
	public Size(String sClassification, int sNumber) 
	{
		this.setSizeClassification(sClassification);
		this.setSizeNumber(sNumber);
		
	}


//Methods	

	
	public void addSizeLocationIntString(int aSizeLocationHitInt, String aSizeLocationNameString)
	{
		this.sizeHashMapIntString.put(aSizeLocationHitInt, aSizeLocationNameString);
	}
	
	//A Size can update one Location for this Size's instance
	public void updateSizeLocationWoundLevel(String gLocationName, int uLocationWoundLevel)
	{
		
		//If the Size already has a Location with the same name as the Location name string
		if(this.getSizeHashMapStringLocation().containsKey(gLocationName))
		{
			//Get the old wound level
			int oldLocationWoundLevel = this.getSizeHashMapStringLocation().get(gLocationName).getLocationWoundLevel();
			
			//Add(or subtract) the wound levels being passed in
			oldLocationWoundLevel += uLocationWoundLevel;
			
			//Set the new wound level total
			this.getSizeHashMapStringLocation().get(gLocationName).setLocationWoundLevel(oldLocationWoundLevel);
		}
		//The Location does not exist in this Size
		else
		{
			//Put this Aptitude into this Trait
			System.out.println("Sorry that just aint one of the parts on that beast!");
		}
	}

	//Get the Trait's Coordination for a given patitude
	public int getSizeLocationWoundLevel(String gLocationName)
	{
		//If the Size already has a Location with the same name as the Location being received
		if(getSizeHashMapStringLocation().containsKey(gLocationName))
		{
			//Return the Wound level of the Location for this Size
			return this.getSizeHashMapStringLocation().get(gLocationName).getLocationWoundLevel();
		}
		//The Location does not exist in this Trait
		else
		{
			//Return a value of negative 1 since the Location does not exist
			System.out.println("Sorry that just aint one of the parts on that beast!");			
			return (-1);
		}
	}
	
	
	
	
	
//Getters and Setters
	
	public void setSizeClassification(String sClassification)
	{
		this.sizeClassification = sClassification;
		
	}
	
	public String getSizeClassification()
	{
		return this.sizeClassification;
		
	}
	
	public void setSizeNumber(int sNumber)
	{
		this.sizeNumber = sNumber;
		
	}
	
	public int getSizeNumber()
	{
		return this.sizeNumber;
		
	}

	/**
	 * @return the traitAptitudesStringAptitudeHashMap
	 */
	public HashMap<String, Location> getSizeHashMapStringLocation() {
		return this.sizeHashMapStringLocation;
	}

	/**
	 * @param traitAptitudesStringAptitudeHashMap the traitAptitudesStringAptitudeHashMap to set
	 */
	public void setSizeHashMapStringLocation(HashMap<String, Location> sizeHashMapStringLocation) {
		this.sizeHashMapStringLocation = sizeHashMapStringLocation;
	}

	/**
	 * @return the traitAptitudesStringAptitudeHashMap
	 */
	public HashMap<Integer, String> getSizeHashMapIntString() {
		return this.sizeHashMapIntString;
	}

	/**
	 * @param traitAptitudesStringAptitudeHashMap the traitAptitudesStringAptitudeHashMap to set
	 */
	public void setSizeHashMapIntString(HashMap<Integer, String> sHashMapIntString) {
		this.sizeHashMapIntString = sHashMapIntString;
	}


	
}



