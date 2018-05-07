import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

//Cards based Enumeration
	public enum Cards
	{
		//Cards are in descending order of Initiative ranking
		
		//Red Joker
		JR ("Joker", "Red", 15, "Red", "D12", 12, 5, 54),
		
		//Aces
		SA ("Spades", "Ace", 14, "Black", "D12", 12, 4, 53),
		HA ("Hearts", "Ace", 14, "Red", "D12", 12, 3, 52),
		DA ("Diamonds", "Ace", 14, "Red", "D12", 12, 2, 51),
		CA ("Clubs", "Ace", 14, "Black", "D12", 12, 1, 50),
		
		//Kings
		SK ("Spades", "King", 13, "Black", "D10", 10, 4, 49),		
		HK ("Hearts", "King", 13, "Red", "D10", 10, 3, 48),
		DK ("Diamonds", "King", 13, "Red", "D10", 10, 2, 47),		
		CK ("Clubs", "King", 13, "Black", "D10", 10, 1, 46),		
		
		//Queens
		SQ ("Spades", "Queen", 12, "Black", "D10", 10, 4, 55),
		HQ ("Hearts", "Queen", 12, "Red", "D10", 10, 3, 44),
		DQ ("Diamonds", "Queen", 12, "Red", "D10", 10, 2, 43),
		CQ ("Clubs", "Queen", 12, "Black", "D10", 10, 1, 42),		
		
		//Jacks
		SJ ("Spades", "Jack", 11, "Black", "D8", 8, 4, 41),
		HJ ("Hearts", "Jack", 11, "Red", "D8", 8, 3, 40),
		DJ ("Diamonds", "Jack", 11, "Red", "D8", 8, 2, 39),
		CJ ("Clubs", "Jack", 11, "Black", "D8", 8, 1, 38),
		
		//Tens
		S10 ("Spades", "10", 10, "Black", "D8", 8, 4, 37),		
		H10 ("Hearts", "10", 10, "Red", "D8", 8, 3, 36),	
		D10 ("Diamonds", "10", 10, "Red", "D8", 8, 2, 35),
		C10 ("Clubs", "10", 10, "Black", "D8", 8, 1, 34),
		
		//Nines
		S9 ("Spades", "9", 9, "Black", "D8", 8, 4, 33),
		H9 ("Hearts", "9", 9, "Red", "D8", 8, 3, 32),
		D9 ("Diamonds", "9", 9, "Red", "D8", 8, 2, 31),
		C9 ("Clubs", "9", 9, "Black", "D8", 8, 1, 30),
		
		//Eights
		S8 ("Spades", "8", 8, "Black", "D6", 6, 4, 29),
		H8 ("Hearts", "8", 8, "Red", "D6", 6, 3, 28),
		D8 ("Diamonds", "8", 8, "Red", "D6", 6, 2, 27),
		C8 ("Clubs", "8", 8, "Black", "D6", 6, 1, 26),
		
		//Sevens
		S7 ("Spades", "7", 7, "Black", "D6", 6, 4, 25),
		H7 ("Hearts", "7", 7, "Red", "D6", 6, 3, 24),
		D7 ("Diamonds", "7", 7, "Red", "D6", 6, 2, 23),		
		C7 ("Clubs", "7", 7, "Black", "D6", 6, 1, 22),
		
		//Sixes
		S6 ("Spades", "6", 6, "Black", "D6", 6, 4, 21),
		H6 ("Hearts", "6", 6, "Red", "D6", 6, 3, 20),
		D6 ("Diamonds", "6", 6, "Red", "D6", 6, 2, 19),
		C6 ("Clubs", "6", 6, "Black", "D6", 6, 1, 18),
		
		//Fives
		S5 ("Spades", "5", 5, "Black", "D6", 6, 4, 17),
		H5 ("Hearts", "5", 5, "Red", "D6", 6, 3, 16),
		D5 ("Diamonds", "5", 5, "Red", "D6", 6, 2, 15),
		C5 ("Clubs", "5", 5, "Black", "D6", 6, 1, 14),
		
		//Fours
		S4 ("Spades", "4", 4, "Black", "D6", 6, 4, 13),
		H4 ("Hearts", "4", 4, "Red", "D6", 6, 3, 12),
		D4 ("Diamonds", "4", 4, "Red", "D6", 6, 2, 11),
		C4 ("Clubs", "4", 4, "Black", "D6", 6, 1, 10),
		
		//Threes
		S3 ("Spades", "3", 3, "Black", "D6", 6, 4, 9),
		H3 ("Hearts", "3", 3, "Red", "D6", 6, 3, 8),
		D3 ("Diamonds", "3", 3, "Red", "D6", 6, 2, 7),
		C3 ("Clubs", "3", 3, "Black", "D6", 6, 1, 6),
		
		//Deuces
		S2 ("Spades", "2", 2, "Black", "D4", 4, 4, 5),
		H2 ("Hearts", "2", 2, "Red", "D4", 4, 3, 4),
		D2 ("Diamonds", "2", 2, "Red", "D4", 4, 2, 3),
		C2 ("Clubs", "2", 2, "Black", "D4", 4, 1, 2),

		//Black Joker
		JB ("Joker", "Black", 1, "Black", "D12", 12, 5, 1);
		
		//Card Attributes
		private final String cardSuitString; 			//Suits from lowest to highest: Clubs, Diamonds, Hearts, Spades
		private final String cardFaceString; 			//Face value from lowest to highest: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace
		private final int cardFaceInt; 					//Face value from lowest to highest: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
		private final String cardColorString; 			//Color from lowest to highest: Black, Red
		private final String cardTraitString; 			//Trait from lowest to highest: D4, D6, D8, D10, D12
		private final int cardTraitInt; 				//Trait from lowest to highest: 4, 6, 8, 10, 12
		private final int cardCoordinationInt; 			//Coordination from lowest to highest: 1, 2, 3, 4, 5
		private final int cardInitiativeValueInt;		//Initiative value from lowest to highest: 1-54
		
		static //Create the Random Seed
		Random random = new Random();
		
		private Cards(String cardSuitString, String cardFaceString, int cardFaceInt, String cardColorString, String cardTraitString, int cardTraitInt, int cardCoordinationInt, int cardInitiativeValueInt)
		{
			this.cardSuitString = cardSuitString;
			this.cardFaceString = cardFaceString;
			this.cardFaceInt = cardFaceInt;
			this.cardColorString = cardColorString;
			this.cardTraitString = cardTraitString;
			this.cardTraitInt = cardTraitInt;
			this.cardCoordinationInt = cardCoordinationInt;
			this.cardInitiativeValueInt = cardInitiativeValueInt;
		}
		
		//Get a random card from this enum list(this is the same as pulling a card from a random deck)
		public static Cards getRandomCard()
		{
			
			//Pick a Card from the elements in the array of Cards based on a random number generation of up to the length of the Cards.values() array 
			return Cards.values()[random.nextInt(values().length)]; 
		}
		
		//Get a random Ace card from this enum list(this is the same as pulling a card from a random deck)
		public static Cards getRandomAces()
		{
			ArrayList<Cards> randomAceArrayList = new ArrayList<Cards>();
			
			for(Cards c: EnumSet.range(Cards.SA, Cards.CA))
			{
				randomAceArrayList.add(c);
			}
			
			//Pick a Card from the elements in the array of Cards based on a random number generation of up to the length of the Cards.values() array 
			return randomAceArrayList.get(random.nextInt(randomAceArrayList.size())); 
		}
		
		
		/**
		 * @return the cardSuitString
		 */
		public String getCardSuitString() {
			return cardSuitString;
		}

		/**
		 * @return the cardFaceString
		 */
		public String getCardFaceString() {
			return cardFaceString;
		}

		/**
		 * @return the cardFaceInt
		 */
		public int getCardFaceInt() {
			return cardFaceInt;
		}

		/**
		 * @return the cardColorString
		 */
		public String getCardColorString() {
			return cardColorString;
		}

		/**
		 * @return the cardTraitString
		 */
		public String getCardTraitString() {
			return cardTraitString;
		}

		/**
		 * @return the cardTraitInt
		 */
		public int getCardTraitInt() {
			return cardTraitInt;
		}

		/**
		 * @return the cardCoordinationInt
		 */
		public int getCardCoordinationInt() {
			return cardCoordinationInt;
		}

		/**
		 * @return the cardInitiativeValueInt
		 */
		public int getCardInitiativeValueInt() {
			return cardInitiativeValueInt;
		}
	

	}