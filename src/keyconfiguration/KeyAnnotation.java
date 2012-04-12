package keyconfiguration;

/**
 * 
 * @author Ran Zhang
 * 
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import configuration.GameParameters;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface KeyAnnotation {
	GameParameters action();
}