import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeadlandsDriver {
		
	
	public static void main(String[] args) {
		//Title
			System.out.println("\nWelcome to hell, welcome to Deadlands: Hell On Earth.");
			System.out.println("After the bombs fell, only two types of people mattered, Heros and Villains.");
			System.out.printf("In the of town of %s, you can expect to see very few folks around... in fact, lets create some!\n\n", "Dempsey");
						
		//Create the entities
		
			System.out.println("Creating a character:\n");
			System.out.println("Your new waster is going to need a few things before they can scrawl the legends of their deeds over the last person to walk the wastes.\n");
			System.out.println("First, they are going to need a name(the one their momma gave 'em), an alias(what they want put over their police record), and an occupation(what they make a livin' doin' out in the wastes).\n");
			System.out.println("Second, your going to need to shuffle a deck of 54 cards... that's a 52 card deck with 2 Jokers(one red, one black) ya brainer!");
			System.out.println("Next you will need to discard 2 from that hand, but you cannot discard any Deuces or Jokers!");
			System.out.println("With the 10 cards you got in your hands, you can assign one of each card to the following Mental or Physical Traits:\n");
			System.out.println("Mental Traits");
			System.out.println("Cognition: Perception and general alertness.");
			System.out.println("Knowledge: Education from book-learnin'and experience.");
			System.out.println("Mien: Presence and influence, as well as charisma and how the entity is reguarded by others.");
			System.out.println("Smarts: Wits and deduction. The is the ability to figure things out or piece together clues.");
			System.out.println("Spirit: Psyche and spiritual presence.\n");
			System.out.println("Corporeal Traits");
			System.out.println("Deftness: Hand eye coordination and manual dexterity.");
			System.out.println("Nimbleness: Agility and overall physical prowess.");
			System.out.println("Strength: Raw muscle, brawn, and how well an entity uses it.");
			System.out.println("Quickness: Reflexes, speed, and the ability to concentrate during stressful situations.");	
			System.out.println("Vigor: Endurance and constitution.\n");		
			System.out.println("Confusin'? Well, grab your 54 card deck and follow along!\n");			
			
			Entity heroDemoOne = new HeroDemo("Spike Swimming Bird Spiegel", "Lunkhead", "Bounty Hunter"); 
			
			System.out.println("\nTraits Values? Coordination Values? What the heck are all these squares?! Dont worry, pardner, let me set you strait...\n");
			System.out.printf("Every card has a Suit(symbol) and Face Value(number or letter) such as %s's Cognition card \"[%s]\" meanin' they got the \"[%s Suit with a Face Value of %d]\"... aka the %s of %s card!\"\n\n", 
					heroDemoOne.getEntityAlias(), heroDemoOne.getEntityTraitCognitionCard().name(), heroDemoOne.getEntityTraitCognitionCard().getCardSuitString(), 
					heroDemoOne.getEntityTraitCognitionCard().getCardFaceInt(), heroDemoOne.getEntityTraitCognitionCard().getCardFaceInt(), heroDemoOne.getEntityTraitCognitionCard().getCardSuitString());
			System.out.println("Trait Values are based on the card's face value whereas Coordination Values are based on the suit of the card, here is a quick reference list of 'em:\n");

			System.out.println("Card's Face Value\t   Trait Value");
			System.out.printf("  %s\t%s\n", "    2\t\t\t", Cards.C2.getCardTraitString());
			System.out.printf("  %s\t%s\n", "   3-8\t\t", Cards.C3.getCardTraitString());
			System.out.printf("  %s\t%s\n", "  9-Jack\t\t", Cards.C9.getCardTraitString());
			System.out.printf("  %s\t%s\n", "Queen-King\t\t", Cards.CQ.getCardTraitString());
			System.out.printf("   %s\t%s\n\n", "Ace-Joker\t\t", Cards.CA.getCardTraitString());
			
			System.out.println("Card's Suit\t\tCoordination Value");
			System.out.printf("   %s\t\t\t%d\n", Cards.CA.getCardSuitString(), Cards.CA.getCardCoordinationInt());
			System.out.printf("  %s\t\t\t%d\n", Cards.DA.getCardSuitString(), Cards.DA.getCardCoordinationInt());
			System.out.printf("   %s\t\t\t%d\n", Cards.HA.getCardSuitString(), Cards.HA.getCardCoordinationInt());
			System.out.printf("   %s\t\t\t%d\n", Cards.SA.getCardSuitString(), Cards.SA.getCardCoordinationInt());
			System.out.printf("   %s\t\t     %s\n\n", Cards.JR.getCardSuitString(), "Special");
			
			System.out.println("You know what they say... the Joker is WILD, today!");
			System.out.println("The Joker cards will always have a special rule assoicated with them any time you pull one.");
			System.out.println("In this case, a Joker's coordination is determined by using a freshly shuffled 54 card deck and pulling the top card's Coordination Value.");
			System.out.println("And surprise, surprise... if you pull another Joker card on the Joker, its Coordination Value is whopping 5!\n");
			System.out.printf("Lets take a look at %s's current Traits Cards versus the Traits Aptitude Values:\n\n", heroDemoOne.getEntityAlias());
			
			heroDemoOne.printEntityStatsTraitCardNames();
			heroDemoOne.printEntityStatsTraitAptitudeValues();
			
			System.out.println("\nThats good to know... but just what in heck can I use these values for? Well that leads us to the next step in making your character, picking out some Aptitudes.\n");
			System.out.println("An Aptitiude is a skill, talent, or trade that your character would know or have.");
			System.out.println("Normal folks have an aptitude value of 1-5, where as a master of their craft would be a 6+.");
			System.out.println("When picking out skills for your waster, you will spend \"Aptitude Points\" determined by the sum of your Trait Values of Cognition, Knowledge, and Smarts.\n");
			System.out.printf("Lets take a look at %s's waster here as an example:\n", heroDemoOne.getEntityNameFirst());
			System.out.printf("%s has a Cognition Card of [%s] which is %s Trait Value so they get %d Aptitude points so far.\n",
					heroDemoOne.getEntityAlias(), heroDemoOne.getEntityTraitCognitionCard().name(),
					heroDemoOne.getEntityTraitCognitionCard().getCardTraitString(), heroDemoOne.getEntityTraitCognitionCard().getCardTraitInt());
			System.out.printf("%s has a Knowledge Card of [%s] which is %s Trait Value so they get an additional %d Aptitude Points bringing his total to %d points so far.\n",
					heroDemoOne.getEntityAlias(), heroDemoOne.getEntityTraitKnowledgeCard().name(),
					heroDemoOne.getEntityTraitKnowledgeCard().getCardTraitString(), heroDemoOne.getEntityTraitKnowledgeCard().getCardTraitInt(),
					(heroDemoOne.getEntityTraitCognitionCard().getCardTraitInt() + heroDemoOne.getEntityTraitKnowledgeCard().getCardTraitInt()) );
			System.out.printf("%s has a Smarts Card of [%s] which is %s Trait Value giving them another %d Aptitude Points leaving them with a total of %d Aptitiude Points.\n\n",
					heroDemoOne.getEntityAlias(), heroDemoOne.getEntityTraitSmartsCard().name(),
					heroDemoOne.getEntityTraitSmartsCard().getCardTraitString(), heroDemoOne.getEntityTraitSmartsCard().getCardTraitInt(),
					heroDemoOne.getEntityAptitudePoints());	
			System.out.println("");
			
			//Purchasing Aptitiudes
			System.out.println("When creating your new hombre, you use these Aptitude points to purchase... yep, you guessed it... Aptitudes!");
			System.out.println("There are 45 commonly used Aptitudes readily available for purchase, however, I rekcon there are hundreds more you can think of!");
			System.out.println("Some Aptitudes are not considered specific enough to be overall effective at and require a \"Concentration\"\n");
			System.out.println("Lets take, for example, the Aptitdue \"Drivin\". While your average brainer may know how to drive a car, they probably do not know how to operate a tank.");
			System.out.println("Both a car and a tank are a vehicle and require a drivin skill to operate, but I imagine that a Concentration is required not to flatten your posse members nearby ATV just trying to park the darn thing!");
			System.out.printf("In this case, %s is going to require the Concentration \"Drivin':Tank\" unless he is looking to keep the local gravedigger busy!\n\n", heroDemoOne.getEntityNameFirst());
			
			System.out.printf("Let's give ole' %s a few Aptitudes so you can get the idea:\n\n", heroDemoOne.getEntityAlias());
			
			heroDemoOne.updateEntityTraitSkills(Traits.COGNITION, "Trackin", 4);
			heroDemoOne.updateEntityTraitSkills(Traits.NIMBLENESS, "Persuasion", 2);
			heroDemoOne.updateEntityTraitSkills(Traits.SMARTS, "Gamblin", 4);
			heroDemoOne.updateEntityTraitSkills(Traits.SPIRIT, "Guts", 2);
			heroDemoOne.updateEntityTraitSkills(Traits.DEFTNESS, "Shootin:Pistol", 4);
			heroDemoOne.updateEntityTraitSkills(Traits.NIMBLENESS, "Drivin:Motorcycle", 4);
			heroDemoOne.updateEntityTraitSkills(Traits.QUICKNESS, "Quick Draw", 3);
			
			heroDemoOne.printEntityStatsKnownTraitsAndAptitudes();
			
			System.out.println("When creating your character, each Aptitude costs 1 Aptitude Point per level of Aptitude, so that Gamblin 4 would cost 4 Aptitude points.");
			System.out.println("Remember, that you cannot purchse more than 5 of any one given Aptitude or Concentration!");
			System.out.println("You do get a few freebies that everyone should know(and not have to pay for!):");
			System.out.println("Cognition : Search 1");
			System.out.println("Knowledge : Area Knowledge:Home County 2");
			System.out.println("Nimbleness : Language:Native Tongue 2");
			System.out.println("Nimbleness : Climbin 1");
			System.out.println("Nimbleness : Sneak 1\n");
			
			//Purchasing Edges and Hindrances
			System.out.println("There another way to spend(and recieve) Aptitude points in the form of giving your waster \"Edges\" and \"Hindrances\".");
			System.out.println("\"Edges\" and \"Hindrances\" are a way bring flavor to your playstyle and offer a way to trade off some inconviences(or worse) to your benefit!");
	
		//todo		
			System.out.println("\n\n*POW* Hang in there for now, this concept is under construction!\n\n");

			
			//Gear
			System.out.println("Your average waste survivor aint gettin by on looks and charm alone! Lets give them some gear!");
		
		//todo	
			System.out.println("\n\n*POW* Hang in there for now, this concept is under construction!\n\n");
			
			
			
			//Chips and Grit
			System.out.println("Now its time to talk about ole Lady Luck herself, Fate.");
		
		//todo
			System.out.println("\n\n*POW* Hang in there for now, this concept is under construction!\n\n");

			
		//Playing the game
			System.out.println("Git ready to unholster them peacemakers! Its time to talk about the Combat system! YEE-HAW");
			
			//Rolling the Dice
			System.out.println("Remeber all those Traits and Aptitudes I was yammering about earlier? Now is the chance to use them!");
			System.out.println("The dice rolling system is as wild as the jokers in your deck becuase it uses a concept known as \"Exploding Dice Rolls\".");
			System.out.println("The way it works is when you have a Die type to roll say a \"D6\", if you get a 6 on that die you reoll the die and add it to the previous roll of that die");
			
			System.out.println("So lets roll 3D6, that's 3 six sided dice at the same time:");
			
		//todo	
			System.out.println("\n\n*POW* Hang in there for now, this concept is under construction!\n\n");
		
			
			//Action System
			
		
			
			
		//Posse test	
			Entity Spike = new Hero("Spike Swimming Bird Spiegel", "Lunkhead", "Bounty Hunter"); 
			Entity Jet = new Hero("Jet Black", "The Hound", "Bounty Hunter"); 
			Entity Faye = new Hero("Faye Valentine", "Lady Luck", "Bounty Hunter"); 
			Entity Ed = new Hero("Edward Wong Hau Pepelu Tivrusky IV","Edward", "Bounty Hunter"); 			
			Entity Ein = new Hero("Ein", "Ein", "Bounty Hunter"); 
			
			Entity Maria = new Villain("Maria Murdock", "Twinkle", "Eco-Warrior"); 
			Entity SpaceWarrior1 = new Villain("Space Warrior", "Sea Rat", "Eco-Warrior"); 
			Entity SpaceWarrior2 = new Villain("Space Warrior", "Sea Rat", "Eco-Warrior"); 
			Entity SpaceWarrior3 = new Villain("Space Warrior", "Sea Rat", "Eco-Warrior"); 
			Entity SpaceWarrior4 = new Villain("Space Warrior", "Sea Rat", "Eco-Warrior"); 
			
	
		
			//Make 2 arrayLists to hold entities (Hero and Villain)
			ArrayList<Entity> heroPosseArrayListEntity = new ArrayList<Entity>();
			ArrayList<Entity> villainPosseArrayListEntity = new ArrayList<Entity>();
			
			//Load Heros into the ArrayList of heros
			heroPosseArrayListEntity.add(Spike);
			heroPosseArrayListEntity.add(Jet);
			heroPosseArrayListEntity.add(Faye);
			heroPosseArrayListEntity.add(Ed);
			heroPosseArrayListEntity.add(Ein);
			
			//Load Villains into the ArrayList of Villains
			villainPosseArrayListEntity.add(Maria);
			villainPosseArrayListEntity.add(SpaceWarrior1);
			villainPosseArrayListEntity.add(SpaceWarrior2);
			villainPosseArrayListEntity.add(SpaceWarrior3);
			villainPosseArrayListEntity.add(SpaceWarrior4);	
			
			//Associate the arraylist entities to their Posses
			Posse heroPosse = new Posse("Bebop Crew", heroPosseArrayListEntity);
			Posse villainPosse = new Posse("Space Warriors", villainPosseArrayListEntity);
			
			//Print the stats for the posse
			heroPosse.printPosseStats();
			//Print the stats for the posse
			villainPosse.printPosseStats();

		//Combat System Example

			
			//Create the combat between the two posses
			Fight fight1 = new Fight(heroPosse, villainPosse);
			
			//Combat test
			fight1.beginFight();
			

			
		
	
	}
	

}
