/**
 * 
 */
package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 *
 */
public class MapDisplay extends JPanel implements KeyListener {
	
	public static final int HEIGHT = 184;
	public static final int WIDTH = 226;
	public static final int BOTTOM = 17;
	public static final int EXTRA = 46;
	
	private Grid grid;
	private int x;
	private int y;
	
	public MapDisplay(Grid grid){
		this.grid = grid;
		x = 0;
		y = 0;
		Game.getInstance().addKeyListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.translate(x, y);
		grid.forEachT((x, y, z, tile) -> {
			Point p = Hex.toCartesian(x, y, z);
			g.drawImage(tile.getImage(), p.x, p.y + HEIGHT + BOTTOM - tile.getImage().getHeight(null), null);
		});
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			x += 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x -= 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			y += 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			y -= 1;
		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
