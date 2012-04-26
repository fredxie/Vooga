package api.configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.golden.gamedev.GameObject;

/**
 * Key type consisting of key value, action, game object and object that this key is initiated in
 * 
 * 
 * @author Ran Zhang
 */
public class Key {
	private int keyValue;
	private String action;
	private GameObject myGame;
	private Object player;

	/**
	 * Constructor
	 * 
	 * 
	 */
	public Key(int value, String actionName, Object player, GameObject game) {
		keyValue = value;
		action = actionName;
		myGame = game;
		this.player = player;
	}

	/**
	 * Test if a key is down
	 * 
	 * 
	 */
	public boolean isKeyDown() {
		if (myGame.keyDown(keyValue))
			return true;
		return false;
	}

	/**
	 * Test if a key is pressed
	 * 
	 * 
	 */
	public boolean isKeyPressed() {
		if (myGame.keyPressed(keyValue))
			return true;
		return false;
	}

	/**
	 * 
	 * 
	 * @return action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 
	 * 
	 * @return key value
	 */
	public int getValue() {
		return keyValue;
	}

	/**
	 * Change the key value
	 * 
	 */
	public void setValue(int value) {
		keyValue = value;
	}

	/**
	 * If this key is pressed, call the corresponding method in the object or in the superclass
	 * of the object
	 * 
	 */
	public void executeKeyFuction(long elapsedTime) {
		Class<?> c = player.getClass();
		if (!execute(elapsedTime, c)) {
			c = player.getClass().getSuperclass();
			execute(elapsedTime, c);
		}
	}

	/**
	 * Use key annotation to call the corresponding method
	 * 
	 */
	private boolean execute(long elapsedTime, Class<?> c) {
		Method[] methods = c.getMethods();
		boolean invoked = false;
		for (Method m : methods) {
			Annotation annotation = m.getAnnotation(KeyAnnotation.class);
			if (annotation instanceof KeyAnnotation) {
				KeyAnnotation keyAnnotation = (KeyAnnotation) annotation;
				if (m.getGenericParameterTypes()[0].equals(long.class) && keyAnnotation.action().equals(action)) {
					try {
						m.invoke(player, elapsedTime);
						invoked = true;
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
		return invoked;
	}

}