package cardLibrary;

import java.util.HashMap;

//mono class
public class CardPackTracker {
	private static CardPackTracker instance=new CardPackTracker();
	public static CardPackTracker getInstance()
	{
		return instance;
	}
	
	private HashMap<String,String> map;
	
	private CardPackTracker() {
		this.map = new HashMap<String,String>();
		//initialization
		
	}
	
	public String getCardPackOfCard(String name)
	{
		if(name==null)
			return null;
		String pack=map.get(name);
		if(pack!=null)
			return pack;
		return "No Pack";
	}
	
}
