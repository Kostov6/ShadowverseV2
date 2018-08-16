package tools;

import java.util.ArrayList;
import java.util.List;

public class PlayAbstraction {

	private int playPointsThisTurn;
	private int playPoints;
	private List<CardAbs> hand;
	private List<CardAbs> deck;
	
	private int turn;
	private List<Integer> playOrbsRemaining;
	private List<Integer> handSizeOnTurn;
	
	public PlayAbstraction(List<CardAbs> deck,int player)
	{
		playPointsThisTurn=1;playPoints=1;
		hand=new ArrayList<CardAbs>();
		this.deck=deck;
		turn=1;
		playOrbsRemaining=new ArrayList<Integer>();
		handSizeOnTurn=new ArrayList<Integer>();

		draw();draw();draw();draw();
		if(player==2)
			draw();

	}
	
	//updaters
	public void draw()
	{
		addToHand(deck.remove(deck.size()-1));
	}
	
	public boolean play(int index)
	{
		if(index>=hand.size())
			return false;
		
		CardAbs card=hand.get(index);
		int cardCost = card.getPlayCost(playPointsThisTurn);
		if(cardCost>playPointsThisTurn)
			return false;
		
		hand.remove(index);
		playPointsThisTurn-=cardCost;
		
		//add new cards
		CardAbs[] additional=card.getEffectiveGain();
		if(additional!=null)
			for(CardAbs newCard : additional)
				addToHand(newCard);
		
		return true;
	}
	
	public void nextTurn()
	{
		//safe statistic data
		handSizeOnTurn.add(hand.size());
		playOrbsRemaining.add(playPointsThisTurn);
		
		if(playPoints<10)
			playPoints++;
		
		playPointsThisTurn=playPoints;

		turn++;
	}
	
	//getters
	public int getTurn()
	{
		return turn;
	}
	
	public List<CardAbs> getHand()
	{
		return hand;
	}
	
	
	public List<CardAbs> getDeck() {
		return deck;
	}

	public List<Integer> getPlayOrbsStatistic() {
		return playOrbsRemaining;
	}

	public List<Integer> getHandSizeStatistic() {
		return handSizeOnTurn;
	}
	
	public int getPlayPointsThisTurn() {
		return playPointsThisTurn;
	}

	public int getPlayPoints() {
		return playPoints;
	}

	private void ramp()
	{
		if(playPoints<10)
			playPoints++;
	}
	private void addToHand(CardAbs card)
	{
		if(hand.size()<9)
			hand.add(card);
	}
}
