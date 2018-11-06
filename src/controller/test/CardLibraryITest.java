package controller.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.CardFetcher;
import controller.CardLibraryI;
import engine.command.CommandManager;

class CardLibraryITest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	public static void main(String[] args) {
		CardLibraryI libraryI = new CardFetcher();
		CommandManager commands = new CommandManager();

		commands.addCommand("getPacks()", (String[] ar) -> {
			System.out.println(Arrays.toString(libraryI.getPacks()));
			return null;
		});

		commands.addCommand("getCardNames()", (String[] ar) -> {
			System.out.println(Arrays.toString(libraryI.getCardNames()));
			return null;
		});
		
		commands.addCommand("getCardIndexes()", (String[] ar) -> {
			System.out.println(Arrays.toString(libraryI.getCardIndexes()));
			return null;
		});
		commands.addCommand("getCardsSize()", (String[] ar) -> {
			System.out.println(libraryI.getCardsSize());
			return null;
		});
//		commands.addCommand("getPacks()", (String[] ar) -> {
//			Arrays.toString(libraryI.getPacks());
//			return null;
//		});
		
		Scanner s = new Scanner(System.in);
		String command;
		boolean quit=false;
		while(!quit)
		{
			command=s.nextLine();
			try {
				commands.execute(command);
			} catch (Exception e) {
				if(!e.getMessage().equals("Got ~quit command"))
					e.printStackTrace();
				quit=true;
			}
		}
	}
}
