import java.util.Collections;
import java.util.Comparator;

public class HeroDemo extends Entity {

	public HeroDemo(String eNameFull, String eAlias, String eOccupation) {
		super(eNameFull, eAlias, eOccupation);
		// TODO Auto-generated constructor stub
		//Assign the Names and Occupation of the entity given
		super.extractEntityNamesAndOccupation(eNameFull, eAlias, eOccupation);
				
		//Pull cards for this entity
		pullCharacterCreationCards();
		
		//Assign the Starting Skills
		super.assignStartingAptitudes();
		
		//Calculate the Aptitude points
		calculateInitalAptitudePoints();
		
	}

	//Randomly assign 10 cards to an entity's Traits
	public void pullCharacterCreationCards() {

		//Tell the User what teh entity named them selves, what their alias is, and what do they do in the wastes
		System.out.printf("%s decides that he wants to go by \"%s\" and be known for a \"%s\"\n\n", getEntityNameFull(), getEntityAlias(), getEntityOccupation());
		
		//Tell the user who has a deck and that they shuffle it
		System.out.printf("%s grabs a fresh deck and shuffles the cards...\n", getEntityNameFirst());
		
		//Create the Character Creation deck
		Deck characterCreationDeck = new Deck(this.getEntityAlias(), "CharacterCreation");
				
		//Tell the user the entity will now pull 12 cards
		System.out.printf("M%s. %s will now draw 12 cards from the deck...\n",  (getEntitySex().toUpperCase()).equals("MALE") ? "r":"s", getEntityNameLast());
		
		//Pull 12 cards from the deck
		characterCreationDeck.pullCards(this, 12);
		
		//Show the user the Entity's hand
		this.printEntityHand();
		
		//Sort the cards within the etity's hand first by the Trait's lowest value, then by the Coordination lowest value 
		getEntityActionHandArrayListCards().sort(Comparator.comparing(Cards::getCardTraitInt).thenComparing(Cards::getCardCoordinationInt));
		
		//Tell the User that the entity has sorted the cards and then show the cards
		System.out.printf("\n%s will now sort the cards in groups of Trait Values and then by lowest Coordination Value... (hold on to your boots, there will be more on those terms later!\n)", getEntityNameFirst());
		this.printEntityHand();
		
		//Remove the 2 lowest card values from your hand that are not 2's or Jokers
		//Start by putting taking the top card out and making a copy of it in your sleeve
		getEntityHandTopCardSlipDeucesInSleeveKeepCards();
		
		//Capture the 2 cards the entity will throw away
		Cards discardCardOne;
		Cards discardCardTwo;
		
		//If the top card is not a 2(meaning there are no 2's dealt this character creation deck pull of 12 cards)
		if(entityTopCardCards.getCardFaceString() != "2")
		{
			//Capture and Remove the first card from the top of the deck
			discardCardOne = getEntityActionHandArrayListCards().get(0);
			getEntityActionHandArrayListCards().remove(0);
			
			//Capture and Remove the second card from the top of the deck
			discardCardTwo = getEntityActionHandArrayListCards().get(0);
			getEntityActionHandArrayListCards().remove(0);
		}
		//If the top card is a 2
		else
		{
			//So long as the entity's top card is a 2
			while(entityTopCardCards.getCardFaceString() == "2")
			{
				//Place that 2 in the back of the entity's hand(and make the top card the next card after the current 2 found)
				getEntityHandTopCardSlipDeucesInSleeveKeepCards();
			}
			
			//Capture and Remove the first card from the top of the deck
			discardCardOne = getEntityActionHandArrayListCards().get(0);
			getEntityActionHandArrayListCards().remove(0);
			
			//Capture and Remove the second card from the top of the deck
			discardCardTwo = getEntityActionHandArrayListCards().get(0);
			getEntityActionHandArrayListCards().remove(0);
		}
				
		
		//Tell the User that the entity is removing these 2 cards
		System.out.printf("\n%s decides he wants to discard these two cards(remember he cannot discard Deuces or Jokers!): ", getEntityNameFirst());
		System.out.printf("[%s]", discardCardOne.name());
		System.out.printf("[%s]\n", discardCardTwo.name());
		this.printEntityHand();
				
		//Shuffle the cards in the hand
		Collections.shuffle(entityActionHandArrayListCards);

		//Tell the user what Traits the entity has assign from these cards
		System.out.printf("\n%s then decides to assign a single card to each of the 10 traits:\n", getEntityNameFirst());
		
		//Pull a random card for the Joker if one exists and update the associated Trait's Suit
		super.pullEntityCharacterCreationHandJokersCard();		
		
		//Assign the cards from the entity's hand to the entity's Traits	
		super.assignEntityTraits();
		
		
		//Print out the Entity's Traits Card Values
		this.printEntityStatsTraitCardNames();
		

		
		//Clear the hand and associated cards
		entityActionHandArrayListCards.removeAll(getEntityActionHandArrayListCards());
		entityTopCardCards = null; 
		entitySleevedCard = null;
		
		//Calculate the Aptitude points
		super.calculateInitalAptitudePoints();
	}
	
	
}
