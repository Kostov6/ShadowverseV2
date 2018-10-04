package cardLibrary;

import java.util.List;

import cardLibrary.effectLibrary.Effect;

public class Follower extends Card{
	private int initialAttack;
	private int initialDeffense;
	
	private int evolveAttackStat;
	private int evolveDeffenseStat;
	private Effect evolveEffect;
	
	private String trait; 
	
	public Follower(int initialCost,String name,int initialAttack,int initialDeffence,List<Effect> effects)
	{
		super(initialCost,name,CardType.follower,CardPackTracker.getInstance().getCardPackOfCard(name),effects);
		this.initialAttack=initialAttack;
		this.initialDeffense=initialDeffense;
		
		this.evolveAttackStat=initialAttack+2;
		this.evolveDeffenseStat=initialDeffence+2;
		this.evolveEffect=null;
	}
}
