import java.util.ArrayList;

public class Rounds {
	
	//A round can have a current round number
	private int roundsNumberInt = 0; //1,2,3,4,5...
	
	//A round will have its own deck to call cards out each round
	private Deck roundsCardCallDeck; //Deck<Cards>("Round " + Integer.toString(roundsNumberInt), "RoundsDeck" )
	
	//A round will have its current card it is on
	private Cards roundsCurrentCard = Cards.JR;
	
	//A round will have at list of at least 2 Posses acting on each other
	ArrayList<Posse> roundsPossesArrayListPosse;

	//A round will have a list of one or more Entities that represents the players involved in that segment
	//ArrayList<Entity> possesEntityArrayListEntity;

	
	//A round will have current Entity to perform an Action
	//Entity roundsCurrentEntity;

	public Rounds(int rNumberInt, ArrayList<Posse> rPossesArrayListPosse)
	{
		this.setRoundsNumberInt(rNumberInt);
		this.roundsPossesArrayListPosse = rPossesArrayListPosse;		
	}
	
	
	//Run the round
	public void runRounds()
	{
		//Print the Rounds number
		System.out.printf("Round %d begins:\n", this.getRoundsNumberInt());

		//Deal cards from their own decks based on quickness roll
		dealCards();
		
		//Split round into segments
		splitRound();
		
	}

	
	
	
		
	private void splitRound() {
		
		//Announce Phase split segments
		System.out.println("\nPhase: Split Rounds into Segments");
		
		
		
				//Iterate though the all cards within the Enum Cards
				for(Cards c : Cards.values())
				{
					
					//If the current card from the deck is the same as the last card or is a Red/Black joker 
					if( c.getCardFaceString() == roundsCurrentCard.getCardFaceString() ||
						c.getCardFaceString() == Cards.JR.getCardFaceString() ||
						c.getCardFaceString() == Cards.JB.getCardFaceString())
					{			
						//Skip this Card Call and
						//Iterate to the next card from the values designated in the Enum Cards
						roundsCurrentCard = c;
					}
					else
					{
						//Call out the card representing which ActionCard can now be played from the posses Action deck
						System.out.printf("\nSegment: %s's!\n\n", c.getCardFaceString());
						
						//Begin a new Segment of the Fight on the current card of the round
						@SuppressWarnings("unused")
						Segment segment1 = new Segment(c, roundsPossesArrayListPosse);
						
						//
						
						
						//Iterate to the next card from the values designated in the Enum Cards
						roundsCurrentCard = c;
						
					}
					
					
					
				}
	}


	/**
	 * @param the dealCards
	 */
	public void dealCards() {

		//Announce the Dealing Cards phase
		System.out.println("Phase: Deal Cards");
		
		//For each posse in the round's posse array list
		for(Posse p: roundsPossesArrayListPosse)
		{
			//Have the posse assign cards from its own deck
			p.assignCards();
		}
	
	
		
	}
		
	/**
	 * @return the roundsNumberInt
	 */
	public int getRoundsNumberInt() {
		return roundsNumberInt;
	}

	/**
	 * @param roundsNumberInt the roundsNumberInt to set
	 */
	public void setRoundsNumberInt(int roundsNumberInt) {
		this.roundsNumberInt = roundsNumberInt;
	}



	/**
	 * @return the roundsCardCallDeck
	 */
	public Deck getRoundsCardCallDeck() {
		return roundsCardCallDeck;
	}



	/**
	 * @param roundsCardCallDeck the roundsCardCallDeck to set
	 */
	public void setRoundsCardCallDeck(Deck roundsCardCallDeck) {
		this.roundsCardCallDeck = roundsCardCallDeck;
	}


	
}
