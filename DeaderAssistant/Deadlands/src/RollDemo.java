import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class RollDemo {

	//Create Random object to base the rolls off of
	Random randomNumberGeneration = new Random();

	//A roll can have a dice number
	private int rollDiceNumber;
	
	//A roll can have a die type
	private int rollDieType;
	
	//A roll can have bonus to apply
	private int rollBonus;
	
	//A roll can have a single highest value
	private int rollHighestInt = 0; //4, 5, 2....
	
	//A roll can have a total value
	private int rollTotalInt = 0; //4, 15, 206....
	
	//A roll can have a current Die total being rolled
	private int dieTotal = 0;
		
	//A roll can bust(get more 1's in a roll by half of the number of dice total)
	private boolean rollBustBoolean = false; //true, false
	
	//A roll can have a result list of each die rolled
	private ArrayList<Integer> rollResultArrayListInteger = new ArrayList<Integer>();//5,6,7,8,23,1

//Constructor	
	
	/**
	 * @param rollDiceString
	 */
	public RollDemo(int rDiceNumber, int rDiceType, int rBonus) {
		this.rollDiceNumber = rDiceNumber;
		this.rollDieType = rDiceType;
		this.rollBonus = rBonus;
		
		this.rollBones();

	}

	/**
	 * @param rollDiceString
	 */
	public RollDemo(int rDiceNumber, int rDiceType) {
		this.rollDiceNumber = rDiceNumber;
		this.rollDieType = rDiceType;
		
		this.rollBonesStandard();

	}


//Methods
	
	private void rollBonesStandard() {
		
		//Create the current Die Rolled int
		int dieRolled = 0;
		
		//For each number of Dice to roll
		for(int i = 0; i < this.getRollDiceNumber(); i++)
		{
			//Generate the number between 1 and the diceTypeInt
			dieRolled = (randomNumberGeneration.nextInt(this.rollDieType) + 1);
			
			//Add the roll of the die to the list of dice rolls
			rollResultArrayListInteger.add(dieRolled);
			
			//Counter for sum of all rolls made
			rollTotalInt += dieRolled;
			
		}
		
		//Find the Highest value in the roll
		Collections.sort(rollResultArrayListInteger, Collections.reverseOrder());
		
		//Set the new highest roll value and add any bonus given to the roll
		this.setRollHighestInt((int) rollResultArrayListInteger.get(0) + this.getRollBonus());
		
	}
	
	//Roll them bones! Return the results to the Roll Objects attributes
	private void rollBones() 
	{
		
		//Create the current Die Rolled int
		int dieRolled = 0;
		
		//Create the Bust Counter
		int bustCounter = 0;
		
		//For each number of Dice to roll
		for(int i = 0; i < this.getRollDiceNumber(); i++)
		{
			
			System.out.println("\nDie #" + (i + 1) + " roll(s): ");
			
			//Roll the single dice with Exploding die rules
			dieRolled = rollExplodeDie();

			//Add the roll of the die to the list of dice rolls
			rollResultArrayListInteger.add(dieRolled);
			
			//Counter for sum of all rolls made
			rollTotalInt += dieRolled;
			
			//Counter for checking if you are going to bust
			if(dieRolled == 1)
			{
				bustCounter++;
			}
			
		}
		
		//If bustCounter is greater than number of dice rolled then set roll to bust status as True
		if(bustCounter > ((double) rollResultArrayListInteger.size() / 2.0))
		{
			this.setRollBustBoolean(true);
		}
		
		//Find the Highest value in the roll
		Collections.sort(rollResultArrayListInteger, Collections.reverseOrder());
		
		//Set the new highest roll value and add any bonus given to the roll
		this.setRollHighestInt((int) rollResultArrayListInteger.get(0) + this.getRollBonus());
		
	}
	
	//Exploding Die roll
	private int rollExplodeDie()
	{
		
		//Generate the number between 1 and the diceTypeInt
		int currentDieRolled = randomNumberGeneration.nextInt(this.rollDieType) + 1;
		System.out.println("You rolled a " + currentDieRolled + ".");
		
		//If the die rolled is the same as the die type, reroll that bone!
		if(currentDieRolled == rollDieType)
		{
			//Reroll!
			rollExplodeDie();
		
			//Return the new total
			return dieTotal += currentDieRolled;
		}
		//Just return the roll
		else
			return dieTotal = currentDieRolled;
	}


//Print methods
	
	//Print the Roll object as a sentence 
	public void printRoll() {

		System.out.printf("rolled %dD%d+%d: Highest Roll = %d Total Roll = %d Busted? %s",
							this.getRollDiceNumber(), this.getRollDieType(), this.getRollBonus(),
							this.getRollHighestInt(), this.getRollTotalInt(), this.isRollBustBoolean() ? "Yes" : "No"
				);
		
	}
	

//Getters and setters
	

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

	/**
	 * @return the rollDiceNumber
	 */
	public int getRollDiceNumber() {
		return rollDiceNumber;
	}

	/**
	 * @param rollDiceNumber the rollDiceNumber to set
	 */
	public void setRollDiceNumber(int rollDiceNumber) {
		this.rollDiceNumber = rollDiceNumber;
	}

	/**
	 * @return the rollDieType
	 */
	public int getRollDieType() {
		return rollDieType;
	}

	/**
	 * @param rollDieType the rollDieType to set
	 */
	public void setRollDieType(int rollDieType) {
		this.rollDieType = rollDieType;
	}

	/**
	 * @return the rollBonus
	 */
	public int getRollBonus() {
		return rollBonus;
	}

	/**
	 * @param rollBonus the rollBonus to set
	 */
	public void setRollBonus(int rollBonus) {
		this.rollBonus = rollBonus;
	}

	/**
	 * @return the rollBustBoolean
	 */
	public boolean isRollBustBoolean() {
		return rollBustBoolean;
	}

	/**
	 * @param rollBustBoolean the rollBustBoolean to set
	 */
	public void setRollBustBoolean(boolean rollBustBoolean) {
		this.rollBustBoolean = rollBustBoolean;
	}
	
	
	
}