package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {

	private Image image;
	private Tileable resident;
	
	static enum Type {
		TREE("wood"), PLAINS("sheep"), WATER("food"), BOULDERS("stone"), FARM("food");
		
		private String resource;
		
		Type(String resource){
			this.resource = resource;
		}
	}
	
	public Image getImage() {
		return image;
	}
	
	public Tile(String name) {
		try {
			image = ImageIO.read(new File("./resources/tiles/tile-" + name + ".png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}