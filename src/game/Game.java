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
	public static final int MAX_TICK_LENGTH = 8000;
	
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
		CardDeck.getInstance().setMode("game");
		GameScene.initialize();
		System.out.println("set mode");
	}
	
	public void run(){
		initialize();
		while(true){
			repaint();
			try {
				Thread.sleep(5);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
