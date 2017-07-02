package game;

import javax.swing.JFrame;

public class Game extends JFrame {
	
	Map map;
	Overlay overlay;

	public Game() {
		
	}
	
	public void init() {
		map = new Map();
		overlay = new Overlay();
		addMouseListener(map);
		addMouseListener(overlay);
	}
}
