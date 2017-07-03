/**
 * 
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 *
 */
public class MapDisplay extends JPanel {
	
	public static final int HEIGHT = 185;
	public static final int WIDTH = 226;
	public static final int BOTTOM = 17;
	public static final int EXTRA = 46;
	
	private Grid grid;
	
	public MapDisplay(Grid grid){
		this.grid = grid;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		grid.forEachT((x, y, z, tile) -> {
			System.out.println("Yee-har");
			System.out.println("Painting a tile at: " + (x * 2 + y) * WIDTH / 2 + ", " +  y * HEIGHT);
			g.drawImage(tile.getImage(), (x * 2 + y) * WIDTH / 2, y * (HEIGHT - EXTRA), null);
		});
	}
}
