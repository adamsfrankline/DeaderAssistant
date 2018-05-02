import java.util.Random;

public enum Traits {

	COGNITION 	(0, "Cognition", "Mental"),
	KNOWLEDGE 	(1, "Knowledge", "Mental"),
	MIEN		(2, "Mien", "Mental"),
	SMARTS		(3, "Smarts", "Mental"),
	SPIRIT		(4, "Spirit", "Mental"),
	DEFTNESS	(5, "Deftness", "Corporeal"),
	NIMBLENESS	(6, "Nimbleness", "Corporeal"),
	STRENGTH	(7, "Strength", "Corporeal"),
	QUICKNESS	(8, "Quickness", "Corporeal"),
	VIGOR		(9, "Vigor", "Corporeal");
	
	private final int traitsOrderInt;			//Trait Order from 0-9 int
	private final String traitsNameString;		//Trait Name as String
	private final String traitsTypeString;		//Trait Type as String Corporeal or Mental

	
	Traits(int tOrderInt, String tNameString, String tTypeString)
	{
		this.traitsOrderInt = tOrderInt;
		this.traitsNameString = tNameString;
		this.traitsTypeString = tTypeString;
		
	}
	
	//Get a random Trait from this enum list 
	public static Traits getRandomTrait()
	{
		//Create the Random Seed
		Random random = new Random();
		
		//Pick a Trait from the elements in the array of Traits based on a random number generation of upto the length of the Traits.values() array 
		return Traits.values()[random.nextInt(values().length)]; 
	}

	/**
	 * @return the traitsNameString
	 */
	public String getTraitsNameString() {
		return traitsNameString;
	}

	/**
	 * @return the traitsOrderInt
	 */
	public int getTraitsOrderInt() {
		return traitsOrderInt;
	}

	/**
	 * @return the traitsTypeString
	 */
	public String getTraitsTypeString() {
		return traitsTypeString;
	}
	
}
