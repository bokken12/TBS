/**
 * 
 */
package game;

import java.awt.CardLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * @author joel
 *
 */
public class CardDeck extends JPanel {
	
	private static CardDeck instance;
	
	public static CardDeck getInstance(){
		if(instance == null){
			instance = new CardDeck();
		}
		return instance;
	}
	
	public CardDeck(){
		setLayout(new CardLayout());
	}

	/* (non-Javadoc)
	 * @see java.awt.Container#getLayout()
	 */
	@Override
	public CardLayout getLayout() {
		return (CardLayout) super.getLayout();
	}
}
