/**
 * 
 */
package game;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * @author joel
 *
 */
public class Hex {
	public static final int HEIGHT = 0;
	public static final int HALF_WIDTH = 0;
	
	public static Point toCartesian(int x, int y){
		return new Point((x * 2 + y) * HALF_WIDTH, y * HEIGHT);
	}
	
	public static Point toCartesian(int x, int y, int z){
		return new Point((x * 2 + y) * HALF_WIDTH, y * HEIGHT);
	}
	
	public static Point2D.Float toCartesian(float x, float y){
		return new Point2D.Float((x * 2 + y) * HALF_WIDTH, y * HEIGHT);
	}
	
	public static Point2D.Float toCartesian(float x, float y, float z){
		return toCartesian(x, y);
	}
	
	public static Point2D.Double toCartesian(double x, double y){
		return new Point2D.Double((x * 2 + y) * HALF_WIDTH, y * HEIGHT);
	}
	
	public static Point2D.Double toCartesian(double x, double y, double z){
		return toCartesian(x, y);
	}
}
