package environment;

import java.util.List;

import cardLibrary.Card;

public class PlayerEnvironment 
{
	private List<Card> hand;
	private List<Card> deck;
	private List<Card> field;
	
	private int leaderHealth;
	private int playOrbs;
	
	//draws a card from deck. Returns false if it drew the last card from deck
	public boolean draw()
	{
		if(deck.size()==0)
			return false;
		
		//not to shift elements	
		Card drawn=deck.remove(deck.size()-1);
		if(hand.size()==9)
		{
			destroyCard(drawn);
		}
		hand.add(drawn);
		
		return true;	
	}
	
	public void putBackInDeck(int index)
	{
		
	}
	
	
	private void destroyCard(Card c)
	{
		
	}
}
