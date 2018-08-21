package cardLibrary;

import java.util.ArrayList;
import java.util.List;

import cardLibrary.effectLibrary.Effect;

public class Card {
	private int initialCost;
	private String name;
	private CardType type;
	
	private String cardPack;
	
	private List<Effect> cardEffects;
	private List<Effect> additionalEffects;

	protected Card(int initialCost, String name, CardType type, String cardPack, List<Effect> cardEffects) {
		this.initialCost = initialCost;
		this.name = name;
		this.type = type;
		this.cardPack = cardPack;
		this.cardEffects = cardEffects;
		this.additionalEffects=new ArrayList<Effect>();
	}
	

	/*
	private int index;
	
	public static List<Card> testDeck()
	{
		ArrayList<Card> deck=new ArrayList<Card>();
		for(int i=0;i<40;i++)
		{
			deck.add(new Card(i));
		}
		return deck;
	}

	@Override
	public String toString() {
		return "Card [index=" + index + "]";
	}

	public Card(int index) {
		super();
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	*/

}
