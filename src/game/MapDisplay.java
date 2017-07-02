/**
 * 
 */
package game;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 *
 */
public class MapDisplay extends JPanel {
	
	public Grid grid;
	
	@Override
	public void paintComponent(Graphics g) {
		grid.forEach((x, y, z, tile) -> {
			g.drawImage(tile.getImage(), x, y, this);
		});
	}
}
