package controller;

/**
 * An helper interface that represents the card library's functionality
 * @author Vic
 *
 */
public interface CardLibraryI {

	/**
	 * returns all avaliable packs
	 */
	String[] getPacks();
	
	
	String[] getCardNames();
	
	int[] getCardIndexes();
	
	int getCardsSize();
	
	int getShadowversePortalCardIndex(int index);
}
