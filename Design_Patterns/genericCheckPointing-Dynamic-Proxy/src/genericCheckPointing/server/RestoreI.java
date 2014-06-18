package genericCheckPointing.server;

import genericCheckPointing.util.SerializableObject;

/**
 * @author Bhavin
 * This interface will be derived from StoreRestoreI and will have
 *  readDJSON method which will be implemented to deserialize 
 *  contents from file.
 */
public interface RestoreI extends StoreRestoreI{
	 SerializableObject readDJSON(String wireFormat);
}
