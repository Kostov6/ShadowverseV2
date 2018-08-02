package tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		PlayAbstraction play=new PlayAbstraction(shuffle(initialDeck()),1);
		
		printPlay(play);
		play.play(1);
		printPlay(play);
		
		play.nextTurn();
		play.draw();

		printPlay(play);
		play.play(1);
		printPlay(play);
		
		play.nextTurn();
		play.draw();
		
		printPlay(play);
	}

	private static List<CardAbs> shuffle(List<CardAbs> deck,int seed)
	{
		Random r=new Random(seed);
		Collections.shuffle(deck,r);
		return deck;
	}
	
	private static List<CardAbs> shuffle(List<CardAbs> deck)
	{
		Random r=new Random();
		Collections.shuffle(deck,r);
		return deck;
	}
	
	private static List<CardAbs> initialDeck()
	{
		ArrayList<CardAbs> deck=new ArrayList<CardAbs>();
		deck.add(new CardAbs(7,"Fairy princess"));
		deck.add(new CardAbs(6,"Cassiopea"));
		deck.add(new CardAbs(1,"Nature's guidance"));
		deck.add(new CardAbs(4,"Goblin leader"));
		deck.add(new CardAbs(2,6,"Winter fairy"));
		deck.add(new CardAbs(1,"Nature's guidance"));
		deck.add(new CardAbs(2,6,"Winter fairy"));
		
		return deck;
	}
	
	private static void printPlay(PlayAbstraction play)
	{
		System.out.println("Turn: "+play.getTurn());
		System.out.println("PP: "+play.getPlayPointsThisTurn()+"/"+play.getPlayPoints());
		System.out.print("Hand:");
		List<CardAbs> hand=play.getHand();
		for(CardAbs card : hand)
			System.out.print(" "+card.toString());
		System.out.println();
		
	}
}
