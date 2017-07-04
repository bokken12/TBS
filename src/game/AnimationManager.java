/**
 * 
 */
package game;

import java.awt.Component;
import java.awt.Graphics;
import java.util.IdentityHashMap;

/**
 * @author joel
 *
 */
public class AnimationManager {
	
	private IdentityHashMap<Component, Animation> animations;
	
	public AnimationManager(){
		animations = new IdentityHashMap<Component, Animation>();
	}
	
	public void paint(Graphics g){
		long time = System.nanoTime();
		for(Animation a: animations.values()){
			int passed = (int)(time - a.getStart());
			if(passed >= a.getLength()){
				a.paintTarget(g, (int)(time - a.getStart()));
			} else {
				a.paintTarget(g, a.getLength());
				animations.remove(a.getTarget());
				a.getTarget().setVisible(true);
			}
		}
	}
	
	public void registerAnimation(Animation a){
		a.setStart(System.nanoTime());
		animations.put(a.getTarget(), a);
		a.getTarget().setVisible(false);
	}
}
