package environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cardLibrary.Card;

public class PlayerEnvironment 
{

	private int leaderHealth;
	private int turn;
	private int remainingPP;
	private int totalPP;

	private List<Card> deck;
	private List<Card> hand;
	private List<Card> discardPile;
	private List<Card> field;
	
	private EndCard lastCard;
	
	/**
	 *  Constructs an PlayerEnvironment based on a set deck (without shuffling) without the redrawing stage
	 * @param deck the deck to be shallow copied
	 * @param whether player 1 is first or not
	 */
	public PlayerEnvironment(List<Card> deck,boolean player1) {
		this(deck,null,player1);
	}
	/**
	 * Constructs an PlayerEnvironment based on a set deck (without shuffling)
	 * @param deck the deck to be shallow copied
	 * @param redrawIndexes initial redraw (array.length<=3 and elements<3)
	 * @param whether player 1 is first or not
	 */
	public PlayerEnvironment(List<Card> deck,int[] redrawIndexes,boolean player1) {
		leaderHealth=20;
		turn=1;
		remainingPP=1;
		totalPP=1;
		this.deck=deck;
		hand=new ArrayList<Card>();
		drawFromDeck();drawFromDeck();drawFromDeck();
		//validation check
		if(redrawIndexes!=null && redrawIndexes.length<=3)
		{
			boolean valid=true;
			boolean[] buffer=new boolean[3];
			for(int index : redrawIndexes)
			{
				if(index>3)
				{
					valid=false;
					break;
				}
				else
					buffer[index-1]=true;
			}
			if(valid)
			{
				Card redraw; 
				for(int i=2;i>=0;i--)
					if(buffer[i])
					{
						redraw=hand.remove(i);
						returnToDeck(redraw);
					}
				for(int i=0;i<3-hand.size();i++)
					drawFromDeck();
			}
			
		}
		//first draw
		drawFromDeck();if(!player1){drawFromDeck();}
		
		discardPile=new ArrayList<Card>();
		field=new ArrayList<Card>();
		lastCard=EndCard.standard;
		
	}
	
	

	//updaters
	public boolean play(int index,int[] targets,int[] choices)
	{
		
	}
	
	public boolean evolve(int index,int[] targets,int[] choices)
	{
		
	}
	
	public void nextTurn()
	{
		turn++;
		gainEmptyPP();
		remainingPP=totalPP;
		drawFromDeck();
	}
	
	boolean clash()
	{
		
	}
	
	void leaderDamage(int ammount)
	{
		
	}
	
	void leaderrHeal(int ammount)
	{
		
	}
	
	void drawFromDeck()
	{
		Card drawn=deck.remove(deck.size()-1);
		addToHand(drawn);
	}
	
	protected void summonOnField(Card[] cards)
	{
		
	}
	
	protected void gainEmptyPP()
	{
		if(totalPP<10)
			totalPP++;
	}

	private void addToHand(Card card)
	{
		if(hand.size()<9)
			hand.add(card);
		else
			discardPile.add(card);
	}
	
	private void returnToDeck(Card card)
	{
		//between [0,size]
		Random r=new Random();
		int indexOfInsertion=r.nextInt(deck.size()+1);
		deck.add(indexOfInsertion, card);
	}
	
	void setLastCard(EndCard lastCard)
	{
		this.lastCard=lastCard;
	}

	//views
	public int getLeaderHealth() {
		return leaderHealth;
	}

	public int getTurn() {
		return turn;
	}

	public int getRemainingPP() {
		return remainingPP;
	}

	public int getTotalPP() {
		return totalPP;
	}

	public List<Card> getHand() {
		return hand;
	}

	public List<Card> getField() {
		return field;
	}

	EndCard getLastCard() {
		return lastCard;
	}
	
	public int getShadowCount()
	{
		return discardPile.size();
	}
}
