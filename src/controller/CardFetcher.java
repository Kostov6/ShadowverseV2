package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CardFetcher implements CardLibraryI {

	private String[] names;
	private String[] ids;
	
	private List<String> namesList;
	private List<String> idList;
	
	public CardFetcher()
	{
		int pages=5;
		namesList=new ArrayList<String>();
		idList=new ArrayList<String>();
		
		for(int i=0;i<pages;i++)
			loadDoc(i);
			
		names = namesList.toArray(new String[0]);
		ids = idList.toArray(new String[0]);
	}
	
	private void loadDoc(int pageIndex)
	{
		try {
			Document doc=Jsoup.connect("https://shadowverse-portal.com/cards?lang=en&card_offset="+12*pageIndex).get();
			collectCardNames(doc);
			collectCardIds(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void collectCardNames(Document doc)
	{
		Elements fetchedCards=doc.getElementsByClass("el-card-visual-name");
		namesList.addAll(fetchedCards.eachText());
	}
	
	private void collectCardIds(Document doc)
	{
		Elements elements=doc.getElementsByClass("el-card-detail");
		idList.addAll(elements.eachAttr("href"));
	}
	
	@Override
	public String[] getPacks() {
		return new String[] {
				"Darkness Evolved\r\n",
				"Rise of Bahamut\r\n" , 
				"Tempest of the Gods\r\n" , 
				"Wonderland Dreams"
				};
	}

	@Override
	public String[] getCardNames() {
		return names;
	}

	@Override
	public int getShadowversePortalCardIndex(int index) {
		String numberRegex=ids[index].split("/")[2];
		return Integer.parseInt(numberRegex);
	}

	@Override
	public int[] getCardIndexes() {
		int[] out=new int[ids.length];
		for(int i=0;i<out.length;i++)
			out[i]=Integer.parseInt(ids[i].split("/")[2]);
		
		return out;
	}

	@Override
	public int getCardsSize() {
		return names.length;
	}

}
