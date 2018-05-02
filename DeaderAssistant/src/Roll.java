import java.util.ArrayList;


public class Roll {

	//A roll has a type of roll
	private String rollTypeString; //Damage, DamageLocation, DamageMassive, DamageStrength, Aptitude, Opposed, Location, Direction, Scart, Dominion
	
	//A roll can have a number of dice, with a number of sides, and a bonus modifier number 
	private String rollDiceString; //XdX+X, 2d4+2, 4d6+1...
	
	//A roll can have a target number to hit
	private int rollTargetNumberInt = 0; //7,9,11,23...
	
	//A roll can have a single highest value
	private int rollHighestInt = 0; //4, 5, 2....
	
	//A roll can have a total value
	private int rollTotalInt = 0; //4, 15, 206....
		
	
	//A roll can bust(get more 1's in a roll by half of the number of dice total)
	private boolean rollBustFlag = false; //true, false
	
	//A roll can succeed(at least meet the Target Number)
	private boolean rollSuccessFlag = false; //true, false
	
	//A roll can succeed by a number of raises(Increments of 5 over the Target number)
	private int rollRaisesInt = 0; // 0, 5, 2...
	
	//A roll can award a chance to pull a chip(if the roll success is 5 raises over the target number)
	private boolean rollAwardChip = false; //true, false	
	
	//A roll can have a result list of each die rolled
	private ArrayList<Integer> rollResultArrayListInteger;//5,6,7,8,23,1
	
	//A roll can have a list of one to many entities involved in the roll
		//(Hero applies damage to Villain, Hero Opposes Hero in strength roll, Hero rolls for massive damage locations, Hero makes a smarts roll...)
	private ArrayList<Entity> rollArrayListEntity; //Hero, Villains, Critters....

	/**
	 * @param rollTypeString
	 * @param rollDiceString
	 * @param rollArrayListEntity
	 */
	public Roll(String rTypeString, String rDiceString, ArrayList<Entity> rArrayListEntity) {
		this.rollTypeString = rTypeString;
		this.rollDiceString = rDiceString;
		this.rollArrayListEntity = rArrayListEntity;
		
		switch (rTypeString)
		{
			//For Trait based rolls that have a Static targetNumber, currentEntityTraitAptitudeString and are pure Trait Rolls only like Quickness(pulling cards), Vigor(taking damage, Strength... 
			case "Trait":
				this.rollTrait();
				break;
			//For Concentrations based rolls that have a Static targetNumber, currentEntityConcentrationAptitudeString and are pure Concentration Rolls only like Shootin, Guts, Fighting... 
			case "Concentrations":
				this.rollConcentrations();
				break;
			//For Opposed rolls that rely on a Target Number generated by a second Entity such as Ridicule(Villain calling out Hero), Quickness(Showdown), Strength(Grappling an opponent)
			case "Opposed":
				this.rollOpposed();
				break;
			default:
				System.out.println("rollTypeString not recognized");;
				break;	
		}
		
		
	}

	private void rollTrait() {
		// TODO Auto-generated method stub
		
	}

	private void rollConcentrations() {
		// TODO Auto-generated method stub
		
	}


	
	private void rollOpposed() {
		// TODO Auto-generated method stub
		
	}




	/**
	 * @return the rollTypeString
	 */
	public String getRollTypeString() {
		return rollTypeString;
	}

	/**
	 * @param rollTypeString the rollTypeString to set
	 */
	public void setRollTypeString(String rollTypeString) {
		this.rollTypeString = rollTypeString;
	}

	/**
	 * @return the rollDiceString
	 */
	public String getRollDiceString() {
		return rollDiceString;
	}

	/**
	 * @param rollDiceString the rollDiceString to set
	 */
	public void setRollDiceString(String rollDiceString) {
		this.rollDiceString = rollDiceString;
	}

	/**
	 * @return the rollTargetNumberInt
	 */
	public int getRollTargetNumberInt() {
		return rollTargetNumberInt;
	}

