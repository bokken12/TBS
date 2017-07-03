/**
 * 
 */
package game;

import java.awt.Component;
import java.awt.Graphics;

/**
 * @author joel
 *
 */
public abstract class Animation {
	private int length; //nanos
	private long start;
	private Component target;
	private Runnable callback;
	
	public Animation(int length, Component target, Runnable callback){
		this.length = length;
		this.target = target;
		this.callback = callback;
	}
	
	public abstract void paintTarget(Graphics g, int time);

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @return the target
	 */
	public Component getTarget() {
		return target;
	}

	/**
	 * @return the callback
	 */
	public Runnable getCallback() {
		return callback;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Component target) {
		this.target = target;
	}

	/**
	 * @param callback the callback to set
	 */
	public void setCallback(Runnable callback) {
		this.callback = callback;
	}

	/**
	 * @return the start
	 */
	public long getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(long start) {
		this.start = start;
	}
}
