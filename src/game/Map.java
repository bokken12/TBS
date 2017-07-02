package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Map extends JPanel implements MouseListener {

	Tile[][] map;
	public final int TILE_SIZE = 64;

	@Override
	public void paintComponent(Graphics g) {
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[0].length; x++) {
				g.drawImage(map[y][x].getImage(), x*(TILE_SIZE/2)*3, y*TILE_SIZE/2, this);
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
