package tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import command.CommandManager;

public class Main {

	public static void main(String[] args) {
		PlayAbstraction play=new PlayAbstraction(shuffle(initialDeck()),1);
		
		CommandManager cm=new CommandManager();
		cm.addCommand("print",(String[] ar) -> {printPlay(play); return new Boolean(true);});
		cm.addCommand("play", (String[] ar) -> {
			int index=Integer.parseInt(ar[0]);
			play.play(index);
			return new Boolean(true);
		});
		cm.addCommand("end",(String[] ar) -> {play.nextTurn();play.draw();return new Boolean(true);});
		
		try(Scanner s=new Scanner(System.in))
		{
			while(true)
			{
				String line=s.nextLine();
				cm.execute(line.split(" "));
			}
		}
	}
	

	public static List<CardAbs> shuffle(List<CardAbs> deck,int seed)
	{
		Random r=new Random(seed);
		Collections.shuffle(deck,r);
		return deck;
	}
	
	public static List<CardAbs> shuffle(List<CardAbs> deck)
	{
		Random r=new Random();
		int seed=r.nextInt();
		System.out.println("Seed:"+seed);
		return shuffle(deck,seed);
	}
	
	public static List<CardAbs> initialDeck()
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
	
	public static void printPlay(PlayAbstraction play)
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
