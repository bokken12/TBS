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
public class Grid implements Iterable<Iterable<Tile>> {
	
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
	
	public Grid(int width, int height){
		tiles = new Tile[width][height];
	}
	
	public Tile get(int x, int y){
		return tiles[x][y];
	}
	
	public Tile get(int x, int y, int z){
		return get(x, y);
	}
	
	public void set(int x, int y, Tile tile){
		tiles[x][y] = tile;
	}
	
	public void set(int x, int y, int z, Tile tile){
		set(x, y, tile);
	}
	
	public Iterable<Tile> neighbors(int x, int y){
		return new NeighborIterator(x, y);
	}
	
	public Iterable<Tile> neighbors(int x, int y, int z){
		return neighbors(x, y);
	}
	
	public void forEach(TileConsumer tc){
		for(int x = 0; x < tiles.length; x++){
			for(int y = 0; y < tiles[x].length; y++){
				tc.accept(x, y, getZ(x, y), tiles[x][y]);
			}
		}
	}
	
	public void forEach2D(TileConsumer2D tc){
		for(int x = 0; x < tiles.length; x++){
			for(int y = 0; y < tiles[x].length; y++){
				tc.accept(x, y, tiles[x][y]);
			}
		}
	}
	
	public void forEachT(TileConsumer tc){
		if(tiles.length > 0){
			for(int y = 0; y < tiles[0].length; y++){
				for(int x = 0; x < tiles.length; x++){
					tc.accept(x, y, getZ(x,  y), tiles[x][y]);
				}
			}
		}
	}
	
	public void forEachT2D(TileConsumer2D tc){
		if(tiles.length > 0){
			for(int y = 0; y < tiles[0].length; y++){
				for(int x = 0; x < tiles.length; x++){
					tc.accept(x, y, tiles[x][y]);
				}
			}
		}
	}
	
	public void forNeighbors(int x, int y, int z, TileConsumer tc){
		for(int i = 0; i < 6; i++){
			int tx = x + OFFSETS[i][0];
			int ty = y + OFFSETS[i][1];
			tc.accept(tx, ty, getZ(tx, ty), tiles[tx][ty]);
		}
	}
	
	public void forNeighbors2D(int x, int y, TileConsumer2D tc){
		for(int i = 0; i < 6; i++){
			int tx = x + OFFSETS[i][0];
			int ty = y + OFFSETS[i][1];
			tc.accept(tx, ty, tiles[tx][ty]);
		}
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Iterable<Tile>> iterator() {
		return new ColumnIterator();
	}
	
	class ColumnIterator implements Iterator<Iterable<Tile>> {

		private int x;
		
		private ColumnIterator(){
			x = -1;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return x + 1 < tiles.length;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Iterable<Tile> next() {
			x++;
			return new Column(x);
		}
		
		public void reset(){
			x = -1;
		}
	}
	
	class Column implements Iterable<Tile> {
		
		private int x;
		
		private Column(int x){
			this.x = x;
		}

		/* (non-Javadoc)
		 * @see java.lang.Iterable#iterator()
		 */
		@Override
		public Iterator<Tile> iterator() {
			return new RowIterator(x);
		}
	}
	
	class RowIterator implements Iterator<Tile> {

		int x, y;
		
		public RowIterator(int x){
			this.x = x;
			y = -1;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return y + 1 < tiles[x].length;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Tile next() {
			y++;
			return tiles[x][y];
		}
		
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
	
	interface TileConsumer {
		public void accept(int x, int y, int z, Tile t);
	}
	
	interface TileConsumer2D {
		public void accept(int x, int y, Tile t);
	}
}
