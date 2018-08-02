package environment;

import java.util.List;

public class Environment 
{
	private PlayerEnvironment environment1;
	private PlayerEnvironment environment2;
	
	private List<Event> gameEvents;
	private List<String> gameLog;

	//it is sure,that the size of deckList is exactly 40 and that it is a valid deck
	public Environment(int[] deckList1,int[] deckList2,String deckType1,String dechType2)
	{
		//player environment creation based on deckType
	}
	
	//it is sure,that indexes.length<=3 and they are in interval [0,2] and they dont repeat
	public void initialRedraw1(int[] indexes)
	{
		for(int i:indexes)
			environment1.putBackInDeck(i);
		for(int i=0;i<indexes.length;i++)
			environment1.draw();
		
		log("Player 1 redrew "+indexes.length+" cards");
	}
	
	//player 1 initial draw
	public void initialDraw1(){}
	
	public boolean play1(int index) {return play1(index,null,null);}
	public boolean playTarget1(int index,int target) {return play1(index,new int[]{target},null);}
	public boolean playTargets1(int index,int target1,int target2) {return play1(index,new int[]{target1,target2},null);}
	public boolean playChoice1(int index,int choice) {return play1(index,null,new int[] {choice});}
	public boolean playChoices1(int index,int choice1,int choice2) {return play1(index,null,new int[]{choice1,choice2});}
	//full parameter play
	//index [0,8]
	//targets null or all elements [1,12]
	//choices null or all elements [0,oo)
	public boolean play1(int index,int[] targets,int[] choices) 
	{
		
	}
	
	public boolean evolve1(int index) {return evolve1(index,null);}
	public boolean evolveTarget1(int index,int target) {return evolve1(index,new int[] {target});}
	//full parameter evolve
	//index [2,6]
	//targets null or all elements[1,12]
	public boolean evolve1(int index,int[] targets)
	
	//full parameter attack
	//index [2,6], defender [7,12]
	public boolean attack1(int index,int defender)
	
	private void log(String message)
	{
		gameLog.add(message);
	}
}
