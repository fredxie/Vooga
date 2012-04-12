package keyconfiguration;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import configuration.GameParameters;

import element.Fighter;
import element.RegularFighter;

/**
 * 
 * @author Ran Zhang
 * 
 */
public class KeyObserver {
	Fighter player;

	public KeyObserver(Fighter player) {
		this.player = player;
	}

	public void Update() {

	}

	public void getActoinMethods(GameParameters action, long elapsedTime) {
		Class<?> c = RegularFighter.class;
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			Annotation annotation = m.getAnnotation(KeyAnnotation.class);
			if (annotation instanceof KeyAnnotation) {
				KeyAnnotation key = (KeyAnnotation) annotation;
				if (!m.getGenericParameterTypes()[0].equals(long.class))
					continue;
				if (key.action().equals(action.toString())) {
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

	public void executeAction() {

	}
}