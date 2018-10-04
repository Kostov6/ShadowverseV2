package tools.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import tools.CardAbs;
import tools.PlayAbstraction;
import tools.test.scenarios.Main;

class PlayAbstractionTest {
	
	private PlayAbstraction case1=new PlayAbstraction(Main.shuffle(Main.initialDeck(), 1686735543),1);
	
	@Test
	void testPlay()
	{
		//case1-removes card anyway
		case1.play(1);
		case1.nextTurn();
		case1.play(1);
		List<CardAbs> hand=case1.getHand();
		assertEquals("Fairy princess",hand.get(1).getName());
	}
	
	@Test
	void test1() {
		Main.printPlay(case1);
		case1.play(1);
		Main.printPlay(case1);
		
		case1.nextTurn();
		case1.draw();

		Main.printPlay(case1);
		case1.play(1);
		Main.printPlay(case1);
		
		case1.nextTurn();
		case1.draw();
		
		Main.printPlay(case1);
		
		System.out.println(case1.getHandSizeStatistic());
		System.out.println(case1.getPlayOrbsStatistic());
	}

}
