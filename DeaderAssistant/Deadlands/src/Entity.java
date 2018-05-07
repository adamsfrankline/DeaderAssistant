import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public abstract class Entity {

//Properties
	
	//Entity can have Names, an Alias, and an Occupation
	
		//Entity can have many Names 
	
			private String entityNameFull; 									//What an entity get called by their momma 
			private String entityNameFirst; 								//Entity First Name
			private ArrayList<String> entityNameMiddleArrayList = new ArrayList<String>(); 	//What other names the Entity Has
			private String entityNameLast; 									//Entity Last name
		
		//Entity can have one Alias	
			
			private String entityAlias; 									//What an entity goes by in the wastes
		
		//Entitiy can have one Occupation	
			
			private String entityOccupation; 								//What an entity does for a livin'
		
		//Entity can have one Sex	
			
			private String entitySex = "Male"; 								//What planet to you align with? Mars(men) or Venus(women)?
	
	//Entity can have many Mental Traits
		
		//Cognition: Perception and general alertness
			private Trait entityTraitCognition;									
			private Cards entityTraitCognitionCard; 						//Card Pulled during Character Creation
		
		//Knowledge: Education from book-learnin'and experience.
			
			private Trait entityTraitKnowledge;
			private Cards entityTraitKnowledgeCard; 						//Card Pulled during Character Creation
		
		//Mien: Presence and influence, as well as charisma and how the entity is regaurded by others

			private Trait entityTraitMien;
			private Cards entityTraitMienCard; 								//Card Pulled during Character Creation

			
		//Smarts: Wits and deduction. The is the ability to figure things out or piece together clues.

			private Trait entityTraitSmarts;
			private Cards entityTraitSmartsCard; 							//Card Pulled during Character Creation

		
		//Spirit: Psyche and spiritual presence.
	
			private Trait entityTraitSpirit;
			private Cards entityTraitSpiritCard; 							//Card Pulled during Character Creation
		
	//Entity can have many Corporeal Traits
		
		//Deftness: Hand eye coordination and manual dexterity.
			
			private Trait entityTraitDeftness;		
			private Cards entityTraitDeftnessCard;							//Card Pulled during Character Creation
		
		//Nimbleness: Agility and overall physical prowess.
			
			private Trait entityTraitNimbleness;
			private Cards entityTraitNimblenessCard; 						//Card Pulled during Character Creation
		
		//Strength: Raw muscle, brawn, and how well an entity uses it.
		
			private Trait entityTraitStrength;
			private Cards entityTraitStrengthCard; 							//Card Pulled during Character Creation
		
		//Quickness: Reflexes, speed, and the ability to concentrate during stressful situations
			
			private Trait entityTraitQuickness;
			private Cards entityTraitQuicknessCard;							//Card Pulled during Character Creation
		
		//Vigor: Endurance and constitution
			
			private Trait entityTraitVigor;
			private Cards entityTraitVigorCard; 							//Card Pulled during Character Creation
		
	//Entity can have a Character Creation Red and/or Black Joker pull... Card value(used for ArcaneBackgrounds, Mutations, and Coordination Value determination)
		
		private Cards entityRedJokerPullCard = null;						//Red Jokers are generally considered to have unpredictably GOOD outcomes
		private Cards entityBlackJokerPullCard = null;						//Black Jokers are generally considered to have unpredictably BAD outcomes

	//Entity can have one hand of Cards
		
		ArrayList<Cards> entityActionHandArrayListCards = new ArrayList<Cards>();	
		
	//Entity can have a single Card at the top of their hand that is not held up the sleeve	
		
		Cards entityTopCardCards; 
		
	//Entity can have a card up its sleeve(which should be treated as the highest value card regardless of its true value)
		
		Cards entitySleevedCard;

	//Entity can have a Many traits
		
		private Map<Traits, Trait> entityTraitsTraitsTraitHashMap = new HashMap<Traits, Trait>();
		
	//A Entity can have Aptitude Points in which to spend on increasing the characters Aptitudes(Traits, Skills, Edges, Hindrances, Grit)
		
		private int entityAptitudePoints; 									//1, 2, 3, 4, 5, 6...
		
	//A Entity can have Bounty Points in which get converted from chip values into Aptitude points to spend later 
		
		private int entityBountyPoints; 									//1, 2, 3, 4, 5, 6...
	
	//An entity can have size, which is the physical size of the Entity that can be made of locations and each location can hold gear.
		
		private Size entitySize = new Size(); //Humanoids are a 6 by default, but this can be anywhere from 0-20
		
		


		
//Constructor for an Entity
	public Entity(String eNameFull, String eAlias, String eOccupation)
	{
		//Assign the Names and Occupation of the entity given
		extractEntityNamesAndOccupation(eNameFull, eAlias, eOccupation);
				
		//Pull cards for this entity
		pullCharacterCreationCards();
		
		//Assign the Starting Skills
		assignStartingAptitudes();
		
		//Calculate the Aptitude points
		calculateInitalAptitudePoints();
		
	}
	
	
	//Used once to generate the Trait objects to hold Aptitudes
	private void createEntityTraits() 
	{
		
		//Generate the Traits based off the Trait ENUM reference
		setEntityTraitCognition(new Trait(Traits.COGNITION));
		setEntityTraitKnowledge(new Trait(Traits.KNOWLEDGE));
		setEntityTraitMien(new Trait(Traits.MIEN));
		setEntityTraitSmarts(new Trait(Traits.SMARTS));
		setEntityTraitSpirit(new Trait(Traits.SPIRIT));
		setEntityTraitDeftness(new Trait(Traits.DEFTNESS));
		setEntityTraitNimbleness(new Trait(Traits.NIMBLENESS));
		setEntityTraitStrength(new Trait(Traits.STRENGTH));
		setEntityTraitQuickness(new Trait(Traits.QUICKNESS));
		setEntityTraitVigor(new Trait(Traits.VIGOR));
		
		
		//Put the Mappings with the Traits paired to Trait ENUM reference
		getEntityTraitsTraitsTraitHashMap().put(Traits.COGNITION, getEntityTraitCognition());
		getEntityTraitsTraitsTraitHashMap().put(Traits.KNOWLEDGE, getEntityTraitKnowledge());
		getEntityTraitsTraitsTraitHashMap().put(Traits.MIEN, getEntityTraitMien());
		getEntityTraitsTraitsTraitHashMap().put(Traits.SMARTS, getEntityTraitSmarts());
		getEntityTraitsTraitsTraitHashMap().put(Traits.SPIRIT, getEntityTraitSpirit());
		getEntityTraitsTraitsTraitHashMap().put(Traits.DEFTNESS, getEntityTraitDeftness());
		getEntityTraitsTraitsTraitHashMap().put(Traits.NIMBLENESS, getEntityTraitNimbleness());
		getEntityTraitsTraitsTraitHashMap().put(Traits.STRENGTH, getEntityTraitStrength());
		getEntityTraitsTraitsTraitHashMap().put(Traits.QUICKNESS, getEntityTraitQuickness());
		getEntityTraitsTraitsTraitHashMap().put(Traits.VIGOR, getEntityTraitVigor());

	}

	//Used once to generate the starting Aptitudes all entities get at no Aptitude Point costs
	protected void assignStartingAptitudes() {
		
		//Cognition: Search (1)
			updateEntityTraitSkills(Traits.COGNITION,"Search", 1);
			
		//Knowledge: Area Knowledge:Home County (2), Language:Native Tongue(2)
			updateEntityTraitSkills(Traits.KNOWLEDGE,"Area Knowledge:Home County", 2);
			updateEntityTraitSkills(Traits.KNOWLEDGE,"Language:Native Tongue", 2);
						
		//Nimbleness: Climbing (1), Sneak(1)
			updateEntityTraitSkills(Traits.NIMBLENESS,"Climbin", 1);
			updateEntityTraitSkills(Traits.NIMBLENESS,"Sneak", 1);
			
				
	}

	//Update one skill for an entity
	public void updateEntityTraitSkills(Traits tEnum, String sNameString, int sCoordinationint )
	{
		//Create the temporary Aptitude out of provided Name String and Coordination Int to Map to the Trait
		Aptitude tempAptitudeNameStringCoordinationInt = new Aptitude(sNameString, sCoordinationint);
	
		//Get the Trait from the Trait Map and update That Traits Aptitude Value
		getEntityTraitsTraitsTraitHashMap().get(tEnum).updateTraitAptitudesValue(tempAptitudeNameStringCoordinationInt);

		
	}
	

	protected void extractEntityNamesAndOccupation(String eeNameFull, String eeAlias, String eeOccupation) {
			
			setEntityAlias(eeAlias);
			
			setEntityOccupation(eeOccupation);
		
			//Set the Full name for this entity
			setEntityNameFull(eeNameFull);
		
			//Split the Full name into its parts seperated by a space
			String[] entityFullNameArraySplit = eeNameFull.split(" ");
			
			//The first part is always the first name
			setEntityNameFirst(entityFullNameArraySplit[0]);
			
			//If the number of parts is 2
			if(entityFullNameArraySplit.length == 2)
			{	
				//Set the Last name to the 2nd element
				setEntityNameLast(entityFullNameArraySplit[1]);
			}
			//If the number of parts is more than 2
			if(entityFullNameArraySplit.length > 2)
			{					
				//Save all them parts in an Array List
				for(int i = 1; i < entityFullNameArraySplit.length - 1; i++)
				{
					//Fill in the middle names array with the remaining name past 
					getEntityNameMiddleArrayList().add(entityFullNameArraySplit[i]);	
				}				
				//Set the last name as the last element in the middle name ArrayList
				setEntityNameLast(entityFullNameArraySplit[entityFullNameArraySplit.length - 1]);				
			}	
		
	}



	//Randomly assign 10 cards to an entity's Traits
	private void pullCharacterCreationCards() {
		
		//Create the Character Creation deck
		Deck characterCreationDeck = new Deck(this.getEntityAlias(), "CharacterCreation");
				
		//Pull 12 cards from the deck
		characterCreationDeck.pullCards(this, 12);
				
		//Sort the cards within the etity's hand first by the Trait's lowest value, then by the Coordination lowest value 
		getEntityActionHandArrayListCards().sort(Comparator.comparing(Cards::getCardTraitInt).thenComparing(Cards::getCardCoordinationInt));

		//Remove the 2 lowest card values from your hand that are not 2's or Jokers
		getEntityHandTopCardSlipDeucesInSleeveKeepCards();
		
		//If the top card is not a 2(meaning there are no 2's dealt this character creation deck pull of 12 cards)
		if(entityTopCardCards.getCardFaceString() != "2")
		{
			//Remove the first card from the top of the deck
			getEntityActionHandArrayListCards().remove(0);
			
			//Remove the second card from the top of the deck
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
			
			//Remove the first card from the top of the deck
			getEntityActionHandArrayListCards().remove(0);
			
			//Remove the second card from the top of the deck
			getEntityActionHandArrayListCards().remove(0);
		}
				
		//Shuffle the cards in the hand
		Collections.shuffle(entityActionHandArrayListCards);
	
		//Assign the cards from the entity's hand to the entity's Traits	
		assignEntityTraits();

		//Pull a random card for the Joker if one exists and update the associated Trait's Suit
		pullEntityCharacterCreationHandJokersCard();
				
		//Clear the hand and associated cards
		entityActionHandArrayListCards.removeAll(getEntityActionHandArrayListCards());
		entityTopCardCards = null; 
		entitySleevedCard = null;
	}	

	//Associate the traits to the entity
	protected void assignEntityTraits() {
		
		//Create the Traits to Assign the Card's Traits to
		createEntityTraits();
		
		//Cognition
		
			//Assign the Card pulled to the Entity Trait
			setEntityTraitCognitionCard(entityActionHandArrayListCards.get(Traits.COGNITION.getTraitsOrderInt()));
		
			//Assign the Entity Cards Values to the Trait Aptitudes
			getEntityTraitCognition().setTraitCoordinationInt(getEntityTraitCognitionCard().getCardCoordinationInt());
			getEntityTraitCognition().setTraitDieTypeString(getEntityTraitCognitionCard().getCardTraitString());
			getEntityTraitCognition().setTraitDieTypeInt(getEntityTraitCognitionCard().getCardTraitInt());
			
		//Knowledge
			
			//Assign the Card pulled to the Entity Trait
			setEntityTraitKnowledgeCard(entityActionHandArrayListCards.get(Traits.KNOWLEDGE.getTraitsOrderInt()));
		
			//Assign the Entity Cards Values to the Trait Aptitudes
			getEntityTraitKnowledge().setTraitCoordinationInt(getEntityTraitKnowledgeCard().getCardCoordinationInt());
			getEntityTraitKnowledge().setTraitDieTypeString(getEntityTraitKnowledgeCard().getCardTraitString());		
			getEntityTraitKnowledge().setTraitDieTypeInt(getEntityTraitKnowledgeCard().getCardTraitInt());		
			
		//Mien
			
			//Assign the Card pulled to the Entity Trait
			setEntityTraitMienCard(entityActionHandArrayListCards.get(Traits.MIEN.getTraitsOrderInt()));
		
			//Assign the Entity Cards Values to the Trait Aptitudes
			getEntityTraitMien().setTraitCoordinationInt(getEntityTraitMienCard().getCardCoordinationInt());
			getEntityTraitMien().setTraitDieTypeString(getEntityTraitMienCard().getCardTraitString());		
			getEntityTraitMien().setTraitDieTypeInt(getEntityTraitMienCard().getCardTraitInt());		
			
		//Smarts
			
			//Assign the Card pulled to the Entity Trait
			setEntityTraitSmartsCard(entityActionHandArrayListCards.get(Traits.SMARTS.getTraitsOrderInt()));
		
			//Assign the Entity Cards Values to the Trait Aptitudes
			getEntityTraitSmarts().setTraitCoordinationInt(getEntityTraitSmartsCard().getCardCoordinationInt());
			getEntityTraitSmarts().setTraitDieTypeString(getEntityTraitSmartsCard().getCardTraitString());		
			getEntityTraitSmarts().setTraitDieTypeInt(getEntityTraitSmartsCard().getCardTraitInt());		
			
		//Spirit
			
			//Assign the Card pulled to the Entity Trait
			setEntityTraitSpiritCard(entityActionHandArrayListCards.get(Traits.SPIRIT.getTraitsOrderInt()));
		
			//Assign the Entity Cards Values to the Trait Aptitudes
			getEntityTraitSpirit().setTraitCoordinationInt(getEntityTraitSpiritCard().getCardCoordinationInt());
			getEntityTraitSpirit().setTraitDieTypeString(getEntityTraitSpiritCard().getCardTraitString());		
			getEntityTraitSpirit().setTraitDieTypeInt(getEntityTraitSpiritCard().getCardTraitInt());		
			
		//Deftness
			
			//Assign the Card pulled to the Entity Trait
			setEntityTraitDeftnessCard(entityActionHandArrayListCards.get(Traits.DEFTNESS.getTraitsOrderInt()));
		
			//Assign the Entity Cards Values to the Trait Aptitudes
			getEntityTraitDeftness().setTraitCoordinationInt(getEntityTraitDeftnessCard().getCardCoordinationInt());
			getEntityTraitDeftness().setTraitDieTypeString(getEntityTraitDeftnessCard().getCardTraitString());		
			getEntityTraitDeftness().setTraitDieTypeInt(getEntityTraitDeftnessCard().getCardTraitInt());		
			
		//Nimbleness
			
			//Assign the Card pulled to the Entity Trait
			setEntityTraitNimblenessCard(entityActionHandArrayListCards.get(Traits.NIMBLENESS.getTraitsOrderInt()));
		
			//Assign the Entity Cards Values to the Trait Aptitudes
			getEntityTraitNimbleness().setTraitCoordinationInt(getEntityTraitNimblenessCard().getCardCoordinationInt());
			getEntityTraitNimbleness().setTraitDieTypeString(getEntityTraitNimblenessCard().getCardTraitString());		
			getEntityTraitNimbleness().setTraitDieTypeInt(getEntityTraitNimblenessCard().getCardTraitInt());		

		//Strength
			
			//Assign the Card pulled to the Entity Trait
			setEntityTraitStrengthCard(entityActionHandArrayListCards.get(Traits.STRENGTH.getTraitsOrderInt()));
		
			//Assign the Entity Cards Values to the Trait Aptitudes
			getEntityTraitStrength().setTraitCoordinationInt(getEntityTraitStrengthCard().getCardCoordinationInt());
			getEntityTraitStrength().setTraitDieTypeString(getEntityTraitStrengthCard().getCardTraitString());		
			getEntityTraitStrength().setTraitDieTypeInt(getEntityTraitStrengthCard().getCardTraitInt());		

		//Quickness
			
			//Assign the Card pulled to the Entity Trait
			setEntityTraitQuicknessCard(entityActionHandArrayListCards.get(Traits.QUICKNESS.getTraitsOrderInt()));
		
			//Assign the Entity Cards Values to the Trait Aptitudes
			getEntityTraitQuickness().setTraitCoordinationInt(getEntityTraitQuicknessCard().getCardCoordinationInt());
			getEntityTraitQuickness().setTraitDieTypeString(getEntityTraitQuicknessCard().getCardTraitString());		
			getEntityTraitQuickness().setTraitDieTypeInt(getEntityTraitQuicknessCard().getCardTraitInt());		
			
		//Vigor
			
			//Assign the Card pulled to the Entity Trait
			setEntityTraitVigorCard(entityActionHandArrayListCards.get(Traits.VIGOR.getTraitsOrderInt()));
		
			//Assign the Entity Cards Values to the Trait Aptitudes
			getEntityTraitVigor().setTraitCoordinationInt(getEntityTraitVigorCard().getCardCoordinationInt());
			getEntityTraitVigor().setTraitDieTypeString(getEntityTraitVigorCard().getCardTraitString());		
			getEntityTraitVigor().setTraitDieTypeInt(getEntityTraitVigorCard().getCardTraitInt());		

	}

	/**This member will check to see if your hand had a joker and Pull a random card during character creation
	 * to represent its Coordination Value while assigning it to the Entity's associated Trait
	 * 
	 * pullEntityCharacterCreationHandJokersCard
	 */	
	protected void pullEntityCharacterCreationHandJokersCard()
	{
		//For every Traits in the Traits Enum
		for(Traits t: Traits.values())
		{
			//Get the card at the
			switch(entityActionHandArrayListCards.get(t.getTraitsOrderInt()))
			{
			case JR:
							
				//Assign the Red Joker Cards Card
				entityRedJokerPullCard = Cards.getRandomCard();		
				
				//Update the Associated Trait with the new Joker Coordination Value
				updateEntityCurrentTraitToJokerPull(t, entityRedJokerPullCard);
				
				break;
				
			case JB:
				
				//Assign the Black Joker Cards Card
				entityBlackJokerPullCard = Cards.getRandomCard();
				
				//Update the Associated Trait with the new Joker Coordination Value
				updateEntityCurrentTraitToJokerPull(t, entityBlackJokerPullCard);
				
				break;
				
			default:
				break;
				
			}
		}		
	}
	
	/**This member will assign the newly pulled Joker's Cards Coordination Value with the Jokers Trait Value to update the string value of the Trait Aptitude Value
	 * 
	 * updateEntityCurrentTraitToJokerPull
	 */	
	private void updateEntityCurrentTraitToJokerPull(Traits iTraits, Cards entityJokerPullCard)
	{	
		switch(iTraits)
		{
		case COGNITION:
			entityTraitCognition.setTraitCoordinationInt(entityJokerPullCard.getCardCoordinationInt());
			entityTraitCognition.setTraitDieTypeString(getEntityTraitCognitionCard().getCardTraitString());
			break;
		case KNOWLEDGE:	
			entityTraitKnowledge.setTraitCoordinationInt(entityJokerPullCard.getCardCoordinationInt());
			entityTraitKnowledge.setTraitDieTypeString(getEntityTraitKnowledgeCard().getCardTraitString());
			break;
		case MIEN:
			entityTraitMien.setTraitCoordinationInt(entityJokerPullCard.getCardCoordinationInt());
			entityTraitMien.setTraitDieTypeString(getEntityTraitMienCard().getCardTraitString());
			break;
		case SMARTS:
			entityTraitSmarts.setTraitCoordinationInt(entityJokerPullCard.getCardCoordinationInt());
			entityTraitSmarts.setTraitDieTypeString(getEntityTraitSmartsCard().getCardTraitString());
			break;
		case SPIRIT:
			entityTraitSpirit.setTraitCoordinationInt(entityJokerPullCard.getCardCoordinationInt());
			entityTraitSpirit.setTraitDieTypeString(getEntityTraitSpiritCard().getCardTraitString());
			break;
		case DEFTNESS:
			entityTraitDeftness.setTraitCoordinationInt(entityJokerPullCard.getCardCoordinationInt());
			entityTraitDeftness.setTraitDieTypeString(getEntityTraitDeftnessCard().getCardTraitString());
			break;
		case NIMBLENESS:
			entityTraitNimbleness.setTraitCoordinationInt(entityJokerPullCard.getCardCoordinationInt());
			entityTraitNimbleness.setTraitDieTypeString(getEntityTraitNimblenessCard().getCardTraitString());
			break;
		case STRENGTH:
			entityTraitStrength.setTraitCoordinationInt(entityJokerPullCard.getCardCoordinationInt());
			entityTraitStrength.setTraitDieTypeString(getEntityTraitStrengthCard().getCardTraitString());
			break;
		case QUICKNESS:
			entityTraitQuickness.setTraitCoordinationInt(entityJokerPullCard.getCardCoordinationInt());
			entityTraitQuickness.setTraitDieTypeString(getEntityTraitQuicknessCard().getCardTraitString());
			break;
		case VIGOR:
			entityTraitVigor.setTraitCoordinationInt(entityJokerPullCard.getCardCoordinationInt());
			entityTraitVigor.setTraitDieTypeString(getEntityTraitVigorCard().getCardTraitString());
			break;
		}
	}
	
	/**This member will check to see if your hand is empty and return null, otherwise it will set your top card of your hand into your sleeve
	 * 
	 * @return the getEntityHandTopCardSlipDeucesInSleeveKeepCards
	 */	
	public Cards getEntityHandTopCardSlipDeucesInSleeveKeepCards()
	{
		//If the entity hand is empty
		if(entityActionHandArrayListCards.size() == 0)
		{		
			//Return null for a Comparator to check against
			return null;
		}
		//If the hand is NOT empty AND the top card is a Card Face value of 2
		else if(entityActionHandArrayListCards.get(0).getCardFaceString() == "2")
			{
				//Stick the Joker up your sleeve
				entitySleevedCard = entityActionHandArrayListCards.get(0);
				
				//Remove the Joker from the top card of Entity hand
				entityActionHandArrayListCards.remove(0);
				
				//Add the Sleeved Joker from the top card of Entity hand
				entityActionHandArrayListCards.add(entitySleevedCard);
				
				//Assign the entity's top card to be the new top card in the entity's hand
				entityTopCardCards = getEntityActionHandArrayListCards().get(0);
				
				//Return a the top card of your hand
				return entityTopCardCards;
			}
		//The hand is not empty
		else 
		{
			//Assign the entity's top card to be the new top card in the entity's hand
			entityTopCardCards = getEntityActionHandArrayListCards().get(0);
			
			//Return a the top card of your hand
			return entityTopCardCards;
		}
	}	


	/**
	 * @return the getEntityHandTopCardJokerCheckCards
	 */	
	public Cards getEntityHandTopCardJokerCheckCards()
	{
		//If the entity hand is empty
		if(entityActionHandArrayListCards.size() == 0)
		{		
			//Return null for the Comparator to check against
			return null;
		}
		//If the hand is NOT empty AND the top card is a Joker
		else if(entityActionHandArrayListCards.get(0) == Cards.JR || entityActionHandArrayListCards.get(0) == Cards.JB)
			{
				//Stick the Joker up your sleeve
				entitySleevedCard = entityActionHandArrayListCards.get(0);
				
				//Remove the Joker from the top card of Entity hand
				entityActionHandArrayListCards.remove(0);
				
				//Add the Sleeved Joker from the top card of Entity hand
				entityActionHandArrayListCards.add(entitySleevedCard);
				
				//Assign the entity's top card to be the new top card in the entity's hand
				entityTopCardCards = getEntityActionHandArrayListCards().get(0);
				
				//Return a the top card of your hand
				return entityTopCardCards;

			}
		//The hand is not empty
		else 
		{
			//Assign the entity's top card to be the new top card in the entity's hand
			entityTopCardCards = getEntityActionHandArrayListCards().get(0);
			
			//Return a the top card of your hand
			return entityTopCardCards;
		}
	}	
	
	/**
	 * Used to Calculate the initial Aptitude points of the entity on character creation
	 */
	protected void calculateInitalAptitudePoints() 
	{
		//Set this heros Aptitude points to the sum of the Face Values for Cognition, Knowledge, Smarts Cards
		setEntityAptitudePoints(getEntityTraitCognitionCard().getCardTraitInt() +
								getEntityTraitKnowledgeCard().getCardTraitInt() +
								getEntityTraitSmartsCard().getCardTraitInt());
		
	
		
	}
	
	// Print Statements for Entity
	/**
	 * void Print to console: Entities Attributes
	 */
	public void printEntityStatsTraitCardNames()
	{		
		//Print the Traits of the Entity
		System.out.printf("%s the %s's Traits: (", getEntityAlias(), getEntityOccupation());
		System.out.printf("Cognition: [%s], ",getEntityTraitCognitionCard().name());
		System.out.printf("Knowledge: [%s], ",getEntityTraitKnowledgeCard().name());
		System.out.printf("Mien: [%s], ", getEntityTraitMienCard().name());
		System.out.printf("Smarts: [%s], ", getEntityTraitSmartsCard().name());
		System.out.printf("Spirit: [%s], ", getEntityTraitSpiritCard().name());
		System.out.printf("Deftness: [%s], ", getEntityTraitDeftnessCard().name());
		System.out.printf("Nimbleness: [%s], ", getEntityTraitNimblenessCard().name());
		System.out.printf("Strength: [%s], ", getEntityTraitStrengthCard().name());
		System.out.printf("Quickness: [%s], ", getEntityTraitQuicknessCard().name());
		System.out.printf("Vigor: [%s])\n", getEntityTraitVigorCard().name());	
	}	
	
	/**
	 * void Print to console: Entities Attributes
	 */
	public void printEntityStatsTraitAptitudeValues()
	{		
		//Print the Traits of the Entity
		System.out.printf("%s the %s's Traits: (", getEntityAlias(), getEntityOccupation());
		System.out.printf("Cognition: %d%s, ", getEntityTraitCognition().getTraitCoordinationInt(), getEntityTraitCognition().getTraitDieTypeString());
		System.out.printf("Knowledge: %d%s, ", getEntityTraitKnowledge().getTraitCoordinationInt(), getEntityTraitKnowledge().getTraitDieTypeString());
		System.out.printf("Mien: %d%s, ", getEntityTraitMien().getTraitCoordinationInt(), getEntityTraitMien().getTraitDieTypeString());
		System.out.printf("Smarts: %d%s, ", getEntityTraitSmarts().getTraitCoordinationInt(), getEntityTraitSmarts().getTraitDieTypeString());
		System.out.printf("Spirit: %d%s, ", getEntityTraitSpirit().getTraitCoordinationInt(), getEntityTraitSpirit().getTraitDieTypeString());
		System.out.printf("Deftness: %d%s, ", getEntityTraitDeftness().getTraitCoordinationInt(), getEntityTraitDeftness().getTraitDieTypeString());
		System.out.printf("Nimbleness: %d%s, ", getEntityTraitNimbleness().getTraitCoordinationInt(), getEntityTraitNimbleness().getTraitDieTypeString());
		System.out.printf("Strength: %d%s, ", getEntityTraitStrength().getTraitCoordinationInt(), getEntityTraitStrength().getTraitDieTypeString());
		System.out.printf("Quickness: %d%s, ", getEntityTraitQuickness().getTraitCoordinationInt(), getEntityTraitQuickness().getTraitDieTypeString());
		System.out.printf("Vigor: %d%s)\n", getEntityTraitVigor().getTraitCoordinationInt(), getEntityTraitVigor().getTraitDieTypeString());	
	}

	public void printEntityStatsKnownTraitsAndAptitudes()
	{
		for(Map.Entry<Traits, Trait> traitsEnum: entityTraitsTraitsTraitHashMap.entrySet())
		{
			//Get the Trait Name, Coordination, and Die Type
			System.out.printf("%s(%d%s):\n", traitsEnum.getValue().getTraitName(), traitsEnum.getValue().getTraitCoordinationInt(), traitsEnum.getValue().getTraitDieTypeString() );
			
			//If the Aptitudes are found
			if(!traitsEnum.getValue().getTraitAptitudesStringAptitudeHashMap().isEmpty())
			{
				//Print out each Aptitude in the Map of known aptitudes
				for(Map.Entry<String, Aptitude> aName: traitsEnum.getValue().getTraitAptitudesStringAptitudeHashMap().entrySet())
				{
					//Get the Aptitude Name and Cordination
					System.out.printf("%s %d\n", aName.getValue().getAptitudeName(), aName.getValue().getAptitudeValue());
				}
				
			}
			//No aptitudes found
			else
			{
				//Print out no aptitudes
				System.out.println("No Aptitudes");
			}
			
			System.out.println();
		}
				
	}
	
	
	public void printEntityHand()
	{
		//Print the First, Alias, Last names with the number of cards in their hands
		System.out.printf("%s has %d card%s in their hand: ", getEntityAlias(), 
																		getEntityActionHandArrayListCards().size() ,
																		getEntityActionHandArrayListCards().size() <= 1 ? "":"s"  );
		
		//Print the Cards in this Entity's hand
		for(Cards c : this.getEntityActionHandArrayListCards())
		{
			System.out.printf("[" + c.name() +"]");
		}
		System.out.println("");
	}

//Overrides
	
//Getters and Setters
	/**
	 * @return the entityActionHandArrayListCards
	 */	
	public ArrayList<Cards> getEntityActionHandArrayListCards()
	{
		return entityActionHandArrayListCards;
	}

	/**
	 * @return the entityAlias
	 */
	public String getEntityAlias() {
		return entityAlias;
	}

	/**
	 * @param entityAlias the entityAlias to set
	 */
	public void setEntityAlias(String entityAlias) {
		this.entityAlias = entityAlias;
	}

	/**
	 * @return the entityOccupation
	 */
	public String getEntityOccupation() {
		return entityOccupation;
	}

	/**
	 * @param entityOccupation the entityOccupation to set
	 */
	public void setEntityOccupation(String entityOccupation) {
		this.entityOccupation = entityOccupation;
	}

	/**
	 * @return the entityTraitCognitionCard
	 */
	public Cards getEntityTraitCognitionCard() {
		return entityTraitCognitionCard;
	}

	/**
	 * @param entityTraitCognitionCard the entityTraitCognitionCard to set
	 */
	public void setEntityTraitCognitionCard(Cards entityTraitCognitionCard) {
		this.entityTraitCognitionCard = entityTraitCognitionCard;
	}

	/**
	 * @return the entityTraitKnowledgeCard
	 */
	public Cards getEntityTraitKnowledgeCard() {
		return entityTraitKnowledgeCard;
	}

	/**
	 * @param entityTraitKnowledgeCard the entityTraitKnowledgeCard to set
	 */
	public void setEntityTraitKnowledgeCard(Cards entityTraitKnowledgeCard) {
		this.entityTraitKnowledgeCard = entityTraitKnowledgeCard;
	}

	/**
	 * @return the entityTraitMienCard
	 */
	public Cards getEntityTraitMienCard() {
		return entityTraitMienCard;
	}

	/**
	 * @param entityTraitMienCard the entityTraitMienCard to set
	 */
	public void setEntityTraitMienCard(Cards entityTraitMienCard) {
		this.entityTraitMienCard = entityTraitMienCard;
	}

	/**
	 * @return the entityTraitSmartsCard
	 */
	public Cards getEntityTraitSmartsCard() {
		return entityTraitSmartsCard;
	}

	/**
	 * @param entityTraitSmartsCard the entityTraitSmartsCard to set
	 */
	public void setEntityTraitSmartsCard(Cards entityTraitSmartsCard) {
		this.entityTraitSmartsCard = entityTraitSmartsCard;
	}

	/**
	 * @return the entityTraitSpiritCard
	 */
	public Cards getEntityTraitSpiritCard() {
		return entityTraitSpiritCard;
	}

	/**
	 * @param entityTraitSpiritCard the entityTraitSpiritCard to set
	 */
	public void setEntityTraitSpiritCard(Cards entityTraitSpiritCard) {
		this.entityTraitSpiritCard = entityTraitSpiritCard;
	}

	/**
	 * @return the entityTraitDeftnessCard
	 */
	public Cards getEntityTraitDeftnessCard() {
		return entityTraitDeftnessCard;
	}

	/**
	 * @param entityTraitDeftnessCard the entityTraitDeftnessCard to set
	 */
	public void setEntityTraitDeftnessCard(Cards entityTraitDeftnessCard) {
		this.entityTraitDeftnessCard = entityTraitDeftnessCard;
	}

	/**
	 * @return the entityTraitNimblenessCard
	 */
	public Cards getEntityTraitNimblenessCard() {
		return entityTraitNimblenessCard;
	}

	/**
	 * @param entityTraitNimblenessCard the entityTraitNimblenessCard to set
	 */
	public void setEntityTraitNimblenessCard(Cards entityTraitNimblenessCard) {
		this.entityTraitNimblenessCard = entityTraitNimblenessCard;
	}

	/**
	 * @return the entityTraitStrengthCard
	 */
	public Cards getEntityTraitStrengthCard() {
		return entityTraitStrengthCard;
	}

	/**
	 * @param entityTraitStrengthCard the entityTraitStrengthCard to set
	 */
	public void setEntityTraitStrengthCard(Cards entityTraitStrengthCard) {
		this.entityTraitStrengthCard = entityTraitStrengthCard;
	}

	/**
	 * @return the entityTraitQuicknessCard
	 */
	public Cards getEntityTraitQuicknessCard() {
		return entityTraitQuicknessCard;
	}

	/**
	 * @param entityTraitQuicknessCard the entityTraitQuicknessCard to set
	 */
	public void setEntityTraitQuicknessCard(Cards entityTraitQuicknessCard) {
		this.entityTraitQuicknessCard = entityTraitQuicknessCard;
	}

	/**
	 * @return the entityTraitVigorCard
	 */
	public Cards getEntityTraitVigorCard() {
		return entityTraitVigorCard;
	}

	/**
	 * @param entityTraitVigorCard the entityTraitVigorCard to set
	 */
	public void setEntityTraitVigorCard(Cards entityTraitVigorCard) {
		this.entityTraitVigorCard = entityTraitVigorCard;
	}

	/**
	 * @return the entityAptitudePoints
	 */
	public int getEntityAptitudePoints() {
		return entityAptitudePoints;
	}

	/**
	 * @param entityAptitudePoints the entityAptitudePoints to set
	 */
	public void setEntityAptitudePoints(int entityAptitudePoints) {
		this.entityAptitudePoints = entityAptitudePoints;
	}

	/**
	 * @return the entityBountyPoints
	 */
	public int getEntityBountyPoints() {
		return entityBountyPoints;
	}

	/**
	 * @param entityBountyPoints the entityBountyPoints to set
	 */
	public void setEntityBountyPoints(int entityBountyPoints) {
		this.entityBountyPoints = entityBountyPoints;
	}

	/**
	 * @return the entityRedJokerPullCard
	 */
	public Cards getEntityRedJokerPullCard() {
		return entityRedJokerPullCard;
	}

	/**
	 * @param entityRedJokerPullCard the entityRedJokerPullCard to set
	 */
	public void setEntityRedJokerPullCard(Cards entityRedJokerPullCard) {
		this.entityRedJokerPullCard = entityRedJokerPullCard;
	}

	/**
	 * @return the entityBlackJokerPullCard
	 */
	public Cards getEntityBlackJokerPullCard() {
		return entityBlackJokerPullCard;
	}

	/**
	 * @param entityBlackJokerPullCard the entityBlackJokerPullCard to set
	 */
	public void setEntityBlackJokerPullCard(Cards entityBlackJokerPullCard) {
		this.entityBlackJokerPullCard = entityBlackJokerPullCard;
	}

	/**
	 * @return the entityNameFull
	 */
	public String getEntityNameFull() {
		return entityNameFull;
	}

	/**
	 * @param entityNameFull the entityNameFull to set
	 */
	public void setEntityNameFull(String entityNameFull) {
		this.entityNameFull = entityNameFull;
	}

	/**
	 * @return the entityNameFirst
	 */
	public String getEntityNameFirst() {
		return entityNameFirst;
	}

	/**
	 * @param entityNameFirst the entityNameFirst to set
	 */
	public void setEntityNameFirst(String entityNameFirst) {
		this.entityNameFirst = entityNameFirst;
	}

	/**
	 * @return the entityNameLast
	 */
	public String getEntityNameLast() {
		return entityNameLast;
	}

	/**
	 * @param entityNameLast the entityNameLast to set
	 */
	public void setEntityNameLast(String entityNameLast) {
		this.entityNameLast = entityNameLast;
	}

	/**
	 * @return the entitySex
	 */
	public String getEntitySex() {
		return entitySex;
	}

	/**
	 * @param entitySex the entitySex to set
	 */
	public void setEntitySex(String entitySex) {
		this.entitySex = entitySex;
	}

	/**
	 * @return the entityNameMiddleArrayList
	 */
	public ArrayList<String> getEntityNameMiddleArrayList() {
		return entityNameMiddleArrayList;
	}

	/**
	 * @param entityNameMiddleArrayList the entityNameMiddleArrayList to set
	 */
	public void setEntityNameMiddleArrayList(ArrayList<String> entityNameMiddleArrayList) {
		this.entityNameMiddleArrayList = entityNameMiddleArrayList;
	}


	/**
	 * @return the entityTraitKnowledge
	 */
	public Trait getEntityTraitKnowledge() {
		return entityTraitKnowledge;
	}


	/**
	 * @param entityTraitKnowledge the entityTraitKnowledge to set
	 */
	public void setEntityTraitKnowledge(Trait entityTraitKnowledge) {
		this.entityTraitKnowledge = entityTraitKnowledge;
	}


	/**
	 * @return the entityTraitMien
	 */
	public Trait getEntityTraitMien() {
		return entityTraitMien;
	}


	/**
	 * @param entityTraitMien the entityTraitMien to set
	 */
	public void setEntityTraitMien(Trait entityTraitMien) {
		this.entityTraitMien = entityTraitMien;
	}


	/**
	 * @return the entityTraitSmarts
	 */
	public Trait getEntityTraitSmarts() {
		return entityTraitSmarts;
	}


	/**
	 * @param entityTraitSmarts the entityTraitSmarts to set
	 */
	public void setEntityTraitSmarts(Trait entityTraitSmarts) {
		this.entityTraitSmarts = entityTraitSmarts;
	}


	/**
	 * @return the entityTraitSpirit
	 */
	public Trait getEntityTraitSpirit() {
		return entityTraitSpirit;
	}


	/**
	 * @param entityTraitSpirit the entityTraitSpirit to set
	 */
	public void setEntityTraitSpirit(Trait entityTraitSpirit) {
		this.entityTraitSpirit = entityTraitSpirit;
	}


	/**
	 * @return the entityTraitDeftness
	 */
	public Trait getEntityTraitDeftness() {
		return entityTraitDeftness;
	}


	/**
	 * @param entityTraitDeftness the entityTraitDeftness to set
	 */
	public void setEntityTraitDeftness(Trait entityTraitDeftness) {
		this.entityTraitDeftness = entityTraitDeftness;
	}


	/**
	 * @return the entityTraitNimbleness
	 */
	public Trait getEntityTraitNimbleness() {
		return entityTraitNimbleness;
	}


	/**
	 * @param entityTraitNimbleness the entityTraitNimbleness to set
	 */
	public void setEntityTraitNimbleness(Trait entityTraitNimbleness) {
		this.entityTraitNimbleness = entityTraitNimbleness;
	}


	/**
	 * @return the entityTraitStrength
	 */
	public Trait getEntityTraitStrength() {
		return entityTraitStrength;
	}


	/**
	 * @param entityTraitStrength the entityTraitStrength to set
	 */
	public void setEntityTraitStrength(Trait entityTraitStrength) {
		this.entityTraitStrength = entityTraitStrength;
	}


	/**
	 * @return the entityTraitQuickness
	 */
	public Trait getEntityTraitQuickness() {
		return entityTraitQuickness;
	}


	/**
	 * @param entityTraitQuickness the entityTraitQuickness to set
	 */
	public void setEntityTraitQuickness(Trait entityTraitQuickness) {
		this.entityTraitQuickness = entityTraitQuickness;
	}


	/**
	 * @return the entityTraitVigor
	 */
	public Trait getEntityTraitVigor() {
		return entityTraitVigor;
	}


	/**
	 * @param entityTraitVigor the entityTraitVigor to set
	 */
	public void setEntityTraitVigor(Trait entityTraitVigor) {
		this.entityTraitVigor = entityTraitVigor;
	}


	/**
	 * @return the entityTraitCognition
	 */
	public Trait getEntityTraitCognition() {
		return entityTraitCognition;
	}


	/**
	 * @param entityTraitCognition the entityTraitCognition to set
	 */
	public void setEntityTraitCognition(Trait entityTraitCognition) {
		this.entityTraitCognition = entityTraitCognition;
	}

	/**
	 * @return the entityTraitsTraitsTraitHashMap
	 */
	public Map<Traits, Trait> getEntityTraitsTraitsTraitHashMap() {
		return entityTraitsTraitsTraitHashMap;
	}

	/**
	 * @param entityTraitsTraitsTraitHashMap the entityTraitsTraitsTraitHashMap to set
	 */
	public void setEntityTraitsTraitsTraitHashMap(Map<Traits, Trait> entityTraitsTraitsTraitHashMap) {
		this.entityTraitsTraitsTraitHashMap = entityTraitsTraitsTraitHashMap;
	}


	/**
	 * @return the entitySize
	 */
	public Size getEntitySize() {
		return entitySize;
	}


	/**
	 * @param entitySize the entitySize to set
	 */
	public void setEntitySize(Size entitySize) {
		this.entitySize = entitySize;
	}


}
