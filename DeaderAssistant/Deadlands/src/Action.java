//Actions are performed by an entity(or between multiple entities) and can contain various roll objects rolled(and/or card objects pulled) to determine what outcomes have occurred due to an action's specifications.
public class Action {

	//An action can have an Entity performing the action(actioner)
		Entity actionActioner;
	
	//An action can have a single Entity having the action performed on(actionee)
		Entity actionActionee;
	
	//An action can have a multiple Entities having the action performed on(actionees)
		Entity actionActionees;
		
	
	//Entity performs an action by itself(moves, 
	Action(Entity aEntity, String aAptitude){
		
		
		
		
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
