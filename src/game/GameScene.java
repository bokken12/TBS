/**
 * 
 */
package game;

import java.awt.BorderLayout;

/**
 * @author joel
 *
 */
public class GameScene extends Scene {

	private static GameScene instance;
	
	static {
		instance = new GameScene();
		CardDeck.getInstance().addCard(instance);
		System.out.println("game initialized");
	}
	
	public static void initialize(){}
	
	private Grid grid;
	
	/**
	 * @param name
	 */
	public GameScene() {
		super("game");
		setLayout(new BorderLayout());
		grid = new Grid(2, 2);
		grid.set(0, 0, new Tile("rocks"));
		grid.set(0, 1, new Tile("trees"));
		grid.set(1, 0, new Tile("trees"));
		grid.set(1, 1, new Tile("rocks"));
		add(new MapDisplay(grid));
	}
	
	public static GameScene getInstance(){
		return instance;
	}
}