	/**
	 * @param rollTargetNumberInt the rollTargetNumberInt to set
	 */
	public void setRollTargetNumberInt(int rollTargetNumberInt) {
		this.rollTargetNumberInt = rollTargetNumberInt;
	}

	/**
	 * @return the rollHighestInt
	 */
	public int getRollHighestInt() {
		return rollHighestInt;
	}

	/**
	 * @param rollHighestInt the rollHighestInt to set
	 */
	public void setRollHighestInt(int rollHighestInt) {
		this.rollHighestInt = rollHighestInt;
	}

	/**
	 * @return the rollBustFlag
	 */
	public boolean isRollBustFlag() {
		return rollBustFlag;
	}

	/**
	 * @param rollBustFlag the rollBustFlag to set
	 */
	public void setRollBustFlag(boolean rollBustFlag) {
		this.rollBustFlag = rollBustFlag;
	}

	/**
	 * @return the rollSuccessFlag
	 */
	public boolean isRollSuccessFlag() {
		return rollSuccessFlag;
	}

	/**
	 * @param rollSuccessFlag the rollSuccessFlag to set
	 */
	public void setRollSuccessFlag(boolean rollSuccessFlag) {
		this.rollSuccessFlag = rollSuccessFlag;
	}

	/**
	 * @return the rollRaisesInt
	 */
	public int getRollRaisesInt() {
		return rollRaisesInt;
	}

	/**
	 * @param rollRaisesInt the rollRaisesInt to set
	 */
	public void setRollRaisesInt(int rollRaisesInt) {
		this.rollRaisesInt = rollRaisesInt;
	}

	/**
	 * @return the rollAwardChip
	 */
	public boolean isRollAwardChip() {
		return rollAwardChip;
	}

	/**
	 * @param rollAwardChip the rollAwardChip to set
	 */
	public void setRollAwardChip(boolean rollAwardChip) {
		this.rollAwardChip = rollAwardChip;
	}

	/**
	 * @return the rollResultArrayListInteger
	 */
	public ArrayList<Integer> getRollResultArrayListInteger() {
		return rollResultArrayListInteger;
	}

	/**
	 * @param rollResultArrayListInteger the rollResultArrayListInteger to set
	 */
	public void setRollResultArrayListInteger(ArrayList<Integer> rollResultArrayListInteger) {
		this.rollResultArrayListInteger = rollResultArrayListInteger;
	}

	/**
	 * @return the rollArrayListEntity
	 */
	public ArrayList<Entity> getRollArrayListEntity() {
		return rollArrayListEntity;
	}

	/**
	 * @param rollArrayListEntity the rollArrayListEntity to set
	 */
	public void setRollArrayListEntity(ArrayList<Entity> rollArrayListEntity) {
		this.rollArrayListEntity = rollArrayListEntity;
	}

	/**
	 * @return the rollTotalInt
	 */
	public int getRollTotalInt() {
		return rollTotalInt;
	}

