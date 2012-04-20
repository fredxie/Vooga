package configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.golden.gamedev.GameObject;

/**
 * 
 * @author Ran Zhang
 * 
 */
public class Key {
	private int keyValue;
	public GameParameters action;
	// private KeyObserver observer;
	private GameObject myGame;
	private Object player;

	public Key(int value, GameParameters actionName, Object player,
			GameObject game) {
		keyValue = value;
		action = actionName;
		// observer = new KeyObserver(player);
		myGame = game;
		this.player = player;
	}

	public boolean isKeyDown() {
		if (myGame.keyDown(keyValue))
			return true;
		return false;
	}

	public GameParameters getAction() {
		return action;
	}

	public int getValue() {
		return keyValue;
	}

	public void setValue(int value) {
		keyValue = value;
	}

	// public void notifyObserver(long elapsedTime) {
	// observer.getActoinMethods(action, elapsedTime);
	// }
	//

	public void executeKeyFuction(long elapsedTime) {
		// Class<?> c = player.getClass();
		Class<?> c = player.getClass().getSuperclass();
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			Annotation annotation = m.getAnnotation(KeyAnnotation.class);
			if (annotation instanceof KeyAnnotation) {
				KeyAnnotation key = (KeyAnnotation) annotation;
				if (!m.getGenericParameterTypes()[0].equals(long.class))
					continue;
				if (key.action().equals(action)) {
					try {
						m.invoke(player, elapsedTime);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}