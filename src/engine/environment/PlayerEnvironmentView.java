package environment;

import java.util.List;

import cardLibrary.Card;

public class PlayerEnvironmentView {

	private PlayerEnvironment playerEnvironment;

	public PlayerEnvironmentView(PlayerEnvironment playerEnvironment) {
		this.playerEnvironment = playerEnvironment;
	}
	
	public void print()
	{
		System.out.print("Turn:"+playerEnvironment.getTurn());
		System.out.println(" ("+playerEnvironment.getRemainingPP()+"/"+playerEnvironment.getTotalPP()+")");
		System.out.println("Hand: ");
		List<Card> hand=playerEnvironment.getHand();
		for(Card card: hand)
			System.out.print(card+" ");
		System.out.println();
	}
	
}
