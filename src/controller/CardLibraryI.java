package controller;

public interface CardLibraryI {

	String[] getPacks();
	
	String[] getCardNames();
	
	int[] getCardIndexes();
	
	int getCardsSize();
	
	int getShadowversePortalCardIndex(int index);
}
