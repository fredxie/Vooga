package api.configuration;

import java.util.List;
/**
 * Classes that have KeyPressedObserver instance should implement this interface
 * 
 * @author Ran Zhang
 */
public interface KeyConfig {

	/**
	 * Get the key list in the object that implements this interface
	 */
	public List<Key> getKeyList();

	/**
	 * Set the key list in the object that implements this interface
	 */
	public void setKeyList(List<Key> list);
}
