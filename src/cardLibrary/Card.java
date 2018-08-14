package cardLibrary;

import java.util.ArrayList;
import java.util.List;

public class Card {
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
	

}
