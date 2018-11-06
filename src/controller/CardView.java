package controller;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CardView extends JFrame{

	private static class CardLibraryImp implements CardLibraryI
	{

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
			return new String[] {"Roan Winged Nexx\r\n" , 
					"Mechanical Bowman\r\n" , 
					"Gravikinetic Warrior\r\n" ,
					"Silver Cog Spinner\r\n" ,
					"Morton the Manipulator\r\n" , 
					"Cruel Puppetmaster\r\n" ,
					"Apostle of Destruction\r\n" , 
					"Lishenna, Omen of Destruction",
					"Puppeteer's Strings"
					};
		}
		
		@Override
		public int getShadowversePortalCardIndex(int index) {
			int[] indexes = new int[] {
					100821020,
					107811010,
					107811030,
					107831030,
					107831050,
					108811020,
					110831010,
					110841010,
					100824010
					};
			
			return indexes[index];
		}

		@Override
		public int[] getCardIndexes() {
			return null;
		}

		@Override
		public int getCardsSize() {
			return 0;
		}
		
	}
	
	private static class Card
	{
		
		public Card(String cardName, int id) {
			this.cardName = cardName;
			this.id = id;
		}

		private String cardName;
		private int id;
		
		@Override
		public String toString() {
			return cardName;
		}
		
		
	}
	
	private CardLibraryI cardLibrary;
	private Card[] allCards;
	
	
	private JTextField searchField;
	private JButton searchButton;
	private JScrollPane cardsPane;
	private JList<String> packList;
	
	private static void connectTest() throws IOException
	{
		//Document doc=Jsoup.connect("https://shadowverse-portal.com/cards").get();
		
		Document doc=Jsoup.connect("https://shadowverse-portal.com/cards?lang=en").get();
		Elements elements=doc.getElementsByClass("el-card-detail");
		for(Element el : elements)
		{
			System.out.println(el.attr("href"));
		}
		System.out.println(doc.body());
	}
	
	private static void connectTest2() throws IOException
	{
		//Document doc=Jsoup.connect("https://shadowverse-portal.com/cards").get();
		
		Document doc=Jsoup.connect("https://shadowverse-portal.com/card/110124010?lang=en").get();
		System.out.println(doc.body());
	}
	
	public static void main(String[] args) throws IOException {
		new CardView(new CardFetcher());

	}
	public CardView(CardLibraryI cardLibrary)
	{
		this.cardLibrary=cardLibrary;
		
		String[] allCardNames=cardLibrary.getCardNames();
		int[] allCardIds=cardLibrary.getCardIndexes();
		this.allCards=new Card[cardLibrary.getCardsSize()];
		for(int i=0;i<allCards.length;i++)
			allCards[i]=new Card(allCardNames[i],allCardIds[i]);
		setSize(350,250);
		initializeComponents();
		initializeLayout();
		setVisible(true);
		
	}

	private void initializeComponents()
	{
		searchField = new JTextField(12);
		searchField.addActionListener((e) -> {
			filter(null,searchField.getText());
		});
		add(searchField);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener((e) -> {
			filter(null,searchField.getText());
		});
		add(searchButton);
		
		packList = new JList<String>(cardLibrary.getPacks());
		packList.addListSelectionListener((e) -> {
			filter(null,null);
		});
		add(packList);
		
		cardsPane = new JScrollPane();
		JList<Card> cards=new JList<Card>(allCards);
		cards.addListSelectionListener((e) -> {
			if(!e.getValueIsAdjusting())
			{
				JList list=(JList) cardsPane.getViewport().getView();
			
				Card card= (Card) list.getModel().getElementAt(cards.getSelectedIndex());
				int cardId=card.id;
				openCardView("https://shadowverse-portal.com/card/" + cardId + "?lang=en");
			}
				System.out.println("open");
		});
		cardsPane.getViewport().add(cards);
		add(cardsPane);
	}
	
	private void initializeLayout()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints searchFieldConst = new GridBagConstraints();
		searchFieldConst.fill=GridBagConstraints.HORIZONTAL;
		searchFieldConst.anchor=GridBagConstraints.CENTER;
		searchFieldConst.gridx=0;
		searchFieldConst.gridy=0;
		searchFieldConst.weighty=0.2f;
		panel.add(searchField,searchFieldConst);
		
		GridBagConstraints searchButtonConst = new GridBagConstraints();
		searchButtonConst.fill=GridBagConstraints.HORIZONTAL;
		searchButtonConst.anchor=GridBagConstraints.CENTER;
		searchButtonConst.gridx=1;
		searchButtonConst.gridy=0;
		searchButtonConst.weighty=0.2f;
		panel.add(searchButton,searchButtonConst);
		
		GridBagConstraints elementsPaneConst = new GridBagConstraints();
		elementsPaneConst.fill=GridBagConstraints.HORIZONTAL;
		elementsPaneConst.anchor=GridBagConstraints.CENTER;
		elementsPaneConst.gridx=0;
		elementsPaneConst.gridy=1;
		elementsPaneConst.weighty=0.8f;
		panel.add(cardsPane,elementsPaneConst);
		
		GridBagConstraints packListConst = new GridBagConstraints();
		packListConst.fill=GridBagConstraints.HORIZONTAL;
		packListConst.anchor=GridBagConstraints.CENTER;
		packListConst.gridx=1;
		packListConst.gridy=1;
		packListConst.weighty=0.8f;
		panel.add(packList,packListConst);
		
		add(panel);
	}
	
	private void filter(String pack,String match)
	{
		JList list=(JList) cardsPane.getViewport().getView();
		
		ArrayList<Card> filtered = new ArrayList<Card>();
		for(Card card : allCards)
			if(card.cardName.contains(match))
				filtered.add(new Card(card.cardName,card.id));
		
		list.setListData(filtered.toArray());
	}
	
	private void openCardView(String url)
	{
		if (Desktop.isDesktopSupported()) {
		    try {
				Desktop.getDesktop().browse(new URI(url));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
