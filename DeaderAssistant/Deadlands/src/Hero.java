

// A hero is one of the good guys which is an entity and can belong to a Posse 
public class Hero extends Entity
{
	public Hero(String hName, String hAlias, String hOccupation) 
	{
		super(hName, hAlias, hOccupation);
		//Initialize the size and locations of the Entity
		initializeSizeLocations();
		
		
		
	}

//Private Methods
	
	private void initializeSizeLocations() {
		//Set the default Size of the HeroDemo(Humanoid, 6)
		super.setEntitySize(new Size("Humanoid", 6));
		
		//Set the location hit values for this HeroDemo
		super.getEntitySize().addSizeLocationIntString(20, "Head");
		super.getEntitySize().addSizeLocationIntString(19, "Guts Upper");
		super.getEntitySize().addSizeLocationIntString(18, "Guts Upper");
		super.getEntitySize().addSizeLocationIntString(17, "Guts Upper");
		super.getEntitySize().addSizeLocationIntString(16, "Guts Upper");
		super.getEntitySize().addSizeLocationIntString(15, "Guts Upper");
		super.getEntitySize().addSizeLocationIntString(14, "Arm Upper Right");
		super.getEntitySize().addSizeLocationIntString(13, "Arm Upper Left");
		super.getEntitySize().addSizeLocationIntString(12, "Arm Lower Right");
		super.getEntitySize().addSizeLocationIntString(11, "Arm Lower Left");
		super.getEntitySize().addSizeLocationIntString(10, "Guts Gizzards");
		super.getEntitySize().addSizeLocationIntString(9, "Guts Lower");
		super.getEntitySize().addSizeLocationIntString(8, "Guts Lower");
		super.getEntitySize().addSizeLocationIntString(7, "Guts Lower");
		super.getEntitySize().addSizeLocationIntString(6, "Guts Lower");
		super.getEntitySize().addSizeLocationIntString(5, "Guts Lower");
		super.getEntitySize().addSizeLocationIntString(4, "Leg Upper Right");
		super.getEntitySize().addSizeLocationIntString(3, "Leg Upper Left");
		super.getEntitySize().addSizeLocationIntString(2, "Leg Lower Right");
		super.getEntitySize().addSizeLocationIntString(1, "Leg Lower Left");
		
		//Assign the Hit location names to the Size of this HeroDemo
		
		//For each of the Hitlocation values
		for(String locationName : super.getEntitySize().getSizeHashMapIntString().values())
		{
			//Make a new Location Object and put it in the Size Location Map
			super.getEntitySize().getSizeHashMapStringLocation().put(locationName, new Location(locationName, 0, 0));
			
		}
		
	}
	

}
