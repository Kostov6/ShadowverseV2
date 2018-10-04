package environment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cardLibrary.Card;
import environment.PlayerEnvironment;

class PlayerEnvironmentTest {

	@Test
	void testConstructor() {
		int[] redraw= {1,2};
		
		PlayerEnvironment case1=new PlayerEnvironment(Card.testDeck(),redraw,true);
		
		assertEquals(4,case1.getHand().size());
	}

}
