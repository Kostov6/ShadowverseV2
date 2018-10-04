package environment.test;

import java.util.ArrayList;
import java.util.List;

import cardLibrary.Card;
import environment.PlayerEnvironment;
import environment.PlayerEnvironmentView;

public class SequenceTest {

	public static void main(String[] args) {
		int[] redraw= null;//{3,1,2};
		
		PlayerEnvironment environment=new PlayerEnvironment(Card.testDeck(),redraw,true);
		PlayerEnvironmentView view=new PlayerEnvironmentView(environment);
		
		view.print();

		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
		environment.nextTurn();
		view.print();
	}
	


}
