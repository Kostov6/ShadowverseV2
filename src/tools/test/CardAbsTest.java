package tools.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tools.CardAbs;

class CardAbsTest {

	@Test
	void testGetPlayCost() {
		CardAbs card1=new CardAbs(1,9,null);
		CardAbs card2=new CardAbs(2,6,null);
		CardAbs card3=new CardAbs(8,3,null);

		assertEquals(card1.getPlayCost(4), 1);
		assertEquals(card1.getPlayCost(9), 9);
		
		assertEquals(card2.getPlayCost(1), 2);
		assertEquals(card2.getPlayCost(2), 2);
		assertEquals(card2.getPlayCost(6), 6);
		
	}

}
