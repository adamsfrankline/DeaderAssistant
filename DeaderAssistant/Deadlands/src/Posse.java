import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is a Bean that represents a group of people known as a "Posse" that can be used for various aspect such as combat teams, town groups, minion association...
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
public class Posse {

	//A posse can have a name
	private String posseName; //Heros, Villians, Townfolk, Dirt Road Raiders, Swarm of HeadHunters
	
	//A posse can have a list of Entities
	private ArrayList<Entity> posseArrayList = new ArrayList<Entity>(); 
	
	//A posse can have an ActionDeck
	private Deck posseDeck;
	
	public Posse(String pName, ArrayList<Entity> pArrayList)
	{
		this.setPosseName(pName);
		this.setPosseArrayList(pArrayList);
		this.setPosseDeck(posseDeck = new Deck(pName, "ActionDeck"));
		
	}
	
	//Assign cards from the Posse's curent deck to each of the posse entities
	public void assignCards()
	{
		
		//if the deck indicates it needs a shuffle, give it one
		if(posseDeck.isDeckReshuffleFlag() == true)
		{
			//Annouce the need to reshuffle the deck
			System.out.printf("Reshuffling deck due to: %s\n\n", posseDeck.getDeckJokerPulledString());
			
			//Shuffle the deck before pulling cards
			posseDeck.deckShuffle();
		}
		
		//Announce card assignments
		System.out.printf("\n%s has been dealt the following cards:\n\n", this.getPosseName());
		
		//For each entity in the posse
		for(Entity e: posseArrayList)
		{
			//Have Entity roll quickness
			//int quicknessRollInt = e.rollDice();
						
			//Pull the number of cards based on the previous quickness roll and to be assigned to the Entities hand
			posseDeck.pullCards(e, 3);
			
			//Sort the Entity's hand from highest card to lowest card
			Collections.sort(e.getEntityActionHandArrayListCards());
			
			//Print the entities hand
			e.printEntityHand();
		}
		
				
	}

	
	public void printPosseStats()
	{
		System.out.println();
		System.out.printf("%s posse consists of ", this.getPosseName());
		
		//iterator for punctuation
		int iPunctuation = 0;
		//Size of the array list
		int posseArrayListSize = this.getPosseArrayList().size();
		
		for(Entity e : this.getPosseArrayList())
		{
			System.out.print(e.getEntityNameFull());
			
			//Put an "and" between all posse members up until the second to last element
			if(iPunctuation % posseArrayListSize < posseArrayListSize - 1)
			{
				System.out.print(", ");
			}
			//
			if(iPunctuation % posseArrayListSize == posseArrayListSize - 2)
			{
				System.out.print("and ");
			}
			//
			if(iPunctuation % posseArrayListSize == posseArrayListSize - 1)
			{
				System.out.print(".\n\n");
			}
			//Iterate  punctuation the iterator
			iPunctuation++;
			
		}
		
		
	}
	
	
	/**
	 * @return the posseName
	 */
	public String getPosseName() {
		return posseName;
	}

	/**
	 * @param posseName the posseName to set
	 */
	public void setPosseName(String posseName) {
		this.posseName = posseName;
	}

	/**
	 * @return the posseArrayList
	 */
	public ArrayList<Entity> getPosseArrayList() {
		return posseArrayList;
	}

	/**
	 * @param posseArrayList the posseArrayList to set
	 */
	public void setPosseArrayList(ArrayList<Entity> posseArrayList) {
		this.posseArrayList = posseArrayList;
	}

	/**
	 * @return the posseDeck
	 */
	public Deck getPosseDeck() {
		return posseDeck;
	}

	/**
	 * @param posseDeck the posseDeck to set
	 */
	public void setPosseDeck(Deck posseDeck) {
		this.posseDeck = posseDeck;
	}



	
}
