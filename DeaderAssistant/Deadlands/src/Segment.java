import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


//A segment will have Entities Taking Actions during a Round
public class Segment {

	//A segment has a current card of the round
	Cards currentSegmentCards; //Cards.JR, Cards.SA, .....
	
	//A segment will have a list of Entitys that can take an action for this segment of combat
	ArrayList<Entity> segmentCurrentArrayListEntity = new ArrayList<Entity>();
	
	
	public Segment(Cards c, ArrayList<Posse> roundsPossesArrayListPosse) 
	{
		
		this.currentSegmentCards = c;
	

		//
		for(Posse p : roundsPossesArrayListPosse)
		{
				
			//Sorting the Entities within the Posse by the highest card in their current hand
			Comparator<Entity> comparatorSortByCardsNullsLast = Comparator.comparing(Entity::getEntityHandTopCardJokerCheckCards,Comparator.nullsLast(Cards::compareTo));
			Collections.sort(p.getPosseArrayList(), comparatorSortByCardsNullsLast);
			
			
			//Print out the segment stats
			//printSegmentStats(p);
			
			
			for(Entity e : p.getPosseArrayList())
			{
				
				
				e.printEntityHand();
				
				if(e.getEntityHandTopCardJokerCheckCards() != null)
				{
				
					//remove cards in the entity hand that are the currentSegmentsCard
					while(e.getEntityHandTopCardJokerCheckCards() != null && e.getEntityHandTopCardJokerCheckCards().getCardFaceString() == currentSegmentCards.getCardFaceString())
					{			
						e.getEntityActionHandArrayListCards().remove(0);
					}
					
				}
			}
			
			//System.out.println("After the Discard:");
			//printSegmentStats(p);
		}
		
		
		
		
		
	}

	//Print the before and after sorting of the Entities within the Posse by the highest card in their current hand
	public void printSegmentStats(Posse p)
	{
		System.out.printf("\n%s's order of characters sorted by highest value card in their current hand:\n", p.getPosseName());
		
		System.out.println("Actual Card face value of the segment: " + currentSegmentCards.getCardFaceString());
		
		p.printPosseStats();
		
		for(Entity e : p.getPosseArrayList())
		{
			e.printEntityHand();

		}
		
	}
	

	
}
