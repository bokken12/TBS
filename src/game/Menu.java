/**
 * 
 */
package game;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * @author nyyyar
 *
 */
public class Menu extends JPanel implements MouseListener {
	
	public Menu() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		CardDeck.getInstance().getLayout().show(new Game(), "game");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
