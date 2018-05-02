import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Trait {

//Properties
	//A Trait can have a name
	private String traitName;	//Uses the ENUM Traits traitsNameString
	
	//A trait can have Die Type Value
	private String traitDieTypeString;	//"D4", "D6", "D8", "D10", "D12"
	private int traitDieTypeInt;		// 4, 6, 8, 10, 12
	
	//A trait can have a Coordination Value
	private int traitCoordinationInt;	//1, 2, 3, 4, 5
	
	//A trait can have one to many Aptitudes
	private Map<String, Aptitude> traitAptitudesStringAptitudeHashMap = new HashMap<String, Aptitude>(); //This is a HashMap of Aptitudes that belong to this Traits instance
	
//Constructor
	public Trait(Traits tEnum)
	{
		//Sets the name of the Trait instance from the ENUM Traits
		setTraitName(tEnum.getTraitsNameString());
	}

//Private Methods	
	
//Public Methods
	
	//A trait can update one Aptitude for this Traits instance
	public void updateTraitAptitudesValue(Aptitude uTraitAptitudeValue) 
	{
		//If the Trait already has a Aptitude with the same name as the Aptitude being received
		if(getTraitAptitudesStringAptitudeHashMap().containsKey(uTraitAptitudeValue.getAptitudeName()))
		{
			//Replace the Aptitude that belongs to this Trait with the new Aptitude
			getTraitAptitudesStringAptitudeHashMap().replace(uTraitAptitudeValue.getAptitudeName(), uTraitAptitudeValue);
		}
		//The Aptitude does not exist in this Trait
		else
		{
			//Put this Aptitude into this Trait
			getTraitAptitudesStringAptitudeHashMap().put(uTraitAptitudeValue.getAptitudeName(), uTraitAptitudeValue);
		}
	}

	
//Overrides
//	
//	//Overridding the toString method from the String Class
//	@Override
//	public String toString()
//	{
//		//Declare new Stringbuilder object for the result
//		StringBuilder result = new StringBuilder();
//		
//		//Create a string with a special property that gives the newLine"\n" character at the end of the String
//		String newLine = System.getProperty("line.separator");
//		
//		//Get the name of this instance of the object
//		result.append(this.getClass().getName());
//		result.append("\nTrait {");
//		result.append(newLine);
//		
//		//Determine fields declared in this class only
//		Field[] fields = this.getClass().getDeclaredFields();
//		
//		//For each field in the Fields array
//		for(Field field : fields) 
//		{
//			//Print the 4 spaces(half tab for standard IDE users) 
//			result.append("    ");
//			
//			//Try for private properties access
//			try
//			{
//				//Get the name and add it to the result
//				result.append(field.getName());
//				
//				//Append the colon separator
//				result.append(": ");
//				
//				//Used to get access to private fields
//				result.append(field.get(this));
//			}
//			//Catch on IllegalAccessExceptions such as accessing the private properties of this bean
//			catch(IllegalAccessException ex)
//			{
//				//Process the exception
//				System.out.printf("\nCaught: %s\n\n", ex );
//			}
//			//Add the newLine "\n" to the result
//			result.append(newLine);
//		}
//		//Append the close brace
//		result.append("}");
//
//		//Return the result and toString
//		return result.toString();
//	}
//	
//Getter and Setters

	/**
	 * @return the traitName
	 */
	public String getTraitName() {
		return traitName;
	}

	/**
	 * @param traitName the traitName to set
	 */
	public void setTraitName(String traitName) {
		this.traitName = traitName;
	}


	/**
	 * @return the traitAptitudesStringAptitudeHashMap
	 */
	public Map<String, Aptitude> getTraitAptitudesStringAptitudeHashMap() {
		return traitAptitudesStringAptitudeHashMap;
	}

	/**
	 * @param traitAptitudesStringAptitudeHashMap the traitAptitudesStringAptitudeHashMap to set
	 */
	public void setTraitAptitudesStringAptitudeHashMap(Map<String, Aptitude> traitAptitudesStringAptitudeHashMap) {
		this.traitAptitudesStringAptitudeHashMap = traitAptitudesStringAptitudeHashMap;
	}

	/**
	 * @return the traitDieTypeString
	 */
	public String getTraitDieTypeString() {
		return traitDieTypeString;
	}

	/**
	 * @param traitDieTypeString the traitDieTypeString to set
	 */
	public void setTraitDieTypeString(String traitDieTypeString) {
		this.traitDieTypeString = traitDieTypeString;
	}

	/**
	 * @return the traitDieTypeInt
	 */
	public int getTraitDieTypeInt() {
		return traitDieTypeInt;
	}

	/**
	 * @param traitDieTypeInt the traitDieTypeInt to set
	 */
	public void setTraitDieTypeInt(int traitDieTypeInt) {
		this.traitDieTypeInt = traitDieTypeInt;
	}

	/**
	 * @return the traitCoordinationInt
	 */
	public int getTraitCoordinationInt() {
		return traitCoordinationInt;
	}

	/**
	 * @param traitCoordinationInt the traitCoordinationInt to set
	 */
	public void setTraitCoordinationInt(int traitCoordinationInt) {
		this.traitCoordinationInt = traitCoordinationInt;
	}
	
}