	/**
	 * @param rollTotalInt the rollTotalInt to set
	 */
	public void setRollTotalInt(int rollTotalInt) {
		this.rollTotalInt = rollTotalInt;
	}
	
	
	
	
}
	
	/*
	public static void main(String[] args)
	{
	
	
	//Create Scanner object for user input
	Scanner scannerUserInput = new Scanner(System.in);		
	
	//Create Random object 
	Random randomNumberGeneration = new Random();
	
	//Declare list to hold dice rolls
	ArrayList<Integer> rollListInts = new ArrayList<Integer>();
					
	//Declare ints 
	int diceTypeInt = 0, 			//to hold the number of dice sides(Dice Type) 
		diceNumberTotalInt = 0,		//total number of dice to roll
		diceRollInt = 0,			//generated roll of one die
		bustCounter = 0,			//used to keep track of the number of 1's rolled
		rollListIntsTotal = 0;		//total of all the dice in the roll list
	
	//Declare Strings
	String fateChipString = null;	//used to decide what type of fate chip to use on the roll
	
	boolean bustBoolean = false;
	
	
	//Prompt User for total number of dice to roll
	System.out.print("Please enter the number of dice you which to roll: ");
	
	//Convert User Input to dice number total
	diceNumberTotalInt = scannerUserInput.nextInt();
	System.out.println();
	
	//Prompt User for die type input
	System.out.print("Please enter the die type of either 4, 6, 8, 10, 12, 20, 100 to roll: ");
	
	//Convert user input to number of dice sides
	diceTypeInt = scannerUserInput.nextInt();
	System.out.println();
			
	//Roll diceNumberTotalInt times
	for(int i = 0; i < diceNumberTotalInt; i++)
	{
		
		//Generate the number between 1 and the diceTypeInt
		diceRollInt = randomNumberGeneration.nextInt(diceTypeInt) + 1;
					
		//Add the roll of the die to the list of dice rolls
		rollListInts.add(diceRollInt);
		
		//Counter for sum of all rolls made
		rollListIntsTotal += diceRollInt;
		
		//Counter for checking if you are going to bust
		if(diceRollInt == 1)
		{
			bustCounter++;
		}
	}
	
	//Prompt the roll of dice
	System.out.print("You rolled: " + rollListInts + "\n\n");

	//Prompt sum of dice roll
	System.out.println("The sum of the roll was: " + rollListIntsTotal);
	
	//If bustCounter is greater than (rollListInts.size / 2) then prompt bust
	if(bustCounter > ((double) rollListInts.size() / 2.0))
	{
		System.out.println("\nYou dun bust!");
		bustBoolean = true;
		
	}
	
	
	if(bustBoolean == false)
	{
	//Prompt the user to spend a fate chip
	System.out.print("\nPlease choose the type of fate chip would you like to spend on this roll; white, red, blue, legend, or none: ");

	scannerUserInput.reset();
	
	//Convert User Input to switch statement argument
	fateChipString = scannerUserInput.next();


				
		//Switch state for set of fate chip rules
		switch(fateChipString.toUpperCase())
		{

			case "WHITE":
				System.out.println("\nYou chose to use a white fate chip on this roll.");
				
				//White Chip Logic
				//Generate the number between 1 and the diceTypeInt
				diceRollInt = randomNumberGeneration.nextInt(diceTypeInt) + 1;
				
				//Print out new single dice roll
				System.out.printf("\nYour white chip fate die rolled: %s \n\n", diceRollInt);
				
				//Add the roll of the die to the list of dice rolls
				rollListInts.add(diceRollInt);
				
				//Prompt the the new roll
				System.out.print("Your new roll is: " + rollListInts + "\n\n");

				
				break;
			case "RED":
				System.out.println("\nYou chose to use a red fate chip on this roll.");
							
				
				//Red Chip Logic
				
				break;	
			case "BLUE":
				System.out.println("\nYou chose to use a blue fate chip on this roll.");
				
				//Blue Chip Logic
				//Generate the number between 1 and the diceTypeInt
				diceRollInt = randomNumberGeneration.nextInt(diceTypeInt) + 1;
				
				//Print out new single dice roll
				System.out.printf("\nYour white chip fate die rolled: %s \n\n", diceRollInt);
				
				//Add the roll of the die to the list of dice rolls
				rollListInts.add(diceRollInt);
				
				//Prompt the the new roll
				System.out.print("Your new roll is: " + rollListInts + "\n\n");
				
				break;
			case "LEGEND":
				System.out.println("\nYou chose to use a legend fate chip on this roll.");
				
				//Legend Chip Logic
				
				break;
				
			case "N":
			case "NO":				
			case "NONE":
				System.out.println("\nYou chose not to use a fate chip on this roll.");
				break;	
				
			default:
				System.out.println("\nWoah there, pardner... put the spook juice down.");
				System.out.println("\nFate is a fickle mistress... wasting her time with nonsense is an sure way to a dirt nap.");
				break;				
		}
	
	}

int[] someArray = new int[]{8,9,1,6,1,6,6,2,3,4,6};	
	
	Arrays.sort(someArray);
	
	int sumOfArray = someArray[someArray.length - 1] + someArray[someArray.length-2];
	
	System.out.println(sumOfArray);

	
	
	
	//close scanner object
	scannerUserInput.close();
	
}

	
}

*/