/**
 * 
 */
package game;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * @author joel
 *
 */
public class CardDeck extends JPanel {
	
	private static CardDeck instance;
	
	private String mode;
	
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
	
	public void addCard(Scene card){
		add(card, card.getName());
	}
	
	public void removeCard(Scene card){
		remove(card);
	}
	
	public void setMode(String mode){
		this.mode = mode;
		getLayout().show(this, mode);
	}
}
