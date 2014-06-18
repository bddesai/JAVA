package genericCheckPointing.server;

import genericCheckPointing.util.SerializableObject;

/**
 * @author Bhavin
 * This interface will be derived from StoreRestoreI and will have
 *  writeDJSON method which will be implemented to serialize 
 *  contents to file.
 */
public interface StoreI extends StoreRestoreI {
    void writeDJSON(SerializableObject aRecord, String wireFormat);
}