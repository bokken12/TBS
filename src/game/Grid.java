/**
 * 
 */
package game;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author joel
 *
 */
public class Grid {
	private static final int[][] OFFSETS = {{-1, 0}, {-1, +1}, {0, +1}, {+1, 0}, {+1, -1}, {0, -1}};
	
	private Tile[][] tiles;
	
	public static int getX(int y, int z){
		return -(y + z);
	}
	
	public static int getY(int x, int z){
		return -(x + z);
	}
	
	public static int getZ(int x, int y){
		return -(x + y);
	}
	
	public static int distance(int x1, int y1, int z1, int x2, int y2, int z2){
		return Math.max(Math.abs(x2 - x1), Math.max(Math.abs(y2 - y1), Math.abs(z2 - z1)));
	}
	
	public Iterable<Tile> neighbors(int x, int y){
		return new NeighborIterator(x, y);
	}
	
	public Iterable<Tile> neighbors(int x, int y, int z){
		return neighbors(x, y);
	}
	
	class NeighborIterator implements Iterator<Tile>, Iterable<Tile> {

		int x, y, i;
		
		private NeighborIterator(int x, int y){
			this.x = x;
			this.y = y;
			i = -1;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Iterable#iterator()
		 */
		@Override
		public Iterator<Tile> iterator() {
			if(i != -1){
				throw new ConcurrentModificationException("Neighbor iterators are single use without calling reset().");
			}
			return this;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return i < 5;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Tile next() {
			i++;
			return tiles[x + OFFSETS[i][0]][y + OFFSETS[i][1]];
		}
		
		public void reset(){
			i = -1;
		}
	}
}
