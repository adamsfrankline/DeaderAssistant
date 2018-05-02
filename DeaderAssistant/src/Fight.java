import java.util.ArrayList;
import java.util.Date;

public class Fight {

	//Record the current Date and Time of the Fight to expose to the historylogs
	Date FightCurrentDateTime = new Date();
	
	//A Fight will have at list two 2 Posses
	ArrayList<Posse> FightPossesArrayListPosse = new ArrayList<Posse>();
	
	//A Fight will have a list of rounds to expose to the history logs
	ArrayList<Rounds> FightRoundArrayListRounds= new ArrayList<Rounds>();
	
	public Fight(Posse pOne, Posse pTwo)
	{
		this.FightPossesArrayListPosse.add(pOne);
		this.FightPossesArrayListPosse.add(pTwo);

		//Print out who is assigned to this Fight
		System.out.printf("\nFight began between %s and %s on %tc.\n", pOne.getPosseName(), pTwo.getPosseName(), FightCurrentDateTime);
		
	}
	
	/**
	 * @return void Begin the Fight sequence
	 */
	public void beginFight()
	{
		
		
		//Call the rounds
		//do{
			//Call the First round
			Rounds currentRound = new Rounds(1, FightPossesArrayListPosse);
			
			currentRound.runRounds();
			
		//}
		//while()
		//{
			
		//}
		
		
		
	}
	
}
