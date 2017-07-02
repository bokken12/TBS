package game;

import java.awt.Image;
import java.util.IdentityHashMap;

import javax.swing.ImageIcon;

public class Tile {

	ImageIcon image;
	
	static enum Type {
		TREE("wood"), PLAINS("sheep"), WATER("food"), BOULDERS("stone"), FARM("food");
		
		private String resource;
		
		Type(String resource){
			this.resource = resource;
		}
	}
	
	public Image getImage() {
		return image.getImage();
	}
	
	public Tile() {
		
	}
}