package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame {
	
	public static final String TITLE = "TBS";
	public static final int DEFAULT_WIDTH = 800;
	public static final int DEFAULT_HEIGHT = 600;
	
	private static Game instance = null;
	
	public static Game getInstance(){
		if(instance == null){
			instance = new Game();
		}
		return instance;
	}
	
	public Game(){
		super(TITLE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - DEFAULT_WIDTH)/2, (screenSize.height - DEFAULT_HEIGHT)/2, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void initialize(){
		add(CardDeck.getInstance());
		JPanel menu = new JPanel(new BorderLayout());
		Grid grid = new Grid(2, 2);
		grid.set(0, 0, new Tile());
		grid.set(0, 1, new Tile());
		grid.set(1, 0, new Tile());
		grid.set(1, 1, new Tile());
		menu.add(new MapDisplay(grid));
		CardDeck.getInstance().addCard(menu, "menu");
		CardDeck.getInstance().setMode("menu");
	}
	
	public void run(){
		initialize();
		repaint();
	}
}
