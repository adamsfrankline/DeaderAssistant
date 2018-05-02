import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * This class is a Bean that represents a deck of cards that can be used for various aspect such as combat initiative, character creation, mutations... etc.
 * 
 * The deck consist of an ArrayList of Card enums, which group owns this current deck, and the type of Deck this is being used for.
 * 
 * Internal methods that can be invoked:
 * deckShuffle() - Can be invoked to shuffle a deck using the Collections.shuffle()
 * deckPrint() - Can be invoked to print the deckOwner, deckType, and all the cards within the deck in descending initiative value.
 *  
 *  
 * @author Franklin Adams
 *
 */


public class Deck {

	//Declare the current owner for this deck
	private String deckOwner;	//Entity, Players, Marshals
	
	//Declare the current type for this deck
	private String deckType;	//GenericDeck, ActionDeck, CharacterCreationDeck, MutationsDeck, VeteransDeck
	
	//Declare ArrayList to hold current cards in the deck
	private ArrayList<Cards> deckCurrentCardsArrayList = new ArrayList<Cards>(); //Cards.S4, Cards.HJ, Cards.RJ...

	//Declare the boolean flag for the need to reshuffle the deck
	private boolean deckReshuffleFlag = false; //true, false

	//Declare the reason for needing a reshuffle of this current deck.
	private String deckJokerPulledString = "Not Needed"; //Red Joker was pulled, Black Joker was pulled, Deck is out of cards, Not Needed...
	

	//Constructor for the owner of the deck, type of deck to be used, and the players associated to it
	public Deck(String dOwner, String dType)
	{
		this.deckOwner = dOwner;
		this.deckType = dType;
		this.deckShuffle();
		
	}
	
	//Assign cards to the current deck and shuffle the deck of cards
	public void deckShuffle()
	{
		
		//Remove current cards from the deck(if any)
		deckCurrentCardsArrayList.clear();
		
		//Get the cards from the Cards enum and put them in the deckCurrentCardsArrayList
		for(Cards c : Cards.values() )
		{
			deckCurrentCardsArrayList.add(c);
		}
		
		//Shuffle this deck 
		Collections.shuffle(deckCurrentCardsArrayList);
		
		//Turn off the need to reshuffle this deck
		deckReshuffleFlag = false;
		
	}
	
	//Assign cards from the Current deck to an Entity
	public void pullCards(Entity e, int numberOfCardsInt)
	{
		//Declare Iterator of Cards type in the Deck's current array list of Cards
		Iterator<Cards> iCards = deckCurrentCardsArrayList.iterator();
		
		//Iterator through the current Deck of Cards
		while(iCards.hasNext())
		{
						
			//If the number of cards to assign is 0
			if(numberOfCardsInt == 0)
			{
								
				//Stop assigning any cards to entity
				break;
			}
			else
			{			
				//Print out the top card from the deck				
				if(deckCurrentCardsArrayList.get(0).getCardSuitString() == Cards.JR.getCardSuitString())
				{
					
					//Set the state of the Deck to needing to be reshuffled
					this.setDeckReshuffleFlag(true);
					
					//Set the reason of the deck to having to be reshuffled due to a Red joker being pulled
					this.setDeckJokerPulledString("Red Joker was pulled");
						
	
				}
				
				//If the card to be assigned is a Black Joker
				if(deckCurrentCardsArrayList.get(0).getCardSuitString() == Cards.JB.getCardSuitString())
				{
					//Set the state of the Deck to needing to be reshuffled
					this.setDeckReshuffleFlag(true);
					
					//Set the reason of the deck to having to be reshuffled due to a Black joker being pulled
					this.setDeckJokerPulledString("Black Joker was pulled");
					
				}
				
				//assign the top card from the deck to the entities hand
				e.getEntityActionHandArrayListCards().add(deckCurrentCardsArrayList.get(0));			

				//Remove the top card from the deck
				deckCurrentCardsArrayList.remove(0);
				
				//Reduce the numbers of cards to assign by 1
				numberOfCardsInt--;

				
			}
		}
		
	}
	
	//Get information about the current deck
	public void deckPrint()
	{
		//Print who owns the deck
		System.out.printf("This deck is owned by %s.\n",  deckOwner);
		
		//Print what type of deck it is for
		System.out.printf("This deck type is %s.\n",  deckType);
		
		//Print the need to reshuffle this deck based off the reshuffle flag
		System.out.printf("This deck needs to be reshuffled? %s\n",  deckReshuffleFlag ? "Yes" : "No");
		
		//Print out the reason for the reshuffle
		System.out.printf("Reason for reshuffling: %s\n", deckJokerPulledString);
		
		//Display the current cards in the deck
		System.out.printf("\nOrdered from first pull to last out of %d cards:\n", deckCurrentCardsArrayList.size());
		
		//Iterator used to place punctuation into the print list.
		int iPunctuation = 0;
		
		for(Cards s: deckCurrentCardsArrayList)
		{	
			System.out.printf("%s of %s", s.getCardFaceString(), s.getCardSuitString());
			
			//Add a comma after every element except the last element
			if(iPunctuation % deckCurrentCardsArrayList.size() < deckCurrentCardsArrayList.size()-1)
			{
				System.out.print(", ");
			}
			//Add a newline after every 5 cards
			if(iPunctuation % 5 == 4)
			{
				System.out.println();
			}
			//Add a period and new lines to the end of your sentence, pardner.
			if(iPunctuation % deckCurrentCardsArrayList.size() == deckCurrentCardsArrayList.size()-1)
			{
				System.out.print(".\n");
			}
			//iterate the punctuation iterator
			iPunctuation++;
		}
		
	
		
	}

	
	/**
	 * @return the deckReshuffleFlag
	 */
	public boolean isDeckReshuffleFlag() {
		return deckReshuffleFlag;
	}

	/**
	 * @param deckReshuffleFlag the deckReshuffleFlag to set
	 */
	public void setDeckReshuffleFlag(boolean deckReshuffleFlag) {
		this.deckReshuffleFlag = deckReshuffleFlag;
	}

	/**
	 * @return the deckJokerPulledString
	 */
	public String getDeckJokerPulledString() {
		return deckJokerPulledString;
	}

	/**
	 * @param deckJokerPulledString the deckJokerPulledString to set
	 */
	public void setDeckJokerPulledString(String deckJokerPulledString) {
		this.deckJokerPulledString = deckJokerPulledString;
	}

	
	
	
}
